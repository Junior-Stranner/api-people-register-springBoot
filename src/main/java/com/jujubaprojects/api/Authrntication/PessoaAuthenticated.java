package com.jujubaprojects.api.Authrntication;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jujubaprojects.api.Model.Pessoa;

public class PessoaAuthenticated implements UserDetails{

    private final Pessoa pessoa;

    
    public PessoaAuthenticated(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      
        return List.of(() -> "read");
    }

    @Override
    public String getPassword() {
       return pessoa.getPassword();
    }

    @Override
    public String getUsername() {
    return pessoa.getNome();
}

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
    return true;
    }
    
}
