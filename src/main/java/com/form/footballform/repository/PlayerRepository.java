package com.form.footballform.repository;

import com.form.footballform.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> getPlayerById(Long id);
    Optional<Player> getPlayerByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
}
