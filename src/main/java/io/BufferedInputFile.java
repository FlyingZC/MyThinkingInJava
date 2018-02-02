package io;

//: io/BufferedInputFile.java
import java.io.*;

/**
 * @author Flyingzc
 * 缓冲 输入文件
 * 若想打开一个文件用于 字符输入,可用String或File对象作为文件名的FileInputReader.
 * 为了提高速度,使用BufferedReader,BufferedReader提供readLine()方法,
 * 当readLine()返回null时表示达到文件末尾
 *
 */
public class BufferedInputFile
{
    // Throw exceptions to console:
    public static String read(String filename) throws IOException
    {
        // Reading input by lines:
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException
    {
        System.out.print(read("BufferedInputFile.java"));
    }
} /* (Execute to see output) *///:~
