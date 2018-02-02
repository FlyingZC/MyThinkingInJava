package exceptions;

//: exceptions/InputFile.java
// Paying attention to exceptions in constructors.
import java.io.*;

public class InputFile
{
    private BufferedReader in;

    /**
     * 对于 在 构造器阶段可能抛出的异常,并且需要清理的类,最安全的使用方式 是 自己处理异常
     * @param fname
     * @throws Exception
     */
    public InputFile(String fname) throws Exception
    {
        try
        {//in对象是一个在之后需要被清理的对象,try..catch
            in = new BufferedReader(new FileReader(fname));
            // Other code that might throw exceptions
        }
        catch (FileNotFoundException e)
        {//1.若抛出FileNotFoundException异常,此时不需要关闭流,因为文件此时还未打开
            System.out.println("Could not open " + fname);
            // Wasn't open, so don't close it
            throw e;
        }
        catch (Exception e)
        {//2.其他异常需要关闭流,因为此时文件已经打开
            // All other exceptions must close it
            try
            {//3.关闭流的过程中也 有可能抛出异常,所以try..catch处理
                in.close();
            }
            catch (IOException e2)
            {
                System.out.println("in.close() unsuccessful");
            }
            throw e; // Rethrow
        }
        finally
        {
            // Don't close it here!!!
        }
    }

    public String getLine()
    {
        String s;
        try
        {
            s = in.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }

    public void dispose()
    {
        try
        {
            in.close();
            System.out.println("dispose() successful");
        }
        catch (IOException e2)
        {
            throw new RuntimeException("in.close() failed");
        }
    }
} ///:~
