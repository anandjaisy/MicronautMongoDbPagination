package com.example;

import io.micronaut.data.model.Page;
import reactor.core.publisher.Mono;

public interface IDiscountService {
    Mono<Page<Discount>> find();
    Mono<Discount> create(Discount model);
}
