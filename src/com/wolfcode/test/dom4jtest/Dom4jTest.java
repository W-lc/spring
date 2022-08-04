package com.wolfcode.test.dom4jtest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;

public class Dom4jTest{
    @Test
    public void test1_dom4j(){
//        创建一个读取解析xml的工具类
        SAXReader saxReader=new SAXReader();
//        使用该对象读取xml
        try {
            Document document =saxReader.read(new File("/Users/wlc/IdeaProjects/day01/src/test1.xml"));
//            通过调用document中的方法获取根节点
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.getName());
//            获取节点中的属性值
            String id = rootElement.attributeValue("id");
            System.out.println(id);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
