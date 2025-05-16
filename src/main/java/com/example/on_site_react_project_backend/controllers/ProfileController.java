package com.example.on_site_react_project_backend.controllers;

import com.example.on_site_react_project_backend.dtos.RequestProfileDto;
import com.example.on_site_react_project_backend.dtos.ResponseProfileDto;
import com.example.on_site_react_project_backend.services.ProfileService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProfileDto> getProfile(
            @NotNull
            @PathVariable int id
            ) {
        return ResponseEntity.status(200).body(profileService.getProfile(id));
    }

    @PostMapping
    public ResponseEntity<ResponseProfileDto> createProfile(
            @RequestBody @Valid RequestProfileDto dto
    ) {
        return ResponseEntity.status(201).body(profileService.createProfile(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(
            @NotNull
            @PathVariable int id
    ) {
        profileService.deleteProfile(id);
        return ResponseEntity.status(204).build();
    }
}
