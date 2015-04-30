package org.dream.service.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.dream.intf.file.FileService;
import org.dream.utils.UuidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 文件相关服务
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class FileServiceImpl implements FileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String uploadImg(String folder, InputStream inputstream) {
        byte[] buffer = new byte[1024];
        String fileName = UuidUtil.getUUID().replace("-", "").toLowerCase() + ".jpg";

        File file = new File(folder, fileName);
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            int len = 0;
            while ((len = inputstream.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            inputstream.close();
            out.close();
        } catch (FileNotFoundException e) {
            logger.warn("uploadImg failed:" + e.toString());
        } catch (IOException e) {
            logger.warn("uploadImg failed:" + e.toString());
        }

        return fileName;
    }
}
