package com.sz.check;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zyh
 * @doc 检查命令行参数
 * @fileName CommandLineArgsChecker
 * @date 2025/3/3
 */
@Component
public class CommandLineArgsChecker implements CommandLineRunner {

    @Override
    public void run(String... args) {
        // 检查命令行参数是否正确
        if (args.length != 3) {
            throw new RuntimeException("命令错误，请按照格式输入：java -jar main.jar <原文路径> <抄袭版路径> <答案路径>");
        }
    }
}