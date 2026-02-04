/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaxingwu
 * @date 2022/9/30 下午5:15
 * @description do something with this class...
 */
public class Main {
    private static final String urlFormat = "https://restapi.amap.com/v3/geocode/geo?address=%s&key" +
            "=4518f72af0d0d2edd80e006d39ff0527";
    // 设置阈值，根据具体情况调整
    private static int threshold = 2;

    public static void main(String[] args) {
        String fileName1 = "/Users/jiaxingwu/Desktop/address.txt";
        //读取文件
        try {
            List<String> data = Files.lines(Paths.get(fileName1), Charset.defaultCharset())
                    .map(t -> t.replaceAll(" ", ""))
                    .map(String::trim)
                    .collect(Collectors.toList());
            List<String> repleatList = new ArrayList<>();
            List<String> distanceList = new ArrayList<>();
            List<String> resultList = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                String address1 = data.get(i);
                int buff = 10;
                for (int j = i + 1; j < data.size(); j++) {
                    // 允许往后多找10条数据   如果10条数据没有相似，跳过。
                    if (buff == 0) {
                        break;
                    }
                    String address2 = data.get(j);
                    if (calculateLevenshteinDistance(address1, address2)) {
                        buff = 10;
                        resultList.add(address1);
                        resultList.add(address2);
                    }
                    buff--;
                }
            }
            // 重复项
            List<String> repeactList = resultList.stream().distinct().collect(Collectors.toList());

            // 不重复
            data.removeIf(repeactList::contains);

            generateNewFile(resultList, "repeact");
            generateNewFile(data, "notRepeact");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static boolean calculateLevenshteinDistance(String s1, String s2) {
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else {
                    distance[i][j] = min(distance[i - 1][j - 1] + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 1),
                            distance[i][j - 1] + 1, distance[i - 1][j] + 1);
                }
            }
        }
        return distance[s1.length()][s2.length()] <= threshold;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }


    public static File generateNewFile(List<String> infos, String fileName) {
        String pathname = "/Users/jiaxingwu/Desktop/" + fileName + ".txt";
        File file;
        Path path = Paths.get(pathname);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String info : infos) {
                writer.write(info);
                writer.newLine();
            }
            writer.flush();
            file = path.toFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file;
    }
}
