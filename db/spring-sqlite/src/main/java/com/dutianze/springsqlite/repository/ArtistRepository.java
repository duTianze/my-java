package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/20
 */
@RepositoryRestResource(collectionResourceRel = "artist", path = "artist")
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {
}
