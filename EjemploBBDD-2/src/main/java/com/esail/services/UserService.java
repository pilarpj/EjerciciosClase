package com.esail.services;

import com.esail.models.User;

public interface UserService {
	
	public boolean validar(User u);
	public User crear(String user, String pass);
	public boolean guardar (User user);

}
