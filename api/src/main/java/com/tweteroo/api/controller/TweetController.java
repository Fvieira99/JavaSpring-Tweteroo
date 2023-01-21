package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model._Tweet;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;
    

    @GetMapping
    public ResponseEntity<List<_Tweet>> listTweets(@PageableDefault(page = 0, size = 5) org.springframework.data.domain.Pageable pageable){


        Page<_Tweet> tweets = tweetService.listTweets(pageable); 

        System.out.println(tweets.getContent());

        return new ResponseEntity<List<_Tweet>>(tweets.getContent(), HttpStatusCode.valueOf(200));


    }

    @PostMapping
    public ResponseEntity<String> createTweet(@RequestBody @Valid TweetDTO req){

        tweetService.createTweet(req);

        return new ResponseEntity<String>("OK", HttpStatusCode.valueOf(201));

    }

}
