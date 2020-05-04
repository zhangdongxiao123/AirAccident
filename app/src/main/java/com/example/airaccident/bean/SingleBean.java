package com.example.airaccident.bean;

import java.util.List;

public class SingleBean {


    /**
     * msg : null
     * status : 0
     * data : [{"airid":"019","airname":"捷星航A320悉尼集装箱装载错误导致隐载","airtype":"隐患","airwhen":"2016年9月8日","airwhere":"布里斯班","airwhy":"其他部门工作人员原因","airhow":"2016年9月8日，一架澳大利亚捷星航空公司空客A320-200型客机（注册号VH-VFN），执行JQ-820航班从澳大利亚悉尼飞往布里斯班，机上载有173名乘客和6名机组人员。整个飞行过程似乎平安无事，最终飞机在布里斯班机场安全着陆。直到工作人员发现飞机装载的是错误的900千克的集装箱，而不是240千克的集装箱，才意识到飞机舱单不准确。然而机组人员在飞行过程中并没有察觉到任何操纵困难。","airimg":"http://q959uuxli.bkt.clouddn.com/19.JPG"},{"airid":"020","airname":"斯托巴特航空AT72都柏林起飞重心超限","airtype":"隐患","airwhen":"2015年7月23日","airwhere":"雷恩","airwhy":"其他部门工作人员原因","airhow":"2015年7月23日，一架爱尔兰斯托巴特航空公司（Stobart）ATR-72-212A型客机（注册号EI-FAV），为爱尔兰航空公司(AerLingus)执行EI-3906航班从爱尔兰都柏林飞往法国雷恩，机上载有57名乘客和4名机组人员。飞机在都柏林机场准备起飞，根据舱单，所有的货物都应装载在前货舱中，但实际上所有货物都装入了后货舱。在飞机起飞抬头时，机长感觉飞机尾部很重。之后飞机爬升继续前往雷恩。机长告诉副驾驶，由于机尾很重，着陆时要比平时飞的更平一些。飞机安全降落，着陆后发现货物装载错误。","airimg":"http://q959uuxli.bkt.clouddn.com/20.JPG"},{"airid":"025","airname":"澳航A333布里斯班MEL保留不当放行","airtype":"隐患","airwhen":"2016年8月4日","airwhere":"东京","airwhy":"其他部门工作人员原因","airhow":"2016年8月4日，一架澳洲航空公司空客A330-300型客机（注册号VH-QPC），执行QF-61航班从澳大利亚昆士兰州布里斯班国际机场飞往日本东京成田国际机场，飞机飞行约9小时后在成田机场16L跑道安全降落。尽管如此，2016年8月11日澳大利亚运输安全局（ATSB）报告称，飞机是在\u201c部分所需导航设备不工作的情况下\u201d放行的。所幸没有造成人员伤亡及飞机损坏。涉事飞机在东京停留不足2小时后便返回布里斯班，在布里斯班降落后在地面停留大约5小时，第二天再次执行QF-61航班。","airimg":"http://q959uuxli.bkt.clouddn.com/25.JPG"},{"airid":"066","airname":"澳航B744香港检查发现发动机吊架裂痕","airtype":"隐患","airwhen":"2016年10月5日","airwhere":"香港","airwhy":"航空器动力装置故障","airhow":"2016年10月5日，一架澳洲航空公司波音747-400型客机（注册号VH-OJT）在香港进行定检，检测到2号发动机（左手边内侧）吊架扭力盒内的4根外侧支柱肋（strutrib）有裂纹。","airimg":"http://q959uuxli.bkt.clouddn.com/66.JPG"},{"airid":"069","airname":"莱比锡航B752飞行途中引擎接近口盖掉落","airtype":"隐患","airwhen":"2015年11月3日","airwhere":"莱比锡","airwhy":"航空器动力装置故障","airhow":"2015年11月3日，一架德国欧洲航空运输莱比锡有限公司(DHL的子公司)波音757-200型货机（注册号D-ALEF），执行QY-121航班从比利时布鲁塞尔飞往德国莱比锡，机上载有两名机组人员。大约在比利时列日机场以南8海里爬升经过高度层FL200时，右侧发动机（RB211）接近口盖从机体分离，掉落地面，对此机组人员并不知情。之后这架飞机在莱比锡安全着陆，最初看起来像一次平静安全的飞行。在2015年11月3日，该机又继续完成了若干后续航段。在2015年11月4日运营人才发现右侧发动机反推的接近口盖丢失，部件被更换。","airimg":"http://q959uuxli.bkt.clouddn.com/69.JPG"}]
     */

    private Object msg;
    private int status;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
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
