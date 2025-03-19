package desafio.itau.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.service.MensagemService;

@RestController
@RequestMapping("/api")
public class MensagemController {
    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService){
        this.mensagemService = mensagemService;
    }

    @GetMapping("/mensagem")
    public String getMethodName(){
        return mensagemService.obterMensagem();
    }
}
