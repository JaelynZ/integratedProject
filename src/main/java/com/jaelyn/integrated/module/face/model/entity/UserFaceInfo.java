package com.jaelyn.integrated.module.face.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFaceInfo {

    private Integer id;

    private Integer groupId;

    private String faceId;

    private String name;

    private Integer age;

    private String email;

    private Short gender;

    private String phoneNumber;

    private Date createTime;

    private Date updateTime;

    private byte[] faceFeature;


}

