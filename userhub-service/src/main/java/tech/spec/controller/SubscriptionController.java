package tech.spec.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.spec.api.dto.SubscriptionDto;
import tech.spec.api.request.UserSubscribeRequest;
import tech.spec.service.SubscriptionService;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subscriptions")
public record SubscriptionController(SubscriptionService subscriptionService) {

    @PostMapping
    @Operation(summary = "${userhub.subscription.subscribe}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> subscribe(@RequestBody @Valid UserSubscribeRequest userSubscribeRequest) {
        subscriptionService.subscribe(userSubscribeRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}")
    @Operation(summary = "${userhub.subscription.getByUserId}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<List<SubscriptionDto>> subscriptions(@PathVariable UUID id) {
        return ResponseEntity.ok().body(subscriptionService.subscriptions(id));
    }

    @DeleteMapping
    @Operation(summary = "${userhub.subscription.unsubscribe}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> unsubscribe(@RequestBody HashMap<UUID, List<UUID>> subscribes) {
        subscriptionService.unsubscribe(subscribes);
        return ResponseEntity.ok().build();
    }
}
