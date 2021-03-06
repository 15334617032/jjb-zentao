package com.jjb.jjbzentao.utils;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxq
 * @date 2021/6/22
 */
@Service
public class HttpClient {
    public String client(String url, HttpMethod method, MultiValueMap<String,String> params){
        RestTemplate template=new RestTemplate();
        ResponseEntity<String> responseEntity=template.getForEntity(url,String.class);
        return responseEntity.getBody();
    }
}
