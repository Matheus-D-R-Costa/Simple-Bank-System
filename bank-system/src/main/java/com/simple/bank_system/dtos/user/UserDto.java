package com.simple.bank_system.dtos.user;

import com.simple.bank_system.dtos.Model;
import com.simple.bank_system.dtos.account.AccountDto;
import com.simple.bank_system.models.user.UserModel;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

public record UserDto(@NotBlank Integer id,
                      @NotBlank String username,
                      @NotBlank Set<AccountDto> accounts) implements Model {


    @Override
    public UserModel toModel() {
        UserModel model = new UserModel();
        model.setId(this.id);
        model.setUsername(this.username);
        model.setAccounts(ofNullable(this.accounts).map(list -> list
                        .stream()
                        .map(AccountDto::toModel)
                        .collect(Collectors.toSet()))
                .orElse(null));;
        return model;
    }
}
