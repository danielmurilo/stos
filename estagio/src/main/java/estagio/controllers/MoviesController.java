package estagio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import estagio.model.AppUserRepo;
import estagio.model.Movie;
import estagio.model.MoviesRepo;

@Controller
public class MoviesController {

	@Autowired
	MoviesRepo movieRepo;
	
	AppUserRepo userRepo;
	
	@RequestMapping( value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam("login") String login, @RequestParam("password") String password){
		if(userRepo.loginCheck(login, password)) {
			ModelAndView mv = new ModelAndView("redirect:/listing");
	        return mv;
		}else {
			return null;
		}
        
    }
	
	@GetMapping("/listing")
	public ModelAndView listing() {
		ModelAndView mv = new ModelAndView("listing");
		List<Movie> lists = (List<Movie>) movieRepo.findAll();
		for (Movie movie : lists) {
			try {
				movie.setImgTO64(Base64Coder.encodeLines(movie.getImage()));				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		mv.addObject("lists", lists);
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("image") byte[] image) {
		
		ModelAndView mv = new ModelAndView("redirect:/listing");
        Movie movie;
        
        if(!id.isEmpty()){
        	movie =(Movie)movieRepo.findOne(Long.parseLong(id));
        } else {
            movie = new Movie();
        }
        movie.setTitle(title);
        movie.setDescription(description);
        //movie.setImage(image);        
        movieRepo.save(movie);        
		return mv;
	}
	
	@RequestMapping( value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("redirect:/listing");
        movieRepo.delete(id);
        return mv;
    }
	
	@RequestMapping( value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView doEdit(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("insert");
        mv.addObject("objectToEdit",movieRepo.findOne(id));
        return mv;
    }

}
