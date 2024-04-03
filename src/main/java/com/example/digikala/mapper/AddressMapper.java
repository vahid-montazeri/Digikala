package com.example.digikala.mapper;

import com.example.digikala.dto.AddressDto;
import com.example.digikala.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper extends BaseMapper<Address, AddressDto> {
}
