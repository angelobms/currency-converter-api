package tech.jaya.currencyconverter.api.services;

import tech.jaya.currencyconverter.api.dtos.TransactionDTO;
import tech.jaya.currencyconverter.api.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Set;

/**
 * Class interface service user
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
    Transaction findById(Long id);

    /**
     * Method responsible for searching transactions by user id.
     *
     * @param id transaction id
     * @return Optional<Transaction>
     */
    Set<TransactionDTO> findByUserId(Long id);

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
     * @param transactionDTO transactionDTO
     * @return Optional<Transaction>
     */
    TransactionDTO save(TransactionDTO transactionDTO);

}
