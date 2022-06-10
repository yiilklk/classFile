package com.zwb;

import com.zwb.type.ClassFile;
import com.zwb.handler.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassFileAnalysiser {

    private final static List<BaseByteCodeHandler> handlers = new ArrayList<>();

    static {
        // 添加各项的解析器
        handlers.add(new MagicHandler()); //魔数解析器
        handlers.add(new VersionHandler()); //版本解析器
        handlers.add(new ConstantPoolHandler()); // 常量池解析器
        handlers.add(new AccessFlagsHandler()); // 访问标志解析器
        handlers.add(new ThisAndSuperClassHandler()); // 子类和父类解析器
        handlers.add(new InterfacesHandler()); // 接口解析器
        handlers.add(new FieldHandler()); // 字段表解析器
        handlers.add(new MethodHandler()); // 方法表解析器
        handlers.add(new AttributesHandler()); // 属性表解析器
        // 解析器排序，要按顺序调用
        handlers.sort((Comparator.comparingInt(BaseByteCodeHandler::order)));
    }

    public static ClassFile analysis(ByteBuffer codeBuf) throws Exception {
        // 重置ByteBuffer的读指针，从头开始
        codeBuf.position(0);
        ClassFile classFile = new ClassFile();
        // 遍历解析器，调用每个解析器的解析方法
        for (BaseByteCodeHandler handler : handlers) {
            handler.read(codeBuf, classFile);
        }
        System.out.println("class文件结构解析完成，剩余未解析的字节数：" + codeBuf.remaining());
        return classFile;
    }

}
