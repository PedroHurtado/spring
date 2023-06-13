package com.example.demo.domain.ingredient.events;

import java.util.Date;
import java.util.UUID;

import com.example.demo.common.EventBase;

public class AddIngredientEvent extends EventBase<AddIngredientEvent.Data>{
    public AddIngredientEvent(UUID id, Date date, String type, Data data){
        super(id,date,type,data);
    }
    public static final record Data(UUID id,String name, double price) {
    }
}
