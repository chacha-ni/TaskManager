package com.example.demo.Services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

@Component
public class IdGenerator {

    private AtomicLong counter = new AtomicLong(1);

    public Long getNextId() {
        return counter.getAndIncrement();
    }
}
