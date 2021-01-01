package com.aaa.specifications;

import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.query.criteria.internal.path.RootImpl;
import org.springframework.data.jpa.domain.Specification;

import com.aaa.model.Sculpture;

public abstract class BaseSpecification<X> {

	protected static <T, S extends Comparable<? super S>> Specification<T> buildIsGreaterThanOrEqualSpecification(
			final SingularAttribute<T, S> attr, final S val) 
	{
		return (root, query, builder)-> {
				Predicate predicate = null;
				if (val != null) {
					predicate = builder.greaterThanOrEqualTo(root.get(attr), val);
				}else {
					predicate = builder.conjunction();
				}
				return predicate;
		};
	}

	protected static <T, S extends Comparable<? super S>> Specification<T> buildIsLessThanOrEqualSpecification(
			final SingularAttribute<T, S> attr, final S val) {
		return (root, query, builder) -> {
			Predicate predicate = null;
			if (val != null) {
				predicate = builder.lessThanOrEqualTo(root.get(attr), val);
			}else {
				predicate = builder.conjunction();
			}
			return predicate;
		};
	}

	protected static <T, S> Specification<T> buildEqualSpecification(final SingularAttribute<T, S> attr, final S val) {
		return (root, query, builder) -> {
			Predicate predicate = null;
			if (val != null) {
				predicate = builder.equal(root.get(attr), val);
			}else {
				predicate = builder.conjunction();
			}
			return predicate;
		};
	}

	protected static <T, S> Specification<T> buildInSpecification(final SingularAttribute<T, S> attr,
			final Collection<S> collection) {
		return (root, query, builder) -> {
			Predicate predicate = null;
			if (collection != null && !collection.isEmpty()) {
				predicate = root.get(attr).in(collection);
			}
			return predicate;
		};
	}

	/*
	 * protected static <T> Specification<T> buildLikeSpecification (final
	 * SingularAttribute<T, String> attr, final String val) { return (root, query,
	 * builder) -> { Predicate predicate = null; if (StringUtils.isNotBlank(val)) {
	 * predicate = builder.like(builder.lower(root.get(attr)), "%" +
	 * val.toLowerCase() + "%"); } return predicate;
	 * 
	 * }; }
	 */

}
