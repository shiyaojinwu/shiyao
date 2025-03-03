package com.sz.check.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author zyh
 * @doc 文件读写
 * @fileName FileUtil
 * @date 2025/3/2
 */
public class FileUtil {

    /**
     * 读取文件内容
     * @param path 文件路径
     * @return {@code String }
     * @author zyh
     * @date 2025/03/03
     */
    public static String readFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path))); // 读取整个文件为字符串
        } catch (IOException e) {
            System.out.println("文件读错误: " + path);
            return null;
        }
    }

    /**
     * 将内容写入文件
     * @param path    文件路径
     * @param content 内容
     * @author zyh
     * @date 2025/03/03
     */
    public static void writeFile(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("文件写错误: " + path);
        }
    }
}
