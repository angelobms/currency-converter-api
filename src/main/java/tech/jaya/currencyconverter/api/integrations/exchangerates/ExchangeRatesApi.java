package tech.jaya.currencyconverter.api.integrations.exchangerates;

import tech.jaya.currencyconverter.api.enums.CurrencyType;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Class of service to consume API conversion rates https://api.exchangeratesapi.io
 *
 * @author angelo santos
 * @version 1.0
 * @since 31/08/2020
 */
@Slf4j
@Service
public class ExchangeRatesApi {

    private static final String RATE_CONVERSION_API = "https://api.exchangeratesapi.io/latest?base=%s";

    /**
     * Method responsible for searching the conversion rate by the source and destination currency type
     *
     * @param origin origin currency type
     * @param target target currency type
     * @return RateResponse
     */
    public RateResponse findRate(CurrencyType origin, CurrencyType target) {

        RestTemplate restTemplate = new RestTemplate();

        String uri = String.format(RATE_CONVERSION_API, origin.name());

        log.info("Consuming rates of Exchange Rates API");

        return restTemplate.getForObject(uri, RateResponse.class);
    }

}
