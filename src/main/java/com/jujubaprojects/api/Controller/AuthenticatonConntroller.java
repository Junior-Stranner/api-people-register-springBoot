package com.jujubaprojects.api.Controller;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jujubaprojects.api.Services.AuthenticatonService;

@RestController
public class AuthenticatonConntroller {
    
    private final AuthenticatonService AuthenticatonService;

    public AuthenticatonConntroller(AuthenticatonService AuthenticatonService) {
        this.AuthenticatonService = AuthenticatonService;
    }

    @PostMapping("authenticate")
    public String authenticate(AuthenticatedPrincipal authentication){
        return AuthenticatonService.authenticate(authentication);
    }
}
