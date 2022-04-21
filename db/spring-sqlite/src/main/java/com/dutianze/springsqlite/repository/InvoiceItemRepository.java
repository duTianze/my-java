package com.dutianze.springsqlite.repository;

import com.dutianze.springsqlite.model.InvoiceItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@RepositoryRestResource(collectionResourceRel = "invoice_items", path = "invoice_items")
public interface InvoiceItemRepository extends PagingAndSortingRepository<InvoiceItem, Integer> {
}
