package utils;

import dao.UserDAO;
import entities.User;

public class CheckUtil {
	static UserDAO userDAO;
	
	public static boolean checkEmail(String email) {
		userDAO = new UserDAO();
		
		if(!(email.contains("@"))) {
			return false;
		}
		User user = userDAO.findByEmail(email);
		if(user != null) {
			return false;
		}
		return true;
	}
	
	public static boolean checkSoLuong(String so) {
		if(so == null) {
			return false;
		}
		int sol = Integer.parseInt(so);
		if(sol <= 0) {
			return false;
		}
		return true;
	}
	
	public static boolean checkDonGia(String don) {
		if(don == null) {
			return false;
		}
		double dong = Double.parseDouble(don);
		if(dong <= 0) {
			return false;
		}
		return true;
	}
	
	public static boolean checkNull(String text) {
		if(text == null) {
			return false;
		}
		return true;
	}
}
