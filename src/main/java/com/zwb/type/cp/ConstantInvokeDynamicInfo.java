package com.zwb.type.cp;

import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;

@Getter
public class ConstantInvokeDynamicInfo extends CpInfo {

    private U2 bootstrapMethodAttrIndex;
    private U2 nameAndTypeIndex;

    public ConstantInvokeDynamicInfo(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bootstrapMethodAttrIndex = new U2(codeBuf.get(), codeBuf.get());
        nameAndTypeIndex = new U2(codeBuf.get(), codeBuf.get());
    }

    @Override
    public String toString() {
        return "CONSTANT_InvokeDynamic_info";
    }
}
