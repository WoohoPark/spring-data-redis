package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Getter
@RedisHash("Demo")
@AllArgsConstructor
@Builder
public class Demo {

    @Id
    private String id;
    private Long amount;
    private LocalDateTime refreshDateTime;

    public void refresh(long amount, LocalDateTime refreshDateTime){
        if(refreshDateTime.isAfter(this.refreshDateTime)){
            this.amount = amount;
            this.refreshDateTime = refreshDateTime;
        }
    }

}
