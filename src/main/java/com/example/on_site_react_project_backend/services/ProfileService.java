package com.example.on_site_react_project_backend.services;

import com.example.on_site_react_project_backend.dtos.RequestProfileDto;
import com.example.on_site_react_project_backend.dtos.ResponseListProfileDto;
import com.example.on_site_react_project_backend.dtos.ResponseProfileDto;
import com.example.on_site_react_project_backend.exception_related.ExceptionUtils;
import com.example.on_site_react_project_backend.exceptions.UserNotFoundException;
import com.example.on_site_react_project_backend.models.Profile;
import com.example.on_site_react_project_backend.repositories.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository profileRepository) {
        this.repository = profileRepository;
    }

    public ResponseProfileDto getProfile(int id) {
        checkIfProfileExists(id, "getProfile");
        Profile profile = repository.findById(id);
        return ResponseProfileDto.from(profile);
    }

    public ResponseListProfileDto getAllProfiles() {
        List<Profile> profiles = repository.findAll();
        List<ResponseProfileDto> profileDtos = profiles.stream()
                .map(ResponseProfileDto::from)
                .toList();
        return new ResponseListProfileDto(profileDtos);
    }

    public ResponseProfileDto createProfile(RequestProfileDto dto) {
        Profile savedProfile = repository.save(dto.toProfile());
        return ResponseProfileDto.from(savedProfile);
    }

    public void deleteProfile(int id) {
        checkIfProfileExists(id, "deleteProfile");
        repository.deleteById(id);
    }

    private void checkIfProfileExists(int id, String methodName) {
        if (!repository.existsById(id)) throw new UserNotFoundException(
                HttpStatus.NOT_FOUND,
                ExceptionUtils.composeExceptionMessage(
                        "User not found",
                        methodName
                )
        );
    }
}
