package com.weproud.authservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Logan. 81k
 */
@ToString
@Getter
@NoArgsConstructor
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -3853976858157157082L;

    @Id
    private long id;
    private String email;
    private String password;
    private String account;
}
