package com.example.service;


import com.example.entity.ArrayRandomEntity;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ArrayService {
    void createStrNum();
    List<ArrayRandomEntity> sort1();
    List<ArrayRandomEntity> findAll(Sort sort);
    List<ArrayRandomEntity> sort2();
    List<ArrayRandomEntity> findStr(String string);
}
