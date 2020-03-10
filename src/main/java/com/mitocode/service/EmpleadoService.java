package com.mitocode.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mitocode.model.Empleado;

public interface EmpleadoService {

	Integer registrar(Empleado empleado);
	Integer actualizar(Empleado empleado);
	Integer eliminar(Integer idEmpleado);
	Empleado obtenerPorId(Integer idEmpleado);
	List<Empleado> obtenerEmpleados();
	Empleado login ( String usuario, String clave);
	
	
	
	
}
