/**
 * Created by joshuakeough on 8/31/16.
 */
public class Atm {
    String userName;
    String atmOption;
    int balance = 100;
    int withdrawl;

    public void inputName() {
        System.out.println("Hello please tell me your name.");
        userName = Main.scanner.nextLine();
        if(userName.equals("")) {
            System.out.println("Sorry you did not enter anything");
            inputName();
        } else {
            System.out.println("Welcome, " + userName);
        }
    }

    public void balance() {
        System.out.println("Your Balance is $" + balance);
        chooseOption();
    }

    public void withdraw() {
        System.out.println("How much would you like to withdraw?");
        withdrawl = Integer.parseInt(Main.scanner.nextLine());
        if(withdrawl <= balance) {
            balance = balance - withdrawl;
            System.out.println("Thanks please take your cash. Your remaining balance is $" + balance);
            chooseOption();
        } else if(withdrawl > balance) {
            System.out.println("Sorry funds not available please try again.");
            this.withdraw();
        }

    }

    public void deposit() {
        System.out.println("How much would you like to deposit?");
        balance = Integer.parseInt(Main.scanner.nextLine()) + balance;
        System.out.println("Your money has been deposited!");
        chooseOption();
    }




    public void chooseOption() {
        System.out.println("Please enter an option!\n1. Check my balance.\n2. Cancel\n3. Withdraw.\n4. Deposit ");
        atmOption = Main.scanner.nextLine();
        switch(atmOption) {
            case "1":
                balance();
                break;
            case "2":
                System.out.println("Thank you and please come again!");
                break;
            case "3":
                withdraw();
                break;
            case "4":
                deposit();
                break;
            default:
                System.out.println(atmOption + " is not an option.");
                this.chooseOption();
        }

    }
}
