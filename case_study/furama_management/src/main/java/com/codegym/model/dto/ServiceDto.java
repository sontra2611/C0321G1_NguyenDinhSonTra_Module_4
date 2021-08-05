package com.codegym.model.dto;

import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ServiceDto {
    private Integer serviceId;

    @Pattern(regexp = "^(DV)-[0-9]{4}$",
            message = "Mã Dịch vụ có định dạng là DV-XXXX (X là số 0-9)")
    private String serviceCode;

    @NotBlank
    private String serviceName;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double serviceArea;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double serviceCost;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Integer serviceMaxPeople;

    @NotBlank
    private String standardRoom;

    @NotBlank
    private String desciption;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Double poolArea;

    @Min(value = 0,
            message = "Vui lòng nhập số dương")
    private Integer numberOfFloors;

    private ServiceType serviceType;
    private RentType rentType;
}
