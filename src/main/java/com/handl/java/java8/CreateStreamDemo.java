package com.handl.java.java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流
 * 介绍如何从值序列、数组、文件来创建流，甚至由生成函数来创建无限流
 */
public class CreateStreamDemo {

    public static void main(String[] args) {

        //1.由值创建流:Stream.of方法
        Stream<String> stream1 = Stream.of("java","lambda","action","stream");
        stream1.forEach(s -> System.out.println(s));

        //2.由数组创建流(数值流): Arrays.stream方法
        int[] numbers = {23,53,2,25,6,8,52,12,57,98};
        IntStream stream2 = Arrays.stream(numbers);
        System.out.println(stream2.sum());

        //3.由文件生成流:Files.lines方法
        try(Stream<String> fileStream = Files.lines(
                Paths.get("./streamfile.txt"),
                Charset.defaultCharset())){

            fileStream.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .forEach(s -> System.out.println(s));

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
