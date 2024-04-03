package com.example.digikala.service;

import com.example.digikala.dto.BuyerDto;

import java.util.List;

public interface BuyerService {
    void save(BuyerDto buyerDto);

    BuyerDto getById(Long id);

    List<BuyerDto> getAll();

    void update(Long id, BuyerDto buyerDto);

    void deleteById(Long id);

    void deleteAll();

}
