package com.example.seven.androidfirstbookalldemo.c9;


import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Seven on 2017/6/12.
 */

public class ContentHandler extends DefaultHandler {
    private String nodeName;
    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    @Override
    public void startDocument() throws SAXException {//初始化
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //记录当前节点名字
        //localName参数记录当前节点名字
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //根据当前的节点名判断将内容添加到哪一个StringBuilder对象中去
        if("id".equals(nodeName)){
            id.append(ch,start,length);
        }else if("name".equals(nodeName)){
            name.append(ch,start,length);
        }else if("version".equals(nodeName)){
            name.append(ch,start,length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("app".equals(localName)){
            Log.d("ContentHandler","id is"+id.toString().trim());
            Log.d("ContentHandler","name is"+name.toString().trim());
            Log.d("ContentHandler","version is"+version.toString().trim());
            //最后要讲StingBuilder清空掉
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
