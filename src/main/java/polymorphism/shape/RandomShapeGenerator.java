//: polymorphism/shape/RandomShapeGenerator.java
// A "factory" that randomly creates shapes.
package polymorphism.shape;

import java.util.*;

public class RandomShapeGenerator
{
    private Random rand = new Random(47);
    //!注意这里return的是Shape类型.向上转型
    public Shape next()
    {
        switch (rand.nextInt(3))
        {
            //default还可以这么写...
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
        }
    }
} ///:~
