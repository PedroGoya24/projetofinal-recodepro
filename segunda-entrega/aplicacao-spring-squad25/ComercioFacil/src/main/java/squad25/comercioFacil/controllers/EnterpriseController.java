package squad25.comercioFacil.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.repositoryes.EmployerRepository;
import squad25.comercioFacil.repositoryes.EnterpriseRepository;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@GetMapping("/listarAll")
	public ModelAndView listarAll() {
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/restrictedArea.html");				
		List<Enterprise> enterprises = enterpriseRepository.findAll();

		modelAndView.addObject("enterprises", enterprises);
		return modelAndView;
	}
	
	@GetMapping("/show")
	public ModelAndView showFormEnterprise() {
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/formEnterprise.html");	
		
		modelAndView.addObject("marketplace", null);
		return modelAndView;
	}	
	
	@PostMapping("/cadastrarImage")
	public ModelAndView cadastrarImage(){	
//		Codigo de cadastro da imagem;
		
		ModelAndView modelAndview = new ModelAndView("redirect:/enterprise/listarProducts");	
		return modelAndview;
	}
	
	@GetMapping("/listarProducts")
	public ModelAndView listarProducts() {
		ModelAndView modelAndview = new ModelAndView("employer/enterprise/product/listProduct.html");	
		
		return modelAndview;
	}
	
	//CONTROLLER NOVO acima;
	
	@GetMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id) {
		Enterprise enterprise = new Enterprise();
		
		List<Employer> employers = employerRepository.findAll(); 		
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/cadastro.html");	
		modelAndView.addObject("enterprise", enterprise);
		modelAndView.addObject("employers", employers);
		return modelAndView;
	}	
	
	@GetMapping("{id}/listar")
	public ModelAndView listar(@PathVariable("id") Long id) {
		Employer employer = employerRepository.getReferenceById(id);
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/listar.html");				
		List<Enterprise> enterprises = enterpriseRepository.findAllByIdUser(id);

		modelAndView.addObject("enterprises", enterprises);
		modelAndView.addObject("employer", employer);
		return modelAndView;
	}
	
	
	@PostMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id, @ModelAttribute Enterprise enterprise,  @RequestParam("idUser") Long idUser){				
		Employer employer = employerRepository.getReferenceById(idUser);
		
		enterprise.setUser(employer);
		ModelAndView modelAndview = new ModelAndView("redirect:/employer/{id}/detalhes");
		enterpriseRepository.save(enterprise);
		return modelAndview;
	}
		
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		
		enterpriseRepository.deleteById(id);
		return modelAndView;						
	}
}