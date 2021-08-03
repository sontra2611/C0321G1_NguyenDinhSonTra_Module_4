package com.codegym.model.entity.contract_detail;


import com.codegym.model.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractDetailId;
    private Integer quantity;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;
}
