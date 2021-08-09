package com.codegym.model.service.contract_detail;

import com.codegym.model.dto.IContractDetailOtherDto;
import com.codegym.model.entity.contract_detail.AttachService;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.repository.contrac_detail.IAttachServiceRepository;
import com.codegym.model.repository.contrac_detail.IContracDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContracDetailRepository iContracDetailRepository;

    @Autowired
    IAttachServiceRepository iAttachServiceRepository;

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContracDetailRepository.findAll(pageable);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContracDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContracDetailRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        iContracDetailRepository.deleteById(id);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllByContract_ContractId(Integer id) {
        return iContracDetailRepository.findAllByContract_ContractId(id);
    }

    @Override
    public List<IContractDetailOtherDto> findAllByContractDetailByAttachService() {
        return iContracDetailRepository.findAllByContractDetailByAttachService();
    }
}
