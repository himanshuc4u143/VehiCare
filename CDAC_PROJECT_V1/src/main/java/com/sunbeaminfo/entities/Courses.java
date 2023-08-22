package com.sunbeaminfo.entities;

import java.time.LocalDate;

//all specs Java EE supplied
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "new_courses") // to specify table name
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Courses extends BaseEntity {

	@Column(length = 20)
	private String Name;
	
	@Column(length = 20, nullable = false) // NOT NULL constraint
	//@JsonProperty(access = Access.WRITE_ONLY)//property will be used for de-ser ONLY
	private String password;		
	private LocalDate startDate;
	private LocalDate endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	@NotNull(message = "category must be supplied!!!!")
	private Category category;
	
	
}
