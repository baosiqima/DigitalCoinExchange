package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.PlaceOrder;

public interface PlaceOrderRepository extends CrudRepository<PlaceOrder,Integer> {

	
}
