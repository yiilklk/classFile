package com.zwb.handler;

import com.zwb.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {

    /**
     * 排序
     *
     * @return
     */
    int order();

    /**
     * 读取
     *
     * @param codeBuf
     * @param classFile
     */
    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;

}
