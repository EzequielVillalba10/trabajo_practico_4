package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionCarrera;
import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.mapper.CarreraMapper;
import ar.edu.unju.fi.service.ICarreraService;
@Service
public class CarreraServiceImpl implements ICarreraService {

	@Autowired
	private CarreraMapper carreraMapper;
	
	@Override
	public List<CarreraDTO> findAll() {
		List<CarreraDTO> carrerasDTO=carreraMapper.toCarreraDTOList(CollectionCarrera.getCarreras());
		return carrerasDTO;
	}

	@Override
	public CarreraDTO findByCod_carrera(int cod_carrera) {
		CarreraDTO carreraDTO=carreraMapper.toCarreraDTO(CollectionCarrera.buscarCarrera(cod_carrera));
		return carreraDTO;
	}

	@Override
	public boolean save(CarreraDTO carreraDTO) {
		boolean respuesta = CollectionCarrera.agregarCarrera(carreraMapper.toCarrera(carreraDTO));
		return respuesta;
	}

	@Override
	public void deleteByCod_carrera(int cod_carrera) {
		CollectionCarrera.eliminarCarrera(cod_carrera);

	}

	@Override
	public void edit(CarreraDTO carreraDTO) throws Exception {
		CollectionCarrera.modificarCarrera(carreraMapper.toCarrera(carreraDTO));
	}

}
