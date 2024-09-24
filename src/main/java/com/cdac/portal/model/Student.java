package com.cdac.portal.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk;

    @Column(nullable = false, unique = true)
    private Long prn;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mobile_no", nullable = false, unique = true)
    private long mobileNo;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "login_pk", referencedColumnName = "pk", nullable = false)
    private Login login;

    @Column
    @Lob
    private byte[] image;
    
    public void setPassword(String password) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedPassword = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        this.password = encodedPassword;
    }

    

}
