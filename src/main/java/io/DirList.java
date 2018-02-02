package io;

//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList
{
    public static void main(String[] args)
    {
        String[] filterArray = new String[]{};
        //.相当于该工程的根目录
        File path = new File(".");
        String[] list;
        if (filterArray.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter(filterArray[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilter implements FilenameFilter
{
    private Pattern pattern;

    public DirFilter(String regex)
    {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name)
    {
        return pattern.matcher(name).matches();
    }
} /* Output:
  DirectoryDemo.java
  DirList.java
  DirList2.java
  DirList3.java
  *///:~
