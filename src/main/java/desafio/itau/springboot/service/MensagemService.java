package desafio.itau.springboot.service;

import org.springframework.stereotype.Service;

import desafio.itau.springboot.repository.MensagemRepository;

@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository){
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem(){
        return mensagemRepository.obterMensagem();
    }
}
