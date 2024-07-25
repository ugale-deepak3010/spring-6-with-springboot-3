package com.DeepHotel.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GUESTS")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GUEST_ID")
	long id;

	@Column(length = 64)
	String firstName;

	@Column(length = 64)
	String lastName;

	@Column(length = 64)
	String emailAddress;

	@Column(length = 64)
	String address;

	@Column(length = 32)
	String country;

	@Column(length = 12)
	String state;

	@Column(length = 24)
	String phoneNumber;

}
