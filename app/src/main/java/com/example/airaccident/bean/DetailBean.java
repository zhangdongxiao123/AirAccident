package com.example.airaccident.bean;

public class DetailBean {


    /**
     * msg : null
     * status : 0
     * data : {"airid":"019","airname":"捷星航A320悉尼集装箱装载错误导致隐载","airtype":"隐患","airwhen":"2016年9月8日","airwhere":"布里斯班","airwhy":"其他部门工作人员原因","airhow":"2016年9月8日，一架澳大利亚捷星航空公司空客A320-200型客机（注册号VH-VFN），执行JQ-820航班从澳大利亚悉尼飞往布里斯班，机上载有173名乘客和6名机组人员。整个飞行过程似乎平安无事，最终飞机在布里斯班机场安全着陆。直到工作人员发现飞机装载的是错误的900千克的集装箱，而不是240千克的集装箱，才意识到飞机舱单不准确。然而机组人员在飞行过程中并没有察觉到任何操纵困难。","airimg":"http://q959uuxli.bkt.clouddn.com/19.JPG"}
     */

    private Object msg;
    private int status;
    private DataBean data;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * airid : 019
         * airname : 捷星航A320悉尼集装箱装载错误导致隐载
         * airtype : 隐患
         * airwhen : 2016年9月8日
         * airwhere : 布里斯班
         * airwhy : 其他部门工作人员原因
         * airhow : 2016年9月8日，一架澳大利亚捷星航空公司空客A320-200型客机（注册号VH-VFN），执行JQ-820航班从澳大利亚悉尼飞往布里斯班，机上载有173名乘客和6名机组人员。整个飞行过程似乎平安无事，最终飞机在布里斯班机场安全着陆。直到工作人员发现飞机装载的是错误的900千克的集装箱，而不是240千克的集装箱，才意识到飞机舱单不准确。然而机组人员在飞行过程中并没有察觉到任何操纵困难。
         * airimg : http://q959uuxli.bkt.clouddn.com/19.JPG
         */

        private String airid;
        private String airname;
        private String airtype;
        private String airwhen;
        private String airwhere;
        private String airwhy;
        private String airhow;
        private String airimg;

        public String getAirid() {
            return airid;
        }

        public void setAirid(String airid) {
            this.airid = airid;
        }

        public String getAirname() {
            return airname;
        }

        public void setAirname(String airname) {
            this.airname = airname;
        }

        public String getAirtype() {
            return airtype;
        }

        public void setAirtype(String airtype) {
            this.airtype = airtype;
        }

        public String getAirwhen() {
            return airwhen;
        }

        public void setAirwhen(String airwhen) {
            this.airwhen = airwhen;
        }

        public String getAirwhere() {
            return airwhere;
        }

        public void setAirwhere(String airwhere) {
            this.airwhere = airwhere;
        }

        public String getAirwhy() {
            return airwhy;
        }

        public void setAirwhy(String airwhy) {
            this.airwhy = airwhy;
        }

        public String getAirhow() {
            return airhow;
        }

        public void setAirhow(String airhow) {
            this.airhow = airhow;
        }

        public String getAirimg() {
            return airimg;
        }

        public void setAirimg(String airimg) {
            this.airimg = airimg;
        }
    }
}
