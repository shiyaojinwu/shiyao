package com.sz.check;

import com.sz.check.utils.FileUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zyh
 * @doc
 * @fileName ExceptionTest
 * @date 2025/3/4
 */
public class ExceptionTest {
    @Test
    void testReadFile_FileNotExist() {
        //场景：文件不存在
        String path = "non_existent.txt";
        String content = FileUtil.readFile(path);
        assertNull(content);  // 预期返回 null
        // 控制台应输出："文件读错误: non_existent.txt"
    }

    @Test
    void testWriteFile_InvalidPath() {
        //场景：写入路径不可用（如目录不存在）
        String path = "/invalid_directory/result.txt";
        FileUtil.writeFile(path, "test content");
        // 控制台应输出："文件写错误: /invalid_directory/result.txt"
    }
    @Test
    void testCheckArgs_InvalidArgumentCount() {
        //场景:参数数量不匹配
        String[] args = {"path1.txt", "path2.txt"};  // 仅2个参数
        Exception exception = assertThrows(RuntimeException.class, () ->
                new CommandLineArgsChecker().run(args));
        //打印异常信息
        System.out.println("捕获异常: " + exception.getMessage());
        assertTrue(exception.getMessage().contains("命令错误"));
    }
}
