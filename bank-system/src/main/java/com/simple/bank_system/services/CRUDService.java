package com.simple.bank_system.services;

import java.util.List;

public interface CRUDService<ID, M, D> {

    List<M> findAll();
    M findById(ID id);
    M create(D dto);
    M update(ID id, D dto);
    void delete(ID id);

}
