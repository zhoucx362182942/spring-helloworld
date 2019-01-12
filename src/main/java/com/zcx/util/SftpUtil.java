package com.zcx.util;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * Created by zhou on 2019/1/4.
 */
public class SftpUtil {
    /**
     * @param ip        目标服务器ip
     * @param username  目标服务器用户名
     * @param password  目标服务器密码
     * @param port      目标服务器端口
     * @param path      目标服务器路径（路径+文件名）
     * @param localPath 本地存储路径（以File.separator结尾，不包含文件名）
     * @param fileName  本地存储文件名
     * @throws JSchException
     */
    public static void downloadFile(String ip, String username, String password,
                                    int port, String path, String localPath, String fileName) throws Exception {
        Session session = null;
        Channel channel = null;
        JSch jsch = new JSch();
        session = jsch.getSession(username, ip, port);
        session.setPassword(password);
        session.setTimeout(5000);
        Properties config = new Properties();
        // 不检查HostKey
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp chSftp = (ChannelSftp) channel;
        String localFilePath = localPath + fileName;
        chSftp.get(path, localFilePath);
        chSftp.quit();
        channel.disconnect();
        session.disconnect();
    }

    public static void main(String[] args) {
//        try {
//            downloadFile("112.65.164.218", "wls81", "wls81", 40190, "/data/xjk/huiyi_qczj_mcht/20190103/20190103201804221234566001.rar", "C:\\qichezhijia\\temp\\", "20190103201804221234566001.rar");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
