package com.headsup.techcrunch.crawler.model;

import com.headsup.techcrunch.crawler.exception.TechCrunchCrawlerException;

import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "article")
@Data
public class Article {

    @Id
    private long id;

    @Column
    private String title;

    @Lob
    private Clob content;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    public String transformContent(){
        StringBuffer buffer = new StringBuffer();
        try {
            if(content!=null){
                Reader r = content.getCharacterStream();

                int ch;
                while ((ch = r.read())!=-1) {
                    buffer.append(""+(char)ch);
                }
            }
        } catch (Exception exception) {
            throw new TechCrunchCrawlerException("Problem reading clob field.",exception);
        }
        return buffer.toString();
    }

}
