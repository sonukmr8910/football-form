package com.form.footballform.repository;

import com.form.footballform.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player getPlayerById(Long id);
}
