package access;

//: access/Dinner.java
// Uses the library.
import access.dessert.*;

public class Dinner {
  public static void main(String[] args) {
    //别看Cookie在access.dessert包下
    //而当前类在         access包下
    //但是 当前类 和Cookie 不在同一个包下,不能访问非public修饰的方法
    Cookie x = new Cookie();
    //! x.bite(); // Can't access
  }
} /* Output:
Cookie constructor
*///:~
