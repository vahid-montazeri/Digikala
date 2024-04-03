package com.example.digikala.service;

import com.example.digikala.dto.BuyerDto;
import com.example.digikala.entity.Buyer;
import com.example.digikala.mapper.BuyerMapper;
import com.example.digikala.repository.BuyerRepository;
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
public class BuyerServiceImpl implements BuyerService {
    private BuyerRepository buyerRepository;
    private BuyerMapper buyerMapper;

    @Override
    @Transactional
    public void save(BuyerDto buyerDto) {
        Buyer buyer = buyerMapper.toEntity(buyerDto);
        buyerRepository.save(buyer);
    }

    @Override
    @Transactional
    public BuyerDto getById(Long id) {
        Buyer buyerEntity = buyerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                ResourceBundleUtils.getExceptionMessage("")));
        return buyerMapper.toDtos(buyerEntity);
    }

    @Override
    @Transactional
    public List<BuyerDto> getAll() {
        List<Buyer> list = buyerRepository.findAll();
        return buyerMapper.toDtos(list);
    }

    @Override
    @Transactional
    public void update(Long id, BuyerDto buyerDto) {
        Buyer buyerEntity = buyerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, ResourceBundleUtils.getExceptionMessage("buyer_not_found")
      ));
        buyerMapper.update(buyerEntity, buyerDto);
        buyerRepository.save(buyerEntity);


    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        buyerRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        buyerRepository.deleteAll();

    }
}
