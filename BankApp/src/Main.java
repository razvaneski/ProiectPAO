import bank.services.AppService;

import java.util.Scanner;
import java.util.List;

public class Main {
    private final static List<String> menuItems = List.of(
        "create_customer",
        "get_customer",
        "update_customer",
        "delete_customer",
        "create_account",
        "get_account",
        "update_account",
        "delete_account",
        "create_card",
        "get_card",
        "update_card",
        "delete_card",
        "exit"
    );
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AppService appService = AppService.getInstance();
        boolean running = true;
        while (running) {
            System.out.println("Choose an option (any letter for available options): ");
            String option = in.nextLine();
            switch (option) {
                case "0":
                    appService.createCustomer();
                    break;
                case "1":
                    appService.getCustomer();
                    break;
                case "2":
                    appService.updateCustomer();
                    break;
                case "3":
                    appService.deleteCustomer();
                    break;
                case "4":
//                    appService.createAccount();
                    break;
                case "5":
//                    appService.getAccount();
                    break;
                case "6":
//                    appService.updateAccount();
                    break;
                case "7":
//                    appService.deleteAccount();
                    break;
                case "8":
//                    appService.createCard();
                    break;
                case "9":
//                    appService.getCard();
                    break;
                case "10":
//                    appService.updateCard();
                    break;
                case "11":
//                    appService.deleteCard();
                    break;
                case "12":
                    running = false;
                    break;
                default:
                    for (int i = 0; i < menuItems.size(); i++) {
                        System.out.println(i + ". " + menuItems.get(i));
                    }
                    break;
            }
        }
    }
}
