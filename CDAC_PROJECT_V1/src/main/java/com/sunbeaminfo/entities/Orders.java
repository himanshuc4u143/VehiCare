package com.sunbeaminfo.entities;

import java.time.LocalDate;

//all specs Java EE supplied
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Orders") // to specify table name
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Orders extends BaseEntity {

	private LocalDate orderBookingDate;
	
	private LocalDate servicingDate;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer selectedCustomer;
//	@Column(length = 20) // varchar(20)
//	private String firstName;
//	
//	@Column( length = 20)
//	private String lastName;
//	
//	@Column(length = 30, unique = true) // unique constraint
//	private String email;
//	
//	@Column(length = 20, nullable = false) // NOT NULL constraint
//	//@JsonProperty(access = Access.WRITE_ONLY)//property will be used for de-ser ONLY	
//	private String password;
//	
//	@Column(length = 100,nullable = false)
//	@NotBlank(message="Address is  required")
//	private String address;
//	
//	private LocalDate dateOfBirth;
//	
//	private String mobileNo;
//	@Enumerated(EnumType.STRING)
//	private Gender gender;
	
	
}
