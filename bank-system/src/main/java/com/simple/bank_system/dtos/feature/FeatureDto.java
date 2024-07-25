package com.simple.bank_system.dtos.feature;

import com.simple.bank_system.dtos.Model;
import com.simple.bank_system.models.feature.FeatureModel;
import jakarta.validation.constraints.NotBlank;

public record FeatureDto(@NotBlank Integer id,
                         @NotBlank String icon,
                         @NotBlank String description) implements Model {


    @Override
    public FeatureModel toModel() {
        FeatureModel model = new FeatureModel();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        return model;
    }
}
