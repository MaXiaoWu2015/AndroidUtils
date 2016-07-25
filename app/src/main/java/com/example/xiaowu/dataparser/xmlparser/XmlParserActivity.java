package com.example.xiaowu.dataparser.xmlparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.xiaowu.androidutils.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XmlParserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_parser);
        parseXmlToStr(" <result>" +
                "     <cmd>getdata</cmd>" +
                "      <successful>yes</successful>" +
                "      <data>" +
                "          {url1,url2,url3}" +
                "      </data>" +
                "  </result>");


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
