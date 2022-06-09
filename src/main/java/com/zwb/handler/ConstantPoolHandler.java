package com.zwb.handler;

import com.zwb.type.ClassFile;
import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U2;

import java.nio.ByteBuffer;

public class ConstantPoolHandler implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        U2 cpLen = new U2(codeBuf.get(), codeBuf.get());
        classFile.setConstant_pool_count(cpLen);
        int cpInfoLength = cpLen.toInt() - 1;
        classFile.setConstant_pool(new CpInfo[cpInfoLength]);
        for (int i = 0; i < cpInfoLength; i++) {
            U1 tag = new U1(codeBuf.get());
            CpInfo cpInfo = CpInfo.newCpInfo(tag);
            cpInfo.read(codeBuf);
            // System.out.println("#" + (i + 1) + ":" + cpInfo);
            classFile.getConstant_pool()[i] = cpInfo;
        }
    }

}