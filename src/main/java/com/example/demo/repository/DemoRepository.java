package com.example.demo.repository;

import com.example.demo.domain.Demo;
import org.springframework.data.repository.CrudRepository;

public interface DemoRepository extends CrudRepository<Demo, String> {
}
