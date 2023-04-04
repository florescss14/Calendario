package com.chrisflores.calendariospring.data;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
	Iterable<User> findByUsername(String username);
}
