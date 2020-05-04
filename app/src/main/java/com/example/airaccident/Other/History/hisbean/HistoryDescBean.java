package com.example.airaccident.Other.History.hisbean;

import java.util.List;

public class HistoryDescBean {

    /**
     * result : [{"_id":"19990105","title":"国家组建缉私警察队伍","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201001/3/8C162636992.jpg","year":1999,"month":1,"day":5,"des":"1999年1月5日 (农历冬月十八)，国家组建缉私警察队伍。","content":"1999年1月5日 (农历冬月十八)，国家组建缉私警察队伍。\n为了严厉打击走私违法活动，中共中央、国务院决定成立国家缉私警察队伍，1999年1月5日，在正式成立海关总署走私犯罪侦查局的同时，正式组建了专司打击走私犯罪的执法队伍──海关缉私警察队伍，实行了\u201c联合缉私，统一处理，综合治理\u201d的反走私斗争新体制。缉私警察由海关总署和公安部双重领导，以海关领导为主。在共和国境内，缉私警察依法查缉涉税走私犯罪案件，对走私犯罪案件和走私犯罪嫌疑人依法进行侦查、拘留、逮捕和预审工作。\n","lunar":"戊寅年冬月十八"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * _id : 19990105
         * title : 国家组建缉私警察队伍
         * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201001/3/8C162636992.jpg
         * year : 1999
         * month : 1
         * day : 5
         * des : 1999年1月5日 (农历冬月十八)，国家组建缉私警察队伍。
         * content : 1999年1月5日 (农历冬月十八)，国家组建缉私警察队伍。
         为了严厉打击走私违法活动，中共中央、国务院决定成立国家缉私警察队伍，1999年1月5日，在正式成立海关总署走私犯罪侦查局的同时，正式组建了专司打击走私犯罪的执法队伍──海关缉私警察队伍，实行了“联合缉私，统一处理，综合治理”的反走私斗争新体制。缉私警察由海关总署和公安部双重领导，以海关领导为主。在共和国境内，缉私警察依法查缉涉税走私犯罪案件，对走私犯罪案件和走私犯罪嫌疑人依法进行侦查、拘留、逮捕和预审工作。
         * lunar : 戊寅年冬月十八
         */

        private String _id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String content;
        private String lunar;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }
    }
}
