package com.cdac.portal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    @NonNull
    @Column(name = "user_name", unique = true)
    private String userName;

    @NonNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_pk", nullable = false)
    private Role role;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private Student student;

    @OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
    private Employee employee;
}
