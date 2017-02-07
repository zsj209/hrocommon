package com.hrocloud.common;

import com.hrocloud.common.utils.SecurityInit;





public class CommonServer {

    public static void main(String[] args) {
    	new SecurityInit().init();
        com.alibaba.dubbo.container.Main.main(args);
    }
}
