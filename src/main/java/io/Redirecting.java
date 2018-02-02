package io;

//: io/Redirecting.java
// Demonstrates standard I/O redirection.
import java.io.*;

public class Redirecting
{
    public static void main(String[] args) throws IOException
    {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/java/io/Redirecting.java"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.txt")));
        //设置标准输入流的来源
        System.setIn(in);
        //设置标准输出流的来源
        System.setOut(out);
        System.setErr(out);
        //读取标准输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);//此时 标准输出流的位置已经被重定向到文件中
        out.close(); // Remember this!
        System.setOut(console);//重新恢复标准输出流到控制台
    }
} ///:~
