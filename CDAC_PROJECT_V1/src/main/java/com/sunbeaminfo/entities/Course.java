//package com.sunbeaminfo.entities;
//
//import java.time.LocalDate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Table(name = "c") // to specify table name
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//
//public class Course extends BaseEntity{
//	@NotNull(message = "Name must be supplied!!!!")
//	@Column(length = 20) 
//	private String Name;
//	
//	@Column(length = 20)
//	@NotNull(message = "category must be supplied!!!!")
//	@Enumerated(EnumType.STRING)
//	private Category category; 
//	
//	@NotNull(message = "startdate must be supplied!!!!")
//	private LocalDate StartDate;
//	@NotNull(message = "enddate must be supplied!!!!")
//	private LocalDate EndDate;
//	
//	@Column(length = 20)
//	@NotNull(message = "Fees must be supplied!!!!")
//	private Double Fees;
//     
//}
