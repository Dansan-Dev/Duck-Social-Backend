package com.example.on_site_react_project_backend.dtos;

import com.example.on_site_react_project_backend.models.Profile;

public record ResponseProfileDto(
        int id,
        String name
) {
    public static ResponseProfileDto from(Profile profile) {
        return new ResponseProfileDto(profile.getId(), profile.getName());
    }
}
