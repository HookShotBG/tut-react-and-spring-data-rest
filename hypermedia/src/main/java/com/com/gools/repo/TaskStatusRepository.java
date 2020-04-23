package com.com.gools.repo;

import com.com.gools.data.TaskStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskStatusRepository extends PagingAndSortingRepository<TaskStatus, Long> {
}
