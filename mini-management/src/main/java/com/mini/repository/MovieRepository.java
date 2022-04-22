package com.mini.repository;

import com.mini.beans.Movie;
import org.springframework.data.repository.CrudRepository;

public interface  MovieRepository extends CrudRepository<Movie, Long> {
}
