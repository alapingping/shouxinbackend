package com.alapingping.shouxin.service;

import com.alapingping.shouxin.entity.Word;

import java.util.List;

public interface WordService {

    List<Word> getAllWords();
    List<Word> getWordsByCategory(String category);
    List<String> getCategories();

}
