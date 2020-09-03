package br.com.bmsti.currencyconverter.api.services;

import br.com.bmsti.currencyconverter.api.converters.TransactionConverter;
import br.com.bmsti.currencyconverter.api.converters.UserConverter;
import br.com.bmsti.currencyconverter.api.dtos.TransactionDTO;
import br.com.bmsti.currencyconverter.api.dtos.UserDTO;
import br.com.bmsti.currencyconverter.api.entities.Transaction;
import br.com.bmsti.currencyconverter.api.entities.User;
import br.com.bmsti.currencyconverter.api.enums.CurrencyType;
import br.com.bmsti.currencyconverter.api.repositories.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Slf4j
@SpringBootTest
public class TransactionServiceTest {

    private static final Long ID = 1L;
    private static final Long USER_ID = 1L;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    private Long totalTransactions;

    @BeforeEach
    public void setUp() {

        BDDMockito.given(this.transactionRepository.findById(Mockito.anyLong())).
                willReturn(Optional.of(new Transaction()));
        BDDMockito.given(this.transactionRepository.findByUserId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
                .willReturn(new PageImpl<>(new ArrayList<>()));
        BDDMockito.given(this.transactionRepository.findByUserId(Mockito.anyLong()))
                .willReturn(new HashSet<>());
        BDDMockito.given(this.transactionRepository.save(Mockito.any(Transaction.class))).willReturn(new Transaction());
    }

    @Test
    public void shouldFindTransactionById() {
        log.info("Executing 'shouldFindTransactionById' transaction service test");
        Transaction transaction = this.transactionService.findById(ID);

        assertNotNull(transaction);
    }

    @Test
    public void shouldFindTransactionByUserId() {
        log.info("Executing 'shouldFindTransactionByUserId' user service test");
        Set<TransactionDTO> transactions = this.transactionService.findByUserId(USER_ID);

        totalTransactions = (long) transactions.size();

        assertNotNull(transactions);
        assertSame(totalTransactions, (long) transactions.size());
        verify(transactionRepository, times(1)).findByUserId(USER_ID);
    }

    @Test
    public void shouldFindTransactionByUserIdPageable() {
        log.info("Executing 'shouldFindTransactionByUserIdPageable' user service test");
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Transaction> transactions = this.transactionService.findByUserId(USER_ID, pageRequest);

        totalTransactions = transactions.getTotalElements();

        assertNotNull(transactions);
        assertSame(totalTransactions, transactions.getTotalElements());
        verify(transactionRepository, times(1)).findByUserId(USER_ID, pageRequest);
    }

    @Test
    public void shouldPersistTransaction() {
        log.info("Executing 'shouldFindTransactionByUserIdPageable' user service test");

    }

}
