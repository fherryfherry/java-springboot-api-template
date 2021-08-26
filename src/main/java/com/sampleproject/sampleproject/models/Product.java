package com.sampleproject.sampleproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private Date created_at;

    private Date updated_at;

    private String sku;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String status;

}
