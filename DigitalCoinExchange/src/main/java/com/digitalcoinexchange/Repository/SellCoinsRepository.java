package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.BuyCoins;

public interface SellCoinsRepository extends CrudRepository<BuyCoins,String> {

}