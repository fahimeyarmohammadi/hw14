package ir.maktab.model;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("CurrentAccount")
public class CurrentAccount extends BankAccount {
}
