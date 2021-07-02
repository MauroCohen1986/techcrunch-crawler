package com.headsup.techcrunch.crawler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "author")
@Data
public class Author {

    @Id
    private long id;

    @Column
    private String name;

}
