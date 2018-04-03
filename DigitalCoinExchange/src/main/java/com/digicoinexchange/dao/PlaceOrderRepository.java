package com.digicoinexchange.dao;

import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.PlaceOrder;



public interface PlaceOrderRepository extends CrudRepository<PlaceOrder,Integer> {

	
}
