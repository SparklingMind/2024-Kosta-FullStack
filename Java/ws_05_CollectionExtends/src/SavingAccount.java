

public class SavingAccount extends AccountDto {
    private double transferFee; // 이체 수수료

    public SavingAccount() {}

    public SavingAccount(int accountSeq, String accountNumber, int balance, int userSeq, double transferFee) {
        super(accountSeq, accountNumber, balance, userSeq);
        this.transferFee = transferFee;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "transferFee=" + transferFee +
                "} " + super.toString();
    }
}
