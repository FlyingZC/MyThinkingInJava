//: interfaces/classprocessor/Apply.java
package interfaces.classprocessor;

import java.util.*;
import static net.mindview.util.Print.*;

class Processor
{
    public String name()
    {
        return getClass().getSimpleName();
    }

    Object process(Object input)
    {
        return input;
    }
}
//转成大写
class Upcase extends Processor
{
    String process(Object input)
    { // Covariant return
        return ((String) input).toUpperCase();
    }
}
//转成小写
class Downcase extends Processor
{
    String process(Object input)
    {
        return ((String) input).toLowerCase();
    }
}
//拆分
class Splitter extends Processor
{
    String process(Object input)
    {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}

/**
 * 在Apply中设置不同的process(处理者),将字符串分别转换成全大写,全小写,拆分 等  
 * @author  zhangcheng
 * @version  [版本号, 2017年7月17日]
 */
public class Apply
{
    public static void process(Processor p, Object s)
    {
        print("Using Processor " + p.name());
        print(p.process(s));
    }

    public static String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args)
    {
        process(new Upcase(), s);
        process(new Downcase(), s);
        process(new Splitter(), s);
    }
} /* Output:
  Using Processor Upcase
  DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
  Using Processor Downcase
  disagreement with beliefs is by definition incorrect
  Using Processor Splitter
  [Disagreement, with, beliefs, is, by, definition, incorrect]
  *///:~
