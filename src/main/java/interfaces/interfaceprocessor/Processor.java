//: interfaces/interfaceprocessor/Processor.java
package interfaces.interfaceprocessor;
//将Process修改为接口
public interface Processor
{
    String name();

    Object process(Object input);
} ///:~
