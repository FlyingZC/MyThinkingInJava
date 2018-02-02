package access;

//: access/IceCream.java
// Demonstrates "private" keyword.

class Sundae {
    //private限制访问该构造方法
  private Sundae() {}
  static Sundae makeASundae() {
    return new Sundae();
  }
}

public class IceCream {
  public static void main(String[] args) {
    //! Sundae x = new Sundae();
    Sundae x = Sundae.makeASundae();
  }
} ///:~
