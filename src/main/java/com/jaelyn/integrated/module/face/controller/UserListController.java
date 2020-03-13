package com.jaelyn.integrated.module.face.controller;

import com.jaelyn.integrated.module.face.model.entity.UserFaceInfo;
import com.jaelyn.integrated.module.face.service.UserFaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/")
@Slf4j
public class UserListController {

    @Autowired
    private UserFaceInfoService userFaceInfoService;

    @GetMapping("/userInfo")
    public List<UserFaceInfo> getUserInfo()
    {
        return userFaceInfoService.findUserFaceInfoList();
    }
}
