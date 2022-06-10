package com.zwb.attribute;

import com.zwb.type.U2;
import com.zwb.type.U4;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValueAttribute {

    private U2 attributeNameIndex;
    private U4 attributeLength;
    private U2 constantvalueIndex;

}
