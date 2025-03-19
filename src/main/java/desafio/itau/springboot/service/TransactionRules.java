package desafio.itau.springboot.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import desafio.itau.springboot.model.Transaction;

@Service
public class TransactionRules {

    /* fila FIFO first in first out, que vai conter as transações */
    private Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public void clearTransactions(){
        transactions.clear();
    }

    /*Obtém a data e hora atual.
    Filtra a coleção transactions, mantendo apenas as transações que ocorreram nos últimos 60 segundos.
    Extrai o valor de cada transação filtrada.
    Calcula as estatísticas resumidas dos valores extraídos.
    Retorna um objeto DoubleSummaryStatistics contendo as estatísticas calculadas. */
    /* .filter(): Aplica um filtro ao fluxo, mantendo apenas os elementos que satisfazem uma determinada condição. */
    /* t -> t.getDateTime().isAfter(now.minusSeconds(60)): Esta é uma expressão lambda que define a condição do filtro.  */
    public DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream().filter(
            t -> t.getDateTime().isAfter(now.minusSeconds(60))
        ).mapToDouble(Transaction::getValue).summaryStatistics();
    }

}
