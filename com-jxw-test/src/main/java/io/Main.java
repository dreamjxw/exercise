/*
 * Copyright (C) 2022 Baidu, Inc. All Rights Reserved.
 */
package io;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jiaxingwu
 * @date 2022/9/30 下午5:15
 * @description do something with this class...
 */
public class Main {
    public static void main(String[] args) {
        String fileName1 = "/Users/jiaxingwu/Desktop/productJson.txt";
        //读取文件
        try {
            List<String> data = Files
                    .lines(Paths.get(fileName1), Charset.defaultCharset())
                    .flatMap(line -> Arrays.stream(line.trim().split("\n")))
                    .map(String::trim)
                    .map(StringEscapeUtils::escapeJson)
                    .collect(Collectors.toList());
            generateNewFile(data, "result");
        } catch (Exception e) {

        }
    }


//    public static void main(String[] args) {
//        String fileName1 = "/Users/jiaxingwu/Desktop/data.txt";
//        //读取文件
//        try {
//            List<String> data = Files
//                    .lines(Paths.get(fileName1), Charset.defaultCharset())
//                    .flatMap(line -> Arrays.stream(line.trim().split("\n")))
//                    .map(t -> {
//                        String[] split = t.split("\\|");
//                        List<RefundReasonDetailJson> ts = JSON.parseArray(split[2], RefundReasonDetailJson.class);
//                        List<RefundReasonInfo> infos = new ArrayList<>();
//                        for (RefundReasonDetailJson refundReasonDetailJson : ts) {
//                            RefundReasonInfo configure = new RefundReasonInfo();
//                            configure.setRefundReasonCode(refundReasonDetailJson.getRefundReasonCode());
//                            configure.setRefundReasonText(refundReasonDetailJson.getRefundReasonText());
//                            RefundReasonRule refundReasonRule =
//                                    JSON.parseObject(refundReasonDetailJson.getRefundReasonRules(),
//                                            RefundReasonRule.class);
//                            configure.setDeliverTag(refundReasonRule.getDeliverTag() == null ? "通用" :
//                                    refundReasonRule.getDeliverTag() == 0 ? "未发货" : "已发货");
//                            configure.setBusinessId(Long.valueOf(split[0].trim()));
//                            configure.setRefundType(OrderRefundTypeEnum.valueOf(Integer.valueOf(split[1].trim()))
//                            .getMsg());
//                            infos.add(configure);
//                        }
//                        return infos;
//                    }).flatMap(Collection::stream)
//                    .map(t -> {
//                        return t.getBusinessId() + "," + t.getRefundType() + "," + t.getDeliverTag() + "," + t
//                        .getRefundReasonCode() + "," + t.getRefundReasonText();
//                    })
//                    .collect(Collectors.toList());
//            StringBuilder result = new StringBuilder();
//            for (String datum : data) {
//                result.append(datum).append("@");
//            }
//
//            System.out.println(result);
//
////            generateNewFile(data, "refundReason");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
