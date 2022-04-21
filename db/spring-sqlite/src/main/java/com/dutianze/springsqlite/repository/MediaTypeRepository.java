package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.MediaType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "media_types", path = "media_types")
public interface MediaTypeRepository extends PagingAndSortingRepository<MediaType, Integer> {
}
