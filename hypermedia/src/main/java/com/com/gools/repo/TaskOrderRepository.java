package com.com.gools.repo;


import com.com.gools.data.TaskOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskOrderRepository extends PagingAndSortingRepository<TaskOrder, Long> {
}
