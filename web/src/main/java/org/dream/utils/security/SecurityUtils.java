/*
 * Copyright (C), 2002-2015, 苏宁易购电子商务有限公司
 * FileName: SecurityUtils.java
 * Author:   Administrator
 * Date:     2015-4-26 上午10:26:28
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package org.dream.utils.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

/**
 * 加密工具
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SecurityUtils {
    
    /**
     * MD5加密
     *
     * @param value
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String md5(String value) {
        if (!StringUtils.isEmpty(value)) {
            return DigestUtils.md5DigestAsHex(value.getBytes());
        }
        return value;
    }
    
}
