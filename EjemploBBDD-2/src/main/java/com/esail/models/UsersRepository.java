package com.esail.models;

import org.springframework.data.repository.CrudRepository;
/**
 * Esta interfaz se usa para hacer un repositorio de una clase específica, 
 * en este caso usuarios. El repositorio se usará en el controller para almacenar usuarios.
 * @author Lenovo
 *
 */
public interface UsersRepository extends CrudRepository<User, Integer>{

}
