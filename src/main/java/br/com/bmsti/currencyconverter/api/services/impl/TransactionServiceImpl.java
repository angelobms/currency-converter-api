package br.com.bmsti.currencyconverter.api.services.impl;

import br.com.bmsti.currencyconverter.api.entities.Transaction;
import br.com.bmsti.currencyconverter.api.repositories.TransactionRepository;
import br.com.bmsti.currencyconverter.api.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

/**
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        LOG.info("Searching for a transaction by ID {}", id);
        return this.transactionRepository.findById(id);
    }

    @Override
    public Set<Transaction> findByUserId(Long id) {
        LOG.info("Searching for transactions by user ID {}", id);
        return this.transactionRepository.findByUserId(id);
    }

    @Override
    public Page<Transaction> findByUserId(Long id, PageRequest pageRequest) {
        LOG.info("Searching for transactions by user ID {} and pageable {}", id, pageRequest.getPageSize());
        return this.transactionRepository.findByUserId(id, pageRequest);
    }

    @Override
    public Optional<Transaction> save(Transaction transaction) {
        LOG.info("Persisting transaction {}", transaction);
        return Optional.of(this.transactionRepository.save(transaction));
    }
}
