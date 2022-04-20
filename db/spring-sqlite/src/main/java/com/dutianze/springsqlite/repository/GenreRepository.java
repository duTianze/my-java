package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Genre;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/21
 */
@RepositoryRestResource(collectionResourceRel = "genre", path = "genre")
public interface GenreRepository extends PagingAndSortingRepository<Genre, Integer> {
}
