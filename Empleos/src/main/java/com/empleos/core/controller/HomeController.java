package com.empleos.core.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empleos.core.model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla (Model model) {
		List<Vacante> lista = getVacantes();
		model.addAttribute("vacantes",lista);		
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle (Model model) {
		Vacante vacante= new Vacante();		
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero par dar soporte a Internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.0);		
		model.addAttribute("vacante",vacante);		
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarListado(Model model) {
		
		List<String> lista = new LinkedList<>();
		
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar de Contabilidad");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		
		model.addAttribute("empleos",lista);		
		return "listado";
	}

	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje","Bienvenidos a Empleos APP Pasado por Attribute"
		 * ); model.addAttribute("fecha",new Date());
		 */
		String nombre = "Auxiliar de Contabilidad";
		Date fechaPub = new Date();
		double salario = 9000;
		boolean vigente = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigente", vigente);

		return "home";
	}
	
	private List<Vacante> getVacantes(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		List<Vacante> lista = new LinkedList<>();
		try {
			// Creamos la oferta de trabajo 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ing. Civiles");
			vacante1.setFecha( sdf.parse("09-02-2019") );
			vacante1.setSalario(1200.00);
			vacante1.setDestacado(1);
			
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero Sistemas");
			vacante2.setDescripcion("Solicitamos Ing. Sistemas");
			vacante2.setFecha( sdf.parse("09-02-2019") );
			vacante2.setSalario(1200.00);
			vacante2.setDestacado(0);
						
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Doctores");
			vacante3.setDescripcion("Solicitamos Doctores");
			vacante3.setFecha( sdf.parse("09-02-2019") );
			vacante3.setSalario(1200.00);
			vacante3.setDestacado(0);
			
			Vacante vacante4 = new Vacante();
			vacante4.setId(41);
			vacante4.setNombre("Enfermeras");
			vacante4.setDescripcion("Solicitamos Enfermeras");
			vacante4.setFecha( sdf.parse("09-02-2019") );
			vacante4.setSalario(1200.00);
			vacante4.setDestacado(1);
			
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		}
		catch (ParseException e) {
			System.out.println("Error "+ e.getMessage());
		}
		
		return lista;
	}

}
