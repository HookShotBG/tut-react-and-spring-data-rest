package com.gools.repo;

import com.gools.data.Environment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EnvironmentRepository extends PagingAndSortingRepository<Environment, Long> {
}
