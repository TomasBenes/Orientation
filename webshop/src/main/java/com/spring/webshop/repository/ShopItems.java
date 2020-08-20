package com.spring.webshop.repository;

import com.spring.webshop.models.Item;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopItems {

    private List <Item> shopItems;

    public ShopItems () {
        this.shopItems = new ArrayList<>();
        shopItems.add(new Item("Running Shoes", "Nike running shoes for every day sport", 1000.0, 5, "Clothes and Shoes"));
        shopItems.add(new Item("Printer", "Some HP printer that will print pages", 3000.0, 2, "Electronics"));
        shopItems.add(new Item("Coca cola", "0.5l standard coke", 25.0, 0, "Beverages and Snacks"));
        shopItems.add(new Item("Wokin", "Chicken with fried rice and WOKIN sauce", 119.0, 100, "Beverages and Snacks"));
        shopItems.add(new Item("T-shirt", "Blue with a corgi on a bike", 300.0, 1, "Clothes and Shoes"));
    }

    public List<Item> getShopItems() {
        return this.shopItems;
    }

    public List<Item> getOnlyAvailable (){
        return this.shopItems.stream()
                .filter(item -> item.getQuantityOfStock() > 0)
                .collect(Collectors.toList());
    }

    public List<Item> getCheapestFirst () {
        return this.shopItems.stream()
                .sorted(Comparator.comparingDouble(Item::getPrice))
                .collect(Collectors.toList());
    }

    public List<Item> getContainsNike () {
        return this.shopItems.stream()
                .filter(item -> item.getName().toLowerCase().contains("nike") || item.getDescription().toLowerCase().contains("nike"))
                .collect(Collectors.toList());
    }

    public double getAverageStock () {
        return this.shopItems.stream()
                .mapToDouble(Item::getQuantityOfStock)
                .average()
                .orElse(0);
    }


    public Item getMostExpensive () {
        return this.shopItems.stream()
                .max(Comparator.comparing(Item::getPrice))
                .get();
    }

    public List<Item> getSearch (String keyword) {
        return this.shopItems.stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword) || item.getDescription().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    public List<Item> getFilteredByType (String buttonName) {
        return this.shopItems.stream()
                .filter(item -> item.getType().toUpperCase().contains(buttonName))
                .collect(Collectors.toList());
    }

    public List<Item> getPriceInEur () {
        return this.shopItems.stream()
                .map(item -> {item.setPrice(item.getPrice()/26); return item;})
                .collect(Collectors.toList());
    }


    public List<Item> getAbovePrice (int givenPrice) {
        return this.shopItems.stream()
                .filter(item -> item.getPrice() > givenPrice)
                .collect(Collectors.toList());
    }

    public List<Item> getBelowPrice (int givenPrice) {
        return this.shopItems.stream()
                .filter(item -> item.getPrice() < givenPrice)
                .collect(Collectors.toList());
    }

    public List<Item> getExactlyPrice (int givenPrice) {
        return this.shopItems.stream()
                .filter(item -> item.getPrice() == givenPrice)
                .collect(Collectors.toList());
    }

}
