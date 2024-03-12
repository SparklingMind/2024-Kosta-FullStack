package app.mvc.controller;

import app.mvc.model.dto.Customer;
import app.mvc.model.service.CustomerService;
import app.mvc.view.FailView;
import app.mvc.view.MenuView;

public class CustomerController {
	static CustomerService customerService = new CustomerService();
 /**
  * 로그인
  * */
	public static void login(String userId, String userPwd) {
		try {
			Customer customer = customerService.login(userId, userPwd);
			MenuView.printUserMenu(userId);
			//MenuView.menu();
		}catch (Exception e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
			
		}
	}

	/**
	 * 가입
	 */
public static void register(String userId, String userPwd) {
	try {
		customerService.register(userId, userPwd);
		MenuView.menu();
	} catch (Exception e) {
		FailView.errorMessage(e.getMessage());
	}
	
}
}
