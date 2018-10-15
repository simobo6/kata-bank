import java.util.Date;

public class Operation {

    private Date operationDate;
    private OperationType operationType;
    private long amount;
    private long balance;


    public Operation(OperationType _perationType, long _amount, long _balance){
        this.amount = _amount;
        this.balance = _balance;
        this.operationType = _perationType;
        this.operationDate = new Date();
    }

    @Override
    public String toString() {
        return String.format("Date %tc >> %s of %d EUR - new balance is %d EUR", operationDate, operationType.name(), amount, balance);
    }
}
