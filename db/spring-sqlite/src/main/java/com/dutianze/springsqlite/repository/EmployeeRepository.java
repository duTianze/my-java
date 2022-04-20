package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/20
 */
@RepositoryRestResource(collectionResourceRel = "employeex", path = "employee")
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
