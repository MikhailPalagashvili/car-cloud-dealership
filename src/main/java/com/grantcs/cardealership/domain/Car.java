package com.grantcs.cardealership.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car extends BaseEntity {
    private String brand, model, color, registerNumber;
    private Integer year, price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Owner owner;
}
