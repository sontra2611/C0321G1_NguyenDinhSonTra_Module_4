package com.codegym.controller;

import com.codegym.model.bean.Cart;
import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/product/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Optional<Long> id, Model model) {
        Optional<Product> product = productService.findById(id.get());
        model.addAttribute("product", product.get());
        return "/product/view";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart, RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/product/error";
        }

        cart.addProduct(productOptional.get());
        redirectAttributes.addFlashAttribute("message", "Bạn đã thêm sản phẩm " +
                productOptional.get().getName() + " vào giỏ hàng thành công");
        return "redirect:/shop";
    }

    @GetMapping("/changeQuantity/{id}")
    public String changeQuantity(@PathVariable Optional<Long> id, @SessionAttribute Cart cart, String action, Model model) {
        Optional<Product> productOptional = productService.findById(id.get());
        if (!productOptional.isPresent()) {
            return "/product/error";
        }

        cart.changeQuantity(productOptional.get(), action);
        return "redirect:/shopping-cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Optional<Long> id, @SessionAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(id.get());
        if (!productOptional.isPresent()) {
            return "/product/error";
        }

        cart.removeProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }
}
