package com.example.xiaowu.dataparser.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.example.aaron.library.MLog;
import com.example.xiaowu.androidutils.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParserActivity extends AppCompatActivity {
    private static final String TAG = "XmlParserActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);
//        parseXmlToStr(" <result>" +
//                "     <cmd>getdata</cmd>" +
//                "      <successful>yes</successful>" +
//                "      <data>" +
//                "          {url1,url2,url3}" +
//                "      </data>" +
//                "  </result>");
        Log.d(TAG, "onCreate: ");
        ArrayList<String>  list=transferPicsStr2List("[\"http://konka.com/1.jpg\",\"http://konka.com/2.jpg\"]");
        MLog.d(TAG,"transferPicsStr2List   "+list);

    }



    public ArrayList<String> transferPicsStr2List(String picsStr)
    {
        ArrayList<String> picUrlList=null;
        if (!TextUtils.isEmpty(picsStr)){
            picsStr=picsStr.trim();
            picsStr=picsStr.substring(1,picsStr.length()-1);
            String[] picsArray=picsStr.split(",");
            picUrlList=new ArrayList<>(Arrays.asList(picsArray));
        }
//        MLog.d(TAG,"transferPicsStr2List   "+transferPicsStr2List("[\"http://konka.com/1.jpg\",\"http://konka.com/2.jpg\"]"));
        return picUrlList;
    }


    public static String parseXmlToStr(String xmlStr)
    {
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            XMLReader reader=parser.getXMLReader();
            reader.setContentHandler(new SaxParserHandler());
            reader.parse(new InputSource(new StringReader(xmlStr)));
            return "";
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
