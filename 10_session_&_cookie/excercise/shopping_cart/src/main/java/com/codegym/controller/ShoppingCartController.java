package com.codegym.controller;

import com.codegym.model.bean.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute(name = "cart", required = false) Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
}