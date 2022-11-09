package ir.maktab.service;

import ir.maktab.model.BankAccount;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountServiceTest {
    static BankAccountService bankAccountService;
    static BankAccount bankAccount;

    @BeforeAll
    static void setUp() {
        bankAccountService = new BankAccountService();
    }

    @Test
    void saveBankAccountTest() {
        System.out.println("Running saveBankAccountTest...");
        bankAccount = new BankAccount("1234567890", "1234567890987654", LocalDate.of(2020, 11, 21), 10e6, 1234, LocalDate.of(2024, 11, 13));
        int id = bankAccountService.saveBankAccount(bankAccount);
        assertTrue(id > 0);
    }

    @Test
    void findByIdTest() {
        System.out.println("Running findByIdTest...");
        bankAccount = new BankAccount("1234567890", "1234567890987654", LocalDate.of(2020, 11, 21), 10e6, 1234, LocalDate.of(2024, 11, 13));
        assertEquals(bankAccount, bankAccountService.findById(1));
    }

    @Test
    void findAllBankAccountTest() {
        System.out.println("Running findAllBankAccountTest...");
        assertFalse(bankAccountService.findAll().isEmpty());
    }

    @Test
    void updateBankAccountTest() {
        System.out.println("Running updateBankAccountTest...");
        String accountNumber = "9876543210";
        BankAccount bankAccount1 = bankAccountService.findById(1);
        bankAccount1.setAccountNumber(accountNumber);
        bankAccountService.update(bankAccount1);
        assertEquals(bankAccount1, bankAccountService.findById(1));
    }


    /*@Test
    void deleteBankAccountTest() {
        BankAccount bankAccount = bankAccountService.findById(1);
        bankAccountService.delete(bankAccount);
        BankAccount bankAccount1 = bankAccountService.findById(1);
        assertNull(bankAccount1);
    }*/


    @Test
    void withdrawTest() {
        BankAccount bankAccount = bankAccountService.findById(1);
        double balance = bankAccount.getBalance();
        double amount = 5e6;
        bankAccountService.withdraw(bankAccount, amount);
        assertEquals((balance - 5e6), bankAccountService.findById(1).getBalance());
    }

    @Test
    void notNegativeEmauntTest() {
        System.out.println("Running notNegativeEmauntTest");
        BankAccount bankAccount = bankAccountService.findById(1);
        double balance = bankAccount.getBalance();
        double amount = -5000000.0;
        try {
            bankAccountService.withdraw(bankAccount, amount);
        } catch (IllegalArgumentException e) {
            assertEquals("Sorry, you can not withdraw a negative amount", e.getMessage());
        }
    }

    @Test
    void amountMoreThanBalanceTest() {
        System.out.println("Running amountMoreThanBalanceTest");
        BankAccount bankAccount = bankAccountService.findById(1);
        bankAccount.setBalance(5e5);
        double amount = 10e5;
        try {
            bankAccountService.withdraw(bankAccount, amount);
        } catch (RuntimeException e) {
            assertEquals("Your balance is not enough", e.getMessage());
        }
    }

    @Test
    void depositTest() {
        BankAccount bankAccount1 = bankAccountService.findById(1);
        double balance = bankAccount1.getBalance();
        double amount = 5e6;
        bankAccountService.deposit(bankAccount1, amount);
        assertEquals((balance + 5e6), bankAccountService.findById(1).getBalance());
    }
}