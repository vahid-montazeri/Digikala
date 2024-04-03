package com.example.digikala.service;

import com.example.digikala.dto.AddressDto;

import java.util.List;

public interface AddressService  {
    void save(AddressDto addressDto);

    AddressDto getById(Long id);

    List<AddressDto> getAll();

    void update(Long id, AddressDto addressDto);

    void deleteById(Long id);

    void deleteAll();

}
