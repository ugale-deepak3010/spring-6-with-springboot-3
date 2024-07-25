package com.DeepHotel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DeepHotel.Model.Guest;

public interface GuestRepo extends JpaRepository<Guest, Long> {

}
