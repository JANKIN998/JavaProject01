/**
 * 
 */
package com.abc.hotelsys.config;

/**
 * @author joeyang ong
 *
 */
public class VersionInfo {
	
    //application info
	public final static String APP_NAME="ABC代码工作室";
    public final static String APP_VERSION="1.0";
    public final static String APP_STATUS="Beta";
    public final static String APP_BUILDATE="2021-7-31";
    public final static String APP_BUILDVER="#1";
    	
    //application author
    public final static String APP_AUTHOR="ABC代码工作室";
    public final static String APP_WORKSTUDIO="ABC代码工作室";
    
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;ABC代码工作室:&nbsp;<a href=\"mailto:joeyang_ong@yahoo.com.cn\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("&copy;&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

    	return sb.toString();	
    }

}
