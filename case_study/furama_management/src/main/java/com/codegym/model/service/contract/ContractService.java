package com.codegym.model.service.contract;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.repository.contrac_detail.IContracDetailRepository;
import com.codegym.model.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository iContractRepository;

    @Autowired
    IContracDetailRepository iContracDetailRepository;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllCustomerUseService(Pageable pageable, String name) {
        return iContractRepository.findAllContractByCustomerUseService(pageable, name);
    }

}
