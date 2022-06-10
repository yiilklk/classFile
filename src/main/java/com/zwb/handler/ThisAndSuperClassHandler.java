package com.zwb.handler;

import com.zwb.type.ClassFile;
import com.zwb.type.U2;

import java.nio.ByteBuffer;

public class ThisAndSuperClassHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setThisClass(new U2(codeBuf.get(), codeBuf.get()));
        classFile.setSuperClass(new U2(codeBuf.get(), codeBuf.get()));
    }

}
