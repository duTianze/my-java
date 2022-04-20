package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "album", path = "album")
public interface AlbumRepository extends PagingAndSortingRepository<Album, Integer> {

    List<Album> findByTitle(@Param("title") String title);
}
