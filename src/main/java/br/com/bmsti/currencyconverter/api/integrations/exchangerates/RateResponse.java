package br.com.bmsti.currencyconverter.api.integrations.exchangerates;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

/**
 * Class representing the API response https://api.exchangeratesapi.io
 *
 * @author angelo santos
 * @version 1.0
 * @since 31/08/2020
 */
@Data
@NoArgsConstructor
public class RateResponse {

    private HashMap<String, BigDecimal> rates = new HashMap<>();
    private String base;
    private LocalDate date;
}
