package gr.codehub.review.service;

import gr.codehub.review.domain.Author;
import gr.codehub.review.domain.Content;

import java.math.BigDecimal;

public interface AuthorService extends BaseService<Author, Long> {
	Author getLazy(Long id);

	void assign(Author author, Content content, BigDecimal cost);
}
