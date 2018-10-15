

public class App {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100L, 150L);

        // Save money
        bankAccount.deposit(100);

        // Retreive some money
        bankAccount.withdrawal(100);


        // Retreive all my savings
        bankAccount.fullWithdrawal();

        // Retreive some money impossible
        bankAccount.withdrawal(100);

        bankAccount.printStatement();


    }
}