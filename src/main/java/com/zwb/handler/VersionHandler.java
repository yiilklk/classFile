package com.zwb.handler;

import com.zwb.type.ClassFile;
import com.zwb.type.U2;

import java.nio.ByteBuffer;

public class VersionHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 1;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 minorVersion = new U2(codeBuf.get(), codeBuf.get());
        classFile.setMinorVersion(minorVersion);
        U2 majorVersion = new U2(codeBuf.get(), codeBuf.get());
        classFile.setMajorVersion(majorVersion);
    }

}
