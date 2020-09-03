package br.com.bmsti.currencyconverter.api.entities;

import br.com.bmsti.currencyconverter.api.enums.CurrencyType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * <b>Transaction</b> entity representing the database <b>transaction</b> table.
 * A persistent object of this class represents a record in the database.
 *
 * @author angelo santos
 * @version 1.0
 * @since 28/08/2020
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "originCurrency", nullable = false)
    private CurrencyType originCurrency;

    @Column(name = "originValue", nullable = false)
    private BigDecimal originValue;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "targetCurrency", nullable = false)
    private CurrencyType targetCurrency;

    @Column(name = "conversionRate", nullable = false)
    private BigDecimal conversionRate;

    @Column(name = "dateTransaction", nullable = false)
    private ZonedDateTime dateTransaction;

    @Column(name = "createdAt", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private ZonedDateTime updatedAt;

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
