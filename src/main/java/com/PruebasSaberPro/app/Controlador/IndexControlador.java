	package com.PruebasSaberPro.app.Controlador;
	
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	
	public class IndexControlador {
		@Controller
		@RequestMapping("/login")
		public class IndexController {
	
			@RequestMapping
			public String inicio(Model model) {
				String titulo = "Pagina de inicio";
				model.addAttribute("titulo", titulo);
				return "login";
			}
		}
	}
