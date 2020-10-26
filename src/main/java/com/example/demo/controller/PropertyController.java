package com.example.demo.controller;

import com.example.demo.config.GmhConfigBean;
import com.example.demo.property.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PropertyController {
    private final ApplicationProperty applicationProperty;
    private final DeveloperProperty developerProperty;

    @Autowired
    private BlogProperty blogProperty;
    @Autowired
    private BlogProperty1 blogProperty1;

    @Autowired
    public PropertyController(ApplicationProperty applicationProperty, DeveloperProperty developerProperty) {
        this.applicationProperty = applicationProperty;
        this.developerProperty = developerProperty;
    }

    @GetMapping("/property")
//    public Dict index() {
//        return Dict.create()
//                .set("applicationProperty", applicationProperty)
//                .set("developerProperty", developerProperty);
//    }
    public HashMap<String, Object> index() {
        HashMap<String, Object> s = new HashMap<String, Object>();
        s.put("applicationProperty", applicationProperty);
        s.put("developerProperty", developerProperty);
        return s;
    }

    @GetMapping("/blog")
    public String blog() {
        return blogProperty.getName() + "---" + blogProperty.getTitle();
    }

    @GetMapping("/blog1")
    public String blog1() {
        return blogProperty1.getName() + "---" + blogProperty1.getTitle();
    }

}
