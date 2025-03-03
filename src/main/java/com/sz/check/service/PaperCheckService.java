package com.sz.check.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author zyh
 * @doc 查重计算
 * @fileName PaperCheck
 * @date 2025/3/2
 */
@Service
public class PaperCheckService {

    /**
     * 二分查找+滑动窗口找最长公共子串的长度
     * @param s1 字符串1
     * @param s2 字符串2
     * @return int
     * @author zyh
     * @date 2025/03/03
     */
    public static int binarySearchLCS(String s1, String s2) {
        // 如果有空字符串，直接返回0
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        // 确保 s1 是较短的字符串，减少哈希集合的大小，提高匹配效率
        if (s1.length() > s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int low = 0, high = s1.length(); // 二分查找范围
        int bestLength = 0; // 记录最长公共子串的长度

        // 二分查找最长公共子串
        while (low <= high) {
            int mid = (low + high) / 2; // 取中间长度
            if (hasCommonSubstring(s1, s2, mid)) { // 判断是否存在该长度的公共子串
                bestLength = mid;  // 更新最长子串长度
                low = mid + 1;      // 尝试更长的子串
            } else {
                high = mid - 1;     // 尝试更短的子串
            }
        }
        return bestLength;
    }

    /**
     * 判断s1和s2是否存在长度为len的公共子串
     * @param s1  字符串1
     * @param s2  字符串2
     * @param len 子串长度
     * @return boolean
     * @author zyh
     * @date 2025/03/03
     */
    private static boolean hasCommonSubstring(String s1, String s2, int len) {
        HashSet<String> substrings = new HashSet<>(); // 用 HashSet 存储 s1 的子串

        // s1中提取所有长度为 len 的子串，存入哈希表
        for (int i = 0; i <= s1.length() - len; i++) {
            substrings.add(s1.substring(i, i + len));
        }

        // 遍历s2，看是否有匹配的子串
        for (int i = 0; i <= s2.length() - len; i++) {
            if (substrings.contains(s2.substring(i, i + len))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 计算两个字符串的相似度
     * @param s1 字符串1
     * @param s2 字符串2
     * @return double
     * @author zyh
     * @date 2025/03/03
     */
    public static double computeSimilarity(String s1, String s2) {
        // 处理空字符串
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0.0;
        }

        int lcsLength = binarySearchLCS(s1, s2); // 获取最长公共子串长度
        double similarity = (2.0 * lcsLength) / (s1.length() + s2.length()); // 计算相似度
        return Math.round(similarity * 100.0) / 100.0;  // 保留两位小数
    }
}
