package com.gools.repo;


import com.gools.data.TaskOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskOrderRepository extends PagingAndSortingRepository<TaskOrder, Long> {
}
