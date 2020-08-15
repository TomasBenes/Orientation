package com.spring.webshop.controllers;

import com.spring.webshop.repository.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    ShopItems shopItems = new ShopItems();
    static final String addBook = "/add-book";


    @GetMapping("/")
    public String homePage (Model model){
        model.addAttribute("items", shopItems.getShopItems());
        return "index";
    }

    @GetMapping("/only-available")
    public String displayOnlyAvailable (Model model){
        model.addAttribute("items", shopItems.getOnlyAvailable());
        return "index";
    }

    @GetMapping("/cheapest-first")
    public String displayCheapestFirst (Model model){
        model.addAttribute("items", shopItems.getCheapestFirst());
        return "index";
    }

    @GetMapping("/contains-nike")
    public String displayContainsNike (Model model){
        model.addAttribute("items", shopItems.getContainsNike());
        return "index";
    }


    @GetMapping("/average-stock")
    public String displayAverageStock (Model model){
        model.addAttribute("averageStock", shopItems.getAverageStock());
        return "averageStockAndMax";
    }

    @GetMapping("/most-expensive")
    public String displayMostExpensive (Model model){
        model.addAttribute("itemMax", shopItems.getMostExpensive());
        return "averageStockAndMax";
    }
/*
    @GetMapping("/add-book")
    public String addBook(){
        return "add-book";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    // @PostMapping("/add-book")
    public String addNewBook(@ModelAttribute Book book){
        bookshelf.addBook(book);
        return "redirect:/";
    }*/
}
