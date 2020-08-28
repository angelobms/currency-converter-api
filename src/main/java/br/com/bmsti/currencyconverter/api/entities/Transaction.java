package br.com.bmsti.currencyconverter.api.entities;

import br.com.bmsti.currencyconverter.api.enums.CurrencyType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <b>Transaction</b> entity representing the database <b>transaction</b> table.
 * A persistent object of this class represents a record in the database.
 *
 * @author angelo santos
 * @version 1.0
 * @since 28/08/2020
 */
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(value = EnumType.STRING)
    private CurrencyType originCurrency;

    @Column(name = "originValue", nullable = false)
    private BigDecimal originValue;

    @Column(name = "conversionRate", nullable = false)
    private BigDecimal conversionRate;

    @Column(name = "dateTransaction", nullable = false)
    private LocalDateTime dateTransaction;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CurrencyType getOriginCurrency() {
        return originCurrency;
    }

    public void setOriginCurrency(CurrencyType originCurrency) {
        this.originCurrency = originCurrency;
    }

    public BigDecimal getOriginValue() {
        return originValue;
    }

    public void setOriginValue(BigDecimal originValue) {
        this.originValue = originValue;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
