package com.jaelyn.integrated.module.face.service;

import com.jaelyn.integrated.module.face.model.entity.UserFaceInfo;

import java.util.List;


public interface UserFaceInfoService {

    void insertSelective(UserFaceInfo userFaceInfo);

    List<UserFaceInfo> findUserFaceInfoList();
}
