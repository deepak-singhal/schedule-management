package com.gs.scm.repository;

import com.gs.scm.data.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {

}
