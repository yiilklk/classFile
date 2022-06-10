package com.zwb.type;

import lombok.Getter;
import lombok.Setter;
import com.zwb.type.cp.*;

@Getter
@Setter
public abstract class CpInfo implements ConstantInfoHandler {

    private U1 tag;

    protected CpInfo(U1 tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "tag=" + tag.toString();
    }

    public static CpInfo newCpInfo(U1 tag) throws Exception {
        int tagValue = tag.toInt();
        CpInfo info;
        switch (tagValue) {
            case 1:
                info = new ConstantUtf8Info(tag);
                break;
            case 3:
                info = new ConstantIntegerInfo(tag);
                break;
            case 4:
                info = new ConstantFloatInfo(tag);
                break;
            case 5:
                info = new ConstantLongInfo(tag);
                break;
            case 6:
                info = new ConstantDoubleInfo(tag);
                break;
            case 7:
                info = new ConstantClassInfo(tag);
                break;
            case 8:
                info = new ConstantStringInfo(tag);
                break;
            case 9:
                info = new ConstantFieldrefInfo(tag);
                break;
            case 10:
                info = new ConstantMethodrefInfo(tag);
                break;
            case 11:
                info = new ConstantInterfaceMethodrefInfo(tag);
                break;
            case 12:
                info = new ConstantNameAndTypeInfo(tag);
                break;
            case 15:
                info = new ConstantMethodHandleInfo(tag);
                break;
            case 16:
                info = new ConstantMethodTypeInfo(tag);
                break;
            case 18:
                info = new ConstantInvokeDynamicInfo(tag);
                break;
            default:
                throw new Exception("没有找到该TAG=" + tagValue + "对应的常量类型");
        }
        return info;
    }

}
