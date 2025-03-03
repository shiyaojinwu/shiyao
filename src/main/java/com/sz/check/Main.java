package com.sz.check;

import com.sz.check.service.PaperCheckService;
import com.sz.check.utils.FileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        // 读取原文和抄袭文本
        String originalText = FileUtil.readFile(args[0]);
        String plagiarizedText = FileUtil.readFile(args[1]);

        // 检查文件读取是否成功
        if (originalText == null || plagiarizedText == null) {
            System.out.println("文件读写错误");
            //结束程序
            System.exit(0);
        }

        // 计算相似度
        double similarity = PaperCheckService.computeSimilarity(originalText, plagiarizedText);

        // 将相似度结果写入到文件
        FileUtil.writeFile(args[2], String.format("%.2f", similarity));

        //结束程序
        System.exit(0);
    }
}
