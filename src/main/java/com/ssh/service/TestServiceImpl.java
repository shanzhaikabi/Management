package com.ssh.service;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    public String test() {
        return "test";
    }
}
