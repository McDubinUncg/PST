package com.csc340sp23.service;

import com.csc340sp23.domain.Hyperlink;
import com.csc340sp23.repository.HyperlinkRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HyperlinkService {

    @Autowired
    private HyperlinkRepository hyperlinkRepository;

    //returns list of all hyperlink objects
    public List<Hyperlink> findAll() {
        return hyperlinkRepository.findAll();
    }

    //returns hyperlink object by id
    public Hyperlink findById(Long id) {
        return hyperlinkRepository.findById(id).orElse(null);
    }

    //saves or updates hyperlink to database
    public Hyperlink save(Hyperlink hyperlink) {
        return hyperlinkRepository.save(hyperlink);
    }
    
    //deletes hyperlink from database
    public void delete(Long id){
        hyperlinkRepository.deleteById(id);
    }
}
