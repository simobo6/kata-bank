Feature: Deposit and Withdrawal money from bank account
         We consider that the bank client he has a valid bank account.
         His authorized to make deposit and withdrawal operation on his account.

  Background: client have a valid bank account with an init balance and an overdraft limit
    Given valid bank account with a balance amount of 100 EUR and -150 EUR of overdraft limit


  Scenario Outline:
          In order to save money
          As a bank client
          I want to make a deposit in my account

    When  make a deposit of <DepositAmount>
    Then  new account balance after deposit is <NewBalance>

    Examples:
      | DepositAmount | NewBalance |
      | 50            | 150        |
      | 100           | 200        |


  Scenario Outline:
  In order to retrieve some money
  As a bank client
  I want to make a withdrawal from my account within the authorized overdraft limit

    When make a withdrawal of <WithdrawalAmount>  within the authorized overdraft limit
    Then new account balance after withdrawal is <NewBalance>

    Examples:
      | WithdrawalAmount | NewBalance |
      | 50               | 50         |
      | 150              | -50        |

  Scenario Outline:
  In order to retrieve some money
  As a bank client
  I want to make a withdrawal from my account over than the authorized overdraft limit

    When make a withdrawal of <WithdrawalAmount> over the authorized overdraft limit
    Then the account balance still remains <NewBalance>

    Examples:
      | WithdrawalAmount | NewBalance |
      | 500              | 100        |


  Scenario Outline:
  In order to retrieve all my money
  As a bank client
  I want to make a full withdrawal off all my money

    When make a full withdrawal of all my savings
    Then new account balance after a full withdrawal is <OverdraftLimitAmount>

    Examples:
      | OverdraftLimitAmount |
      | -150                 |

