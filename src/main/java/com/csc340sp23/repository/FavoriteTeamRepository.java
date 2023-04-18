package com.csc340sp23.repository;

import com.csc340sp23.domain.FavoriteTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteTeamRepository extends JpaRepository<FavoriteTeam, Long> {
    
}
