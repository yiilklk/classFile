package com.zwb;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ClassFileAnalysisMain {

    public static ByteBuffer readFile(String classFilePath) throws Exception {
        File file = new File(classFilePath);
        if (!file.exists()) {
            throw new Exception("file not exists!");
        }
        byte[] byteCodeBuf = new byte[(int) file.length()];
        int length;
        try (InputStream in = new FileInputStream(file)) {
            length = in.read(byteCodeBuf);
        }
        if (length < 1) {
            throw new Exception("not read byte code.");
        }
        return ByteBuffer.wrap(byteCodeBuf, 0, length)
                .asReadOnlyBuffer();
    }
}
