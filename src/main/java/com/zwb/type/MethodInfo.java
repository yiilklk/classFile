package com.zwb.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MethodInfo {

    private U2 accessFlags;
    private U2 nameIndex;
    private U2 descriptorIndex;
    private U2 attributesCount;
    private AttributeInfo[] attributes;

}