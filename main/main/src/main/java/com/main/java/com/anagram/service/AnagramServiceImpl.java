package com.main.java.com.anagram.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class AnagramServiceImpl implements AnagramService {


        @Override
        public List<String> generateAnagrams(String input) {
            validateInput(input);
            List<String> result = new ArrayList<>();
            permute(input.toCharArray(), 0, result);
            return result;
        }

        private void validateInput(String input) {
            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("A entrada não pode ser vazia ou nula.");
            }
            if (!input.chars().allMatch(Character::isLetter)) {
                throw new IllegalArgumentException("A entrada deve conter apenas letras.");
            }
        }

        private void permute(char[] chars, int index, List<String> result) {
            if (index == chars.length - 1) {
                result.add(new String(chars));
                return;
            }
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                permute(chars, index + 1, result);
                swap(chars, index, i);
            }
        }

        private void swap(char[] chars, int i, int j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
    }
