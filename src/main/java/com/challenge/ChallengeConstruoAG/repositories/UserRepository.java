package com.challenge.ChallengeConstruoAG.repositories;

import com.challenge.ChallengeConstruoAG.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
