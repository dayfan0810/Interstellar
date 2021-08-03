package cn.intersteller.darkintersteller.bean;

import java.util.List;

public class HotSearchDetailBean {

    /**
     * code : 200
     * data : [{"searchWord":"喜欢你","score":3769503,"content":"我喜欢你爱我的心~","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"夏天的风","score":2367307,"content":"单曲循环无数次 回忆杀！","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"人间","score":1976429,"content":"天上人间 若真的值得歌颂~","source":1,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"featured"},{"searchWord":"无人之岛","score":1530741,"content":"每个人都是等待被发掘的孤岛","source":0,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"alg_statistics"},{"searchWord":"与我无关","score":1277608,"content":"还是希望你好 即使那与我无关","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"立夏","score":1187697,"content":"来一点清凉的夏日之歌吧！","source":0,"iconType":2,"iconUrl":"https://p1.music.126.net/szWeddITZIVxpvQ0QywzcQ==/109951163967989323.png","url":"","alg":"alg_statistics"},{"searchWord":"喜欢","score":951883,"content":"扛不住，对你的喜欢。","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"林俊杰","score":930722,"content":"一千年以后，还是学不会爱你","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"相信未来义演","score":918769,"content":"相信未来的力量，正在进行时","source":1,"iconType":1,"iconUrl":"https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png","url":"","alg":"featured"},{"searchWord":"夏天","score":909217,"content":"海边微风起，等风也等你，夏天来了","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"万有引力","score":876283,"content":"喜欢你完全处于万有引力","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"张杰","score":869093,"content":"张杰带你穿越人海","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"天下","score":846377,"content":"一起感受张杰歌里的壮志凌云","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"小苹果","score":828187,"content":"你一定记得这首歌的旋律","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"独角戏","score":827036,"content":"如果一切只是演戏，心碎只是我自己","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"枯木逢春","score":787428,"content":"枯木逢春的歌声中藏着一片风景","source":0,"iconType":5,"iconUrl":"https://p1.music.126.net/PtgUJbcvDAY0HKWpmOB2HA==/109951163967988470.png","url":"","alg":"alg_statistics"},{"searchWord":"我的歌声里","score":779015,"content":"当年大火的热门华语歌！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"爱如潮水","score":742538,"content":"张信哲代表作，一秒沦陷！","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"},{"searchWord":"Take It Off","score":722142,"content":"一天不被kesha洗脑就浑身难受！","source":0,"iconType":5,"iconUrl":"https://p1.music.126.net/PtgUJbcvDAY0HKWpmOB2HA==/109951163967988470.png","url":"","alg":"alg_statistics"},{"searchWord":"伍佰","score":700225,"content":"他看似粗犷，却比谁都温柔～","source":0,"iconType":0,"iconUrl":null,"url":"","alg":"alg_statistics"}]
     * message : success
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
         * searchWord : 喜欢你
         * score : 3769503
         * content : 我喜欢你爱我的心~
         * source : 0
         * iconType : 1
         * iconUrl : https://p1.music.126.net/2zQ0d1ThZCX5Jtkvks9aOQ==/109951163968000522.png
         * url :
         * alg : alg_statistics
         */

        private String searchWord;

        public String getSearchWord() {
            return searchWord;
        }

        public void setSearchWord(String searchWord) {
            this.searchWord = searchWord;
        }
    }
}
