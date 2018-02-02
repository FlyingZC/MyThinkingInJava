package strings;

//: strings/Concatenation.java

public class Concatenation
{
    public static void main(String[] args)
    {
        String mango = "mango";
        //相当于
        String s1=new StringBuilder().append("abc").append(mango).append("def").append(47).toString();
        String s = "abc" + mango + "def" + 47;
        System.out.println(s);
    }
} /* Output:
  abcmangodef47
  *///:~
