package com.kiktan.processors;

import org.apache.camel.Headers;
import org.apache.cxf.binding.soap.SoapHeader;
import org.omg.CORBA.Object;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Map;

import javax.wsdl.Input;

public class GetSoapheader {

    public static String getHeaders(@Headers Map headers, String custom) {
        ArrayList<SoapHeader> soapheaders = (ArrayList) headers.get("org.apache.cxf.headers.Header.list");
        for (SoapHeader soapHeader : soapheaders) {
            javax.xml.namespace.QName ff = soapHeader.getName();
            String kolder = ff.toString();
            if (kolder.contains("chainId"))
            {
                Element e = (Element) soapHeader.getObject();
                String bert = e.getTextContent();
                headers.put("chainId", bert);
            }
        }
        return custom;
    }
}
