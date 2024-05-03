public abstract class BankAccount implements Account {

    private static final int DEFAULT_AGENCY = 0001;
    private static int sequential = 1;

    protected Client client;

    protected int agency;
    protected int accountNumber;
    protected double balance = 0;

    public BankAccount(Client client) {
        this.client = client;
        this.agency = DEFAULT_AGENCY;
        this.accountNumber = sequential++;
    }

    public int getAgency() {
        return agency;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void transfer(double amount, Account accountAddress) {
        this.withdraw(amount);
        accountAddress.deposit(amount);
    }

    @Override
    public void printStatement() {

        System.out.println("=== Extrato Conta ===");
        System.out.println("Titular: " + client.getClientName());
        System.out.printf("Agencia: %d%n", agency);
        System.out.printf("Numero da Conta: %d%n", accountNumber);
        System.out.printf("Balance: %.2f ", balance);
        System.out.println();
    }
}