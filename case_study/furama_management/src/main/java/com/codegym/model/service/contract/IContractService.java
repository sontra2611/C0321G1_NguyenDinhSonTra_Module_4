package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    Contract findById(Integer id);

    void removeById(Integer id);

    Page<Contract> findAllCustomerUseService(Pageable pageable, String name);
}
