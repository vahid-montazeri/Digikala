package com.example.digikala.mapper;

import com.example.digikala.dto.BuyerDto;
import com.example.digikala.entity.Buyer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuyerMapper extends BaseMapper<Buyer, BuyerDto> {
}
