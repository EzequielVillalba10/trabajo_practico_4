package ar.edu.unju.fi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import ar.edu.unju.fi.dto.CarreraDTO;
import ar.edu.unju.fi.model.Carrera;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
/*Componente*/
public interface CarreraMapper {
	/*source, los atributos de la clase. target se refiere al DTO*/

	@Mapping(source="nombre",target="nombre") 
	@Mapping(source="codigo", target="codigo")
	@Mapping(source="cantidadAnios", target="cantidadAnios")
	@Mapping(source="estado", target="estado")


	CarreraDTO toCarreraDTO(Carrera carrera);
	
	
	@InheritInverseConfiguration /*Inversa de la configuracion del DTO al usuario*/
	Carrera toCarrera(CarreraDTO carreraDTO);
	
	List<CarreraDTO> toCarreraDTOList(List<Carrera> carreras);
	
	List<Carrera> toCarreraList(List<CarreraDTO> carrerasDTO);
}
