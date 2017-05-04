package com.bigademo.tony.signin.Bean;

/**
 * Created by Tony on 2017/4/25.
 */

public class ResponseBean {

    /**
     * RESULT_MSG : null
     * RESULT_DATA : [{"r_content":"...... ..................","r_url":"http://bangbang.anbanggroup.com:9000/app-download/"},{"r_content":"......... .......................................","r_url":"http://www.anbangjr.com/lcb_webView/pages/download/download.jsp?from=groupmessage&isappinstalled=0"},{"r_content":"......... .......................................","r_url":"http://106.39.86.118:7890/app_download.html"}]
     * RESULT_TYPE : success
     */

    private Object RESULT_MSG;
    private String RESULT_DATA;
    private String RESULT_TYPE;

    public Object getRESULT_MSG() {
        return RESULT_MSG;
    }

    public void setRESULT_MSG(Object RESULT_MSG) {
        this.RESULT_MSG = RESULT_MSG;
    }

    public String getRESULT_DATA() {
        return RESULT_DATA;
    }

    public void setRESULT_DATA(String RESULT_DATA) {
        this.RESULT_DATA = RESULT_DATA;
    }

    public String getRESULT_TYPE() {
        return RESULT_TYPE;
    }

    public void setRESULT_TYPE(String RESULT_TYPE) {
        this.RESULT_TYPE = RESULT_TYPE;
    }
}
