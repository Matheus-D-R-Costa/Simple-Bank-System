import model.BankAccount;
import model.Client;
import model.CurrentAccount;
import model.SavingsAccount;

public class Main {

    public static void main(String[] args) {

        Client kylian = new Client();
        kylian.setClientName("Kylian Sthefane Di Naye");

        BankAccount currentAccount = new CurrentAccount(kylian);
        BankAccount savingsAccount = new SavingsAccount(kylian);

        currentAccount.deposit(100);
        currentAccount.withdraw(50);
        currentAccount.transfer(25, savingsAccount);
        currentAccount.invest(25);

        currentAccount.printStatement();
        savingsAccount.printStatement();
    }
}
