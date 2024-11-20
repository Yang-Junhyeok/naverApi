package com.example.naverAPI.dto;



import lombok.Getter;
import org.json.JSONObject;

@Getter
public class Item {
    private String title;
    private String link;
    private String image;
    private int lprice;
    private String mallName;
    private String brand;
    private String category4;
    //JSON 데이터를 받아서 멤버 변수에 저장하는 생성자
    public Item(JSONObject itemJson){
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
        this.mallName = itemJson.getString("mallName");
        this.brand = itemJson.getString("brand");
        this.category4 = itemJson.getString("category4");
    }
}
