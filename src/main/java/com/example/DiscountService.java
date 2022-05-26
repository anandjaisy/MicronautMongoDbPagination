package com.example;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;
@Singleton
public record DiscountService(IDiscountRepository iDiscountRepository) implements IDiscountService{
    @Override
    public Mono<Page<Discount>> find() {
        var item = iDiscountRepository.findAll(Pageable.from(0,10)).block();
        return iDiscountRepository.findAll(Pageable.from(0,10));
    }

    @Override
    public Mono<Discount> create(Discount model) {
        return iDiscountRepository.save(model);
    }
}
