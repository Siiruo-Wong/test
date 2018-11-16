package com.siiruo.bytecode.modification.dynamic;

import javassist.ClassPool;
import javassist.CtClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by siiruo wong on 2018/11/13.
 */
public class DynamicProxyByteCodeTransformer implements ClassFileTransformer{
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        ClassPool pool = null;
        CtClass cl = null;
        try {
            pool = ClassPool.getDefault();

            cl = pool.makeClass(new java.io.ByteArrayInputStream(
                    classfileBuffer));
            CtClass superClass=pool.get("java.lang.reflect.Proxy");
            if(superClass!=null){
                if (cl.subclassOf(superClass)) {
                    System.out.println("Exporting " + className);
                    int lastIndexOf = className.lastIndexOf("/") + 1;
                    String fileName = className.substring(lastIndexOf) + ".class";
                    exportClazzToFile("D:\\javaCode\\byteCode\\", fileName, classfileBuffer);
                    System.out.println(className + " --> EXPORTED Succeess!");
                }
                superClass.detach();
            }
        } catch (Exception e) {
            System.err.println("Could not instrument  " + className
                    + ",  exception : " + e.getMessage());
        } finally {
            if (cl != null) {
                cl.detach();
            }
        }

        return new byte[0];
    }

    private void exportClazzToFile(String dirPath, String fileName, byte[] data) {
        OutputStream fos=null;
        try {
            File file = new File(dirPath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
        } catch (Exception e) {
            System.out.println("exception occured while doing some file operation");
            e.printStackTrace();
        }finally {

            if (fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
