package com.jaelyn.integrated.module.face.service.impl;

import com.jaelyn.integrated.module.face.dao.UserFaceInfoDao;
import com.jaelyn.integrated.module.face.model.entity.UserFaceInfo;
import com.jaelyn.integrated.module.face.service.UserFaceInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserFaceInfoServiceImpl implements UserFaceInfoService {


    @Resource
    private UserFaceInfoDao userFaceInfoDao;

    @Override
    public void insertSelective(UserFaceInfo userFaceInfo) {
        userFaceInfoDao.insertUserFaceInfo(userFaceInfo);
    }

    @Override
    public List<UserFaceInfo> findUserFaceInfoList() {
        return userFaceInfoDao.findUserFaceInfoList();
    }


}
