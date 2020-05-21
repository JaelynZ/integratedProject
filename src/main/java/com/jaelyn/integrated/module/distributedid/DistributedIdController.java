package com.jaelyn.integrated.module.distributedid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式id
 *
 * @author zjaelyn@gmail.com
 * @date 2020-01-13 15:55
 */
@RestController
@RequestMapping("/distributedId")
@Slf4j
public class DistributedIdController {

    @Autowired
    private DistributedZkIdGenerateService zkIdGenerateService;

    @GetMapping("/generateZkId")
    public String generateZkId() {
        return zkIdGenerateService.generateId();
    }
}
