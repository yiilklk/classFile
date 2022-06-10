package com.zwb.type.cp;

import com.zwb.type.U1;

public class ConstantFloatInfo extends ConstantIntegerInfo {

    public ConstantFloatInfo(U1 tag) {
        super(tag);
    }

    @Override
    public String toString() {
        return "CONSTANT_Float_info";
    }

}
