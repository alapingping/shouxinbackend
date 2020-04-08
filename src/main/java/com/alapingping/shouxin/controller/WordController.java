package com.alapingping.shouxin.controller;

import com.alapingping.shouxin.entity.Word;
import com.alapingping.shouxin.service.WordService;
import com.alapingping.shouxin.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/word")
public class WordController {

    @Autowired
    private WordService service;
    private String msg;
    private int code;

    @GetMapping(value = "/getAll")
    public JsonResult<Word> getAllWords() {
        List<Word> words = service.getAllWords();
        code = 200;
        if (words != null) {
            msg = "查询成功";
        } else msg = "查询失败";
        return new JsonResult<>(words, code, msg);
    }

    @GetMapping(value = "/getCategories")
    public JsonResult<String> getCategories() {
        List<String> categories = service.getCategories();
        code = 200;
        if (categories != null) {
            msg = "查询成功";
        } else msg = "查询失败";
        return new JsonResult<>(categories, code, msg);
    }

    @GetMapping(value = "/getWords")
    public JsonResult<Word> getWords(@RequestParam("category") String category) {
        List<Word> words = service.getWordsByCategory(category);
        code = 200;
        if (words != null) {
            msg = "查询成功";
        } else msg = "查询失败";
        return new JsonResult<>(words, code, msg);
    }

}
