package com.zwb.type.cp;

import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ConstantMethodHandleInfo extends CpInfo {

    private U1 referenceKind;
    private U2 referenceIndex;

    public ConstantMethodHandleInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        referenceKind = new U1(codeBuf.get());
        referenceIndex = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info";
    }
}
