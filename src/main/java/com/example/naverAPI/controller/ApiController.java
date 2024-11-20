package com.example.naverAPI.controller;

import com.example.naverAPI.dto.Item;
import com.example.naverAPI.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Controller
@ResponseBody
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/api/search")
    public List<Item> getItems(@RequestParam("query") String query){
        query = URLDecoder.decode(query, StandardCharsets.UTF_8);
        return apiService.searchItem(query);
    }
}
