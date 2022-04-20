package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/20
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customer")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
}
