package com.sz.check;

import com.sz.check.service.PaperCheckService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zyh
 * @doc
 * @fileName PaperCheckServiceTest
 * @date 2025/3/4
 */
class PaperCheckServiceTest {

    // 测试binarySearchLCS
    @Test
    void testBinarySearchLCS_FullMatch() {
        //完全相同的字符串
        String s1 = "abcdefg";
        String s2 = "abcdefg";
        int expected = s1.length();
        assertEquals(expected, PaperCheckService.binarySearchLCS(s1, s2));
    }

    @Test
    void testBinarySearchLCS_PartialMatch() {
        //最长公共子串在中间
        String s1 = "abcxyz";
        String s2 = "xyabc";
        assertEquals(3, PaperCheckService.binarySearchLCS(s1, s2)); // 预期 "abc"
    }

    @Test
    void testBinarySearchLCS_NoCommonSubstring() {
        //无公共子串
        String s1 = "abcd";
        String s2 = "wxyz";
        assertEquals(0, PaperCheckService.binarySearchLCS(s1, s2));
    }

    @Test
    void testBinarySearchLCS_EmptyString() {
        //其中一个字符串为空
        assertEquals(0, PaperCheckService.binarySearchLCS("", "test"));
    }

    // 测试computeSimilarity
    @Test
    void testComputeSimilarity_FullMatch() {
        //完全相同的字符串
        String s = "hello world";
        assertEquals(1.0, PaperCheckService.computeSimilarity(s, s));
    }

    @Test
    void testComputeSimilarity_NoCommonSubstring() {
        //无公共子串
        String s1 = "abcd";
        String s2 = "wxyz";
        assertEquals(0.0, PaperCheckService.computeSimilarity(s1, s2));
    }

    @Test
    void testComputeSimilarity_Rounding() {
        //验证四舍五入逻辑
        String s1 = "abcde";
        String s2 = "cdefg";
        // 最长公共子串长度=3, 相似度= (2 * 3)/(5+5)=0.6 → 0.6
        assertEquals(0.6, PaperCheckService.computeSimilarity(s1, s2));
    }

    @Test
    void testComputeSimilarity_SwapStrings() {
        //s1比s2长，验证交换逻辑
        String s1 = "abcdefgh";
        String s2 = "cde";
        // 最长公共子串长度=3, 相似度= (2 * 3)/(8+3)=6/11≈0.545 → 0.55
        assertEquals(0.55, PaperCheckService.computeSimilarity(s1, s2));
    }

    //空字符串、长字符串
    @Test
    void testBinarySearchLCS_LargeInput() {
        //长字符串
        String s1 = "a".repeat(10000);
        String s2 = "a".repeat(10000);
        assertEquals(10000, PaperCheckService.binarySearchLCS(s1, s2));
    }

    @Test
    void testComputeSimilarity_BothEmpty() {
        //两个空字符串
        assertEquals(0.0, PaperCheckService.computeSimilarity("", ""));
    }
}