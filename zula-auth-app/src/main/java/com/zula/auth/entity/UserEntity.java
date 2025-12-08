package com.zula.auth.entity;

import com.zula.database.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Plain POJO for use with JDBI mappers. JPA annotations removed.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity {

    private String username;

    private String email;

    private String passwordHash;

    private String firstName;

    private String lastName;

    @Builder.Default
    private String status = "ACTIVE";

    private LocalDateTime lastLogin;
}
