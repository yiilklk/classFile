package com.zwb.handler;

import com.zwb.type.ClassFile;
import com.zwb.type.U2;

import java.nio.ByteBuffer;

public class InterfacesHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setInterfacesCount(new U2(codeBuf.get(), codeBuf.get()));
        int interfaces_count = classFile.getInterfacesCount().toInt();
        if (interfaces_count > 0) {
            U2[] interfaces = new U2[interfaces_count];
            classFile.setInterfaces(interfaces);
            for (int i = 0; i < interfaces_count; i++) {
                interfaces[i] = new U2(codeBuf.get(), codeBuf.get());
            }
        }
    }

}
