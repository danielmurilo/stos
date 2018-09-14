package estagio.dao;

public abstract class AppUserDAO {
	
	public Boolean loginCheck (String login , String password) {
		
		//simulating persistence...
		if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				return true;
		}
		
		return false;
	}

}
