package com.jiyun.fym.mysql;

import java.util.List;

/**
 * Created by 冯玉苗 on 2017/7/2.
 */

public class Bean {

    /**
     * code : 00000
     * integ : {"infoList":[{"goods_name":"音乐枕头","ima_url":"a.png","integral":"100","likes":"293"},{"goods_name":"魔法充电宝","ima_url":"b.png","integral":"200","likes":"543"},{"goods_name":"极简手表","ima_url":"c.png","integral":"200","likes":"4543"},{"goods_name":"加湿器","ima_url":"d.png","integral":"105","likes":"1223"},{"goods_name":"多功能发电机","ima_url":"e.png","integral":"442","likes":"4345"}],"integral":"20"}
     * message : 请求成功
     */

    private String code;
    /**
     * infoList : [{"goods_name":"音乐枕头","ima_url":"a.png","integral":"100","likes":"293"},{"goods_name":"魔法充电宝","ima_url":"b.png","integral":"200","likes":"543"},{"goods_name":"极简手表","ima_url":"c.png","integral":"200","likes":"4543"},{"goods_name":"加湿器","ima_url":"d.png","integral":"105","likes":"1223"},{"goods_name":"多功能发电机","ima_url":"e.png","integral":"442","likes":"4345"}]
     * integral : 20
     */

    private IntegBean integ;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IntegBean getInteg() {
        return integ;
    }

    public void setInteg(IntegBean integ) {
        this.integ = integ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class IntegBean {
        private String integral;
        /**
         * goods_name : 音乐枕头
         * ima_url : a.png
         * integral : 100
         * likes : 293
         */

        private List<InfoListBean> infoList;

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public List<InfoListBean> getInfoList() {
            return infoList;
        }

        public void setInfoList(List<InfoListBean> infoList) {
            this.infoList = infoList;
        }

        public static class InfoListBean {
            private String goods_name;
            private String ima_url;
            private String integral;
            private String likes;

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getIma_url() {
                return ima_url;
            }

            public void setIma_url(String ima_url) {
                this.ima_url = ima_url;
            }

            public String getIntegral() {
                return integral;
            }

            public void setIntegral(String integral) {
                this.integral = integral;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }
        }
    }
}
