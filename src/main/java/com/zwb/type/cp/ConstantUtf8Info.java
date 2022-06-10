package com.zwb.type.cp;

import com.zwb.type.CpInfo;
import com.zwb.type.U1;
import com.zwb.type.U2;
import lombok.Getter;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Getter
public class ConstantUtf8Info extends CpInfo {

    private U2 length;
    private byte[] bytes;

    public ConstantUtf8Info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        length = new U2(codeBuf.get(), codeBuf.get());
        bytes = new byte[length.toInt()];
        codeBuf.get(bytes, 0, length.toInt());
    }

    @Override
    public String toString() {
        return super.toString() +
                ",length=" + length.toInt() +
                ",str=" + new String(bytes, StandardCharsets.UTF_8);
    }

}
