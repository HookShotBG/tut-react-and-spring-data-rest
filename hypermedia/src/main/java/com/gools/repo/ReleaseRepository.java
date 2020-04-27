package com.gools.repo;

import com.gools.data.Release;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReleaseRepository extends PagingAndSortingRepository<Release, Long> {
}
