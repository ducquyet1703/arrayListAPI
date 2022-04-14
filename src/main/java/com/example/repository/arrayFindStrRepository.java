package com.example.repository;

import com.example.entity.FindStringEntity;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface arrayFindStrRepository extends JpaRepository<FindStringEntity, Integer> {
}
