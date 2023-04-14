package com.csc340sp23.repository;

import com.csc340sp23.domain.Hyperlink;
import com.csc340sp23.domain.Hyperlink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HyperlinkRepository extends JpaRepository<Hyperlink, Long>{
    List<Hyperlink> findAll(); // new method to retrieve all hyperlinks
    Hyperlink findById(long id); // modify to return Hyperlink object
}