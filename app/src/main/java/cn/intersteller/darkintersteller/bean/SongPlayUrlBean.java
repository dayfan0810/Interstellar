package cn.intersteller.darkintersteller.bean;

import java.util.List;

public class SongPlayUrlBean {

    /**
     * data : [{"id":412327300,"url":"http://m7.music.126.net/20200506165557/5cd2566d5f978e0d5acd7d17cfb38fff/ymusic/sIswW1rVhZdBzV64K30wBg==/509951162786488943","br":1006238,"size":14885627,"md5":"fc3c1a2e1c9600226209237c939ed8f3","code":200,"expi":1200,"type":"FLAC","gain":0,"fee":0,"uf":null,"payed":0,"flag":264,"canExtend":false,"freeTrialInfo":null,"level":null,"encodeType":null}]
     * code : 200
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 412327300
         * url : http://m7.music.126.net/20200506165557/5cd2566d5f978e0d5acd7d17cfb38fff/ymusic/sIswW1rVhZdBzV64K30wBg==/509951162786488943
         * br : 1006238
         * size : 14885627
         * md5 : fc3c1a2e1c9600226209237c939ed8f3
         * code : 200
         * expi : 1200
         * type : FLAC
         * gain : 0
         * fee : 0
         * uf : null
         * payed : 0
         * flag : 264
         * canExtend : false
         * freeTrialInfo : null
         * level : null
         * encodeType : null
         */

        private int id;
        private String url;
        private int code;
        private String type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
