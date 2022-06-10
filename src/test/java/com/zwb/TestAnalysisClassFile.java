package com.zwb;

import com.zwb.type.*;
import com.zwb.util.ClassAccessFlagUtils;
import com.zwb.util.FieldAccessFlagUtils;
import com.zwb.util.HexStringUtils;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;


/**
 * @author zhengweibo
 * @Date 2022/6/9
 */
public class TestAnalysisClassFile {
    ClassFile classFile;
    String filePath = "/Users/zhengweibo/github/DemoClass.class";

    @Before
    public void init() throws Exception {
        ByteBuffer codeBuf = ClassFileAnalysisMain.readFile(filePath);
        classFile = ClassFileAnalysiser.analysis(codeBuf);
    }

    @Test
    public void testReadMagic() {
        U4 magic = classFile.getMagic();
        System.out.println("class文件的魔数为:" + magic.toHexString());
    }

    @Test
    public void testReadClassFileVersion() {
        U2 majorVersion = classFile.getMajorVersion();
        U2 minorVersion = classFile.getMinorVersion();
        System.out.println("class文件的主版本号为:" + majorVersion.toInt() + ", 次版本号为:" + minorVersion.toInt());
    }

    @Test
    public void testReadConstantPool() {
        U2 constantPoolCount = classFile.getConstantPoolCount();
        System.out.println("class文件的常量池计数器为:" + constantPoolCount.toInt());

        CpInfo[] constantPools = classFile.getConstantPool();
        for (int i = 0; i < constantPools.length; i++) {
            CpInfo cpInfo = constantPools[i];
            System.out.println("index:" + i + ", 常量信息:" + cpInfo);
            System.out.println(cpInfo.getTag().toHexString());
        }
    }

    @Test
    public void testReadAccessFlag() {
        U2 accessFlag = classFile.getAccessFlags();
        System.out.println("class文件的类访问标志为:" + ClassAccessFlagUtils.toClassAccessFlagsString(accessFlag));
    }

    @Test
    public void testReadClass() {
        U2 thisClass = classFile.getThisClass();
        U2 superClass = classFile.getSuperClass();
        System.out.println("当前类为:" + thisClass.toHexString());
        System.out.println("父类为:" + superClass.toHexString());
    }

    @Test
    public void testReadInterface() {
        U2 interfacesCount = classFile.getInterfacesCount();
        System.out.println("接口数为:" + interfacesCount.toInt());

        U2[] interfaces = classFile.getInterfaces();
        for (U2 interfaceInfo : interfaces) {
            System.out.println("接口信息:" + interfaceInfo.toHexString());
        }
    }

    @Test
    public void testReadField() {
        U2 fieldsCount = classFile.getFieldsCount();
        System.out.println("属性表计数器为:" + fieldsCount.toInt());

        FieldInfo[] fields = classFile.getFields();
        for (FieldInfo field : fields) {
            System.out.println("access_flag:" + FieldAccessFlagUtils.toFieldAccessFlagsString(field.getAccessFlags()));
            System.out.println("name_index:" + field.getNameIndex().toInt());
            System.out.println("descriptor_index:" + field.getDescriptorIndex().toInt());
            System.out.println("attributes_count:" + field.getAttributesCount().toInt());
            System.out.println("=====================================");
        }
    }

    @Test
    public void testReadMethod() {
        U2 methodsCount = classFile.getMethodsCount();
        System.out.println("方法计数器值为:" + methodsCount.toInt());

        MethodInfo[] methods = classFile.getMethods();
        for (MethodInfo method : methods) {
            System.out.println("access_flag:" + FieldAccessFlagUtils.toFieldAccessFlagsString(method.getAccessFlags()));
            System.out.println("name_index:" + method.getNameIndex().toInt());
            System.out.println("descriptor_index:" + method.getDescriptorIndex().toInt());
            System.out.println("attributes_count:" + method.getAttributesCount().toInt());
            System.out.println("=====================================");
        }
    }

    @Test
    public void testReadAttributes() {
        U2 attributesCount = classFile.getAttributesCount();
        System.out.println("属性计数器值为:" + attributesCount.toInt());

        AttributeInfo[] attributes = classFile.getAttributes();
        for (AttributeInfo attribute : attributes) {
            System.out.println("attribute_name_index:" + attribute.getAttributeNameIndex().toInt());
            System.out.println("attribute_length:" + attribute.getAttributeLength().toInt());
            System.out.println("attribute_info:" + HexStringUtils.toHexString(attribute.getInfo()));
            System.out.println("=====================================");
        }
    }
}
