package com.alapingping.shouxin.service.impl;

import com.alapingping.shouxin.Consts;
import com.alapingping.shouxin.entity.Word;
import com.alapingping.shouxin.mapper.WordMapper;
import com.alapingping.shouxin.service.WordService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("WordService")
public class WordServiceImpl implements WordService {

    @Override
    public List<Word> getAllWords() {
        try (SqlSession session = Consts.getSession().openSession()) {
            WordMapper mapper = session.getMapper(WordMapper.class);
            List<Word> words = mapper.getAllWords();
            session.close();
            return words;
        }
    }

    @Override
    public List<Word> getWordsByCategory(String category) {
        try (SqlSession session = Consts.getSession().openSession()) {
            WordMapper mapper = session.getMapper(WordMapper.class);
            List<Word> words = mapper.getWordsByCategory(category);
            session.close();
            return words;
        }
    }

    @Override
    public List<String> getCategories() {
        try (SqlSession session = Consts.getSession().openSession()) {
            WordMapper mapper = session.getMapper(WordMapper.class);
            List<String> categories = mapper.getCategories();
            session.close();
            return categories;
        }
    }
}
