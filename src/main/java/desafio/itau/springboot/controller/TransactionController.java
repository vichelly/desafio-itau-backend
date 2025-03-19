package desafio.itau.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import desafio.itau.springboot.dataTransfer.TransactionRequest;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionRules;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    private TransactionRules transactionRules;

    public TransactionController(TransactionRules transactionRules){
        this.transactionRules = transactionRules;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequest request) {
        if(request.getDateTime().isAfter(OffsetDateTime.now()) || request.getValue() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionRules.addTransaction(new Transaction(request.getValue(), request.getDateTime()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionRules.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
