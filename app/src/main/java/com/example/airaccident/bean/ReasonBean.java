package com.example.airaccident.bean;

import java.util.List;

public class ReasonBean {

    /**
     * msg : null
     * status : 0
     * data : [{"reaid":"01","reaname":"航空器动力装置故障","reahow":"燃油系统故障、发动机故障"},{"reaid":"02","reaname":"航空器结构故障","reahow":"机腹整流罩故障、客舱门故障"},{"reaid":"03","reaname":"机载电子设备故障","reahow":"飞机上的各种电子设备出故障"},{"reaid":"04","reaname":"操纵系统故障","reahow":"主操纵系统故障"},{"reaid":"05","reaname":"起落装置故障","reahow":"起落架故障"},{"reaid":"06","reaname":"机翼尾翼故障","reahow":"水平尾翼故障、机翼结冰故障"},{"reaid":"07","reaname":"机组原因","reahow":"飞行员操作失误、乘务员处置不当"},{"reaid":"08","reaname":"地面指挥原因","reahow":"机场运行指挥不当、空管指挥不当"},{"reaid":"09","reaname":"无关人员原因","reahow":"不是机场或航空公司内部人员造成的的原因"},{"reaid":"10","reaname":"环境原因","reahow":"电磁波干扰、空中障碍、危险品、天气原因、地理环境"},{"reaid":"11","reaname":"其他部门工作人员原因","reahow":"安检失误、检查失误（检查装载货物之类的）、部门之间沟通 合作存在问题、部门制定的有关条例不清晰等，装载分布差错未被发现，因为在事故航班执行前，未按照批准的程序进行重量和平衡计算"}]
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
         * reaid : 01
         * reaname : 航空器动力装置故障
         * reahow : 燃油系统故障、发动机故障
         */

        private String reaid;
        private String reaname;
        private String reahow;

        public String getReaid() {
            return reaid;
        }

        public void setReaid(String reaid) {
            this.reaid = reaid;
        }

        public String getReaname() {
            return reaname;
        }

        public void setReaname(String reaname) {
            this.reaname = reaname;
        }

        public String getReahow() {
            return reahow;
        }

        public void setReahow(String reahow) {
            this.reahow = reahow;
        }
    }
}
