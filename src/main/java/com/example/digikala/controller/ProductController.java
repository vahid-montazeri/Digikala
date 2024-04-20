package com.example.digikala.controller;

import com.example.digikala.dto.BaseResponse;
import com.example.digikala.dto.ProductDto;
import com.example.digikala.service.ProductService;
import com.example.digikala.util.ResourceBundleUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public BaseResponse<Void> create(@RequestBody ProductDto productDto) {
        BaseResponse<Void> baseResponse = new BaseResponse<>();
        try {
            productService.save(productDto);
            baseResponse.setCode(HttpStatus.CREATED.value());
            baseResponse.setMessage("محصول مورد نظر با موفقیت ثبت شد");
            baseResponse.setDate(new Date());
            baseResponse.setData(null);
        } catch (Exception e) {
            baseResponse.setCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("خطا هنگام ثبت محصول: " + e.getMessage());
            baseResponse.setDate(new Date());
            baseResponse.setData(null);
        }
        return baseResponse;
    }

    @GetMapping(path = "{id}")
    public BaseResponse<ProductDto> getById(@PathVariable Long id) {
        BaseResponse<ProductDto> baseResponse = new BaseResponse<>();
        try {
            ProductDto productDto = productService.getById(id);
            baseResponse.setCode(HttpStatus.CREATED.value());
            baseResponse.setMessage("محصول مورد نظر دریافت شد");
            baseResponse.setDate(new Date());
            baseResponse.setData(List.of(productDto));

        } catch (Exception e) {
            baseResponse.setCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage("خطا هنگام دریافت محصول:" + e.getMessage());
            baseResponse.setDate(new Date());
            baseResponse.setData(null);
        }
        return baseResponse;
    }

    @GetMapping
    public BaseResponse<ProductDto> getAll() {
        BaseResponse<ProductDto> baseResponse = new BaseResponse<>();
        try {
            List<ProductDto> productDtoList = productService.getAll();
            baseResponse.setCode(HttpStatus.OK.value());
            baseResponse.setMessage(ResourceBundleUtils.getExceptionMessage("successful"));
            baseResponse.setDate(new Date());
            baseResponse.setData(productDtoList);
        } catch (Exception e) {
            baseResponse.setCode(HttpStatus.BAD_REQUEST.value());
            baseResponse.setMessage(ResourceBundleUtils.getExceptionMessage("product_not_found"));
            baseResponse.setDate(new Date());
            baseResponse.setData(null);
        }
        return baseResponse;
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

    @GetMapping("/in-stock")
    public ResponseEntity<List<ProductDto>> findAllByInStock(@RequestParam boolean inStock) {
        try {
            List<ProductDto> allProducts = productService.findAllByInStock(inStock);
            return ResponseEntity.ok(allProducts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


}
