package desafio.itau.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau.springboot.dataTransfer.Statistics;
import desafio.itau.springboot.service.TransactionRules;


@RestController
@RequestMapping("/statistic")
public class StatisticsController {
    
    private TransactionRules transactionRules;

    public StatisticsController(TransactionRules transactionRules){
        this.transactionRules = transactionRules;
    }

    @GetMapping
    public ResponseEntity<Statistics>  getStatistics() {
        DoubleSummaryStatistics stats = transactionRules.getStatistics();
        return ResponseEntity.ok(new Statistics(stats));
    }
}
