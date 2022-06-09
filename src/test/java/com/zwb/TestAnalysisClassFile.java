package com.zwb;

import com.zwb.type.ClassFile;
import com.zwb.type.CpInfo;
import com.zwb.type.U2;
import com.zwb.type.U4;
import com.zwb.util.ClassAccessFlagUtils;
import org.junit.Before;
import org.junit.Test;

import java.nio.ByteBuffer;


/**
 * @author zhengweibo
 * @Date 2022/6/9
 */
public class TestAnalysisClassFile {
    ClassFile classFile;
    String filePath = "/Users/zhengweibo/github/TestClassFile.class";

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
        U2 majorVersion = classFile.getMajor_version();
        U2 minorVersion = classFile.getMinor_version();
        System.out.println("class文件的主版本号为:" + majorVersion.toInt() + ", 次版本号为:" + minorVersion.toInt());
    }

    @Test
    public void testReadConstantPoolCount() {
        U2 constantPoolCount = classFile.getConstant_pool_count();
        System.out.println("class文件的常量池计数器为:" + constantPoolCount.toInt());
    }

    @Test
    public void testReadConstantPool() {
        CpInfo[] constantPools = classFile.getConstant_pool();
        for (CpInfo cpInfo : constantPools) {
            System.out.println("常量类型为:" + cpInfo.toString());
        }
    }

    @Test
    public void testReadAccessFlag() {
        U2 accessFlag = classFile.getAccess_flags();
        System.out.println("class文件的类访问标志为:" + ClassAccessFlagUtils.toClassAccessFlagsString(accessFlag));
    }
}
