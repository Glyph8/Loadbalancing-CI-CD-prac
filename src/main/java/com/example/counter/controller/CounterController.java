package com.example.counter.controller;

import com.example.counter.service.CounterService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/counter")
@RequiredArgsConstructor
public class CounterController {
    private final CounterService counterService;

    @GetMapping
    public Map<String, Object> getCount () throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();

        Map<String, Object> response = new HashMap<>();
        response.put("count", counterService.getCount());
        response.put("server", hostname);

        return response;
    }

    @PostMapping("/increment")
    public Map<String, Object> increment () throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();

        Long newCount = counterService.increment();

        Map<String, Object> response = new HashMap<>();
        response.put("count", newCount);
        response.put("server", hostname);
        response.put("message", "counter 증가");
        return response;
    }

    @GetMapping("/info")
    public Map<String, Object> getinfo () throws Exception {
        String hostname = InetAddress.getLocalHost().getHostName();
        String ip = InetAddress.getLocalHost().getHostAddress();

        Map<String, Object> response = new HashMap<>();
        response.put("hostname", hostname);
        response.put("ip", ip);
        return response;
    }
}
