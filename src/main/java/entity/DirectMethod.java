package entity;

public class DirectMethod extends PaymentMethod {
    public final String bank;
    public final int account;

    public DirectMethod(String bank, int account) {
        this.bank = bank;
        this.account = account;
    }
}
