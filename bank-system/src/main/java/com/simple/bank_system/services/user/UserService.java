package com.simple.bank_system.services.user;

import com.simple.bank_system.dtos.user.UserDto;
import com.simple.bank_system.models.user.UserModel;
import com.simple.bank_system.services.CRUDService;

public interface UserService extends CRUDService<Integer, UserModel, UserDto> {
}
