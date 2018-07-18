package com.gs.scm.repository;

import com.gs.scm.data.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("reservationRepository")
public interface ReservationRepository extends CrudRepository<ReservationEntity,String> {
    
}
