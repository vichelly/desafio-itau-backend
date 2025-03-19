package desafio.itau.springboot.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
    public String obterMensagem(){
        return "Hello from repository!";
    }
}
