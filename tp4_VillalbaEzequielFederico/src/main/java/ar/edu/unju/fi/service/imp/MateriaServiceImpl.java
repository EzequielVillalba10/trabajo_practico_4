package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.collections.CollectionMateria;
import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.mapper.MateriaMapper;
import ar.edu.unju.fi.service.IMateriaService;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private MateriaMapper materiaMapper;
	
	@Override
	public List<MateriaDTO> findAll() {
		List<MateriaDTO> materiasDTO = materiaMapper.toMateriaDTOList(CollectionMateria.getMaterias());
		return materiasDTO;
	}

	@Override
	public MateriaDTO findById(int cod) {
		MateriaDTO materiaDTO = materiaMapper.toMateriaDTO(CollectionMateria.buscarMateria(cod));
		return materiaDTO;
	}

	@Override
	public boolean save(MateriaDTO materiaDTO) {
		boolean respuesta = CollectionMateria.agregarMateria(materiaMapper.toMateria(materiaDTO));
		return respuesta;
	}

	@Override
	public void deleteByCod(int cod) {
		CollectionMateria.eliminarMateria(cod);
	}

	@Override
	public void edit(MateriaDTO materiaDTO) throws Exception {
		CollectionMateria.modificarMateria(materiaMapper.toMateria(materiaDTO));
	}

}
