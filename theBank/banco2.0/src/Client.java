class Client {
    private String username;
    private String password;
    private BankAccount savingsAccount;

    public Client(String username, String password, double initialBalance) {
        this.username = username;
        this.password = password;
        this.savingsAccount = new BankAccount(initialBalance);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public BankAccount getSavingsAccount() {
        return savingsAccount;
    }
}
