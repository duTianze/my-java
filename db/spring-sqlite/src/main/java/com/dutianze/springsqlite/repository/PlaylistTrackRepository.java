package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.PlaylistTrack;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "playlists", path = "playlists")
public interface PlaylistTrackRepository extends PagingAndSortingRepository<PlaylistTrack, Integer> {
}
