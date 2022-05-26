package com.example;

import io.micronaut.data.model.Page;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class MongodbandmicronautTest extends TestContainerFixture{
    @Inject
    @Client("/")
    protected HttpClient client;

    @Test
    @DisplayName("Should create a discount with valid claim as Owner")
    void shouldCreateADiscountWithValidClaimAsOwner() {
        // Given
        Discount discount = new Discount(null,"Discount-code", "Discount-Type");

        // When
        HttpRequest request = HttpRequest.POST("/discount", discount);
        HttpResponse<Discount> rsp = client.toBlocking().exchange(request, Discount.class);
        var item = rsp.body();

        // Then
        assertEquals(rsp.getStatus(), HttpStatus.CREATED);
        assertTrue(rsp.body().id() != null);
    }


    @Test
    @DisplayName("Should get the list of discounts")
    void shouldGetTheListOfDiscounts() {
        // Given
        Discount discount = new Discount(null,"Discount-code", "Discount-Type");
        HttpRequest request = HttpRequest.POST("/discount", discount);
        HttpResponse<Discount> rsp = client.toBlocking().exchange(request, Discount.class);
        assertEquals(rsp.getStatus(), HttpStatus.OK);

        // When
        request = HttpRequest.GET(String.format("%s","/discount"));
        HttpResponse<Page<Discount>> crsp = client.toBlocking().exchange(request, Page.class);

        // Then
        assertEquals(crsp.getStatus(), HttpStatus.OK);
        assertTrue(crsp.body().getContent().stream().count() > 0);
    }

}
