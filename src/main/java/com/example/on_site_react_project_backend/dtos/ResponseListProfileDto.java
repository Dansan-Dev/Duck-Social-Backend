package com.example.on_site_react_project_backend.dtos;

import java.util.List;

public record ResponseListProfileDto(
        List<ResponseProfileDto> requestProfileDtos
) {
}
