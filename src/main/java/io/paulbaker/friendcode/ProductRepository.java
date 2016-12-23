package io.paulbaker.friendcode;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paulbaker on 12/23/16.
 */
@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
