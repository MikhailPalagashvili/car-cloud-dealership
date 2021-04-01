package com.grantcs.cardealership.domain;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
}