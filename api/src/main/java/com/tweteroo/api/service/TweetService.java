package com.tweteroo.api.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model._Tweet;
import com.tweteroo.api.model._User;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;


    public Page<_Tweet> listTweets(org.springframework.data.domain.Pageable pageable){
        int page =pageable.getPageNumber();
        int size = pageable.getPageSize();

        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(
            tweetRepository.findAll(), 
            pageRequest, size);
    }


    public void createTweet(TweetDTO dto){

        Optional<_User> existingUser = userRepository.findByUsername(dto.username());
        
        tweetRepository.save(new _Tweet(dto, existingUser.get().getAvatar()));
    } 
}
