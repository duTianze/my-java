package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/18
 */
@Data
@Entity
@Table(name = "albums")
public class Albums {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer albumId;

    private String title;

    private Integer artistId;
}
