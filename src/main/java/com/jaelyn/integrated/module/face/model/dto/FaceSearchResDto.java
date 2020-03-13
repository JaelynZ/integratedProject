package com.jaelyn.integrated.module.face.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FaceSearchResDto {
    private String faceId;
    private String name;
    private Integer similarValue;
    private Integer age;
    private String gender;
    private String image;
}
