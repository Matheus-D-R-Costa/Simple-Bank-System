package com.simple.bank_system.dtos.news;

import com.simple.bank_system.dtos.Model;
import com.simple.bank_system.models.news.NewsModel;
import jakarta.validation.constraints.NotBlank;

public record NewsDto(@NotBlank Integer id,
                      @NotBlank String icon,
                      @NotBlank String description) implements Model {

    @Override
    public NewsModel toModel() {
        NewsModel model = new NewsModel();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        return model;
    }
}
