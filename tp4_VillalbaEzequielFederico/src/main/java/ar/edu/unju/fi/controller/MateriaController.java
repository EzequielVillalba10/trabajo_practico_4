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
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.service.IMateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	@Autowired
	private MateriaDTO materiaDTO;
	
	@Autowired
	private IMateriaService materiaService;
	
	@GetMapping("/listado")
	public String getMateriasPage(Model model) {
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("titulo","Materias");
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getNuevaMateriaPage(Model model) {
		boolean edicion=false;
		model.addAttribute("materia", materiaDTO);
		model.addAttribute("edicion", edicion);
		model.addAttribute("titulo", "Nueva materia");
		return "materia";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO) {
		ModelAndView modelView=new ModelAndView("materias");
		String mensaje;
		materiaDTO.setModalidad("Precensial");
		boolean exito=materiaService.save(materiaDTO);
		if(exito)
		{
			mensaje="Materia guardada con exito!";
		}else {
			mensaje="Materia no se pudo guardar";
		}
		modelView.addObject("exito", exito);
		modelView.addObject("mensaje", mensaje);
		modelView.addObject("carreras",materiaService.findAll());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo") int codigo) {
		MateriaDTO materiaEncontradaDTO= materiaService.findById(codigo);
		boolean edicion=true;
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontradaDTO);
		model.addAttribute("titulo","Modificar Materia");
		return "materia";
	}
	
	@PostMapping("/modificar")
	public String modificarMateria(@ModelAttribute("materia") MateriaDTO materiaDTO, Model model) {
		boolean exito=false;
		String mensaje="";
		try {
			materiaService.edit(materiaDTO);
			mensaje="La materia con codigo "+materiaDTO.getCodigo()+" fue modificada";
			exito=true;
		}catch(Exception e) {
			mensaje=e.getMessage();
			e.printStackTrace();
		}
		model.addAttribute("exito", exito);
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("materias", materiaService.findAll());
		model.addAttribute("titulo","Materias");
		return "materias";
	}
	
	@GetMapping("/eliminar/{cod}")
	public String eliminarMateria(@PathVariable(value="cod") int codigo) {
            materiaService.deleteByCod(codigo);
            return "redirect:/materia/listado";
	}
	
	
}
