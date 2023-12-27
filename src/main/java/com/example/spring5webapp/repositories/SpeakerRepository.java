package com.example.spring5webapp.repositories;

import com.example.spring5webapp.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

    @Query(value = "SELECT * FROM speakers ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Speaker getRandomSpeaker();
}
