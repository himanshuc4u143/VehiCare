package com.sunbeaminfo.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//all specs Java EE supplied
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Customer") // to specify table name
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "password")
public class Customer extends BaseEntity {

	
	
	public Customer() {
		
	}


	@Column(length = 20) // varchar(20)
	private String firstName;
	
	@Column( length = 20)
	private String lastName;
	
	@Column(length = 30, unique = true) // unique constraint
	private String email;
	
	@Column(length = 20, nullable = false) // NOT NULL constraint
	//@JsonProperty(access = Access.WRITE_ONLY)//property will be used for de-ser ONLY	
	private String password;
	
	@Column(length = 100,nullable = false)
	@NotBlank(message="Address is  required")
	private String address;
	
	private LocalDate dateOfBirth;
	
	private String mobileNo;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
	@OneToMany(mappedBy="selectedCustomer",cascade=CascadeType.MERGE,orphanRemoval=true)
	@JsonIgnore 	
	private List<Orders> olist =new ArrayList<>();
}
