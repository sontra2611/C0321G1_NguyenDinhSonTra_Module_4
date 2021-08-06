package com.codegym.model.repository.contract;

import com.codegym.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

}
