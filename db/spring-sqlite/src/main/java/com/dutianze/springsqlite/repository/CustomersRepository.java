package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Customers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/20
 */
@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomersRepository extends PagingAndSortingRepository<Customers, Integer> {
}
