package estagio.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MoviesRepo extends CrudRepository<Movie,Long> {
	
	@Query(value = "SELECT * FROM movie m WHERE m.movie_title like :title", nativeQuery = true)
	public List<Movie> doSearch(@Param("title") String title);

}
