package com.codegym.model.entity.contract;

import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.net.ServerSocket;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;

    @Column(name = "contract_start_date", columnDefinition = "DATE")
    private String contractStartDate;

    @Column(name = "contract_end_date", columnDefinition = "DATE")
    private String contractEndDate;

    private Double contactDeposit;
    private Double contactTotalMoney;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;
}
