package com.aaa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import com.aaa.model.ArtPiece;
import com.aaa.model.Material;
import com.aaa.model.Painting;
import com.aaa.model.PaintingTechnique;
import com.aaa.model.Sculpture;
import com.aaa.model.SearchRequest;
import com.aaa.repository.ArtPieceRepository;
import com.aaa.specifications.ArtPieceSpecification;

@SpringBootApplication
public class InheritanceJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InheritanceJpaApplication.class, args);
		ArtPieceRepository artPieceRepo = context.getBean(ArtPieceRepository.class);
		
	    ArtPiece sculpture = new Sculpture("John Doe", Material.WOOD, 220.2);
	    sculpture.setCreateDateTime(LocalDateTime.parse("2018-02-20T06:30:00"));
	    ArtPiece painting1 = new Painting("Tom Smith", PaintingTechnique.ACRYLIC, 25.5, 44.9, "China");
	    painting1.setCreateDateTime(LocalDateTime.now());
	    artPieceRepo.save(painting1);
	    
	    ArtPiece painting2 = new Painting("Mike Bill", PaintingTechnique.ACRYLIC, 25.5, 44.9, "US");
	    painting2.setCreateDateTime(LocalDateTime.parse("2018-02-20T06:30:00"));
	    artPieceRepo.save(painting2);
	    
	    artPieceRepo.save(sculpture);
//	    SearchRequest request = new SearchRequest(null, LocalDateTime.parse("2017-02-20T06:30:00"), LocalDateTime.parse("2020-02-20T06:30:00"), "China");
	    SearchRequest request = new SearchRequest(null, null, null, "China");
		
	    
	    List<ArtPiece> artPieces = artPieceRepo.findAll(buildSpecification(request));
	    
	    System.out.println(artPieces.get(0).getAuthor());
	}
	
	private static Specification<ArtPiece> buildSpecification (SearchRequest request)
    {
        return Specification.where(ArtPieceSpecification.createTimeIsGreaterThanOrEqualSpecification(request.getStart()))
        		.and(ArtPieceSpecification.countryEqualSpecification(request.getCountry()))
        		.and(ArtPieceSpecification.countryEqualSpecification(request.getCountry()));
    }

}
