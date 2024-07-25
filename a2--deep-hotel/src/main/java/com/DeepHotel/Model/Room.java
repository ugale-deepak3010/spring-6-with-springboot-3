package com.DeepHotel.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@Column(name = "ROOM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Id;

	@Column(length = 16)
	String name;
	
	@Column(length = 2)
	String roomNumber;

	@Column(length = 2)
	String bedInfo;

}
