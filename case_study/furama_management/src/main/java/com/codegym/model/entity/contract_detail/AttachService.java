package com.codegym.model.entity.contract_detail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachServiceId;
    private String attachServiceName;
    private Double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetailList;
}
