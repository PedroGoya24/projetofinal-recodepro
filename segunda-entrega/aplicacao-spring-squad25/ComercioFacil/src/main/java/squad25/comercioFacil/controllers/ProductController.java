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
import squad25.comercioFacil.models.Enterprise;
import squad25.comercioFacil.models.Product;
import squad25.comercioFacil.repositoryes.EnterpriseRepository;
import squad25.comercioFacil.repositoryes.ProductRepository;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	
	@GetMapping("{id}/listar")
	public ModelAndView listar(@PathVariable("id") Long id) {
		Enterprise enterprise = enterpriseRepository.getReferenceById(id);
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/product/listar.html");
		List<Product> products = productRepository.findAllByIdEnterprise(id);
		modelAndView.addObject("products", products);
		modelAndView.addObject("enterprise", enterprise);
		
		return modelAndView;
		
	}

	@GetMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id) {
		Product product = new Product();
		List<Enterprise> enterprises = enterpriseRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/product/cadastro.html");
		modelAndView.addObject("product", product);
		modelAndView.addObject("enterprises", enterprises);
		return modelAndView;		
	}
	
	@PostMapping("{id}/cadastrar")
	public ModelAndView cadastrar(@PathVariable("id") Long id,
								  @ModelAttribute Product product,
								  @RequestParam("idEnterprise") Long idEnterprise) {
		Enterprise enterprise = enterpriseRepository.getReferenceById(idEnterprise);
		product.setEnterprise(enterprise);		
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		productRepository.save(product);
		return modelAndView; 
	}
	
	@GetMapping("{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("employer/enterprise/product/editar");
		List<Enterprise> enterprises = enterpriseRepository.findAll();
		modelAndView.addObject("product", productRepository.getReferenceById(id));
		modelAndView.addObject("enterprises", enterprises);
		return modelAndView;
	}
	
	@PostMapping("{id}/editar")
	public ModelAndView editar(Product product,@RequestParam("idEnterprise") Long idEnterprise) {
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		Enterprise enterprise = enterpriseRepository.getReferenceById(idEnterprise);
		product.setEnterprise(enterprise);		
		productRepository.save(product);
		return modelAndView;
	}
	
	@GetMapping("{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/employer");
		productRepository.deleteById(id);
		return modelAndView;
	}
}