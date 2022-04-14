package com.example.control;

import com.example.entity.ArrayRandomEntity;
import com.example.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
public class Controller {
    @Autowired
    private ArrayService array1Service;

    @PostMapping("/createArrayApi")
    public void  createArrayApi () {
        array1Service.createStrNum();
    }

    @PostMapping("/sort1API")
    public List<ArrayRandomEntity> findAll(Sort sort) {
        return array1Service.findAll(sort);
    }
    @PostMapping("/sort2API")
    public List<ArrayRandomEntity> sort2() {
        return  array1Service.sort2();
    }
    @PostMapping("/findStr")
    public List<ArrayRandomEntity> findStrAp(@PathVariable("string") String string) {
        return array1Service.findStr(string);
    }
}
