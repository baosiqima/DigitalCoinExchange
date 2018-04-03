package com.digicoinexchange.dao;

import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency,String>{

}
