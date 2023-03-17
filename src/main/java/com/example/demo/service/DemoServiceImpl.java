package com.example.demo.service;

import com.example.demo.domain.Demo;
import com.example.demo.repository.DemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DemoServiceImpl implements DemoService {
    private DemoRepository demoRepository;

    @Override
    public List<Demo> getContents() {
        return (List<Demo>) demoRepository.findAll();
    }

    @Override
    public Object addContents() {

        String id = "jojoldu";
        LocalDateTime refreshDateTime = LocalDateTime.of(2018, 5, 26, 0, 0);

        Demo demo = Demo.builder()
                .id(id)
                .amount(1000L)
                .refreshDateTime(refreshDateTime)
                .build();

        demoRepository.save(demo);

        return "success";
    }
}
