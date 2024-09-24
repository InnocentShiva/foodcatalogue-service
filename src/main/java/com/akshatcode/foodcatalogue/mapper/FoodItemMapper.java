package com.akshatcode.foodcatalogue.mapper;
import com.akshatcode.foodcatalogue.dto.FoodItemDTO;
import com.akshatcode.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

        FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

        FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

        FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);



}
