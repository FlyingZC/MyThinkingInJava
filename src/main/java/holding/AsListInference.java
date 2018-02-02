package holding;


//: holding/AsListInference.java
// Arrays.asList() makes its best guess about type.
import java.util.*;

class Snow
{
}

class Powder extends Snow
{
}

class Light extends Powder
{
}

class Heavy extends Powder
{
}

class Crusty extends Snow
{
}

class Slush extends Snow
{
}

public class AsListInference
{
    public static void main(String[] args)
    {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        
        /* 
         * 编译不通过,说明只能识别到子类型,识别不到子子类型
         *   Won't compile:
             Compiler says:
             found   : java.util.List<Powder>
             required: java.util.List<Snow>
                                       编译不通过,虽然传入的是Snow的子类型
         */
        //List<Snow> snow2 = Arrays.asList(new Light(), new Heavy());

        // Collections.addAll() doesn't get confused:
        List<Snow> snow3 = new ArrayList<Snow>();
        //可以使用,虽然添加的也是Snow的子类型
        Collections.addAll(snow3, new Light(), new Heavy());

        // Give a hint using an
        // explicit type argument specification:
        List<Snow> snow4 = Arrays.<Snow> asList(new Light(), new Heavy());
    }
} ///:~
