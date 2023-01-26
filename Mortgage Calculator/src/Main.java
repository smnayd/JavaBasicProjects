import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner input = new Scanner(System.in);
        System.out.println("-- Welcome to Mortgage Calculator! --");
        System.out.print("Principal: ");
        double principal = input.nextDouble();
        while(principal<0){
            System.out.print("Enter correct principal: ");
            principal = input.nextDouble();
        }
        System.out.print("Annual interest rate: ");
        float annualInterest = input.nextFloat();
        while(annualInterest<0){
            System.out.print("Enter correct annual interest rate: ");
            annualInterest = input.nextFloat();
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = input.nextByte();
        while(years<0){
            System.out.print("Enter correct period: ");
            years = input.nextByte();
        }
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = (principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + formattedMortgage);

    }
}