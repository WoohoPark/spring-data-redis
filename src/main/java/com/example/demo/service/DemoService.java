package com.example.demo.service;

import com.example.demo.domain.Demo;

import java.util.List;

public interface DemoService {
    public List<Demo> getContents();
    Object addContents();
}
