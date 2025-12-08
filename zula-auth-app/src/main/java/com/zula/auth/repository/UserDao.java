package com.zula.auth.repository;

import com.zula.auth.entity.UserEntity;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.transaction.Transaction;

import java.util.Optional;

@RegisterBeanMapper(UserEntity.class)
public interface UserDao {

    @SqlQuery("SELECT id, username, email, password_hash AS passwordHash, first_name AS firstName, last_name AS lastName, status, last_login AS lastLogin FROM user_entity WHERE id = :id")
    Optional<UserEntity> findById(@Bind("id") long id);

    @SqlQuery("SELECT id, username, email, password_hash AS passwordHash, first_name AS firstName, last_name AS lastName, status, last_login AS lastLogin FROM user_entity WHERE username = :username")
    Optional<UserEntity> findByUsername(@Bind("username") String username);

    @SqlQuery("SELECT id, username, email, password_hash AS passwordHash, first_name AS firstName, last_name AS lastName, status, last_login AS lastLogin FROM user_entity WHERE email = :email")
    Optional<UserEntity> findByEmail(@Bind("email") String email);

    @SqlQuery("SELECT COUNT(1) > 0 FROM user_entity WHERE username = :username")
    boolean existsByUsername(@Bind("username") String username);

    @SqlQuery("SELECT COUNT(1) > 0 FROM user_entity WHERE email = :email")
    boolean existsByEmail(@Bind("email") String email);

    @SqlUpdate("INSERT INTO user_entity (username, email, password_hash, first_name, last_name, status, last_login) VALUES (:username, :email, :passwordHash, :firstName, :lastName, :status, :lastLogin)")
    @Transaction
    void insert(@Bind("username") String username,
                @Bind("email") String email,
                @Bind("passwordHash") String passwordHash,
                @Bind("firstName") String firstName,
                @Bind("lastName") String lastName,
                @Bind("status") String status,
                @Bind("lastLogin") java.time.LocalDateTime lastLogin);

    @SqlUpdate("UPDATE user_entity SET username = :username, email = :email, password_hash = :passwordHash, first_name = :firstName, last_name = :lastName, status = :status, last_login = :lastLogin WHERE id = :id")
    @Transaction
    void update(@Bind("id") long id,
                @Bind("username") String username,
                @Bind("email") String email,
                @Bind("passwordHash") String passwordHash,
                @Bind("firstName") String firstName,
                @Bind("lastName") String lastName,
                @Bind("status") String status,
                @Bind("lastLogin") java.time.LocalDateTime lastLogin);
}

