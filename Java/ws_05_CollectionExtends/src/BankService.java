

import java.util.List;

public interface BankService {
	
	
	public List<AccountDto> getAccountList(int userSeq);

	public UserDto getUserDetail(int userSeq);
	
	public List<AccountDto> getAccountList();
	
	public List<AccountDto> getAccountListSortByBalance();
	
	public List<AccountDto> getAccountListSortByUserSeq();
	
	AccountDto getUserAccount(int userSeq, int accountSeq) throws UserAccountNotFoundException;
	
	int withdraw(int userSeq, int accountSeq, int amount) throws BalanceLackException, UserAccountNotFoundException;
	
	
	}
