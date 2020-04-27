package com.gools.repo;

import com.gools.data.Dep;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DepRepository extends PagingAndSortingRepository<Dep, Long> {
}
