package gr.codehub.review.repository;

import gr.codehub.review.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	@Query("select a from Author a join fetch a.activities where a.id = ?1")
	Optional<Author> getLazy(Long id);
}
