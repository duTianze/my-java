package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/21
 */
@Data
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer trackId;
    private String name;
    private Integer albumId;
    private Integer mediaTypeId;
    private Integer genreId;
    private String composer;
    private Integer milliseconds;
    private Integer bytes;

    private Double unitPrice;
}
