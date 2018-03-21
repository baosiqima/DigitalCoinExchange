package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.BuyCoins;

public interface BuyCoinsRepository extends CrudRepository<BuyCoins,String> {

}
