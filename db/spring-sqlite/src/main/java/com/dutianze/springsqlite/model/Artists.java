package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/19
 */
@Data
@Entity
@Table(name = "artists")
public class Artists {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer artistId;

    private String name;
}
