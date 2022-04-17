package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Albums;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "albums", path = "albums")
public interface AlbumsRepository extends PagingAndSortingRepository<Albums, Integer> {

    List<Albums> findByTitle(@Param("title") String title);
}
