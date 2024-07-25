package com.DeepHotel.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomReservation {

	long roomId;
	String roomName;
	String roomNumber;
	long guestId;
	String firstName;
	String lastName;
	long reservationId;
	String reservationDate;
}
