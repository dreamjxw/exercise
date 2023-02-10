package io;

import com.google.common.collect.Lists;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * <p>Desc:文件解析器 </p>
 * <p>Date:2020/6/11 9:53</p>
 *
 * @author xxx
 */
public class FileResolver {

    public static void main(String[] args) {

        queryChannelId();
        // getWarehouseInfo();
        // getProductExtInfo();
        // getSkuPriceInfo();
    }

    private static void queryChannelId() {
        try {


            String fileName1 = "/Users/jiaxingwu/Desktop/data.txt";


            //读取文件
            Map<String, String> collect = Files
                    .lines(Paths.get(fileName1), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.trim().split("\n")))
                    .collect(Collectors.toMap(k -> k.split(",")[1], v -> v.split(",")[0]));

            String fileName = "";

            //读取文件
            List<String> lineLists = Files
                    .lines(Paths.get(fileName), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());
            List<String> newList = Lists.newArrayList();
            for (String lineList : lineLists) {
                String skuId = lineList.split(",")[0];
                String channelId = collect.get(skuId);
                newList.add(channelId + "," + lineList);
            }
            generateNewFile(newList, "newList");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getSkuPriceInfo() {
        try {
            String fileName = "";

            //读取文件
            List<String> lineLists = Files
                    .lines(Paths.get(fileName), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());

            Map<String, List<String>> map = lineLists.stream().collect(groupingBy(t -> t.split(",")[0]));
            HashMap<String, List<BigDecimal>> hashMap = new HashMap<>();
            map.forEach((key, value) -> hashMap.put(key, value.stream()
                    .map(t -> new BigDecimal(t.split(",")[1]))
                    .sorted()
                    .collect(Collectors.toList())));

            List<String> list = hashMap.entrySet().stream().map(t -> {
                String result = t.getKey() + ",";
                List<BigDecimal> value = t.getValue();
                for (BigDecimal bigDecimal : value) {
                    result += bigDecimal.toString() + ",";
                }
                return result;
            }).collect(Collectors.toList());

            generateNewFile(list, "skuPriceInfoList");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getProductExtInfo() {
        try {
            String fileName = "";

            //读取文件
            List<String> lineLists = Files
                    .lines(Paths.get(fileName), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());

            Map<String, List<String>> map = lineLists.stream().collect(groupingBy(t -> t.split(",")[0] + "," + t.split(",")[1]));


            String fileName1 = "";


            //读取文件
            List<String> lineLists1 = Files
                    .lines(Paths.get(fileName1), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.trim().split("\n")))
                    .collect(Collectors.toList());

            List<String> noExitList = Lists.newArrayList();

            for (String str : lineLists1) {
                int index = str.lastIndexOf(",");
                String substring = str.substring(0, index);
                if (!map.containsKey(substring)) {
                    noExitList.add(str);
                }
            }
            generateNewFile(noExitList, "noExitList");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getWarehouseInfo() {
        try {

            String fileName = "";

            //读取文件
            List<String> lineLists = Files
                    .lines(Paths.get(fileName), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());

            Map<String, List<String>> map = lineLists.stream().collect(groupingBy(t -> t.split(",")[0] + "_" + t.split(",")[1]));

            List<String> successList = Lists.newArrayList();
            List<String> failList = Lists.newArrayList();
            List<String> mixedList = Lists.newArrayList();

            map.forEach((key, value) -> {
                int success = 0;
                int fail = 0;
                for (String s : value) {
                    String[] split = s.split(",");
                    int initNum = Integer.parseInt(split[4].trim());
                    if (initNum < 0) {
                        fail++;
                    }
                    if (initNum >= 0) {
                        success++;
                    }
                }
                if (success == value.size()) {
                    successList.addAll(value);
                } else if (fail == value.size()) {
                    failList.addAll(value);
                } else {
                    mixedList.addAll(value);
                }

            });
            generateNewFile(successList, "successList");
            generateNewFile(failList, "failList");
            generateNewFile(mixedList, "mixedList");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File generateNewFile(List<String> infos, String fileName) {
        String pathname = "/export/Data/" + fileName + ".csv";
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


