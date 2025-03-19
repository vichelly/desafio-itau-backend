package desafio.itau.springboot.dataTransfer;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;

public class TransactionRequest {
    @NotNull
    private double value;
    
    @NotNull
    private OffsetDateTime dateTime;

    public double getValue() {
        return value;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }
}
