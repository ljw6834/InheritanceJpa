package com.aaa.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorValue(value = "PAINTING")
public class Painting extends ArtPiece {

	@Enumerated(value=EnumType.STRING)
	private PaintingTechnique paintingTechnique;
	private Double width;
	private Double height; 
	private String country; 
	
	public Painting() {
		super();
	}

	public Painting(String author, PaintingTechnique paintingTechnique, Double width, Double height, String country) {
		super(author);
		this.paintingTechnique = paintingTechnique;
		this.width = width;
		this.height = height;
		this.country = country; 
	}

	public PaintingTechnique getPaintingTechnique() {
		return paintingTechnique;
	}

	public void setPaintingTechnique(PaintingTechnique paintingTechnique) {
		this.paintingTechnique = paintingTechnique;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
