package br.com.bmsti.currencyconverter.api.dtos;

import br.com.bmsti.currencyconverter.api.enums.CurrencyType;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
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
}
