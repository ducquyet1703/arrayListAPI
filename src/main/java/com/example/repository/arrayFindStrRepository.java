package com.example.repository;

import com.example.entity.FindStringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface arrayFindStrRepository extends JpaRepository<FindStringEntity, Integer> {
}
