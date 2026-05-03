package com.trucks_logistics.Trucks.Logistics.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
