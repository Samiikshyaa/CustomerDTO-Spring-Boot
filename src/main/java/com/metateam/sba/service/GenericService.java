package com.metateam.sba.service;

import java.util.List;

public interface GenericService<D> {
    D create(D d);
    List<D> findAll();
    D findById(Integer id);
    void deleteById(Integer id);
}
