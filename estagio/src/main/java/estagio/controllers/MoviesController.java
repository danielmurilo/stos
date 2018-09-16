package estagio.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import estagio.model.AppUserRepo;
import estagio.model.Movie;
import estagio.model.MoviesRepo;

@Controller
public class MoviesController {

	@Autowired
	MoviesRepo movieRepo;
	@Autowired
	AppUserRepo userRepo;

	@RequestMapping(value = "/login")
	public ModelAndView login(ModelMap model, HttpServletRequest request) {
		ModelAndView mv;

		if (userRepo.doLogin(request.getParameter("login"), request.getParameter("password")).intValue() > 0) {
			mv = new ModelAndView("redirect:/listing");

		} else {
			mv = new ModelAndView("index");
			mv.addObject("hidden_attribute", "");
			mv.addObject("message1", "Ops!");
			mv.addObject("message2", "Login or password not found!");

		}
		return mv;

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
	public ModelAndView doSave(@RequestParam("id") String id, @RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam MultipartFile image) throws IOException{	
		
		ModelAndView mv = new ModelAndView("redirect:/listing");
		Movie movie = new Movie();
		if (!id.isEmpty()) {
			movie = (Movie) movieRepo.findOne(Long.parseLong(id));
		}
		if (!image.isEmpty()) {
			
            InputStream is = image.getInputStream();            
            movie.setImage(IOUtils.toByteArray(is));
			
		} 
		movie.setTitle(title);
		movie.setDescription(description);
		movieRepo.save(movie);
		return mv;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("redirect:/listing");
		movieRepo.delete(id);
		return mv;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView doEdit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("insert");
		mv.addObject("objectToEdit", movieRepo.findOne(id));
		return mv;
	}
	
	
}
