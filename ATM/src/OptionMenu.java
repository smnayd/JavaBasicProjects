import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat(" '$' ####, ##0.00 ");
    HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(1, 1);
                data.put(2, 2);
                System.out.println("Welcome to the ATM!");
                System.out.print("Enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter your pin: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception ex) {
                System.out.println("\nInvalid character(s). Only numbers.\n");
                x = 2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("\nWrong Customer Number or Pin Number\n");
            }
        } while (x == 1);
    }
    public void getAccountType(){
        System.out.println("Select the account you want to access: ");
        System.out.println("Type 1 - Checking account\nType 2 - Saving account\nType 3 - Exit");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using ATM, goodbye!\n");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getAccountType();
        }
    }
    public void getChecking(){
        System.out.println("Checking account: \nType 1 - View Balance\nType 2 - Withdraw Funds\nType 3 - Deposit Funds\nType 4 - Exit\nChoice: ");
        int selection = menuInput.nextInt();
        switch (selection){
            case 1:
                System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ATM, goodbye!");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("Saving account:\nType 1 - View Balance\nType 2 - Withdraw Funds\nType 3 - Deposit Funds\nType 4 - Exit\nChoice: ");
        int selection = menuInput.nextInt();
        switch(selection){
            case 1:
                System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using ATM, goodbye!");
                break;
            default:
                System.out.println("\nInvalid choice.\n");
                getChecking();
        }

    }

}

