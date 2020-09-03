package tech.jaya.currencyconverter.api.converters;

import tech.jaya.currencyconverter.api.dtos.TransactionDTO;
import tech.jaya.currencyconverter.api.entities.Transaction;

/**
 * Class converter transaction
 *
 * @author angelo santos
 * @version 1.0
 * @since 31/08/2020
 */
public class TransactionConverter {

    /**
     * Method responsible for converting a transaction to a data transaction object
     *
     * @param transactionDTO transaction Data Transfer Object
     * @return Transaction
     */
    public static Transaction covertTo(TransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setOriginCurrency(transactionDTO.getOriginCurrency());
        transaction.setTargetCurrency(transactionDTO.getTargetCurrency());
        transaction.setOriginValue(transactionDTO.getOriginValue());
        transaction.setDateTransaction(transactionDTO.getDateTransaction());

        return transaction;
    }

    /**
     * Method responsible for converting a data transaction object to a transaction
     *
     * @param transaction transaction
     * @return TransactionDTO
     */
    public static TransactionDTO covertTo(Transaction transaction) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setUserId(transaction.getUser().getId());
        transactionDTO.setOriginCurrency(transaction.getOriginCurrency());
        transactionDTO.setOriginValue(transaction.getOriginValue());
        transactionDTO.setTargetCurrency(transaction.getTargetCurrency());
        transactionDTO.setConversionRate(transaction.getConversionRate());
        transactionDTO.setDateTransaction(transaction.getDateTransaction());

        return transactionDTO;
    }
}
