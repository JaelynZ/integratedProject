package com.jaelyn.integrated.module.face.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessInfo {
    private Integer age;
    private Integer gender;

}
