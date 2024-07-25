package com.simple.bank_system.repositories.account;

import com.simple.bank_system.models.account.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

}
