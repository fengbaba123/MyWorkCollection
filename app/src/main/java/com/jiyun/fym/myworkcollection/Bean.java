package com.jiyun.fym.myworkcollection;

import java.util.List;

/**
 * Created by 冯玉苗 on 2017/7/4.
 */

public class Bean {

    /**
     * code : 00000
     * message : 请求成功
     * integ : {"integral":"206","infoList":[{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/mengmengda.jpg","goods_name":"测试添加数据050","likes":"132","integral":"78"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/xuexi.jpg","goods_name":"测试添加数据040","likes":"4","integral":"12"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/qunzhong.jpg","goods_name":"测试添加数据030","likes":"15","integral":"89"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/haodiao.jpg","goods_name":"测试添加数据020","likes":"95","integral":"789"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/shabi.jpg","goods_name":"测试添加数据010","likes":"268","integral":"132"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/jiunihuad.jpg","goods_name":"测试添加数据00","likes":"35","integral":"457"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/xihuan.jpg","goods_name":"测试添加数据99","likes":"234","integral":"467"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/lalla.jpg","goods_name":"测试添加数据88","likes":"23","integral":"234123"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/jinqul.jpeg","goods_name":"测试添加数据77","likes":"43","integral":"3545"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/shuaibux.jpg","goods_name":"测试添加数据66","likes":"23","integral":"455"}]}
     */

    private String code;
    private String message;
    private IntegBean integ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public IntegBean getInteg() {
        return integ;
    }

    public void setInteg(IntegBean integ) {
        this.integ = integ;
    }

    public static class IntegBean {
        /**
         * integral : 206
         * infoList : [{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/mengmengda.jpg","goods_name":"测试添加数据050","likes":"132","integral":"78"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/xuexi.jpg","goods_name":"测试添加数据040","likes":"4","integral":"12"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/qunzhong.jpg","goods_name":"测试添加数据030","likes":"15","integral":"89"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/haodiao.jpg","goods_name":"测试添加数据020","likes":"95","integral":"789"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/shabi.jpg","goods_name":"测试添加数据010","likes":"268","integral":"132"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/jiunihuad.jpg","goods_name":"测试添加数据00","likes":"35","integral":"457"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/xihuan.jpg","goods_name":"测试添加数据99","likes":"234","integral":"467"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/lalla.jpg","goods_name":"测试添加数据88","likes":"23","integral":"234123"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/jinqul.jpeg","goods_name":"测试添加数据77","likes":"43","integral":"3545"},{"ima_url":"http://101.200.142.201/MyListLoadAuto/image/shuaibux.jpg","goods_name":"测试添加数据66","likes":"23","integral":"455"}]
         */

        private String integral;
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
            /**
             * ima_url : http://101.200.142.201/MyListLoadAuto/image/mengmengda.jpg
             * goods_name : 测试添加数据050
             * likes : 132
             * integral : 78
             */

            private String ima_url;
            private String goods_name;
            private String likes;
            private String integral;

            public String getIma_url() {
                return ima_url;
            }

            public void setIma_url(String ima_url) {
                this.ima_url = ima_url;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getIntegral() {
                return integral;
            }

            public void setIntegral(String integral) {
                this.integral = integral;
            }
        }
    }
}
