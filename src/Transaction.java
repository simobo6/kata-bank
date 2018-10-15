public class Transaction {

    private long balance;
    private long amount;

    public Transaction(long _balance, long _amount){
        this.balance = _balance;
        this.amount = _amount;
    }

    public long getNewBalanceAfterTransaction(){
        return  balance + amount;
    }

}

