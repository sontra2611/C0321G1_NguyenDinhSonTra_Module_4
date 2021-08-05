package com.codegym.model.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

public class ContractDto {
    private Integer contractId;

    private String contractStartDate;

    private String contractEndDate;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double contactDeposit;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double contactTotalMoney;

    private Employee employee;

    private Customer customer;

    private Service service;
}
