package com.akshatcode.foodcatalogue.dto;

import com.akshatcode.foodcatalogue.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;


    public FoodCataloguePage setFoodItemsList(List<FoodItem> foodItemsList) {
        this.foodItemsList = foodItemsList;
        return this;
    }

    public FoodCataloguePage setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        return this;
    }

    public List<FoodItem> getFoodItemsList() {
        return foodItemsList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
