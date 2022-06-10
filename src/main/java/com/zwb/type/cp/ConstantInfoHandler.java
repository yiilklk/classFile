package com.zwb.type.cp;

import java.nio.ByteBuffer;

public interface ConstantInfoHandler {

    /**
     * 读取
     */
    void read(ByteBuffer codeBuf) throws Exception;

}
