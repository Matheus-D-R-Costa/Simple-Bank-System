public interface Account {

    void deposit(double amount);
    void withdraw(double amount);
    void transfer(double amount, Account accountAddress);
    void printStatement();
}