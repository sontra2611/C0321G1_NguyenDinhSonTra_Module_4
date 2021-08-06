package com.codegym.model.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Integer contractId;

    private String contractStartDate;

    private String contractEndDate;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double contractDeposit;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double contractTotalMoney;

    private Employee employee;

    private Customer customer;

    private Service service;
}
