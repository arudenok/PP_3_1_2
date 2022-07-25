package ru.kata.spring.boot_security.demo.repositoty;

import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
    User getUserByUsername(String name);
    User getUserById(int id);
}
