import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class GlobantBankSystem {
    private static Map<String, Client> clients = new HashMap<>();
    public static void main(String[] args) {
        // Crear clientes y agregarlos al mapa 'clients'
        Client client1 = new Client("user123", "pass123", 1000.0);
        clients.put(client1.getUsername(), client1);

        Client client2 = new Client("john_doe", "securePass", 500.0);
        clients.put(client2.getUsername(), client2);

        Client client3 = new Client("jane_smith", "secret123", 750.0);
        clients.put(client3.getUsername(), client3);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Print all clients");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    printAllClients();
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    logIn(username, password);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void printAllClients() {
        System.out.println("Clients and their related information:");
        for (Client client : clients.values()) {
            System.out.println("Username: " + client.getUsername());
            System.out.println("Account Number: " + client.getSavingsAccount().getAccountNumber());
            System.out.println("Balance: $" + client.getSavingsAccount().getBalance());
            System.out.println("Opening Date: " + client.getSavingsAccount().getOpeningDate());
            System.out.println();
        }
    }

    private static void logIn(String username, String password) {
        if (clients.containsKey(username)) {
            Client client = clients.get(username);
            if (client.getPassword().equals(password)) {
                performTransactions(client);
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("Username not found.");
        }
    }

    private static void performTransactions(Client client) {
        BankAccount account = client.getSavingsAccount();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose a transaction:");
            System.out.println("1. Withdraw money");
            System.out.println("2. Add money");
            System.out.println("3. Transfer money");
            System.out.println("4. Log out");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful.");
                        System.out.println("Remaining balance: $" + account.getBalance());
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    System.out.println("Updated balance: $" + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    if (transferMoney(account, recipientAccountNumber, transferAmount)) {
                        System.out.println("Transfer successful.");
                        System.out.println("Remaining balance: $" + account.getBalance());
                    } else {
                        System.out.println("Transfer failed. Insufficient funds or invalid account number.");
                    }
                    break;
                case 4:
                    System.out.println("Logging out.");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static boolean transferMoney(BankAccount senderAccount, int recipientAccountNumber, double amount) {
        if (senderAccount.getBalance() >= amount + 100) { // Includes the transfer tax
            for (Client client : clients.values()) {
                if (client.getSavingsAccount().getAccountNumber() == recipientAccountNumber) {
                    senderAccount.withdraw(amount + 100); // Includes the transfer tax
                    client.getSavingsAccount().deposit(amount);
                    return true;
                }
            }
        }
        return false;
    }
}
