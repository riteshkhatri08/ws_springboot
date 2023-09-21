package com.ritesh.springaction.tacocloud.dao;

import org.springframework.data.repository.CrudRepository;

import com.ritesh.springaction.tacocloud.model.TacoOrder;

public interface TacoOrderJPARepository extends CrudRepository<TacoOrder,Long>{
    
}
