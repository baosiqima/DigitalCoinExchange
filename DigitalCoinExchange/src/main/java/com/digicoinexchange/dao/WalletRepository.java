package com.digicoinexchange.dao;

import org.springframework.data.repository.CrudRepository;

import com.digicoinexchange.model.Wallet;

public interface WalletRepository extends CrudRepository<Wallet,String> {

}
