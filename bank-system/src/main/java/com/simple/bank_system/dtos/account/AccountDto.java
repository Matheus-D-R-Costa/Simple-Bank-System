package com.simple.bank_system.dtos.account;

import com.simple.bank_system.dtos.Model;
import com.simple.bank_system.dtos.card.CardDto;
import com.simple.bank_system.dtos.feature.FeatureDto;
import com.simple.bank_system.dtos.news.NewsDto;
import com.simple.bank_system.models.account.AccountModel;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public record AccountDto(@NotBlank Integer id,
                         @NotBlank String number,
                         @NotBlank String agency,
                         @NotBlank BigDecimal balance,
                         @NotBlank BigDecimal accountLimit,
                         @NotBlank List<CardDto> cards,
                         @NotBlank List<FeatureDto> features,
                         @NotBlank List<NewsDto> news) implements Model {

    @Override
    public AccountModel toModel() {
        AccountModel model = new AccountModel();
        model.setId(this.id);
        model.setNumber(this.number);
        model.setAgency(this.agency);
        model.setBalance(this.balance);
        model.setAccountLimit(this.accountLimit);
        model.setCards(ofNullable(this.cards).map(list -> list
                .stream()
                .map(CardDto::toModel)
                .collect(Collectors.toList()))
                .orElse(null));

        model.setFeatures(ofNullable(this.features).map(list -> list
                .stream()
                .map(FeatureDto::toModel)
                .collect(Collectors.toList()))
                .orElse(null));

        model.setNews(ofNullable(this.news).map(list -> list
                .stream()
                .map(NewsDto::toModel)
                .collect(Collectors.toList()))
                .orElse(null));
        return model;
    }
}
