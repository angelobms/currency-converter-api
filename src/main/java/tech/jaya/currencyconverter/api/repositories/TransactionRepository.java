package tech.jaya.currencyconverter.api.repositories;

import tech.jaya.currencyconverter.api.entities.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.Set;

/**
 * Interface for accessing the user repository.
 *
 * @author angelo santos
 * @version 1.0
 * @since 29/08/2020
 */
@Transactional(readOnly = true)
@NamedQueries({
        @NamedQuery(name = "TransactionRepository.findByUserId",
                    query= "SELECT transaction FROM Transaction transaction WHERE transaction.user.id = :userId")
})
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Set<Transaction> findByUserId(@Param("userId") Long userId);

    Page<Transaction> findByUserId(@Param("userId") Long userId, Pageable pageable);
}
