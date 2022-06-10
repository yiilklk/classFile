package com.zwb.type.cp;

import com.zwb.type.U1;

public class ConstantInterfaceMethodrefInfo extends ConstantFieldrefInfo {

    public ConstantInterfaceMethodrefInfo(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_InterfaceMethodref_info";
    }
}
