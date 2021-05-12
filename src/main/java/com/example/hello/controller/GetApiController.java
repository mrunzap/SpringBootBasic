package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // Get으로 요청옸을 때 Mapping한다.
    @GetMapping(path = "/hello")
    public String getHello(){
            return "get Helllo";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String hi(){
        return "hi";
    }

    //http://localhost:8080/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVarabie(@PathVariable(name ="name") String pathName){
        System.out.println("PathVariable : "+ pathName);
        return pathName;
    }

    //Query-Parameter  // ? Key = Value & Key = Value 그럼 이걸 스프링부트에서는 어떻게 쓰는가?
    //http://localhost:8080/api/get/query-param?user =steve&email=steve@gmail.com
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");
            sb.append(entry.getKey() + "= " + entry.getValue());
        });
        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        return name + " " + email + " " + age;

    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        return userRequest.toString();

    }
}
