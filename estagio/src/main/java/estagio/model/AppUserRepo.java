package estagio.model;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Transactional
public interface AppUserRepo extends CrudRepository<AppUser, Long> {
	
	@Query(value = "SELECT (SELECT COUNT(*) FROM app_users a WHERE a.login = :login and a.password = :password) > 0", 
			  nativeQuery = true)
	public BigInteger doLogin(@Param("login") String login, @Param("password") String password);
}
