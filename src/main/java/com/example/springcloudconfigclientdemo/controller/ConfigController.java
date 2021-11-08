package com.example.springcloudconfigclientdemo.controller;

import com.example.springcloudconfigclientdemo.service.DynamicConfigService;
import com.example.springcloudconfigclientdemo.service.StaticConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    private final StaticConfigService staticConfigService;
    private final DynamicConfigService dynamicConfigService;

    public ConfigController(StaticConfigService staticConfigService,
            DynamicConfigService dynamicConfigService) {
        this.staticConfigService = staticConfigService;
        this.dynamicConfigService = dynamicConfigService;
    }

    @GetMapping("/static")
    public Object getConfigFromStatic() {
        return staticConfigService.getConfig();
    }

    @GetMapping("/dynamic")
    public Object getConfigFromDynamic() {
        return dynamicConfigService.getConfig();
    }
}
