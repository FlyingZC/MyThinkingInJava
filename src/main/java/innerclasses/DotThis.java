package innerclasses;

//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.
//.this
public class DotThis
{
    void f()
    {
        System.out.println("DotThis.f()");
    }

    public class Inner
    {
        public DotThis outer()
        {
            //在内部类中,外部类.this指向外部类
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
        
        public Inner inter()
        {
            return this;
        }
    }

    public Inner inner()
    {
        return new Inner();
    }

    public static void main(String[] args)
    {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
} /* Output:
  DotThis.f()
  *///:~
