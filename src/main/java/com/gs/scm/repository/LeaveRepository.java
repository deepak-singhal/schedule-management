package com.gs.scm.repository;

import com.gs.scm.data.entity.LeaveEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("leaveRepository")
public interface LeaveRepository extends CrudRepository<LeaveEntity,Long> {

    public List<LeaveEntity> findByEmployeeid(String employeeId);
    
}
