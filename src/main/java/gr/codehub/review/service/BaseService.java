package gr.codehub.review.service;

import java.util.List;

public interface BaseService<T, ID> {

	// this is a .save
	T create(T item);

	// this is a .saveAll
	List<T> createAll(List<T> items);

	// this is a .saveAll
	List<T> createAll(T... items);

	// this is a .save
	void update(T item);

	// this is a .delete
	void delete(T item);

	// this is a .deleteById
	void deleteById(ID id);

	// this is a .findById
	T get(ID id);

	// this is a .existsById
	boolean exists(T item);

	// this is a .findAll
	List<T> findAll();
}
