package com.mini.repository;

import com.mini.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface  MovieRepository extends CrudRepository<Movie, Long> {
}
