package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    User findUserByUserId(UUID id);

    @NotNull
    @Query("SELECT u FROM User u")
    List<User> findAll();

    Long deleteUserByUserId(UUID id);

    @Modifying
    @Query("UPDATE User u SET u.username = :newUsername WHERE u.userId = :userId")
    int updateUsernameById(@Param("userId") UUID userId, @Param("newUsername") String newUsername);
}
