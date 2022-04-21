package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Track;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "tracks", path = "tracks")
public interface TrackRepository extends PagingAndSortingRepository<Track, Integer> {
}
