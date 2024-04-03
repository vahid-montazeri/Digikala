package com.example.digikala.service;

import com.example.digikala.dto.CartDto;
import com.example.digikala.entity.Cart;
import com.example.digikala.mapper.CartMapper;
import com.example.digikala.repository.CartRepository;
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
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;
    private CartMapper cartMapper;

    @Override
    @Transactional
    public void save(CartDto cartDto) {
        Cart cartEntity = cartMapper.toEntity(cartDto);
        cartRepository.save(cartEntity);
    }

    @Override
    @Transactional
    public CartDto getById(Long id) {
        Cart cartEntity = cartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("cart_not_found"))
                );
        return cartMapper.toDtos(cartEntity);
    }

    @Override
    @Transactional
    public List<CartDto> getAll() {
        List<Cart> list = cartRepository.findAll();
        return cartMapper.toDtos(list);
    }

    @Override
    @Transactional
    public void update(Long id, CartDto cartDto) {
        Cart cartEntity = cartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        ResourceBundleUtils.getExceptionMessage("cart_not_found"))
                );
        cartMapper.update(cartEntity, cartDto);
        cartRepository.save(cartEntity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cartRepository.deleteAll();
    }
}
