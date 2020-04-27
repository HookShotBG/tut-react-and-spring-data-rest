package com.gools.repo;

import com.gools.data.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends PagingAndSortingRepository<Location, Long> {

}
