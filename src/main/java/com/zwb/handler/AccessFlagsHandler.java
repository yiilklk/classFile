package com.zwb.handler;

import com.zwb.type.ClassFile;
import com.zwb.type.U2;

import java.nio.ByteBuffer;

public class AccessFlagsHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setAccess_flags(new U2(codeBuf.get(), codeBuf.get()));
    }

}
