package ir.maktab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accountNumber;
    private String cartNumber;
    private LocalDate accountOpeningDate;
    private double balance;
    private int cvv2;
    private LocalDate expirationDate;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, String cartNumber, LocalDate accountOpeningDate,
                       double balance, int cvv2, LocalDate expirationDate) {
        this.accountNumber = accountNumber;
        this.cartNumber = cartNumber;
        this.accountOpeningDate = accountOpeningDate;
        this.balance = balance;
        this.cvv2 = cvv2;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return cvv2 == that.cvv2 && accountNumber.equals(that.accountNumber) && cartNumber.equals(that.cartNumber) && accountOpeningDate.equals(that.accountOpeningDate) && expirationDate.equals(that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, cartNumber, accountOpeningDate, cvv2, expirationDate);
    }
}
