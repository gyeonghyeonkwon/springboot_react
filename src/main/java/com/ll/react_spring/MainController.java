package com.ll.react_spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MainController {
    @GetMapping("/api/hello")
    public List<String> Hello(){
        return Arrays.asList("하하", "호호");
    }

}
