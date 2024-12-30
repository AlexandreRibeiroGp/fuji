package com.main.java.com.anagram.controller;

import com.main.java.com.anagram.request.AnagramRequest;
import com.main.java.com.anagram.service.AnagramService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/anagrams")
class AnagramController {

    private final AnagramService anagramService;

    public AnagramController(AnagramService anagramService) {

        this.anagramService = anagramService;

    }

    @PostMapping
    public List<String> generateAnagrams(@RequestBody AnagramRequest request) {

        return anagramService.generateAnagrams(request.getInput());

    }

}

