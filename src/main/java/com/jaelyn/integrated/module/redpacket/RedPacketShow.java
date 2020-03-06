package com.jaelyn.integrated.module.redpacket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 红包展示对象
 *
 * @author zjaelyn@gmail.com
 * @date 2020-03-06 16:26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedPacketShow {
    /**
     * 姓名
     */
    private String name;
    /**
     * 红包金额
     */
    private BigDecimal amount;
    /**
     * 最佳标识
     */
    private Integer bestFlag;
    /**
     * 抢红包展示时间
     */
    private String showTime;
    /**
     * 抢红包时间戳
     */
    private Long grabTime;
}
