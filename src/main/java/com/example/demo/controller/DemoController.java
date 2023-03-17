package com.example.demo.controller;

import com.example.demo.service.DemoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DemoController {

    private DemoService demoService;

    @PostMapping("/content")
    public ResponseEntity addContents(){
        return ResponseEntity.ok().
                body(demoService.addContents());
    }

    @GetMapping("/content")
    public ResponseEntity getContents(){
        return ResponseEntity.ok().
                body(demoService.getContents());
    }
}
