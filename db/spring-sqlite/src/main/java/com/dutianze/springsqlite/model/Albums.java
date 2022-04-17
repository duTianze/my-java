package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@Entity
@Data
public class Albumsx {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer albumId;

    private String title;

    private Integer artistId;
}
