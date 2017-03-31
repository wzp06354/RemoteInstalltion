package com.wozipa.remoteinstall.service.ip;

import org.apache.log4j.Logger;

import java.awt.*;
import java.net.InterfaceAddress;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wozipa on 2017/3/27.
 */
public class IPTask extends Thread {

    private static final Logger LOGGER=Logger.getLogger(IPTask.class);

    private static Set<String> HOSTS=new HashSet<>();

    public static synchronized void AddIP(String host)
    {
        HOSTS.add(host);
    }

    private int firstStart=-1,firstEnd=-1;
    private int secondStart=-1,secondEnd=-1;
    private int thirdStart=-1,thirdEnd=-1;
    private int fouthStart=-1,fouthEnd=-1;

    public IPTask()
    {
    }

    public void setFirst(int start,int end)
    {
        this.firstStart=start;
        firstEnd=end;
    }

    public void setSecond(int start,int end)
    {
        secondStart=start;
        secondEnd=end;
    }

    public void setThird(int start,int end)
    {
        thirdStart=start;
        thirdEnd=end;
    }

    public void setFouth(int start,int end)
    {
        fouthStart=start;
        fouthEnd=end;
    }

    private boolean doRun=true;

    public void shutdown()
    {
        this.doRun=false;
    }

    @Override
    public void run() {
        if(!check(firstStart,firstEnd,secondStart,secondEnd,thirdStart,thirdEnd,fouthStart,fouthEnd))
        {
            LOGGER.info("the ip address is not complite");
            return;
        }
        StringBuffer IPSb=new StringBuffer();
        for(int first=firstStart;first<=firstEnd;first++)
        {
            for(int second=secondStart;second<=secondEnd;second++)
            {
                for(int third=thirdStart;third<=thirdEnd;third++)
                {
                    for(int fouth=fouthStart;fouth<=fouthEnd;fouth++)
                    {
                        IPSb.delete(0,IPSb.length()-1);
                        IPSb.append(first).append(".").append(second).append(".").append(third).append(".").append(fouth);
                        String ip=IPSb.toString();
                    }
                }
            }
        }
    }

    public boolean check(int... ints)
    {
        for(int i:ints)
        {
            if(i<0)
            {
                return false;
            }
        }
        return true;
    }
}
