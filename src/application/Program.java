package application;

import models.entities.Account;
import models.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = scanner.nextInt();
            System.out.print("Holder: ");
            scanner.nextLine();
            String holder = scanner.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = scanner.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);

            System.out.printf("New balance: %.2f", account.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}
