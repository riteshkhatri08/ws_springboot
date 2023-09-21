package com.ritesh.springaction.tacocloud.data.repository.impl;

import org.springframework.stereotype.Repository;

import com.ritesh.springaction.tacocloud.model.TacoOrder;

// @Repository
public interface TacoOrderRepository {

    public TacoOrder save(TacoOrder tacoOrder);


}
