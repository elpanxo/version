package com.versionamiento.version.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class VersionController {

    @GetMapping("/api/saludo")
    public Map<String, Object> saludo() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", "Hola Mundo");
        return response;
    }
}
