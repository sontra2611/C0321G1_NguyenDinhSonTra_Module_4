package com.codegym.controller;

import com.codegym.model.dto.CustomerDto;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract_detail.ContractDetail;
import com.codegym.model.entity.customer.Customer;
import com.codegym.model.entity.customer.CustomerType;
import com.codegym.model.service.contract.IContractService;
import com.codegym.model.service.contract_detail.IContractDetailService;
import com.codegym.model.service.customer.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IContractService iContractService;

    @Autowired
    IContractDetailService iContractDetailService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getCustomerTypeList(){
        return iCustomerService.findAllCustomerType();
    }


    @GetMapping({"", "/search", "/"})
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam Optional<String> name, Model model){
        String nameValue = "";
        if (name.isPresent()){
            nameValue = name.get();
        }

        Page<Customer> customerList = iCustomerService.searchByName(pageable, nameValue);
        model.addAttribute("customerEdit", new Customer());
        model.addAttribute("customerList", customerList);
        model.addAttribute("name", nameValue);
        return "customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute CustomerDto customerDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Added new customer have successfully");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id){
        Customer customer = iCustomerService.findById(id.get());
        if(customer == null) {
            return "/error";
        }

        customer.setFlag(true);
        iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Optional<Customer> customerEdit){
        iCustomerService.save(customerEdit.get());
        return "redirect:/customer";
    }

    @GetMapping({"/customerUseService"})
    public String customerUseService(@PageableDefault(value = 3) Pageable pageable, @RequestParam Optional<String> name,
                                     Model model) {

        String nameValue = "";
        if (name.isPresent()){
            nameValue = name.get();
        }
        Page<Contract> contractList = iContractService.findAllCustomerUseService(pageable, nameValue);
        for (Contract contract : contractList) {
            List<ContractDetail> contractDetailList = iContractDetailService.findAllByContract_ContractId(contract.getContractId());
            Double totalMoney = contract.getService().getServiceCost() - contract.getContractDeposit();

            for (ContractDetail contractDetail : contractDetailList) {
                totalMoney += contractDetail.getAttachService().getAttachServiceCost() * contractDetail.getQuantity();
            }
            contract.setContractTotalMoney(totalMoney);
        }

        model.addAttribute("contractDetailOther", iContractDetailService.findAllByContractDetailByAttachService());
        model.addAttribute("contractList", contractList);
        model.addAttribute("name", nameValue);

        return "/customer/customer-use-service";
    }
}
