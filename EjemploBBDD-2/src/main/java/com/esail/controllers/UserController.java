package com.esail.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esail.models.User;
import com.esail.models.UsersRepository;
import com.esail.services.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/validar", method=RequestMethod.POST)
	public String validar(Model mochila,
			@RequestParam(name="user") String user, 
			@RequestParam(name="pass") String pass
			) {
		
		//Creamos un usuario temporal y lo validamos, ambas opciones desde un servicio para no tener que saber como se crea o valida un User
		boolean esValido = false;
		User userTemporal = userService.crear(user, pass);
		esValido = userService.validar(userTemporal);
		
		//Y ahora decidimos qué mensaje enviar a index, y a qué vista ir
		String mensaje= "";
		String destino="index";
		if (esValido) {
			mensaje = "Usuario correcto";
			destino = "home";
			mochila.addAttribute("user", userTemporal); //Le enviamos el objeto User, ya que es válido y así en home.html podemos usar sus datos
		} else {
			mensaje = "Usuario y/o contraseña incorrectos";
			destino = "index";
		}
		mochila.addAttribute("mensaje", mensaje); //Lo adjuntamos al index (desde allí lo recuperamos con ${mensaje})
		
		//Y nos vamos a index, con nuestra mochila "llena" (tiene un mensaje)
		return destino;
	}
	
	

	
	@RequestMapping(value="/alta/{user}/{pass}")
	public String alta(Model model, 
			/**
			 * Se usa pathvariable porque viene por url, si los parametros entran
			 * por formulario o input se usar requestparam.
			 */
			@PathVariable(name="user")String user,
			@PathVariable(name="pass")String pass) {
		//Creo un usuario usando el servicio crear.
		User u = userService.crear(user, pass);
		userService.guardar(u);
		return "index";
	}
	
	
	
	
}
