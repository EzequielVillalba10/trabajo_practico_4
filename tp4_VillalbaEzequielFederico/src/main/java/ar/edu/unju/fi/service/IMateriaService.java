package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.MateriaDTO;

public interface IMateriaService {
	
	List<MateriaDTO> findAll();
	MateriaDTO findById(int cod);
	boolean save(MateriaDTO materiaDTO);
	void deleteByCod(int cod);
	void edit(MateriaDTO materiaDTO) throws Exception;
}