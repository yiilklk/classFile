package com.zwb.type.cp;

import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ConstantStringInfo extends CpInfo {

    private U2 stringIndex;

    public ConstantStringInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        stringIndex = new U2(codeBuf.get(), codeBuf.get());
    }
    @Override
    public String toString() {
        return "CONSTANT_String_info";
    }
}
