package br.com.bmsti.currencyconverter.api.repositories;

import br.com.bmsti.currencyconverter.api.entities.Transaction;
import br.com.bmsti.currencyconverter.api.entities.User;
import br.com.bmsti.currencyconverter.api.enums.CurrencyType;
import br.com.bmsti.currencyconverter.api.enums.Profile;
import br.com.bmsti.currencyconverter.api.utils.PasswordUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(PasswordUtil.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private Long userId;

    @BeforeEach
    public void setUp() {
        LOG.info("Startup test");

        User user = userRepository.save(getUserData());
        this.userId = user.getId();

        this.transactionRepository.save(getTransactionData(user));
        this.transactionRepository.save(getTransactionData(user));
        this.transactionRepository.save(getTransactionData(user));
    }

    @AfterEach
    public void tearDown() {
        LOG.info("Finalize test");

        this.userRepository.deleteAll();
        this.transactionRepository.deleteAll();
    }

    @Test
    public void shouldFindTransactionByUserId() {
        LOG.info("Executing 'shouldFindTransactionByUserId' test");

        Set<Transaction> transactions = this.transactionRepository.findByUserId(userId);

        assertEquals(3, transactions.size());
    }

    @Test
    public void shouldFindTransactionByUserIdPaged() {
        LOG.info("Executing 'shouldFindTransactionByUserIdPaged' test");

        PageRequest page = PageRequest.of(0,10);
        Page<Transaction> transactions = this.transactionRepository.findByUserId(userId, page);

        assertEquals(3, transactions.getTotalElements());
    }

    private User getUserData() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword(PasswordUtil.createHash("123456"));
        user.setProfile(Profile.ROLE_USER);
        return user;
    }

    private Transaction getTransactionData(User user) {
        Transaction transaction = new Transaction();
        transaction.setUser(user);
        transaction.setOriginCurrency(CurrencyType.BRL);
        transaction.setOriginValue(BigDecimal.valueOf(100.00));
        transaction.setTargetCurrency(CurrencyType.EUR);
        transaction.setConversionRate(BigDecimal.valueOf(0.8392782207));
        transaction.setDateTransaction(LocalDateTime.now());
        return transaction;
    }
}
