package com.utkuerem.prometheusandgrafanaexercise.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

}
