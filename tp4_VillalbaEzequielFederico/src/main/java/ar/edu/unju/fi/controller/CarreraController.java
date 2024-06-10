package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.model.Carrera;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	private Carrera carrera;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model) {
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("titulo", "Carreras");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		return "carreras";
	}
	
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion = false;
		model.addAttribute("carrera", carrera);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva Carrera");
		return "carrera";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") Carrera carrera) {
		ModelAndView modelView = new ModelAndView("carreras");
		String mensaje;
		carrera.setEstado(true);
		boolean exito = CollectionCarrera.agregarCarrera(carrera);
		if (exito) {
			mensaje = "Carrera guardado con exito!";
		}else
		{
			mensaje = "Carrera no se pudo guardar";
		}
		modelView.addObject("exito",exito);
		modelView.addObject("mensaje",mensaje);
		modelView.addObject("carreras", CollectionCarrera.getCarreras());
		return modelView;
	}
	
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="codigo")int codigo) {
		Carrera carreraEncontrada = new Carrera();
		boolean edicion = true;
		carreraEncontrada = CollectionCarrera.buscarCarrera(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontrada);
		model.addAttribute("titulo", "Modificar Carrera");
		return "carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera")Carrera carrera) {
		CollectionCarrera.modificarCarrera(carrera);
		return "redirect:/carrera/listado";
	}


	@GetMapping("eliminar/{codigo}")
	public String eliminarCarrera(@PathVariable(value="codigo")int codigo) {
		CollectionCarrera.eliminarCarrera(codigo);
		return "redirect:/carrera/listado";
	}
}
