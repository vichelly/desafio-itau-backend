package desafio.itau.springboot.model;

import java.time.OffsetDateTime;

public class Transaction {
    
    private double value;
    private OffsetDateTime dateTime;

    /* construtor */
    public Transaction(double value, OffsetDateTime dateTime){
        this.value = value;
        this.dateTime = dateTime;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }
    public double getValue() {
        return value;
    }
}
