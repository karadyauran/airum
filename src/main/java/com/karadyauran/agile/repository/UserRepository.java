package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID>
{
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Modifying
    @Query("update User u set u.username = :username where u.id = :id")
    void changeUsername(UUID id, String username);

    @Modifying
    @Query("update User u set u.firstname = :firstname where u.id = :id")
    void changeFirstname(UUID id, String firstname);

    @Modifying
    @Query("update User u set u.surname = :surname where u.id = :id")
    void changeSurname(UUID id, String surname);

    @Modifying
    @Query("update User u set u.email = :email where u.id = :id")
    void changeEmail(UUID id, String email);
}
