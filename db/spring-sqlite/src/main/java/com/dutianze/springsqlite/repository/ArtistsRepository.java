package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Artists;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/20
 */
@RepositoryRestResource(collectionResourceRel = "artists", path = "artists")
public interface ArtistsRepository extends PagingAndSortingRepository<Artists, Integer> {
}
