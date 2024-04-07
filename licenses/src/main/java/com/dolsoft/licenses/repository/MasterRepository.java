package com.dolsoft.licenses.repository;

import com.dolsoft.licenses.model.Master;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MasterRepository extends CrudRepository<Master, Long> {
    public Master findByMasterId(String masterId);
}

