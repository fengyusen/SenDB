package com.fengyusen.ysdb.backend.util;

/**
 * ParseStringRes，用于解析字符串时返回解析结果
 */
public class ParseStringRes {
    public String str;
    public int next;

    public ParseStringRes(String str, int next) {
        this.str = str;
        this.next = next;
    }
}
