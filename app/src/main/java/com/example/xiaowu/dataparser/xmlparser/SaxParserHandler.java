package com.example.xiaowu.dataparser.xmlparser;

import android.text.TextUtils;
import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by xiaowu on 2016-7-21.
 * <result>
 *     <cmd>getdata</cmd>
 *     <successful>yes</successful>
 *     <data>
 *         {url1,url2,url3}
 *     </data>
 * </result>
 * 
 * 
 */
public class SaxParserHandler extends DefaultHandler {
    private static final String TAG = "SaxParserHandler";
    private String tagname;
    

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        Log.d(TAG, "characters: ");
        if (!TextUtils.isEmpty(tagname))
        {
            String str=new String(ch,start,length);
            if (tagname.equals("successful"))
            {
                Log.d(TAG, "characters: "+str);
            }
            if (tagname.equals("data"))
            {
                Log.d(TAG, "characters: "+str);
            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        Log.d(TAG, "endDocument: ");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Log.d(TAG, "endElement: ");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        Log.d(TAG, "startElement: ");
        this.tagname=qName;
    }

    @Override
    public void startDocument() throws SAXException {
        Log.d(TAG, "startDocument: ");
    }


}
