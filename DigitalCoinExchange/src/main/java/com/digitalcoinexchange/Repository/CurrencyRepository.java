package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.Currency;

public interface CurrencyRepository extends CrudRepository<Currency,String>{

}
