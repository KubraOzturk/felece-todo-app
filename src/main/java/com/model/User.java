package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("password")
public class User extends  BaseModel implements Serializable {
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String lastName;


    @OneToMany(cascade = CascadeType.ALL, targetEntity = TodoItem.class, mappedBy = "user")
    private List<TodoItem> toDos = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY)
   // @JoinTable(	name = "user_roles",
           // joinColumns = @JoinColumn(name = "user_id"),
           // inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email,String password, String name, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
    }

}
