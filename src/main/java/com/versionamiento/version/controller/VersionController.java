package com.versionamiento.version.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/api/saludo/{nombre}")
    public Map<String, Object> saludoConNombre(@PathVariable String nombre) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", "Hola, " + nombre);
        return response;
    }
}
