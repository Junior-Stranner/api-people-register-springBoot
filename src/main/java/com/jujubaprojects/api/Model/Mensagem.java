package com.jujubaprojects.api.Model;

import org.springframework.stereotype.Component;

@Component
public class Mensagem {
    
    private String Mensagem;
    

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    
}
