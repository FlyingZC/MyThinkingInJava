package strings;

//: strings/WhitherStringBuilder.java

public class WhitherStringBuilder
{
    public static String implicitString(String[] fields)
    {
        String result = "";
        for (int i = 0; i < fields.length; i++)
        {
            result += fields[i];
            //相当于,即 每次在循环体内都要创建一个StringBuilder对象
            //result += new StringBuilder().append(fields[i]).toString();
        }
        return result;
    }

    public static String explicitSB(String[] fields)
    {
        //只创建一个StringBuilder对象
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
    }
    
    public static String explicitSB2(String[] fields,int sbLength)
    {
        StringBuilder result = new StringBuilder(sbLength);
        for (int i = 0; i < fields.length; i++)
            result.append(fields[i]);
        return result.toString();
    }
    
    
    public static void main(String[] args)
    {
        String[] fields = new String[100000];
        for(int i=0;i<fields.length;i++)
        {
            fields[i] = ""+i;
        }
        long begin1 = System.currentTimeMillis();
        implicitString(fields);
        long end1 = System.currentTimeMillis();
        System.out.println(end1-begin1);//29554

        long begin2 = System.currentTimeMillis();
        explicitSB(fields);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-begin2);//8
        
        long begin3 = System.currentTimeMillis();
        explicitSB2(fields,fields.length);
        long end3 = System.currentTimeMillis();
        System.out.println(end3-begin3);//8
    }
    
    
} ///:~
