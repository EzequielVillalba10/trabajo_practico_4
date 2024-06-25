package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.service.ICarreraService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	@Autowired
	private CarreraDTO carreraDTO;
	
	@Autowired
	private ICarreraService carreraService;
	
	@GetMapping("/listado")
	public String getCarrerasPage(Model model) {
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo","Carreras");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		return "carreras";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaCarreraPage(Model model) {
		boolean edicion=false;
		model.addAttribute("carrera", carreraDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva carrera");
		return "carrera";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO) {
		ModelAndView modelView=new ModelAndView("carreras");
		String mensaje;
		carreraDTO.setEstado(true);
		boolean exito = carreraService.save(carreraDTO);
		if(exito)
		{
			mensaje="Carrera guardada con exito!";
		}else {
			mensaje="Carrera no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("carreras",carreraService.findAll());
		return modelView;
	}
	
	@GetMapping("/modificar/{cod_carrera}")
	public String getModificarCarreraPage(Model model, @PathVariable(value="cod_carrera") int codigo) {
		CarreraDTO carreraEncontradaDTO= carreraService.findByCod_carrera(codigo);
		boolean edicion=true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("carrera", carreraEncontradaDTO);
		model.addAttribute("titulo","Modificar Carrera");
		return "carrera";
	}
	
	@PostMapping("/modificar")
	public String modificarCarrera(@ModelAttribute("carrera") CarreraDTO carreraDTO, Model model) {
		boolean exito=false;
		String mensaje="";
		try {
			carreraService.edit(carreraDTO);
			mensaje="La carrera "+carreraDTO.getNombre()+" fue modificada";
			exito=true;
		}catch(Exception e) {
			mensaje=e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("carreras", carreraService.findAll());
		model.addAttribute("titulo","Carreras");
		return "carreras";
	}
	
	@GetMapping("/eliminar/{cod_carrera}")
	public String eliminarCarrera(@PathVariable(value="cod_carrera") int codigo) {
		carreraService.deleteByCod_carrera(codigo);
		return "redirect:/carrera/listado";
	}
}
