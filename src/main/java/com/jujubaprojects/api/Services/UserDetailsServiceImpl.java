package com.jujubaprojects.api.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jujubaprojects.api.Authrntication.PessoaAuthenticated;
import com.jujubaprojects.api.Repositorio.PessoaRepositorio;

public class UserDetailsServiceImpl implements UserDetailsService{

    private final PessoaRepositorio pessoaRepositorio;

    

    public UserDetailsServiceImpl(PessoaRepositorio pessoaRepositorio) {
        this.pessoaRepositorio = pessoaRepositorio;
    }


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return this.pessoaRepositorio.finByName(name)
                .map(PessoaAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    
}
