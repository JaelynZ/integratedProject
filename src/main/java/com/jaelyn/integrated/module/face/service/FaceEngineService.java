package com.jaelyn.integrated.module.face.service;

import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageInfo;
import com.jaelyn.integrated.module.face.model.dto.FaceUserInfo;
import com.jaelyn.integrated.module.face.model.dto.ProcessInfo;

import java.util.List;
import java.util.concurrent.ExecutionException;


public interface FaceEngineService {

    List<FaceInfo> detectFaces(ImageInfo imageInfo);

    List<ProcessInfo> process(ImageInfo imageInfo);

    /**
     * 人脸特征
     * @param imageInfo
     * @return
     */
    byte[] extractFaceFeature(ImageInfo imageInfo) throws InterruptedException;

    /**
     * 人脸比对
     * @param groupId
     * @param faceFeature
     * @return
     */
    List<FaceUserInfo> compareFaceFeature(byte[] faceFeature, Integer groupId) throws InterruptedException, ExecutionException;



}
