package com.ecommerce.www.repository;

import java.util.Optional;

import com.ecommerce.www.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByEmail(String email);
}
