package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/19
 */
@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int genreId;

    public String name;
}
