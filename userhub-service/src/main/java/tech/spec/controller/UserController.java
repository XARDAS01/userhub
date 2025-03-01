package tech.spec.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.spec.api.ReferenceDto;
import tech.spec.api.dto.UserDto;
import tech.spec.api.request.UserRegistrationRequest;
import tech.spec.service.UserService;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public record UserController(UserService userService) {

    @PostMapping
    @Operation(summary = "${userhub.user.registration}", responses = @ApiResponse(responseCode = "201"))
    public ResponseEntity<ReferenceDto> registration(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest) {
        final var next = userService.registration(userRegistrationRequest);
        return ResponseEntity.ok(ReferenceDto.of(next.getId()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "${userhub.user.getById}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<UserDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "${userhub.user.update}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody UserRegistrationRequest userRegistrationRequest) {
        userService.updateById(id, userRegistrationRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "${userhub.user.delete}", responses = @ApiResponse(responseCode = "200"))
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
