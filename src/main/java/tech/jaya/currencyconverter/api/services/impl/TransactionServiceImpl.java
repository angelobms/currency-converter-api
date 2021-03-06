package tech.jaya.currencyconverter.api.services.impl;

import tech.jaya.currencyconverter.api.converters.TransactionConverter;
import tech.jaya.currencyconverter.api.converters.UserConverter;
import tech.jaya.currencyconverter.api.dtos.TransactionDTO;
import tech.jaya.currencyconverter.api.entities.Transaction;
import tech.jaya.currencyconverter.api.entities.User;
import tech.jaya.currencyconverter.api.integrations.exchangerates.ExchangeRatesApi;
import tech.jaya.currencyconverter.api.integrations.exchangerates.RateResponse;
import tech.jaya.currencyconverter.api.repositories.TransactionRepository;
import tech.jaya.currencyconverter.api.services.TransactionService;
import tech.jaya.currencyconverter.api.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Transaction service class
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final ExchangeRatesApi exchangeRatesApi;

    private final UserService userService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, ExchangeRatesApi exchangeRatesApi, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.exchangeRatesApi = exchangeRatesApi;
        this.userService = userService;
    }

    /**
     * Method responsible for fetching a transaction by id
     *
     * @param id transaction id
     * @return
     */
    @Override
    public Transaction findById(Long id) {
        log.info("Searching for a transaction by ID {}", id);
        return this.transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    /**
     * Method responsible for fetching a transaction by user id
     *
     * @param id transaction id
     * @return Set<TransactionDTO>
     */
    @Override
    public Set<TransactionDTO> findByUserId(Long id) {
        log.info("Searching for transactions by user ID {}", id);
        return this.transactionRepository
                .findByUserId(id)
                .stream()
                .map(TransactionConverter::covertTo)
                .collect(Collectors.toSet());
    }

    /**
     * Method responsible for fetching a transaction by user id
     *
     * @param id transaction id
     * @param pageRequest page request transaction
     * @return Page<Transaction>
     */
    @Override
    public Page<Transaction> findByUserId(Long id, PageRequest pageRequest) {
        log.info("Searching for transactions by user ID {} and pageable {}", id, pageRequest.getPageSize());
        return this.transactionRepository.findByUserId(id, pageRequest);
    }

    /**
     * Method responsible for saving a transaction
     *
     * @param transactionDTO transactionDTO
     * @return TransactionDTO
     */
    @Override
    public TransactionDTO save(TransactionDTO transactionDTO) {

        RateResponse rateResponse = exchangeRatesApi.findRate(transactionDTO.getOriginCurrency(), transactionDTO.getTargetCurrency());
        BigDecimal conversionRate = rateResponse.getRates().get(transactionDTO.getTargetCurrency().name());
        BigDecimal result = conversionRate.multiply(transactionDTO.getOriginValue());

        Transaction transaction = TransactionConverter.covertTo(transactionDTO);
        transaction.setConversionRate(conversionRate);
        if (transactionDTO.getDateTransaction() != null) {
            transaction.setDateTransaction(transactionDTO.getDateTransaction().withZoneSameInstant(ZoneId.of("UTC")));
        } else {
            transaction.setDateTransaction(ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC")));
        }

        User user = UserConverter.contertTo(this.userService.findById(transactionDTO.getUserId()));
        transaction.setUser(user);

        TransactionDTO savedTransaction = TransactionConverter.covertTo(this.transactionRepository.save(transaction));
        savedTransaction.setTargetValue(result);
        savedTransaction.setConversionRate(conversionRate);

        log.info("Persisting transaction {}", savedTransaction);
        return savedTransaction;
    }

}
