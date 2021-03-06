package com.codegym.model.dto;

import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        java.sql.Date dateNow = new java.sql.Date(System.currentTimeMillis());

        Date startDate = null;
        Date enddate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.getContractStartDate());
            enddate = new SimpleDateFormat("yyyy-MM-dd").parse(contractDto.getContractEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (startDate.after(dateNow)) {
            errors.rejectValue("contractStartDate", "day.noFuture");
        }

        if (enddate.before(startDate)) {
            errors.rejectValue("contractEndDate", "day.noPast");
        }

        if (contractDto.getContractDeposit() > contractDto.getContractTotalMoney()) {
            errors.rejectValue("contractEndDate", "", "Tiền đặt cọc phải nhỏ hơn tổng tiền");
        }
    }
}
