package com.headsup.techcrunch.crawler.services;

import com.headsup.techcrunch.crawler.daos.AuthorDAO;
import com.headsup.techcrunch.crawler.dtos.AuthorDTO;
import com.headsup.techcrunch.crawler.model.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

  @Autowired
  private AuthorDAO authorDAO;

  public List<AuthorDTO> getAllAuthors() {
    return authorDAO.findAll()
            .stream()
            .map(author -> AuthorDTO.builder().name(author.getName()).build())
            .collect(Collectors.toList());
  }


  public Author getOrCreateAuthor(Long id, String name){
    Optional<Author> author = authorDAO.findById(id);
    if(!author.isPresent()){
      Author newAuthor = new Author();
      newAuthor.setId(id);
      newAuthor.setName(name);
      author = Optional.of(authorDAO.save(newAuthor));

    }
    return author.get();
  }
}
