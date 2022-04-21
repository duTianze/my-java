package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/21
 */
@Data
@Entity
@Table(name = "media_types")
public class MediaType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer mediaTypeId;
    private String name;
}
