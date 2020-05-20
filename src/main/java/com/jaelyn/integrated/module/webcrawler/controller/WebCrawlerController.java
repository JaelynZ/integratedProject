package com.jaelyn.integrated.module.webcrawler.controller;

import com.jaelyn.integrated.module.webcrawler.service.WebCrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-20 9:59
 **/
@RestController
@RequestMapping("/webCrawler")
@Slf4j
public class WebCrawlerController {

    @Autowired
    private WebCrawlerService webCrawlerService;

    @GetMapping("/crawlingPinDuoDuo")
    public String crawlingPinDuoDuo() {
        webCrawlerService.crawlingPinDuoDuo();
        return "success";
    }
}
