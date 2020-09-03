package tech.jaya.currencyconverter.api.controllers;

import tech.jaya.currencyconverter.api.dtos.TransactionDTO;
import tech.jaya.currencyconverter.api.services.TransactionService;
import tech.jaya.currencyconverter.api.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * Class controller transaction
 *
 * @author angelo santos
 * @version 1.0
 * @since 30/08/2020
 */
@Slf4j
@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final UserService userService;

    private final TransactionService transactionService;

    public TransactionController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    /**
     * Method responsible for creating a currency conversion transaction
     *
     * @param transactionDTO transaction Data Transfer Object
     * @return ResponseEntity<TransactionDTO> result
     */
    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        log.info("Create transaction: {}", transactionDTO.toString());

        TransactionDTO result = this.transactionService.save(transactionDTO);

        return ResponseEntity.ok(result);
    }

    /**
     * Method responsible for searching for currency conversion transactions carried out by a user
     *
     * @param userId user id
     * @return ResponseEntity<Set<TransactionDTO>>
     */
    @GetMapping("/{userId}")
    public ResponseEntity<Set<TransactionDTO>> getTransactionBuUser(@Valid @PathVariable Long userId) {

        Set<TransactionDTO> transactions = this.transactionService.findByUserId(userId);
        log.info("Create transaction: {}", transactions);

        return ResponseEntity.ok(transactions);
    }
}
