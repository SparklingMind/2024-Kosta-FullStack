

public class InstallAccount extends AccountDto {
    private int term; // 기간
    private int amount; // 금액

    public InstallAccount() {}

    public InstallAccount(int accountSeq, String accountNumber, int balance, int userSeq, int term, int amount) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.term = term;
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "InstallAccount{" +
                "term=" + term +
                ", amount=" + amount +
                "} " + super.toString();
    }
}
