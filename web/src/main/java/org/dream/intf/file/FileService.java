package org.dream.intf.file;

import java.io.InputStream;

/**
 * 文件相关服务
 *
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface FileService {
    
    /**
     * 图片上传
     *
     * @param folder
     * @param inputstream
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    String uploadImg(String folder,InputStream inputstream);
}
