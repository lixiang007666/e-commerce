package top.lixiang007.taotao.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author Xiang Li
 * @Date 2021/8/25 下午2:31
 * @Since version-1.0
 * @青软实训
 */

public class FTPTest115 {
     @Test
     public void testFtpClient115() throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("10.211.55.10",21);
        ftpClient.login("ftpuser", "ftpuser");
        FileInputStream inputStream = new FileInputStream(new File("/Users/lixiang/IdeaProjects/e_commerce/taotao-manager/taotao-manager-web/src/main/java/top/lixiang007/taotao/controller/ItemCatController.java"));
        System.out.println(inputStream);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        /**
         * @Author Xiang Li
         * @Date 2021/8/25 下午2:38
         * @Since version-1.0
         * @青软实训 改变上传路径
         */
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images/");
        ftpClient.storeFile("ItemCatController.java", inputStream);
        inputStream.close();

        ftpClient.logout();
    }



}
