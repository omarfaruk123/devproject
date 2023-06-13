package dev.faruk.devproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.faruk.devproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
}
