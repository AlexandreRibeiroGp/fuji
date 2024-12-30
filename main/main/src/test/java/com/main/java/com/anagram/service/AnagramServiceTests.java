package com.main.java.com.anagram.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AnagramServiceTests {

    @Autowired
    private AnagramService anagramService;

    @Test
    void testGenerateAnagramsNormalCase() {
        List<String> result = anagramService.generateAnagrams("abc");
        assertEquals(6, result.size());
        assertTrue(result.containsAll(List.of("abc", "acb", "bac", "bca", "cab", "cba")));
    }

    @Test
    void testGenerateAnagramsSingleLetter() {
        List<String> result = anagramService.generateAnagrams("a");
        assertEquals(1, result.size());
        assertEquals("a", result.get(0));
    }

    @Test
    void testGenerateAnagramsEmptyInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> anagramService.generateAnagrams(""));
        assertEquals("A entrada não pode ser vazia ou nula.", exception.getMessage());
    }

    @Test
    void testGenerateAnagramsInvalidInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> anagramService.generateAnagrams("ab1"));
        assertEquals("A entrada deve conter apenas letras.", exception.getMessage());
    }
}
