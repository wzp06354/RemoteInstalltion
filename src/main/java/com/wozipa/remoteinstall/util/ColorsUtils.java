package com.wozipa.remoteinstall.util;

import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wozipa on 2017/3/27.
 */
public class ColorsUtils {

    public static final Logger LOGGER=Logger.getLogger(ColorsUtils.class);
    public static final String WHITE="white";
    public static final String RED="red";
    public static final String GREEN="green";
    public static final String BLUE="blue";
    public static final String BLACK="black";


    public static Map<String,Color> CONTAINER=new HashMap<>();

    static {
        CONTAINER.put(WHITE,new Color(null,new RGB(255,255,255)));
        CONTAINER.put(GREEN,new Color(null,new RGB(0,255,0)));
        CONTAINER.put(RED,new Color(null,new RGB(255,0,0)));
        CONTAINER.put(BLUE,new Color(null,new RGB(0,0,255)));
        CONTAINER.put(BLACK,new Color(null,new RGB(0,0,0)));
    }

    public static Color GetColor(String color)
    {
        return CONTAINER.get(color);
    }

}
