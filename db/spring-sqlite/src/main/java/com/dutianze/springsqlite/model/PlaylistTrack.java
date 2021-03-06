package com.dutianze.springsqlite.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author dutianze
 * @date 2022/4/21
 */
@Data
@Entity
@Table(name = "playlists")
public class PlaylistTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer playlistId;
    private Integer trackId;
}
