package com.jujubaprojects.api.Services;

import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatonService {

    private final Jwtservice jwtservice;

    
     
    public AuthenticatonService(Jwtservice jwtservice) {
        this.jwtservice = jwtservice;
    }



    public String authenticate(AuthenticatedPrincipal authentication){
        return jwtservice.generateToken(authentication);
    }
}
