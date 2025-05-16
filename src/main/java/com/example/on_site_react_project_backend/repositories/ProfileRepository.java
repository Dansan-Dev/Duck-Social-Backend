package com.example.on_site_react_project_backend.repositories;

import com.example.on_site_react_project_backend.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Profile findById(int id);
    void deleteById(int id);
    Integer findTopByOrderByIdDesc();
}
