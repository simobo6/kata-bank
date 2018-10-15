import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;import org.junit.Assert;

public class BankAccountSteps {

    private BankAccount bankAccount;

    @Given("^valid bank account with a balance amount of (\\d+) EUR and -(\\d+) EUR of overdraft limit$")
    public void valid_bank_account_with_a_balance_amount_of_EUR_and_EUR_of_overdraft_limit(int arg1, int arg2)  {
        bankAccount = new BankAccount(arg1, arg2);
    }

    @When("^make a deposit of (\\d+)$")
    public void make_a_deposit_of(int arg1)  {
        bankAccount.deposit(arg1);
    }

    @Then("^new account balance after deposit is (\\d+)$")
    public void new_account_balance_after_deposit_is(int arg1)  {
        Assert.assertEquals(bankAccount.getBalance(), arg1);
    }

    @When("^make a withdrawal of (\\d+)  within the authorized overdraft limit$")
    public void make_a_withdrawal_of_within_the_authorized_overdraft_limit(int arg1)  {
        bankAccount.withdrawal(arg1);
    }

    @Then("^new account balance after withdrawal is (-?\\d+)$")
    public void new_account_balance_after_withdrawal_is(int arg1)  {
        Assert.assertEquals(bankAccount.getBalance(), arg1);
    }


    @When("^make a withdrawal of (\\d+) over the authorized overdraft limit$")
    public void make_a_withdrawal_of_over_the_authorized_overdraft_limit(int arg1)  {
        bankAccount.withdrawal(arg1);
    }

    @Then("^the account balance still remains (\\d+)$")
    public void the_account_balance_still_remains(int arg1)  {
        Assert.assertEquals(bankAccount.getBalance(), arg1);
    }

    @When("^make a full withdrawal of all my savings$")
    public void make_a_full_withdrawal_of_all_my_savings()  {
        bankAccount.fullWithdrawal();
    }

    @Then("^new account balance after a full withdrawal is -(\\d+)$")
    public void new_account_balance_after_a_full_withdrawal_is(int arg1)  {
        Assert.assertEquals(bankAccount.getBalance(), bankAccount.getOverdraftLimit());
    }
}
