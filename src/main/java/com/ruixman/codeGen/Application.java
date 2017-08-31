package com.ruixman.codeGen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/31.
 */
public class Application {

    public static void main(String[] args){
//        for (String s:args){
//            System.out.print(s);
//        }
        //通过参数得
        String vo= args[0];
        Map m= new HashMap();
        String filePath = CommUtil.freemarkerProcess(m,vo);        //在字串中替换变量
        System.out.print("the object is"+vo);

        //写入java文件
        CommUtil.writeFile(filePath,vo);

    }
}
