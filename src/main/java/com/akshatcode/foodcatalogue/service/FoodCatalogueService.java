package com.akshatcode.foodcatalogue.service;

import com.akshatcode.foodcatalogue.dto.FoodCataloguePage;
import com.akshatcode.foodcatalogue.dto.FoodItemDTO;
import com.akshatcode.foodcatalogue.dto.Restaurant;
import com.akshatcode.foodcatalogue.entity.FoodItem;
import com.akshatcode.foodcatalogue.mapper.FoodItemMapper;
import com.akshatcode.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSavedInDB);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {

        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);

        Restaurant restaurant = fetchRestaurantDetaisFromRestaurantMS(restaurantId);

        FoodCataloguePage foodCataloguePageDetailss =  createFoodCataloguePage(foodItemList , restaurant);

        return foodCataloguePageDetailss;



    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;


    }

    private Restaurant fetchRestaurantDetaisFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANTLISTING/restaurant/fetchById/"+restaurantId, Restaurant.class );

    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
