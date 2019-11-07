package com.axenov.shorts.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
public class LinkEntity {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "original")
    private String originalLink;
    @Column(name = "short")
    private String shortLink;

    public LinkEntity(String originalLink, String shortLink) {
        this.originalLink = originalLink;
        this.shortLink = shortLink;
    }

    public String getFullShortLink() {
        return System.getenv("DOMEN") + shortLink;
    }
}
