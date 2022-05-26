package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.jpa.criteria.PredicateSpecification;
import io.micronaut.data.repository.reactive.ReactorPageableRepository;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

@MongoRepository
public interface IDiscountRepository extends ReactorPageableRepository<Discount, ObjectId> {
    @NonNull
    Mono<Page<Discount>> findAll(@Nullable PredicateSpecification<Discount> spec, Pageable pageable);
}
