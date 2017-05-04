package com.bigademo.tony.signin.Bean;

import java.util.List;

/**
 * Created by Tony on 2017/4/25.
 */

public class ResponseDataBean {

    /**
     * type : 0
     * msg : ............
     * maxversion : null
     * ipmreloadversion : 15
     * obj : [{"ABNUMBER":"AB054865","PHONEID":"18911139112","EMAIL":"ab054865yangyantao@ab-insurance.com","USERNAME":"........."}]
     * retcode : null
     * retmsg : null
     * content : null
     */

    private String type;
    private String msg;
    private Object maxversion;
    private String ipmreloadversion;
    private Object retcode;
    private Object retmsg;
    private Object content;
    private List<ObjBean> obj;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getMaxversion() {
        return maxversion;
    }

    public void setMaxversion(Object maxversion) {
        this.maxversion = maxversion;
    }

    public String getIpmreloadversion() {
        return ipmreloadversion;
    }

    public void setIpmreloadversion(String ipmreloadversion) {
        this.ipmreloadversion = ipmreloadversion;
    }

    public Object getRetcode() {
        return retcode;
    }

    public void setRetcode(Object retcode) {
        this.retcode = retcode;
    }

    public Object getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(Object retmsg) {
        this.retmsg = retmsg;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * ABNUMBER : AB054865
         * PHONEID : 18911139112
         * EMAIL : ab054865yangyantao@ab-insurance.com
         * USERNAME : .........
         */

        private String ABNUMBER;
        private String PHONEID;
        private String EMAIL;
        private String USERNAME;

        public String getABNUMBER() {
            return ABNUMBER;
        }

        public void setABNUMBER(String ABNUMBER) {
            this.ABNUMBER = ABNUMBER;
        }

        public String getPHONEID() {
            return PHONEID;
        }

        public void setPHONEID(String PHONEID) {
            this.PHONEID = PHONEID;
        }

        public String getEMAIL() {
            return EMAIL;
        }

        public void setEMAIL(String EMAIL) {
            this.EMAIL = EMAIL;
        }

        public String getUSERNAME() {
            return USERNAME;
        }

        public void setUSERNAME(String USERNAME) {
            this.USERNAME = USERNAME;
        }
    }
}
