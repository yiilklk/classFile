package com.zwb.type.cp;

import com.zwb.type.U1;

public class ConstantMethodrefInfo extends ConstantFieldrefInfo {

    public ConstantMethodrefInfo(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Methodref_info";
    }
}