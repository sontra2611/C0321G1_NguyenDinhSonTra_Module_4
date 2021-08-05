package com.codegym.model.dto;

import com.codegym.model.entity.customer.CustomerType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CustomerDto {
    private Integer customerId;

    @Pattern(regexp = "^(KH)-[0-9]{4}$",
            message = "Mã Khách hàng có định dạng là KH-XXXX (X là số từ 0-9)")
    private String customerCode;

    @NotBlank
    private String customerName;

    private String customerBirthday;

    private int customerGender;

    @Pattern(regexp = "[0-9]{9}|[0-9]{12}",
            message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String customerIdCard;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String customerPhone;

    @NotBlank
    @Email(message = "Địa chỉ email phải đúng định dạng email")
    private String customerEmail;

    @NotBlank
    private String customerAddress;

    private CustomerType customerType;
}
