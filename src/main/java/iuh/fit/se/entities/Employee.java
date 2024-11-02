package iuh.fit.se.entities;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name= "first_name")
	@NotNull(message = "First Name must be not null")
	@NotEmpty(message =  "First name not be Empty")
	private String firstName;
	
	@Column(name= "last_name")
	@NotNull(message = "Last Name must be not null")
	@NotEmpty(message =  "Last name not be Empty")
	private String lastName;
	

	
	private String Gender;
	
	@Column(name= "email")
	@NotNull(message = "Email must be not null")
	@NotEmpty(message =  "Email not be Empty")
	private String emailAddress;
	
	@Column(name= "phone_number")
	@Pattern(regexp = "\\(\\d{3}\\)\\d{3}-\\d{4}", message = "Plesase input phone number with forrmat ")
	private String phoneNumber;
	
	@Past(message = "Date of birth musst be less than today")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	
	@CreationTimestamp
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	private Date modifiedDate;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name= "address_id", referencedColumnName = "id")
	@JsonIgnore
	private Address address;

}
