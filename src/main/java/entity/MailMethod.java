package entity;

public class MailMethod extends PaymentMethod {
    public final String email;

    public MailMethod(String email) {
        this.email = email;
    }
}
