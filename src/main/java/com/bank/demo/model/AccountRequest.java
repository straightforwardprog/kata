package com.bank.demo.model;

import lombok.Data;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
public class AccountRequest {

    private long idAccount;
    @DecimalMin(value = "0.0", inclusive = false, message = "The amount must be greater than 0")
    private BigDecimal amount;
}
