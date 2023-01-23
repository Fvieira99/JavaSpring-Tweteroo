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
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Page<_Tweet>> listTweets(@PageableDefault(page = 0, size = 5) org.springframework.data.domain.Pageable pageable){

        System.out.println(pageable.getPageNumber());

        Page<_Tweet> tweets = tweetService.listTweets(pageable); 

        return new ResponseEntity<Page<_Tweet>>(tweets, HttpStatusCode.valueOf(200));


    }

    @PostMapping
    public ResponseEntity<String> createTweet(@RequestBody @Valid TweetDTO req){

        tweetService.createTweet(req);

        return new ResponseEntity<String>("OK", HttpStatusCode.valueOf(201));

    }

    @GetMapping("/{username}")
    public ResponseEntity<List<_Tweet>> listUserTweets(@PathVariable String username){
       List<_Tweet> userTweets = tweetService.listUserTweets(username);

        return new ResponseEntity<List<_Tweet>>(userTweets, HttpStatusCode.valueOf(200));
    }

}
