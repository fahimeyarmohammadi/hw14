package ir.maktab.repository;

import ir.maktab.model.BankAccount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BankAccountRepository {
    static final SessionFactory SESSION_FACTORY = DatabaseAccess.getSessionFactory();

    public int saveBankAccount(BankAccount bankAccount) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(bankAccount);
        transaction.commit();
        session.close();
        return id;
    }

    public BankAccount findById(int id) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        BankAccount bankAccount = session.get(BankAccount.class, id);
        transaction.commit();
        session.close();
        return bankAccount;
    }

    public List<BankAccount> findAllBankAccount() {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        Query<BankAccount> query = session.createQuery("FROM BankAccount ", BankAccount.class);
        List<BankAccount> BankAccountList = query.getResultList();
        transaction.commit();
        session.close();
        return BankAccountList;
    }

    public void updateBankAccount(BankAccount bankAccount) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(bankAccount);
        transaction.commit();
        session.close();
    }

    public void deleteBankAccount(BankAccount bankAccount) {
        Session session = SESSION_FACTORY.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(bankAccount);
        transaction.commit();
        session.close();
    }
}
