

public class LoanAccount extends AccountDto {
    private String collateral; // 담보

    public LoanAccount() {}

    public LoanAccount(int accountSeq, String accountNumber, int balance, int userSeq, String collateral) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.collateral = collateral;
    }

    public String getCollateral() {
        return collateral;
    }

    public void setCollateral(String collateral) {
        this.collateral = collateral;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "collateral='" + collateral + '\'' +
                "} " + super.toString();
    }
}
