package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	List<CarreraDTO> findAll();
	
	CarreraDTO findByCod_carrera(int cod_carrera);
	
	boolean save(CarreraDTO carreraDTO);
	
	void deleteByCod_carrera(int cod_carrera);
	
	void edit(CarreraDTO carreraDTO) throws Exception;
}
