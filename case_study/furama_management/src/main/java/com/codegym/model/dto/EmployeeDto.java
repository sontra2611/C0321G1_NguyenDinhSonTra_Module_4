package com.codegym.model.dto;

import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;
import com.codegym.model.entity.user.User;
import lombok.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;

        if (employeeDto.getEmployeeBirthday().equals("")) {
            errors.rejectValue("employeeBirthday", "", "Vui lòng không để trống");
        } else {
            int age = Period.between(LocalDate.parse(employeeDto.getEmployeeBirthday()), LocalDate.now()).getYears();
            if (age < 18) {
                errors.rejectValue("employeeBirthday", "", "Tuổi của bạn phải >= 18");
            }
        }
    }
}
