package com.example.digikala.controller;

import com.example.digikala.dto.BaseResponse;
import com.example.digikala.dto.ProductDto;
import com.example.digikala.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody ProductDto productDto) {
        BaseResponse baseResponse = new BaseResponse();
        try {
            productService.save(productDto);

            baseResponse.setCode(HttpStatus.CREATED.value());
            baseResponse.setMessage("محصول مورد نظر با موفقیت ثبت شد");
            baseResponse.setDate(new Date());

            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
        } catch (Exception e) {
            baseResponse.setCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("خطا هنگام ثبت محصول: " + e.getMessage());
            baseResponse.setDate(new Date());
            return new ResponseEntity<>(baseResponse, HttpStatusCode.valueOf(baseResponse.getCode()));
        }
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
        ProductDto productDto = productService.getById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll() {
        List<ProductDto> accountServiceAll = productService.getAll();
        return new ResponseEntity<>(accountServiceAll, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.update(id, productDto);
        return ResponseEntity.ok("Product With id" + id + " update successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Product With id" + id + " deleted successfully");
    }

}
