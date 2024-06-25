package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import ar.edu.unju.fi.dto.MateriaDTO;
import ar.edu.unju.fi.model.Materia;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaMapper {
	@Mappings({
		
		@Mapping(source="cantidadHoras", target="cantidadHoras"),
		@Mapping(source="carrera", target="carrera"),
		@Mapping(source="codigo", target="codigo"),
		@Mapping(source="docente", target="docente"),
		@Mapping(source="modalidad", target="modalidad"),
		@Mapping(source="nombre", target="nombre")
	})
	
	MateriaDTO toMateriaDTO(Materia materia);
	@InheritInverseConfiguration
	Materia toMateria(MateriaDTO materiaDTO);
	
	List<MateriaDTO> toMateriaDTOList(List<Materia> materias);
	List<Materia> toMateriaList(List<MateriaDTO> materiasDTO);
	
}
