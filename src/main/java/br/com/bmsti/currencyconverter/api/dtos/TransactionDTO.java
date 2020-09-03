package br.com.bmsti.currencyconverter.api.dtos;

import br.com.bmsti.currencyconverter.api.enums.CurrencyType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * Transaction Data Transaction Object
 *
 * @author angelo santos
 * @version 1.0
 * @since 28/08/2020
 */
@JsonPropertyOrder({"id", "userId", "originCurrency", "originValue", "targetCurrency", "conversionRate",
        "targetValue", "dateTransaction"})
public class TransactionDTO {

    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private CurrencyType originCurrency;

    @NotNull
    private BigDecimal originValue;

    @NotNull
    private CurrencyType targetCurrency;

    @NotNull
    private BigDecimal conversionRate;

    private BigDecimal targetValue;

    private ZonedDateTime dateTransaction;

    public TransactionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public CurrencyType getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(CurrencyType originCurrency) {
        this.originCurrency = originCurrency;
    }

    public BigDecimal getOriginValue() {
        return originValue;
    }

    public void setOriginValue(BigDecimal originValue) {
        this.originValue = originValue;
    }

    public CurrencyType getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(CurrencyType targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(BigDecimal targetValue) {
        this.targetValue = targetValue;
    }

    public ZonedDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(ZonedDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }
}
