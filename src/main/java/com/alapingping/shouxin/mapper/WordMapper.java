package com.alapingping.shouxin.mapper;

import com.alapingping.shouxin.entity.Word;

import java.util.List;

public interface WordMapper {

    List<Word> getAllWords();
    List<Word> getWordsByCategory(String category);
    List<String> getCategories();

}
