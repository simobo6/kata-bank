import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class BankAccount {
    private AtomicLong solde = new AtomicLong();
    private  long overdraftLimit;
    private LinkedList<Operation> listOperations = new LinkedList();
    private Transaction transaction;


    public BankAccount(long balance, long overdraft){
        this.solde.set(balance);
        this.overdraftLimit = -overdraft;
    }

    public void deposit(long amount){
        saveTransaction(amount, getBalance(), OperationType.DEPOSIT);
    }

    public void withdrawal(long amount){
            if(getBalance() - amount >= overdraftLimit){
                saveTransaction(-amount, getBalance(), OperationType.WITHDRAWAL);
            }
    }

    public void fullWithdrawal() {
            if(getBalance()  > overdraftLimit){
                long possibleAmount = Math.abs(overdraftLimit) + getBalance();
                saveTransaction(-possibleAmount, getBalance(), OperationType.FULLWITHDRAWAL);
            }
    }
    private void saveTransaction(long _amount, long _balance, OperationType _operationType) {
        transaction = new Transaction(_balance, _amount);
        solde.set(transaction.getNewBalanceAfterTransaction());
        listOperations.add(new Operation(_operationType, Math.abs(_amount), solde.get()));
    }


    public  void printStatement(){
        System.out.println(this.listOperations.stream().map(e -> e.toString()).collect(Collectors.joining("\n")));
    }

    public long getBalance(){
        return solde.longValue();
    }

    public long getOverdraftLimit(){
        return overdraftLimit;
    }

}