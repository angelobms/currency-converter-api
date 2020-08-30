package br.com.bmsti.currencyconverter.api.services;

import br.com.bmsti.currencyconverter.api.entities.Transaction;
import br.com.bmsti.currencyconverter.api.repositories.TransactionRepository;
import br.com.bmsti.currencyconverter.api.utils.PasswordUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
@SpringBootTest
public class TransactionServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    private static final Long ID = 1L;
    private static final Long USER_ID = 1L;

    @MockBean
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

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
        LOG.info("Executing 'shouldFindTransactionById' transaction service test");
        Optional<Transaction> transaction = this.transactionService.findById(ID);

        assertTrue(transaction.isPresent());
    }

    @Test
    public void shouldFindTransactionByUserId() {
        LOG.info("Executing 'shouldFindTransactionByUserId' user service test");
        Set<Transaction> transactions = this.transactionService.findByUserId(USER_ID);

        totalTransactions = (long) transactions.size();

        assertNotNull(transactions);
        assertSame(totalTransactions, (long) transactions.size());
        verify(transactionRepository, times(1)).findByUserId(USER_ID);
    }

    @Test
    public void shouldFindTransactionByUserIdPageable() {
        LOG.info("Executing 'shouldFindTransactionByUserIdPageable' user service test");
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Transaction> transactions = this.transactionService.findByUserId(USER_ID, pageRequest);

        totalTransactions = transactions.getTotalElements();

        assertNotNull(transactions);
        assertSame(totalTransactions, transactions.getTotalElements());
        verify(transactionRepository, times(1)).findByUserId(USER_ID, pageRequest);
    }

    @Test
    public void shouldPersistTransaction() {
        LOG.info("Executing 'shouldFindTransactionByUserIdPageable' user service test");
        Optional<Transaction> transaction = this.transactionService.save(new Transaction());

        assertNotNull(transaction);
    }
}
