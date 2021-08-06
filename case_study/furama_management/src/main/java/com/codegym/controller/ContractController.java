package com.codegym.controller;

import com.codegym.model.dto.ContractDto;
import com.codegym.model.dto.EmployeeDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.entity.employee.Employee;
import com.codegym.model.entity.service.Service;
import com.codegym.model.service.contract.IContractService;
import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.employee.IEmployeeService;
import com.codegym.model.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IServiceService iServiceService;

    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList(){
        return iEmployeeService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> getCustomerList(){
        return iCustomerService.findAll();
    }

    @ModelAttribute("serviceList")
    public List<Service> getServiceList(){
        return iServiceService.findAll();
    }

    @GetMapping({""})
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model){

        Page<Contract> contractList = iContractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDto",new ContractDto());
        return "contract/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDto contractDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
            return "/contract/create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Added new contract have successfully");
        return "redirect:/contract";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id){
        iContractService.removeById(id.get());
        return "redirect:/contract";
    }
}
