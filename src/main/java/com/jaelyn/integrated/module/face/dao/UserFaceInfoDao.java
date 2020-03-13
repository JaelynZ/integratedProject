package com.jaelyn.integrated.module.face.dao;

import com.jaelyn.integrated.module.face.model.dto.FaceUserInfo;
import com.jaelyn.integrated.module.face.model.entity.UserFaceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;



@Mapper
public interface UserFaceInfoDao {

    List<UserFaceInfo> findUserFaceInfoList();

    void insertUserFaceInfo(UserFaceInfo userFaceInfo);

    List<FaceUserInfo> getUserFaceInfoByGroupId(Integer groupId);
}
