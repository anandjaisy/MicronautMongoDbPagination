package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;

@MappedEntity
public record Discount(@Id
                       @GeneratedValue
                       ObjectId id,
                       @NotNull
                       String discountCode,
                       @NotNull
                       String discountType) {
}

//@MappedEntity
//public class Discount {
//    @Id
//    @GeneratedValue
//    private ObjectId id;
//    @NotNull
//    private String discountCode;
//    @NotNull
//    private String discountType;
//
//    public Discount(ObjectId id, String discountCode, String discountType) {
//        this.id = id;
//        this.discountCode = discountCode;
//        this.discountType = discountType;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getDiscountCode() {
//        return discountCode;
//    }
//
//    public void setDiscountCode(String discountCode) {
//        this.discountCode = discountCode;
//    }
//
//    public String getDiscountType() {
//        return discountType;
//    }
//
//    public void setDiscountType(String discountType) {
//        this.discountType = discountType;
//    }
//}