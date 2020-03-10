package com.mitocode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import com.mitocode.model.Empleado;
import com.mitocode.service.EmpleadoService;

import ch.qos.logback.classic.Logger;

@SpringBootTest
@ContextConfiguration
public class EmpleadoServiceTest {

	@Autowired
	private EmpleadoService empleadoService;
	
	@Test
	public void insert() {
		
		Empleado empleado = new Empleado();
		empleado.setNombres("Dany");
		empleado.setApellidos("Cenas Vasquez");
		empleado.setDocumento("12345678");
		
		empleado.setFechaNacimiento(LocalDate.now());
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(0);
		empleado.setUsuario("admin");
		empleado.setClave("admin");
		
		int status = empleadoService.registrar(empleado);
		Assert.state(status == 1 , "Insert failed");
		Assert.state(empleado.getIdEmpleado() == 1, "Insert failed 2");
	}
	
	@Test
	public void update() {
		
		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);
		empleado.setNombres("Juan");
		empleado.setApellidos("Cenas Vasquez");
		empleado.setDocumento("12345678");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date ="13/10/1992";
				
		LocalDate localDate = LocalDate.parse(date, formatter);
		empleado.setFechaNacimiento(localDate);
		empleado.setSueldo(1000);
		empleado.setNumeroHijos(0);
		empleado.setUsuario("admin");
		empleado.setClave("admin");
		
		int status = empleadoService.actualizar(empleado);
		Assert.state(status == 1 , "Insert failed");
	}
	
	@Test
	public void delete() {
		
		int idEmpleado = 1;
		int status = empleadoService.eliminar(idEmpleado);
		Assert.state(status == 1, "Deletion failed");
	
	}
	
	@Test
	public void list() {
		List<Empleado> list = empleadoService.obtenerEmpleados();
		Assert.notNull(list, "list is null");
		Assert.notEmpty(list, " list is empty");
	}
	
	@Test
	public void testLogin() {
		Empleado empleado = empleadoService.login("admin", "123456");
		
		Assert.notNull(empleado, "empleado is null");
	}
	
	
	
}
