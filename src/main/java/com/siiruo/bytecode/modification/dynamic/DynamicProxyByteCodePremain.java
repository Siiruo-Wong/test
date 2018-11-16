package com.siiruo.bytecode.modification.dynamic;

import java.lang.instrument.Instrumentation;

/**
 * Created by siiruo wong on 2018/11/13.
 */
public class DynamicProxyByteCodePremain {
    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new DynamicProxyByteCodeTransformer());
    }
}
