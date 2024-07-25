package com.simple.bank_system.dtos.card;

import com.simple.bank_system.dtos.Model;
import com.simple.bank_system.models.card.CardModel;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CardDto(@NotBlank Integer id,
                      @NotBlank String number,
                      @NotBlank BigDecimal cardLimit) implements Model {
    @Override
    public CardModel toModel() {
        CardModel model = new CardModel();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setCardLimit(this.cardLimit);
        return model;
    }
}
