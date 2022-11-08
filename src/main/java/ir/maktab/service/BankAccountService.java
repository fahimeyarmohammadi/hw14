package ir.maktab.service;

import ir.maktab.model.BankAccount;
import ir.maktab.repository.BankAccountRepository;

import java.util.List;

public class BankAccountService {
    static BankAccountRepository bankAccountRepository=new BankAccountRepository();

    public int saveBankAccount(BankAccount bankAccount){
        return bankAccountRepository.saveBankAccount(bankAccount);
    }
    public BankAccount findById(int id){
        return bankAccountRepository.findById(id);
    }
    public List<BankAccount> findAll(){
        return bankAccountRepository.findAllBankAccount();
    }
    public void update(BankAccount bankAccount){
        bankAccountRepository.updateBankAccount(bankAccount);
    }
    public void delete(BankAccount bankAccount){
        bankAccountRepository.deleteBankAccount(bankAccount);
    }
    public void withdraw(BankAccount bankAccount,double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Sorry, you can not withdraw a negative amount");
        }
        if (amount > bankAccount.getBalance()) {
            throw new RuntimeException("Your balance is not enough");
        }
        double balance= bankAccount.getBalance()-amount;
        bankAccount.setBalance(balance);
        bankAccountRepository.updateBankAccount(bankAccount);
    }
    public void deposit(BankAccount bankAccount,double amount) {
        double balance = bankAccount.getBalance() + amount;
        bankAccount.setBalance(balance);
        bankAccountRepository.updateBankAccount(bankAccount);
    }





}
