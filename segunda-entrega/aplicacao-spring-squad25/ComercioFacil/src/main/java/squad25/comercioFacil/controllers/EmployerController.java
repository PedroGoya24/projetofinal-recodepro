package squad25.comercioFacil.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.repositoryes.EmployerRepository;
import squad25.comercioFacil.util.AccesLevel;

@Controller
@RequestMapping("/employer")
public class EmployerController {
	
	@Autowired
	private EmployerRepository employerRepository;
	private AccesLevel accesLevel;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("employer/listar.html");
 
		List<Employer> employers = employerRepository.findByAccesLevel(accesLevel);
		
		modelAndView.addObject("employers", employers);
		
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(){
		ModelAndView modelAndView = new ModelAndView("employer/cadastro.html");
		modelAndView.addObject("employer", new Employer());
		
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Employer employer){
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		employerRepository.save(employer);
		return modelAndView;	
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id){
		ModelAndView modelAndView = new ModelAndView("employer/editar");
		modelAndView.addObject("employer", employerRepository.getReferenceById(id));
		return modelAndView;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Employer employer) {
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		employerRepository.save(employer);
		return modelAndView;
	}
	
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		employerRepository.deleteById(id);
		return modelAndView;
		
	}
	
	
	@GetMapping("/{id}/detalhes")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("employer/detalhes");
		Employer employer = employerRepository.getReferenceById(id);
		modelAndView.addObject("employer", employer);
	
		return modelAndView;
	}
	
	
	
	
	
}
