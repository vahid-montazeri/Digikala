package com.example.digikala.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<E, D> {

    D toDto(E entity);

    E toEntity( D toDto);

    List<D> toDtos(List<E> entities);

    List<E> toEntities(List<D> toDto);

    void update(@MappingTarget E entity, D dto);

}
