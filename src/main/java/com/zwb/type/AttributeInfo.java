package com.zwb.type;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttributeInfo {
    private U2 attributeNameIndex;
    private U4 attributeLength;
    private byte[] info;
}
