package com.example.naverAPI.dto;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component : 선언적 어노테이션, 리포지토리객체 없이 서비스나 컨트로에서 naverSearch객체를 바로 인식하도록 해줌.NaverSearch클래스 자체를 새로운 Bean객체로 자동 등록해주는 역할.
@Component
public class NaverSearch {
    
    public String search(String query){
        //RsetTemplate : REST 방식의 API를 호출하는 객체,비동기 접근 방식을 지원함.
        RestTemplate rest = new RestTemplate();
        //HttpHeaders:Http 헤더정보 읽어오기
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id","bLmc23OHuTWMMrJmbvVc");
        headers.add("X-Naver-Client-Secret","J2hNIFQJZS");
        //HttpEntity : HttpHeader정보 + httpBody정보를 합친객체
        HttpEntity<String> requestEntity = new HttpEntity<>("",headers);
        //apiURL :
        String apiURL = "https://openapi.naver.com/v1/search/shop.json?query="+query;
        //ResponseEntity : HttpEntity로 요청하거나 응답한 데이터(HttpHeader + HttpBody)를 포함하고,HttpRequest에 대한 응답 데이터를 포함하는 클래스임. (HttpStatus + HttpHeader + HttpBody)
        ResponseEntity<String> responseEntity = rest.exchange(apiURL, HttpMethod.GET,requestEntity,String.class);
        return responseEntity.getBody();

    }
}
