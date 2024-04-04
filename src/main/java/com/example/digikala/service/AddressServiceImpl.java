package com.example.digikala.service;

import com.example.digikala.dto.AddressDto;
import com.example.digikala.entity.Address;
import com.example.digikala.mapper.AddressMapper;
import com.example.digikala.repository.AddressRepository;
import com.example.digikala.util.ResourceBundleUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Override
    @Transactional
    public void save(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        addressRepository.save(address);

    }

    @Override
    @Transactional
    public AddressDto getById(Long id) {
        Address addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("address_not_found")
                ));
        return addressMapper.toDto(addressEntity);
    }


    @Override
    @Transactional
    public List<AddressDto> getAll() {
        List<Address> list = addressRepository.findAll();
        return addressMapper.toDtos(list);

    }

    @Override
    @Transactional
    public void update(Long id, AddressDto addressDto) {
        Address addressEntity =addressRepository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("address_not_found")));
        addressMapper.update(addressEntity,addressDto);
        addressRepository.save(addressEntity);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        addressRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        addressRepository.deleteAll();
    }
}
