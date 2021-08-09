package com.codegym.model.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.AttachService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


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
