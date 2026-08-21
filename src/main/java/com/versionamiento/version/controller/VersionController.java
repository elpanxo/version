package com.versionamiento.version.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1")
public class VersionController {
    @GetMapping
    public String holaMundo(@AuthenticationPrincipal Jwt jwt) {
        String usuario = jwt.getSubject();
        return "hola mundo v1.0.0- bug corregido v1.1.1 " + usuario;
    }

    @PostMapping
    public String despedida(@AuthenticationPrincipal Jwt jwt) {
        String usuario = jwt.getSubject();
        return "despedida V1.1.0 " + usuario;
    }

    @GetMapping("/public")
    public String endpointLibre() {
        return "enspoint sin validacion";
    }
}