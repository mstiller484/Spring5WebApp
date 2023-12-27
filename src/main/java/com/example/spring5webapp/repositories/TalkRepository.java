package com.example.spring5webapp.repositories;

import com.example.spring5webapp.models.Talk;
import org.springframework.data.repository.CrudRepository;

public interface TalkRepository extends CrudRepository<Talk, Long> {
}
