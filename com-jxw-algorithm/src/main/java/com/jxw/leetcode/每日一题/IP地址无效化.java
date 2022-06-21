/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package com.jxw.leetcode.每日一题;

/**
 * @author jiaxingwu
 * @date 2022/6/21 下午11:05
 * @description 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * https://leetcode.cn/problems/defanging-an-ip-address/
 */
public class IP地址无效化 {
    public String defangIPaddr(String address) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                builder.append("[.]");
            } else {
                builder.append(address.charAt(i));
            }
        }
        return builder.toString();
    }
}
