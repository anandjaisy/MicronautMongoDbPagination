package com.example;

import io.micronaut.data.model.Page;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

@Controller("/discount")
public class DiscountController {

    private final IDiscountService iDiscountService;

    public DiscountController(IDiscountService iDiscountService) {
        this.iDiscountService = iDiscountService;
    }

    @Get
    public Mono<Page<Discount>> find() {
        return iDiscountService.find();
    }

    @Post
    public Mono<Discount> create(Discount model) {
        return iDiscountService.create(model);
    }
}
