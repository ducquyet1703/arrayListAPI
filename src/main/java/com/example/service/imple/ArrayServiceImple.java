package com.example.service.imple;


import com.example.entity.ArrayRandomEntity;
import com.example.entity.ArraySort1Entity;
import com.example.entity.ArraySort2Entity;
import com.example.entity.FindStringEntity;
import com.example.repository.array1Repository;
import com.example.repository.arraySort1Repository;
import com.example.repository.arraySort2Repository;
import com.example.repository.arrayFindStrRepository;
import com.example.service.ArrayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class ArrayServiceImple implements ArrayService {

    @Autowired
    array1Repository arrayARepository;
    @Autowired
    arraySort1Repository  arrayBRepository;
    @Autowired
    arraySort2Repository arrayCRepostitory;
    @Autowired
    arrayFindStrRepository arrayDRepostitory;


    // Create Array 1000 - 10000 element, random 1->10 characters
    @Override
    public void createStrNum() {
        int r = ThreadLocalRandom.current().nextInt(1000, 10001);
        for(int i  = 1; i < r; i++) {
            ArrayRandomEntity arrayRandomEntity = new ArrayRandomEntity();
            arrayRandomEntity.setId(i);
            arrayRandomEntity.setData(getAlphaNumericString());
            arrayARepository.save(arrayRandomEntity);
        }
    }

    protected static String getAlphaNumericString(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        int n = ThreadLocalRandom.current().nextInt(1, 11);
        while (sb.length() < n) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        String strNumber = sb.toString();
        return strNumber;
    }

    // Sort 1
    public List<ArrayRandomEntity> sort1() {
        return arrayARepository.findAll();
    }

    @Override
    public List<ArrayRandomEntity> findAll(Sort sort) {
        sort = Sort.by("data");
        List<ArrayRandomEntity> a = arrayARepository.findAll(sort);
        ArraySort1Entity arraySort1 = new ArraySort1Entity();
        for(int i = 1 ; i < a.size() + 1; i++) {
            arraySort1.setId(i);
            arraySort1.setData(a.get(i - 1).getData());
            arrayBRepository.save(arraySort1);
        }
        return arrayARepository.findAll(sort);
    }

    // Sort 2
    @Override
    public List<ArrayRandomEntity> sort2() {
        List<ArrayRandomEntity> a = arrayARepository.findAllDataAsc();
        ArraySort2Entity arraySort2 = new ArraySort2Entity();
        for (int i = 1; i < a.size() + 1; i++) {
            arraySort2.setId(i);
            arraySort2.setData(a.get(i - 1).getData());
            arrayCRepostitory.save(arraySort2);

        }
        return arrayARepository.findAllDataAsc();
    }

    // Search String
    @Override
    public List<ArrayRandomEntity> findStr(String string) {
        List<ArrayRandomEntity> b = arrayARepository.findStringArray(string);
        FindStringEntity findString = new FindStringEntity();
        for (int i = 1; i < b.size() + 1 ; i++) {
            findString.setId(i);
            findString.setData(b.get(i-1).getData());
            arrayDRepostitory.save(findString);
        }

        return arrayARepository.findStringArray(string);
    }
}
