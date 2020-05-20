package com.jaelyn.integrated.module.webcrawler.service.impl;

import com.jaelyn.integrated.module.webcrawler.dao.WebCrawlerDao;
import com.jaelyn.integrated.module.webcrawler.service.WebCrawlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-20 10:06
 **/
@Service
@Slf4j
public class WebCrawlerServiceImpl implements WebCrawlerService {
    @Resource
    private WebCrawlerDao webCrawlerDao;

    @Override
    public void crawlingPinDuoDuo() {

    }
}
