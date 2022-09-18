package cn.intersteller.darkintersteller.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchSongBean {

    @SerializedName("result")
    private ResultBean result;
    @SerializedName("code")
    private Integer code;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static class ResultBean {
        @SerializedName("searchQcReminder")
        private Object searchQcReminder;
        @SerializedName("songs")
        private List<SongsBean> songs;
        @SerializedName("songCount")
        private Integer songCount;

        public Object getSearchQcReminder() {
            return searchQcReminder;
        }

        public void setSearchQcReminder(Object searchQcReminder) {
            this.searchQcReminder = searchQcReminder;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public Integer getSongCount() {
            return songCount;
        }

        public void setSongCount(Integer songCount) {
            this.songCount = songCount;
        }

        public static class SongsBean {
            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private Integer id;
            @SerializedName("pst")
            private Integer pst;
            @SerializedName("t")
            private Integer t;
            @SerializedName("ar")
            private List<ArBean> ar;
            @SerializedName("alia")
            private List<?> alia;
            @SerializedName("pop")
            private Integer pop;
            @SerializedName("st")
            private Integer st;
            @SerializedName("rt")
            private String rt;
            @SerializedName("fee")
            private Integer fee;
            @SerializedName("v")
            private Integer v;
            @SerializedName("crbt")
            private Object crbt;
            @SerializedName("cf")
            private String cf;
            @SerializedName("al")
            private AlBean al;
            @SerializedName("dt")
            private Integer dt;
            @SerializedName("h")
            private HBean h;
            @SerializedName("m")
            private MBean m;
            @SerializedName("l")
            private LBean l;
            @SerializedName("sq")
            private SqBean sq;
            @SerializedName("hr")
            private Object hr;
            @SerializedName("a")
            private Object a;
            @SerializedName("cd")
            private String cd;
            @SerializedName("no")
            private Integer no;
            @SerializedName("rtUrl")
            private Object rtUrl;
            @SerializedName("ftype")
            private Integer ftype;
            @SerializedName("rtUrls")
            private List<?> rtUrls;
            @SerializedName("djId")
            private Integer djId;
            @SerializedName("copyright")
            private Integer copyright;
            @SerializedName("s_id")
            private Integer sId;
            @SerializedName("mark")
            private Integer mark;
            @SerializedName("originCoverType")
            private Integer originCoverType;
            @SerializedName("originSongSimpleData")
            private Object originSongSimpleData;
            @SerializedName("tagPicList")
            private Object tagPicList;
            @SerializedName("resourceState")
            private Boolean resourceState;
            @SerializedName("version")
            private Integer version;
            @SerializedName("songJumpInfo")
            private Object songJumpInfo;
            @SerializedName("entertainmentTags")
            private Object entertainmentTags;
            @SerializedName("single")
            private Integer single;
            @SerializedName("noCopyrightRcmd")
            private Object noCopyrightRcmd;
            @SerializedName("rtype")
            private Integer rtype;
            @SerializedName("rurl")
            private Object rurl;
            @SerializedName("mst")
            private Integer mst;
            @SerializedName("cp")
            private Integer cp;
            @SerializedName("mv")
            private Integer mv;
            @SerializedName("publishTime")
            private Long publishTime;
            @SerializedName("privilege")
            private PrivilegeBean privilege;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Integer getPst() {
                return pst;
            }

            public void setPst(Integer pst) {
                this.pst = pst;
            }

            public Integer getT() {
                return t;
            }

            public void setT(Integer t) {
                this.t = t;
            }

            public List<ArBean> getAr() {
                return ar;
            }

            public void setAr(List<ArBean> ar) {
                this.ar = ar;
            }

            public List<?> getAlia() {
                return alia;
            }

            public void setAlia(List<?> alia) {
                this.alia = alia;
            }

            public Integer getPop() {
                return pop;
            }

            public void setPop(Integer pop) {
                this.pop = pop;
            }

            public Integer getSt() {
                return st;
            }

            public void setSt(Integer st) {
                this.st = st;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public Integer getFee() {
                return fee;
            }

            public void setFee(Integer fee) {
                this.fee = fee;
            }

            public Integer getV() {
                return v;
            }

            public void setV(Integer v) {
                this.v = v;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public String getCf() {
                return cf;
            }

            public void setCf(String cf) {
                this.cf = cf;
            }

            public AlBean getAl() {
                return al;
            }

            public void setAl(AlBean al) {
                this.al = al;
            }

            public Integer getDt() {
                return dt;
            }

            public void setDt(Integer dt) {
                this.dt = dt;
            }

            public HBean getH() {
                return h;
            }

            public void setH(HBean h) {
                this.h = h;
            }

            public MBean getM() {
                return m;
            }

            public void setM(MBean m) {
                this.m = m;
            }

            public LBean getL() {
                return l;
            }

            public void setL(LBean l) {
                this.l = l;
            }

            public SqBean getSq() {
                return sq;
            }

            public void setSq(SqBean sq) {
                this.sq = sq;
            }

            public Object getHr() {
                return hr;
            }

            public void setHr(Object hr) {
                this.hr = hr;
            }

            public Object getA() {
                return a;
            }

            public void setA(Object a) {
                this.a = a;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public Integer getNo() {
                return no;
            }

            public void setNo(Integer no) {
                this.no = no;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public Integer getFtype() {
                return ftype;
            }

            public void setFtype(Integer ftype) {
                this.ftype = ftype;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public Integer getDjId() {
                return djId;
            }

            public void setDjId(Integer djId) {
                this.djId = djId;
            }

            public Integer getCopyright() {
                return copyright;
            }

            public void setCopyright(Integer copyright) {
                this.copyright = copyright;
            }

            public Integer getSId() {
                return sId;
            }

            public void setSId(Integer sId) {
                this.sId = sId;
            }

            public Integer getMark() {
                return mark;
            }

            public void setMark(Integer mark) {
                this.mark = mark;
            }

            public Integer getOriginCoverType() {
                return originCoverType;
            }

            public void setOriginCoverType(Integer originCoverType) {
                this.originCoverType = originCoverType;
            }

            public Object getOriginSongSimpleData() {
                return originSongSimpleData;
            }

            public void setOriginSongSimpleData(Object originSongSimpleData) {
                this.originSongSimpleData = originSongSimpleData;
            }

            public Object getTagPicList() {
                return tagPicList;
            }

            public void setTagPicList(Object tagPicList) {
                this.tagPicList = tagPicList;
            }

            public Boolean getResourceState() {
                return resourceState;
            }

            public void setResourceState(Boolean resourceState) {
                this.resourceState = resourceState;
            }

            public Integer getVersion() {
                return version;
            }

            public void setVersion(Integer version) {
                this.version = version;
            }

            public Object getSongJumpInfo() {
                return songJumpInfo;
            }

            public void setSongJumpInfo(Object songJumpInfo) {
                this.songJumpInfo = songJumpInfo;
            }

            public Object getEntertainmentTags() {
                return entertainmentTags;
            }

            public void setEntertainmentTags(Object entertainmentTags) {
                this.entertainmentTags = entertainmentTags;
            }

            public Integer getSingle() {
                return single;
            }

            public void setSingle(Integer single) {
                this.single = single;
            }

            public Object getNoCopyrightRcmd() {
                return noCopyrightRcmd;
            }

            public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
                this.noCopyrightRcmd = noCopyrightRcmd;
            }

            public Integer getRtype() {
                return rtype;
            }

            public void setRtype(Integer rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public Integer getMst() {
                return mst;
            }

            public void setMst(Integer mst) {
                this.mst = mst;
            }

            public Integer getCp() {
                return cp;
            }

            public void setCp(Integer cp) {
                this.cp = cp;
            }

            public Integer getMv() {
                return mv;
            }

            public void setMv(Integer mv) {
                this.mv = mv;
            }

            public Long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(Long publishTime) {
                this.publishTime = publishTime;
            }

            public PrivilegeBean getPrivilege() {
                return privilege;
            }

            public void setPrivilege(PrivilegeBean privilege) {
                this.privilege = privilege;
            }

            public static class AlBean {
                @SerializedName("id")
                private Integer id;
                @SerializedName("name")
                private String name;
                @SerializedName("picUrl")
                private String picUrl;
                @SerializedName("tns")
                private List<?> tns;
                @SerializedName("pic_str")
                private String picStr;
                @SerializedName("pic")
                private Long pic;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public String getPicStr() {
                    return picStr;
                }

                public void setPicStr(String picStr) {
                    this.picStr = picStr;
                }

                public Long getPic() {
                    return pic;
                }

                public void setPic(Long pic) {
                    this.pic = pic;
                }
            }

            public static class HBean {
                @SerializedName("br")
                private Integer br;
                @SerializedName("fid")
                private Integer fid;
                @SerializedName("size")
                private Integer size;
                @SerializedName("vd")
                private Integer vd;
                @SerializedName("sr")
                private Integer sr;

                public Integer getBr() {
                    return br;
                }

                public void setBr(Integer br) {
                    this.br = br;
                }

                public Integer getFid() {
                    return fid;
                }

                public void setFid(Integer fid) {
                    this.fid = fid;
                }

                public Integer getSize() {
                    return size;
                }

                public void setSize(Integer size) {
                    this.size = size;
                }

                public Integer getVd() {
                    return vd;
                }

                public void setVd(Integer vd) {
                    this.vd = vd;
                }

                public Integer getSr() {
                    return sr;
                }

                public void setSr(Integer sr) {
                    this.sr = sr;
                }
            }

            public static class MBean {
                @SerializedName("br")
                private Integer br;
                @SerializedName("fid")
                private Integer fid;
                @SerializedName("size")
                private Integer size;
                @SerializedName("vd")
                private Integer vd;
                @SerializedName("sr")
                private Integer sr;

                public Integer getBr() {
                    return br;
                }

                public void setBr(Integer br) {
                    this.br = br;
                }

                public Integer getFid() {
                    return fid;
                }

                public void setFid(Integer fid) {
                    this.fid = fid;
                }

                public Integer getSize() {
                    return size;
                }

                public void setSize(Integer size) {
                    this.size = size;
                }

                public Integer getVd() {
                    return vd;
                }

                public void setVd(Integer vd) {
                    this.vd = vd;
                }

                public Integer getSr() {
                    return sr;
                }

                public void setSr(Integer sr) {
                    this.sr = sr;
                }
            }

            public static class LBean {
                @SerializedName("br")
                private Integer br;
                @SerializedName("fid")
                private Integer fid;
                @SerializedName("size")
                private Integer size;
                @SerializedName("vd")
                private Integer vd;
                @SerializedName("sr")
                private Integer sr;

                public Integer getBr() {
                    return br;
                }

                public void setBr(Integer br) {
                    this.br = br;
                }

                public Integer getFid() {
                    return fid;
                }

                public void setFid(Integer fid) {
                    this.fid = fid;
                }

                public Integer getSize() {
                    return size;
                }

                public void setSize(Integer size) {
                    this.size = size;
                }

                public Integer getVd() {
                    return vd;
                }

                public void setVd(Integer vd) {
                    this.vd = vd;
                }

                public Integer getSr() {
                    return sr;
                }

                public void setSr(Integer sr) {
                    this.sr = sr;
                }
            }

            public static class SqBean {
                @SerializedName("br")
                private Integer br;
                @SerializedName("fid")
                private Integer fid;
                @SerializedName("size")
                private Integer size;
                @SerializedName("vd")
                private Integer vd;
                @SerializedName("sr")
                private Integer sr;

                public Integer getBr() {
                    return br;
                }

                public void setBr(Integer br) {
                    this.br = br;
                }

                public Integer getFid() {
                    return fid;
                }

                public void setFid(Integer fid) {
                    this.fid = fid;
                }

                public Integer getSize() {
                    return size;
                }

                public void setSize(Integer size) {
                    this.size = size;
                }

                public Integer getVd() {
                    return vd;
                }

                public void setVd(Integer vd) {
                    this.vd = vd;
                }

                public Integer getSr() {
                    return sr;
                }

                public void setSr(Integer sr) {
                    this.sr = sr;
                }
            }

            public static class PrivilegeBean {
                @SerializedName("id")
                private Integer id;
                @SerializedName("fee")
                private Integer fee;
                @SerializedName("payed")
                private Integer payed;
                @SerializedName("st")
                private Integer st;
                @SerializedName("pl")
                private Integer pl;
                @SerializedName("dl")
                private Integer dl;
                @SerializedName("sp")
                private Integer sp;
                @SerializedName("cp")
                private Integer cp;
                @SerializedName("subp")
                private Integer subp;
                @SerializedName("cs")
                private Boolean cs;
                @SerializedName("maxbr")
                private Integer maxbr;
                @SerializedName("fl")
                private Integer fl;
                @SerializedName("toast")
                private Boolean toast;
                @SerializedName("flag")
                private Integer flag;
                @SerializedName("preSell")
                private Boolean preSell;
                @SerializedName("playMaxbr")
                private Integer playMaxbr;
                @SerializedName("downloadMaxbr")
                private Integer downloadMaxbr;
                @SerializedName("maxBrLevel")
                private String maxBrLevel;
                @SerializedName("playMaxBrLevel")
                private String playMaxBrLevel;
                @SerializedName("downloadMaxBrLevel")
                private String downloadMaxBrLevel;
                @SerializedName("plLevel")
                private String plLevel;
                @SerializedName("dlLevel")
                private String dlLevel;
                @SerializedName("flLevel")
                private String flLevel;
                @SerializedName("rscl")
                private Object rscl;
                @SerializedName("freeTrialPrivilege")
                private FreeTrialPrivilegeBean freeTrialPrivilege;
                @SerializedName("chargeInfoList")
                private List<ChargeInfoListBean> chargeInfoList;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getFee() {
                    return fee;
                }

                public void setFee(Integer fee) {
                    this.fee = fee;
                }

                public Integer getPayed() {
                    return payed;
                }

                public void setPayed(Integer payed) {
                    this.payed = payed;
                }

                public Integer getSt() {
                    return st;
                }

                public void setSt(Integer st) {
                    this.st = st;
                }

                public Integer getPl() {
                    return pl;
                }

                public void setPl(Integer pl) {
                    this.pl = pl;
                }

                public Integer getDl() {
                    return dl;
                }

                public void setDl(Integer dl) {
                    this.dl = dl;
                }

                public Integer getSp() {
                    return sp;
                }

                public void setSp(Integer sp) {
                    this.sp = sp;
                }

                public Integer getCp() {
                    return cp;
                }

                public void setCp(Integer cp) {
                    this.cp = cp;
                }

                public Integer getSubp() {
                    return subp;
                }

                public void setSubp(Integer subp) {
                    this.subp = subp;
                }

                public Boolean getCs() {
                    return cs;
                }

                public void setCs(Boolean cs) {
                    this.cs = cs;
                }

                public Integer getMaxbr() {
                    return maxbr;
                }

                public void setMaxbr(Integer maxbr) {
                    this.maxbr = maxbr;
                }

                public Integer getFl() {
                    return fl;
                }

                public void setFl(Integer fl) {
                    this.fl = fl;
                }

                public Boolean getToast() {
                    return toast;
                }

                public void setToast(Boolean toast) {
                    this.toast = toast;
                }

                public Integer getFlag() {
                    return flag;
                }

                public void setFlag(Integer flag) {
                    this.flag = flag;
                }

                public Boolean getPreSell() {
                    return preSell;
                }

                public void setPreSell(Boolean preSell) {
                    this.preSell = preSell;
                }

                public Integer getPlayMaxbr() {
                    return playMaxbr;
                }

                public void setPlayMaxbr(Integer playMaxbr) {
                    this.playMaxbr = playMaxbr;
                }

                public Integer getDownloadMaxbr() {
                    return downloadMaxbr;
                }

                public void setDownloadMaxbr(Integer downloadMaxbr) {
                    this.downloadMaxbr = downloadMaxbr;
                }

                public String getMaxBrLevel() {
                    return maxBrLevel;
                }

                public void setMaxBrLevel(String maxBrLevel) {
                    this.maxBrLevel = maxBrLevel;
                }

                public String getPlayMaxBrLevel() {
                    return playMaxBrLevel;
                }

                public void setPlayMaxBrLevel(String playMaxBrLevel) {
                    this.playMaxBrLevel = playMaxBrLevel;
                }

                public String getDownloadMaxBrLevel() {
                    return downloadMaxBrLevel;
                }

                public void setDownloadMaxBrLevel(String downloadMaxBrLevel) {
                    this.downloadMaxBrLevel = downloadMaxBrLevel;
                }

                public String getPlLevel() {
                    return plLevel;
                }

                public void setPlLevel(String plLevel) {
                    this.plLevel = plLevel;
                }

                public String getDlLevel() {
                    return dlLevel;
                }

                public void setDlLevel(String dlLevel) {
                    this.dlLevel = dlLevel;
                }

                public String getFlLevel() {
                    return flLevel;
                }

                public void setFlLevel(String flLevel) {
                    this.flLevel = flLevel;
                }

                public Object getRscl() {
                    return rscl;
                }

                public void setRscl(Object rscl) {
                    this.rscl = rscl;
                }

                public FreeTrialPrivilegeBean getFreeTrialPrivilege() {
                    return freeTrialPrivilege;
                }

                public void setFreeTrialPrivilege(FreeTrialPrivilegeBean freeTrialPrivilege) {
                    this.freeTrialPrivilege = freeTrialPrivilege;
                }

                public List<ChargeInfoListBean> getChargeInfoList() {
                    return chargeInfoList;
                }

                public void setChargeInfoList(List<ChargeInfoListBean> chargeInfoList) {
                    this.chargeInfoList = chargeInfoList;
                }

                public static class FreeTrialPrivilegeBean {
                    @SerializedName("resConsumable")
                    private Boolean resConsumable;
                    @SerializedName("userConsumable")
                    private Boolean userConsumable;
                    @SerializedName("listenType")
                    private Object listenType;

                    public Boolean getResConsumable() {
                        return resConsumable;
                    }

                    public void setResConsumable(Boolean resConsumable) {
                        this.resConsumable = resConsumable;
                    }

                    public Boolean getUserConsumable() {
                        return userConsumable;
                    }

                    public void setUserConsumable(Boolean userConsumable) {
                        this.userConsumable = userConsumable;
                    }

                    public Object getListenType() {
                        return listenType;
                    }

                    public void setListenType(Object listenType) {
                        this.listenType = listenType;
                    }
                }

                public static class ChargeInfoListBean {
                    @SerializedName("rate")
                    private Integer rate;
                    @SerializedName("chargeUrl")
                    private Object chargeUrl;
                    @SerializedName("chargeMessage")
                    private Object chargeMessage;
                    @SerializedName("chargeType")
                    private Integer chargeType;

                    public Integer getRate() {
                        return rate;
                    }

                    public void setRate(Integer rate) {
                        this.rate = rate;
                    }

                    public Object getChargeUrl() {
                        return chargeUrl;
                    }

                    public void setChargeUrl(Object chargeUrl) {
                        this.chargeUrl = chargeUrl;
                    }

                    public Object getChargeMessage() {
                        return chargeMessage;
                    }

                    public void setChargeMessage(Object chargeMessage) {
                        this.chargeMessage = chargeMessage;
                    }

                    public Integer getChargeType() {
                        return chargeType;
                    }

                    public void setChargeType(Integer chargeType) {
                        this.chargeType = chargeType;
                    }
                }
            }

            public static class ArBean {
                @SerializedName("id")
                private Integer id;
                @SerializedName("name")
                private String name;
                @SerializedName("tns")
                private List<?> tns;
                @SerializedName("alias")
                private List<String> alias;
                @SerializedName("alia")
                private List<String> alia;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }

                public List<String> getAlias() {
                    return alias;
                }

                public void setAlias(List<String> alias) {
                    this.alias = alias;
                }

                public List<String> getAlia() {
                    return alia;
                }

                public void setAlia(List<String> alia) {
                    this.alia = alia;
                }
            }
        }
    }
}
