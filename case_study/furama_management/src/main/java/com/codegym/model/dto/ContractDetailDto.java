package com.codegym.model.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetailDto {

    private Integer contractDetailId;

    @Min(value = 0, message = "Vui lòng nhập số dương")
    private Integer quantity;

    private Contract contract;

    private AttachService attachService;
}
