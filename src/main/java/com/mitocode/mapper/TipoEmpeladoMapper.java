package com.mitocode.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mitocode.model.TipoEmpleado;

@Mapper
public interface TipoEmpeladoMapper {

	@Select("SELECT * FROM tipoempleado WHERE idtipoempeado = #{idTipoEmpleado}")
	TipoEmpleado obtenerTipo(@Param("idTipoEmpleado") Integer idTipoEmpleado);
	
	
	
	
}


