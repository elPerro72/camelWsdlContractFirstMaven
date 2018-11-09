package com.kiktan.common;

import org.apache.camel.Headers;
import org.apache.cxf.binding.soap.SoapHeader;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.Map;

public class MoneyBean {

    public String getChainId(@Headers Map headers) {
        String bert = null;
        ArrayList<SoapHeader> soapheaders = (ArrayList) headers.get("org.apache.cxf.headers.Header.list");
        for (SoapHeader soapHeader : soapheaders) {
            javax.xml.namespace.QName ff = soapHeader.getName();
            String kolder = ff.toString();
            if (kolder.contains("chainId")) {
                Element e = (Element) soapHeader.getObject();
                bert = e.getTextContent();
                // headers.put("chainId", bert);
            }
        }
        return bert;
    }
}
