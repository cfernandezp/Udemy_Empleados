package com.empleos.core.controller;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empleos.core.model.Vacante;

@Controller
public class HomeController {
	
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

}