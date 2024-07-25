package com.DeepHotel.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepHotel.Model.Room;

public interface RoomRepo extends JpaRepository<Room, Long> {

	Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
