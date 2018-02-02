package generics;
//: generics/GenericArray2.java

public class GenericArray2<T>
{
    //内部直接使用Object[]数组存储,而不是T[]
    private Object[] array;

    public GenericArray2(int sz)
    {
        array = new Object[sz];
    }

    public void put(int index, T item)
    {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index)
    {
        //获取时候转为T类型,可用
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep()
    {
        //获取的地方转为T[],这里仍然在运行时会报错.java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
        return (T[]) array; // Warning: unchecked cast
    }

    public static void main(String[] args)
    {
        GenericArray2<Integer> gai = new GenericArray2<Integer>(10);
        for (int i = 0; i < 10; i++)
            gai.put(i, i);
        for (int i = 0; i < 10; i++)
            System.out.print(gai.get(i) + " ");
        System.out.println();
        try
        {
            Integer[] ia = gai.rep();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
} /* Output: (Sample)
  0 1 2 3 4 5 6 7 8 9
  java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
  *///:~
