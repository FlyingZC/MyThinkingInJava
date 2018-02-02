package holding;

//: holding/EnvironmentVariables.java
import java.util.*;
//获取所有系统环境变量
public class EnvironmentVariables
{
    public static void main(String[] args)
    {
        for (Map.Entry entry : System.getenv().entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
} /* (Execute to see output) *///:~