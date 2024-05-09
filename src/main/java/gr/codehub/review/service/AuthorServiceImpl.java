package gr.codehub.review.service;

import gr.codehub.review.domain.Activity;
import gr.codehub.review.domain.Author;
import gr.codehub.review.domain.Content;
import gr.codehub.review.repository.ActivityRepository;
import gr.codehub.review.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
// @Transactional(readOnly = true)
public class AuthorServiceImpl extends BaseServiceImpl<Author> implements AuthorService {
	private final AuthorRepository authorRepository;
	private final ActivityRepository activityRepository;

	@Override
	public JpaRepository<Author, Long> getRepository() {
		return authorRepository;
	}

	public Author getLazy(Long id) {
		return authorRepository.getLazy(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	// @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void assign(final Author author, final Content content, final BigDecimal cost) {
		Activity newActivity = new Activity(content, author, cost);
		activityRepository.save(newActivity);
		logger.info("Saved activity {}.", newActivity); // logger.debug
	}
}
