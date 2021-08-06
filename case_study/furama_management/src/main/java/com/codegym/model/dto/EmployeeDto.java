package com.codegym.model.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.employee.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Integer employeeId;

    @NotBlank
    private String employeeName;
    private String employeeBirthday;

    @Pattern(regexp = "[0-9]{9}|[0-9]{12}",
            message = "Số CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String employeeIdCard;

    @Min(value = 0, message = "Vui lòng nhập số dương")
    private Double employeeSalary;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String employeePhone;

    @NotBlank
    @Email(message = "Địa chỉ email phải đúng định dạng email")
    private String employeeEmail;

    @NotBlank
    private String employeeAddress;

    private Position position;
    private Division division;
    private EducationDegree educationDegree;
    private User user;
}
