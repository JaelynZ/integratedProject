package com.jaelyn.integrated.module.delayschedule;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-04-28 9:32
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTask implements Serializable {

    /**
     * 圈数
     */
    private Integer cycleNum;
    /**
     * 需要执行的函数
     */
    private Object taskFunction;
}
