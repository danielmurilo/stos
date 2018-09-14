package estagio.model;

import org.springframework.data.repository.CrudRepository;


public interface AppUserRepo extends CrudRepository<AppUser, Long> {
	
	public Boolean loginCheck(String login , String password);

}
