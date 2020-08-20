package com.spring.webshop.controllers;

import com.spring.webshop.repository.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ItemController {

    ShopItems shopItems = new ShopItems();


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

    @PostMapping("/search")
    public String displaySearch (Model model, @RequestParam String keyword){
        model.addAttribute("items", shopItems.getSearch(keyword));
        return "index";
    }

    @GetMapping("/more-filters")
    public String homePageEndpoints (Model model){
        model.addAttribute("items", shopItems.getShopItems());
        return "endpoints";
    }

    @GetMapping("/filter-by-type/{buttonName}")
    public String displayFilteredByType (Model model, @PathVariable String buttonName){
        model.addAttribute("items", shopItems.getFilteredByType(buttonName));
        return "endpoints";
    }

    @GetMapping("/price-in-eur")
    public String displayPriceInEur (Model model){
        model.addAttribute("items", shopItems.getPriceInEur());
        return "endpoints";//MAM TED VSECHNY CENY V EURECH, V TETO FUNKCI POTREBUJI PRIDAT EUR
    }

    @PostMapping("/filter-by-price")
    public String displayFilterByPrice (Model model, @RequestParam int givenPrice){
        model.addAttribute("items", shopItems.getAbovePrice(givenPrice));
        model.addAttribute("items", shopItems.getBelowPrice(givenPrice));
        model.addAttribute("items", shopItems.getExactlyPrice(givenPrice));
        return "endpoints";
    }
}
