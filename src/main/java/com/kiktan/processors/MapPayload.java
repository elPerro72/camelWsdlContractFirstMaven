package com.kiktan.processors;

import org.apache.camel.Headers;
import java.util.Map;

import javax.wsdl.Input;

public class MapPayload {

    public static String map(@Headers Map header, String custom){
        return custom;
    }
}
