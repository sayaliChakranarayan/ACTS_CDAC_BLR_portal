package com.cdac.portal.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pk;

	@Column(nullable = false, name = "role_name")
	private String roleName;

	@OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<Login> logins;
	
}