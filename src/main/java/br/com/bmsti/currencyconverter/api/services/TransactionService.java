package br.com.bmsti.currencyconverter.api.services;

import br.com.bmsti.currencyconverter.api.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import java.util.Set;

/**
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
public interface TransactionService {

    /**
     * Method responsible for searching transaction by id.
     *
     * @param id transaction id
     * @return Optional<Transaction>
     */
    Optional<Transaction> findById(Long id);

    /**
     * Method responsible for searching transactions by user id.
     *
     * @param id transaction id
     * @return Optional<Transaction>
     */
    Set<Transaction> findByUserId(Long id);

    /**
     * Method responsible for searching transactions by user id pageable.
     *
     * @param id transaction id
     * @return Page<Transaction>
     */
    Page<Transaction> findByUserId(Long id, PageRequest pageRequest);

    /**
     * Method responsible for persisting transaction.
     *
     * @param transaction transaction
     * @return Optional<Transaction>
     */
    Optional<Transaction> save(Transaction transaction);

}
