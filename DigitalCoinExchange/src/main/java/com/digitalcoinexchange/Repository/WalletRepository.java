package com.digitalcoinexchange.Repository;

import org.springframework.data.repository.CrudRepository;

import com.digitalcoinexchange.Domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet,String> {

}
