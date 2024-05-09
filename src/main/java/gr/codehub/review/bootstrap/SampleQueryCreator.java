package gr.codehub.review.bootstrap;

import gr.codehub.review.base.BaseComponent;
import gr.codehub.review.domain.Author;
import gr.codehub.review.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("check-content")
@RequiredArgsConstructor
public class SampleQueryCreator extends BaseComponent implements CommandLineRunner {
	private final AuthorService authorService;

	@Override
	public void run(final String... args) throws Exception {
		Author author = authorService.get(1L);
		logger.info("** CHECK START ********************************");
		logger.info("Loaded author {}.", author); // logger.debug
		Author authorWithActivities = authorService.getLazy(1L);
		logger.info("Loaded authorWithActivities {}.", authorWithActivities); // logger.debug
		authorWithActivities.getActivities().forEach(c -> logger.info("Content {}.", c)); // logger.debug
		logger.info("** CHECK END **********************************");
	}
}
