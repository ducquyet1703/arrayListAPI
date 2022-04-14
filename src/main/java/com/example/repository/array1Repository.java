package com.example.repository;

import com.example.entity.ArrayRandomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface array1Repository extends JpaRepository<ArrayRandomEntity, Integer> {
    @Query(value = "SELECT * FROM array_list ORDER BY data DESC ", nativeQuery=true)
    List<ArrayRandomEntity> findAllDataAsc();

    @Query(value = "SELECT * FROM array_list WHERE data = ?1", nativeQuery=true)
    List<ArrayRandomEntity> findStringArray(String NameData);
}
