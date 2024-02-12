

import java.util.List;

public class Test {
	public static void main(String[] args) {

		BankService bankService = new BankServiceImpl();
		System.out.println("1. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
		System.out.println("2.잔액기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByBalance());
		
		
		System.out.println("3.UserSeq 기준으로 정렬하기 -------------");
		print(bankService.getAccountListSortByUserSeq());
		
		
		System.out.println("4. 모든 계좌정보 조회 ------");
		print(bankService.getAccountList());
		
		
		////////WS_8 추가된 문제///////////////////////////////////////
		try {
			int withdrawAmount = bankService.withdraw(111, 10, 100);
			System.out.println(withdrawAmount);
			
			System.out.println(bankService.getUserAccount(111, 10));
			
		}catch( BalanceLackException | UserAccountNotFoundException e ) {
			System.out.println( e.getMessage());
		}
		
		
	}
	

	/**
	 * 계좌목록 출력하기
	 * */
	public static void print(List<AccountDto> accountList) {
		for (AccountDto accountDto : accountList) {
			System.out.println(accountDto);
		}
		System.out.println();
	}

}
