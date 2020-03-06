package com.jaelyn.integrated.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 日志输出工具类
 * @author ucar
 *
 */
public class LogUtil {

    /**
     * 获取e.printStackTrace()的内容
     * @param e 异常
     * @return
     */
    public static String printStackTrace(Exception e){
        try{
            StringWriter stringWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stringWriter, true));
            return stringWriter.toString();
        }catch(Exception ex){
            return ex.getMessage();
        }
    }
}
