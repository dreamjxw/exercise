/*
 * Copyright (C) 2022 dream, Inc. All Rights Reserved.
 */
package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author jiaxingwu
 * @date 2022/3/21 下午2:58
 * @description do something with this class...
 */
public class dreamFileResolver {
    public static void main(String[] args) {
//        fixedData();
//        String path = "/Users/jiaxingwu/Desktop/finddata";
        String path = "/Users/jiaxingwu/Desktop/single";
//        String path = "/Users/jiaxingwu/Desktop/data";
//        String path = "/Users/jiaxingwu/Desktop/dataByShop";
        File file = new File(path);
        func(file);
    }

    private static void func(File file) {
        File[] fs = file.listFiles();
        for (File f : fs) {
            if (Objects.equals(".DS_Store", f.getName())) {
                continue;
            }
            if (f.isDirectory()) {
                func(f);
            }
            if (f.isFile()) {
                fixedData(f);
            }
        }
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int result = 10001;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (!map1.containsKey(list2[i])) {
                continue;
            }
            if (result < i + map1.get(list2[i])) {
                continue;
            }
            result = i + map1.get(list2[i]);
            resultList.add(list2[i]);
        }
        return resultList.toArray(new String[0]);
    }

    private static void fixedData(File file) {
        try {
            String fileName = "";
            //读取文件 方式2
            List<String> collect =
                    Files.lines(Paths.get(file.toURI()), Charset.defaultCharset()).collect(Collectors.toList());
            List<String> objects = new ArrayList<>();
            for (String sql : collect) {
                if (!sql.startsWith("INSERT")) {
                    continue;
                }
                String[] s = sql.split(" ");
                System.out.println(s[2]);
                fileName = s[2];
                String s1 = Pattern.compile("[\\d]").matcher(s[2]).replaceAll("");
                if (!Objects.equals(s1, "`tb_order`") && !Objects.equals(s1, "`tb_order_parent`") && !Objects.equals(s1,
                        "`tb_order_pay`")) {
                    sql = sql.substring(0, sql.length() - 1) + " ON DUPLICATE KEY UPDATE id = CEILING(RAND()" +
                            "*90000000+10000000);";
                }
                objects.add(sql.replaceFirst(s[2], s1));
//                objects.add(String.join(" ", s));
            }

            String pathname =
                    "/Users/jiaxingwu/IdeaProjects/myself/exercise/com-jxw-test/src/main/resources/finddata/" + fileName +
                            ".sql";
            for (String info : objects) {
                method1(pathname, info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method1(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            out.write(conent);
            out.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateNewFile(List<String> infos, String fileName) {
        String pathname = "/Users/jiaxingwu/IdeaProjects/myself/exercise/com-jxw-test/src/main/" + fileName +
                ".sql";
        File file;
        Path path = Paths.get(pathname);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String info : infos) {
                writer.write(info);
                writer.newLine();
            }
            writer.flush();
            path.toFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
