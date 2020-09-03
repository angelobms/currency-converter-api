package br.com.bmsti.currencyconverter.api.entities;

import br.com.bmsti.currencyconverter.api.enums.ProfileType;
import lombok.*;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * <b>User</b> entity representing the database <b>user</b> table.
 * A persistent object of this class represents a record in the database.
 *
 * @author angelo santos
 * @version 1.0
 * @since 28/08/2020
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "profile", nullable = false)
    private ProfileType profile;

    @Column(name = "createdAt", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    @PrePersist
    public void prePersist() {
        createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = ZonedDateTime.now(ZoneId.of("UTC"));
    }
}
