import bank.services.AppService;

import java.util.Scanner;
import java.util.List;

public class Main {
    private final static List<String> menuItems = List.of(
        "Create customer",
        "Get customer",
        "Update customer",
        "Delete customer",
        "Get accounts IBAN (for given CNP)",
        "Get account info (for given IBAN)",
        "Create account (for given CNP)",
        "Update account info (for given IBAN)",
        "Delete account",
        "Create transaction",
        "Get transactions",
        "Update transaction (for given transaction ID)",
        "Delete transaction (for given transaction ID)",
        "Exit"
    );
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AppService appService = AppService.getInstance();
        boolean running = true;
        while (running) {
            System.out.println("Choose an option (any letter for available options): ");
            String option = in.nextLine();
            switch (option) {
                case "1":
                    appService.createCustomer();
                    break;
                case "2":
                    appService.getCustomer();
                    break;
                case "3":
                    appService.updateCustomer();
                    break;
                case "4":
                    appService.deleteCustomer();
                    break;
                case "5":
                    appService.getAccountsIBAN();
                    break;
                case "6":
                    appService.getAccountInfo();
                    break;
                case "7":
                    appService.createAccount();
                    break;
                case "8":
                    appService.updateAccount();
                    break;
                case "9":
                    appService.deleteAccount();
                    break;
                case "10":
                    appService.createTransaction();
                    break;
                case "11":
                    appService.getTransactions();
                    break;
                case "12":
                    appService.updateTransaction();
                    break;
                case "13":
                    appService.deleteTransaction();
                    break;
                case "14":
                    running = false;
                    break;
                default:
                    System.out.println("Available options: ");
                    for (int i = 0; i < menuItems.size(); i++) {
                        System.out.println(i + 1 + ". " + menuItems.get(i));
                    }
                    break;
            }
        }
    }
}
