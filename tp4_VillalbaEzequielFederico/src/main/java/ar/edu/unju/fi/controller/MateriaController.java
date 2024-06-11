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

import ar.edu.unju.fi.collections.CollectionAlumno;
import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.collections.CollectionDocente;
import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.model.Alumno;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	
	
	@Autowired
	private Materia materia;
	
	@Autowired
	private Docente docente;
	
	@Autowired
	private Carrera carrera;

    MateriaController(Docente docente) {
        this.docente = docente;
    }
	@GetMapping("/listado")
	public String getMateriasPage(Model model)
	{
		model.addAttribute("titulo","Materias");
		model.addAttribute("exito",false);
		model.addAttribute("mensaje","");
		model.addAttribute("materias", CollectionMateria.getMaterias());
		return "materias";
	}
	
	@GetMapping("/nuevo")
	public String getMateriaNuevaPage(Model model) {
		model.addAttribute("materia",materia);
		model.addAttribute("docentes", CollectionDocente.getDocentes());
		model.addAttribute("carreras", CollectionCarrera.getCarreras());
		model.addAttribute("titulo","Nueva Materia");
		model.addAttribute("edicion",false);
		return "materia";
	}
	
	@PostMapping("/guardar")
	public ModelAndView guardarMateria(@ModelAttribute("materia") Materia materia, Model model)
	{
		ModelAndView modelView = new ModelAndView("materias");
		carrera = CollectionCarrera.buscarCarrera(materia.getCarrera().getCodigo());
		materia.setCarrera(carrera);
		docente = CollectionDocente.buscarDocente(materia.getDocente().getLegajo());
		String mensaje;
		boolean exito = CollectionMateria.agregarMateria(materia);
		if (exito) {
			mensaje ="Materia guardada cone exito";
			
		}
		else
		{
			mensaje = "Materia no se pudo guardar";
		}
		model.addAttribute("exito",mensaje);
		model.addAttribute("mensaje",mensaje);
		modelView.addObject("materias",CollectionMateria.getMaterias());
		return modelView;
	}
	
	@GetMapping("/modificar/{codigo}")
	public String getModificarMateriaPage(Model model, @PathVariable(value="codigo")int codigo) {
		Materia materiaEncontrada = new Materia();
		boolean edicion = true;
		materiaEncontrada = CollectionMateria.buscarMateria(codigo);
		model.addAttribute("edicion", edicion);
		model.addAttribute("materia", materiaEncontrada);
		model.addAttribute("titulo", "Modificar Materia");
		return "materia";
	}
	
	@GetMapping("eliminar/{codigo}")
	public String eliminarMateria(@PathVariable(value="codigo")int codigo) {
		CollectionMateria.eliminarMateria(codigo);
		return "redirect:/materia/listado";
	}
}
