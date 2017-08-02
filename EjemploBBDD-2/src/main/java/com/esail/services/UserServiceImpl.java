package com.esail.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esail.models.User;
import com.esail.models.UsersRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepository usersRepository;
	

	@Override
	public boolean validar(User u) {
		boolean esValido = false;
		
		if (u.getUserName().equals("admin") && u.getPass().equals("12345")) {
			esValido=true;
		}
		return esValido;
	}

	@Override
	public User crear(String user, String pass) {
		User u = new User();
		u.setUserName(user);
		u.setPass(pass);
		return u;
	}

	@Override
	public boolean guardar(User user) {
		usersRepository.save(user);
		return true;
	}

}
