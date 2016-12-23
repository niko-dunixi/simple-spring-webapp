package io.paulbaker.friendcode;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by paulbaker on 12/23/16.
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
