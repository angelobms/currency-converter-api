package tech.jaya.currencyconverter.api.repositories;

import tech.jaya.currencyconverter.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface for accessing the user repository.
 *
 * @author angelo santos
 * @version 1.0
 * @since 29/08/2020
 */
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
