package com.aaa.specifications;

import java.time.LocalDateTime;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.aaa.model.ArtPiece;
import com.aaa.model.ArtPiece_;
import com.aaa.model.Painting;

public class ArtPieceSpecification extends BaseSpecification {
	
	 public static Specification<ArtPiece> createTimeIsGreaterThanOrEqualSpecification (final LocalDateTime startDate)
	    {
	        return buildIsGreaterThanOrEqualSpecification(ArtPiece_.createDateTime, startDate);
	    }

	    public static Specification<ArtPiece> creationTimeIsLessThanOrEqualSpecification (final LocalDateTime endDate)
	    {
	        return buildIsLessThanOrEqualSpecification(ArtPiece_.createDateTime, endDate);
	    }
	    
	    public static Specification<ArtPiece> countryEqualSpecification(final String country){
	    	return (root, query, builder)->
	    	{
	    		Predicate predicate = null;
	    		if(country != null) {
	    			Root<Painting> paintingRoot = builder.treat(root, Painting.class);
	    			predicate = builder.equal(paintingRoot.get("country"), country);
	    		}
	    		return predicate; 
	    	};
	    }


}
