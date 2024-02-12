package com.ws03.dto;

/**
 *  고객의 계좌정보 관리하는 객체
 * */
public class AccountDto  implements Comparable<AccountDto>{
   public int accountSeq;
   public String accountNumber;
   public int balance;
   public int userSeq;
   
   public AccountDto() {}
   public AccountDto(int accountSeq, String accountNumber, int balance, int userSeq) {
	this.accountSeq = accountSeq;
	this.accountNumber = accountNumber;
	this.balance = balance;
	this.userSeq = userSeq;
  }
   
	@Override
	public int compareTo(AccountDto o) {
		return (balance - o.balance) == 0 ? ( o.accountSeq - accountSeq ) : (balance - o.balance); //음수 or 0 or 양수
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountDto [accountSeq=");
		builder.append(accountSeq);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", userSeq=");
		builder.append(userSeq);
		builder.append("]");
		return builder.toString();
	}
   
	
    
}










