package com.zwb.type.cp;

import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U4;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ConstantLongInfo extends CpInfo {

    private U4 hightBytes;
    private U4 lowBytes;

    public ConstantLongInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        hightBytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
        lowBytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_Long_info";
    }
}
