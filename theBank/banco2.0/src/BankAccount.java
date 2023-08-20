class BankAccount {
    private static int accountCounter = 1000; // Starting account number
    private int accountNumber;
    private double balance;
    private String openingDate;

    public BankAccount(double initialBalance) {
        this.accountNumber = accountCounter++;
        this.balance = initialBalance;
        this.openingDate = "Today"; //use a date library
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            if (amount < 1000) {
                balance -= amount;
            } else {
                double tax = 200 + (0.15 * Integer.parseInt(openingDate)); // Assuming month as an integer value
                balance -= (amount + tax);
            }
            return true;
        }
        return false;
    }
}