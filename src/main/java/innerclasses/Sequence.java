package innerclasses;

//: innerclasses/Sequence.java
// Holds a sequence of Objects.

interface Selector
{
    boolean end();

    Object current();

    void next();
}

public class Sequence
{
    private Object[] items;

    private int next = 0;

    public Sequence(int size)
    {
        items = new Object[size];
    }

    /** 
     * 向items数组中添加元素 
     * @param x
     * @see [类、类#方法、类#成员]
     */
    public void add(Object x)
    {
        if (next < items.length)
            items[next++] = x;
    }

    /**
     * 迭代器实现  
     * @author  zhangcheng
     * @version  [版本号, 2017年7月17日]
     */
    private class SequenceSelector implements Selector
    {
        private int i = 0;

        /**
         * 是否到末尾
         * @return
         */
        public boolean end()
        {
            return i == items.length;
        }

        /**
         * 访问当前对象
         * @return
         */
        public Object current()
        {
            return items[i];
        }

        /**
         * 索引后移 
         */
        public void next()
        {
            if (i < items.length)
                i++;
        }
    }

    public Selector selector()
    {
        return new SequenceSelector();
    }

    public static void main(String[] args)
    {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        //内部类
        Selector selector = sequence.selector();
        while (!selector.end())
        {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
  0 1 2 3 4 5 6 7 8 9
  *///:~
