package com.codegym.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotBlank
    @Size(min = 2, max = 45,
            message = "First name bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 45,
            message = "Last name bắt buộc, có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phone;

    @Min(value = 18, message = "Age >= 18")
    private Integer age;

    @Email(message = "Vui lòng nhập đúng định dạng Email")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phone, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
