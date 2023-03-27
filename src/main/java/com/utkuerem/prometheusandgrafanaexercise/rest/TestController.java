package com.utkuerem.prometheusandgrafanaexercise.rest;

import com.utkuerem.prometheusandgrafanaexercise.Repository.TestRepository;
import com.utkuerem.prometheusandgrafanaexercise.dtos.TestDTO;
import com.utkuerem.prometheusandgrafanaexercise.entity.TestEntity;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestRepository testRepository;

    @Autowired
    MeterRegistry registry;

    @GetMapping("/get")
    public List<TestEntity> getTest() {
        List<TestEntity> all = testRepository.findAll();
        return all;
    }

    @PostMapping("/post")
    public TestEntity postTest(@RequestBody TestDTO testDTO) {
        TestEntity testEntity = new TestEntity();
        testEntity.setName(testDTO.getName());
        testRepository.save(testEntity);
        registry.counter("newTest", "name", testDTO.getName());
        return testEntity;
    }
}
