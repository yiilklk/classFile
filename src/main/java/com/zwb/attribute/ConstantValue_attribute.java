package com.zwb.attribute;

import com.zwb.type.U2;
import com.zwb.type.U4;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantValue_attribute {

    private U2 attribute_name_index;
    private U4 attribute_length;
    private U2 constantvalue_index;

}
