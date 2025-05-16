package com.example.on_site_react_project_backend.dtos;

import com.example.on_site_react_project_backend.models.Profile;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record RequestProfileDto(
        @NotNull @NotEmpty
        String name
) {
    public Profile toProfile(int id) {
        return new Profile(id, name);
    }
}
