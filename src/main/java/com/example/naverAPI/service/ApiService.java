package com.example.naverAPI.service;

import com.example.naverAPI.dto.Item;
import com.example.naverAPI.dto.NaverSearch;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApiService {
    private final NaverSearch naverSearch;
    
    public List<Item> searchItem(String query){
        //검색어(예:라면)를 매개변수로 전달
        String result = naverSearch.search(query);
        return fromJSONtoItems(result);
    }
    public List<Item> fromJSONtoItems(String result){
        //JSONObject : 매개변수 result로 전달받은 문자열을 json데이터로  변환하는 객체, java에서 json 데이터를 쉽게 다룰 수 잇도록 설정함.
        JSONObject json = new JSONObject(result);
        //json데이터에서 key값으로 json배열값을 만들어서 items에 저장
        JSONArray items = json.getJSONArray("items");
        //key,value가 없는 일반 배열 선언
        List<Item> itemList = new ArrayList<>();
        //json배별의 데이터 개수만큼 반복
        for(int i=0; i<items.length();i++){
            //json배열의 데이터를 하나씩 가져와서 itemJson에 저장
            JSONObject itemJson = items.getJSONObject(i);
            //itemJson배열에 저장된 json데이터에서 title,link,image,lprice,mallName, brand, category4정보만 item인스턴스에 저장
            Item item = new  Item(itemJson);
            //itemList배열에서 ltem객체 추가
            itemList.add(item);
        }
        //itemList배열값을 반화
        return itemList;
    }
}
