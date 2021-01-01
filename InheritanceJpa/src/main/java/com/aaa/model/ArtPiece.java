package com.aaa.model;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(
		name = "ART_PIECE_TYPE",
		discriminatorType = DiscriminatorType.STRING
		)
public abstract class ArtPiece {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String author;
	private LocalDateTime createDateTime; 

	public ArtPiece() {
		super();
	}

	
	public ArtPiece(String author) {
		super();
		this.author = author;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}


	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}
	
	

}
