package com.esail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esail.models.User;
import com.esail.models.UsersRepository;

@Controller
public class HomeController {
	/**
	 * Se instancia la variable UsersRepository para poder usar
	 * el repositorio de usuarios, que almacenará usuarios dentro.
	 */
	@Autowired
	private UsersRepository usersRepository;
		
	@RequestMapping(value = {"/", "/index"})
	public String index() {
		return "index";
	}
	
	/**Se usa el repositorio Users creado anteriormente para que almacene usuarios 
	 * dentro. Es decir, metemos dentro de la mochila model el atributo repositorio usuarios y
	 * dentro del repositorio creamos un usuario y lo metemos dentro.
	*/
	@RequestMapping(value="/listado")
	public String listado(Model model) {
		Iterable<User> lista = usersRepository.findAll();
		model.addAttribute("resultado" , lista);
		return "listado";
	}
	
	
}
