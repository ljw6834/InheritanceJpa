package com.aaa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.aaa.model.ArtPiece;

@Repository
public interface ArtPieceRepository extends JpaRepository<ArtPiece, Long>, JpaSpecificationExecutor<ArtPiece> {

	/*
	 * @Query("select a from ArtPiece a where a.createDateTime >= ?1 and a.createDateTime <= ?2"
	 * ) List<ArtPiece> findBetween(LocalDateTime start, LocalDateTime end);
	 */
}
