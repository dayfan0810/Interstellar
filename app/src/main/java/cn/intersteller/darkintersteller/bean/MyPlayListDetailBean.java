package cn.intersteller.darkintersteller.bean;

import java.util.List;

public class MyPlayListDetailBean {

    /*
     *这个bean是通过
     * httpUtil.getHttpUtilInstance().sendOkHttpRequest(Constant.NETEASE_MYPLAYLIST_DETAIL + playlistid, new Callback() {}

     */
    /**
     * code : 200
     * relatedVideos : null
     * playlist : {"subscribers":[],"subscribed":false,"creator":{"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MpL69azafwespE5rEDduMQ==/109951163714288219.jpg","accountStatus":0,"gender":1,"city":1010000,"birthday":690134400000,"userId":1188120,"userType":0,"nickname":"razrday","signature":"安静的程序员","description":"","detailDescription":"","avatarImgId":109951163714288220,"backgroundImgId":109951163715930580,"backgroundUrl":"http://p1.music.126.net/6DMX4zA5KiOo0ogiy2FW_Q==/109951163715930569.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163714288219","backgroundImgIdStr":"109951163715930569","avatarImgId_str":"109951163714288219"},"tracks":[{"name":"The Cello Song","id":1992696,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":12,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":196000,"h":{"br":320000,"fid":0,"size":7867237,"vd":-2},"m":{"br":192000,"fid":0,"size":4720423,"vd":-2},"l":{"br":128000,"fid":0,"size":3147015,"vd":-2},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323076,"publishTime":1327939200007},{"name":"Michael Meets Mozart - 1 Piano, 2 Guys, 100 Cello Tracks","id":1491163,"pst":0,"t":0,"ar":[{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":53,"crbt":null,"cf":"","al":{"id":152099,"name":"Michael Meets Mozart - 1 Piano, 2 Guys, 100 Cello Tracks","picUrl":"http://p1.music.126.net/up91ipndPwLz_ZQElBDxAA==/1748223488163882.jpg","tns":[],"pic":1748223488163882},"dt":316000,"h":{"br":320000,"fid":0,"size":12664225,"vd":-2},"m":{"br":192000,"fid":0,"size":7598560,"vd":-2},"l":{"br":128000,"fid":0,"size":5065727,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":392423,"publishTime":1305820800007},{"name":"Michael Meets Mozart","id":1992693,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":316000,"h":{"br":320000,"fid":0,"size":12664370,"vd":-2},"m":{"br":192000,"fid":0,"size":7598705,"vd":-2},"l":{"br":128000,"fid":0,"size":5065872,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":392423,"publishTime":1327939200007},{"name":"Without You - Piano/Cello Cover","id":1491007,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":0,"v":11,"crbt":null,"cf":"","al":{"id":152078,"name":"Without You - Piano/cello Cover","picUrl":"http://p1.music.126.net/F3eCyYNE9r-MaWO4j-kbwA==/1749322999791636.jpg","tns":[],"pic":1749322999791636},"dt":218000,"h":{"br":320000,"fid":0,"size":8747053,"vd":-1800},"m":{"br":192000,"fid":0,"size":5248316,"vd":361},"l":{"br":128000,"fid":0,"size":3498948,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322064,"publishTime":1320595200007},{"name":"Twinkle Lullaby","id":1992707,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":111000,"h":{"br":320000,"fid":0,"size":4452512,"vd":4845},"m":{"br":192000,"fid":0,"size":2671588,"vd":7114},"l":{"br":128000,"fid":0,"size":1781126,"vd":9119},"a":null,"cd":"1","no":13,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323083,"publishTime":1327939200007},{"name":"More Than Words","id":1992705,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":80,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":236000,"h":{"br":320000,"fid":0,"size":9451304,"vd":2364},"m":{"br":192000,"fid":0,"size":5670863,"vd":4064},"l":{"br":128000,"fid":0,"size":3780642,"vd":1346},"a":null,"cd":"1","no":12,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322067,"publishTime":1327939200000},{"name":"Lead, Kindly Light","id":1992751,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":147000,"h":{"br":320000,"fid":0,"size":5896574,"vd":-28100},"m":{"br":192000,"fid":0,"size":3538030,"vd":-25400},"l":{"br":128000,"fid":0,"size":2358758,"vd":-23400},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Homeward Bound","id":1992785,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":520000,"h":{"br":320000,"fid":0,"size":20830252,"vd":-17000},"m":{"br":192000,"fid":0,"size":12498235,"vd":-14299},"l":{"br":128000,"fid":0,"size":8332227,"vd":-12700},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"All Of Me","id":1992703,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":70,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":182000,"h":{"br":320000,"fid":0,"size":7314481,"vd":-20400},"m":{"br":192000,"fid":0,"size":4388767,"vd":-17800},"l":{"br":128000,"fid":0,"size":2925910,"vd":-16000},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322060,"publishTime":1327939200007},{"name":"Without You","id":1992695,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":218000,"h":{"br":320000,"fid":0,"size":8747039,"vd":-1800},"m":{"br":192000,"fid":0,"size":5248302,"vd":361},"l":{"br":128000,"fid":0,"size":3498934,"vd":-2},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322064,"publishTime":1327939200007},{"name":"Celloopa","id":437827057,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":166680,"h":{"br":320000,"fid":0,"size":6669627,"vd":-7900},"m":{"br":192000,"fid":0,"size":4001794,"vd":-5100},"l":{"br":128000,"fid":0,"size":2667877,"vd":-3700},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"Limitless","id":1322369834,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":270994,"h":{"br":320000,"fid":0,"size":10839815,"vd":0},"m":{"br":192000,"fid":0,"size":6503906,"vd":0},"l":{"br":128000,"fid":0,"size":4335952,"vd":0},"a":null,"cd":"01","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"The cello song","id":1992718,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":9,"crbt":null,"cf":"","al":{"id":200918,"name":"The Cello Song","picUrl":"http://p1.music.126.net/t90WqDXQtRytvu4u2QW9RQ==/1788905418392957.jpg","tns":[],"pic":1788905418392957},"dt":196000,"h":{"br":320000,"fid":0,"size":7867258,"vd":-2},"m":{"br":192000,"fid":0,"size":4720444,"vd":140},"l":{"br":128000,"fid":0,"size":3147036,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323076,"publishTime":1305475200007},{"name":"O My Father (James McGranahan)","id":1992833,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":55,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":247000,"h":{"br":320000,"fid":0,"size":9911023,"vd":23069},"m":{"br":192000,"fid":0,"size":5946680,"vd":26202},"l":{"br":128000,"fid":0,"size":3964508,"vd":27356},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Clair de Lune (Claude Debussy)","id":1992804,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":0,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":492000,"h":{"br":320000,"fid":0,"size":19704853,"vd":3273},"m":{"br":192000,"fid":0,"size":11822979,"vd":6272},"l":{"br":128000,"fid":0,"size":7882042,"vd":8360},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Moonlight","id":1992713,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":0,"v":9,"crbt":null,"cf":"","al":{"id":200917,"name":"Moonlight","picUrl":"http://p1.music.126.net/U7feDF075rl9fEll6D8d5g==/1695446930032043.jpg","tns":[],"pic":1695446930032043},"dt":206000,"h":{"br":320000,"fid":0,"size":8269498,"vd":-2},"m":{"br":192000,"fid":0,"size":4961769,"vd":-2},"l":{"br":128000,"fid":0,"size":3307905,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":5323073,"publishTime":1310313600007},{"name":"Rolling In The Deep","id":1992697,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":8,"v":8,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":232000,"h":{"br":320000,"fid":0,"size":9297708,"vd":-2},"m":{"br":192000,"fid":0,"size":5578707,"vd":852},"l":{"br":128000,"fid":0,"size":3719206,"vd":0},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1327939200007},{"name":"North Cape","id":1322369837,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":35,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":179670,"h":{"br":320000,"fid":0,"size":7187897,"vd":0},"m":{"br":192000,"fid":0,"size":4312755,"vd":0},"l":{"br":128000,"fid":0,"size":2875185,"vd":0},"a":null,"cd":"01","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"Okay","id":437827055,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":11,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":210560,"h":{"br":320000,"fid":0,"size":8425056,"vd":-25900},"m":{"br":192000,"fid":0,"size":5055051,"vd":-23400},"l":{"br":128000,"fid":0,"size":3370048,"vd":-21600},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"The Jungle Book / Sarabande","id":437827058,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":31146982,"name":"Fernando S. Gallegos","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":11,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":222120,"h":{"br":320000,"fid":0,"size":8887946,"vd":-24800},"m":{"br":192000,"fid":0,"size":5332785,"vd":-22200},"l":{"br":128000,"fid":0,"size":3555204,"vd":-20600},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5443372,"publishTime":1477584000007},{"name":"Thanks Be to Thee","id":1992774,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":214000,"h":{"br":320000,"fid":0,"size":8591365,"vd":-6800},"m":{"br":192000,"fid":0,"size":5154904,"vd":-4200},"l":{"br":128000,"fid":0,"size":3436674,"vd":-2500},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"The Water Is Wide (American Traditional)","id":1992808,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":201000,"h":{"br":320000,"fid":0,"size":8069919,"vd":15819},"m":{"br":192000,"fid":0,"size":4842020,"vd":17846},"l":{"br":128000,"fid":0,"size":3228070,"vd":19238},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Holding On","id":437827059,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":206560,"h":{"br":320000,"fid":0,"size":8265187,"vd":-18600},"m":{"br":192000,"fid":0,"size":4959129,"vd":-16000},"l":{"br":128000,"fid":0,"size":3306101,"vd":-14200},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":131072,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"O Fortuna (Carmina Burana)","id":1992699,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":200000,"h":{"br":320000,"fid":0,"size":8010400,"vd":-10800},"m":{"br":192000,"fid":0,"size":4806325,"vd":-8200},"l":{"br":128000,"fid":0,"size":3204288,"vd":-6700},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1327939200007},{"name":"New World","id":1992780,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":394000,"h":{"br":320000,"fid":0,"size":15762491,"vd":-17700},"m":{"br":192000,"fid":0,"size":9457577,"vd":-15000},"l":{"br":128000,"fid":0,"size":6305120,"vd":-13300},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"Uncharted","id":437827062,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":212133,"h":{"br":320000,"fid":0,"size":8487750,"vd":-7500},"m":{"br":192000,"fid":0,"size":5092667,"vd":-5000},"l":{"br":128000,"fid":0,"size":3395126,"vd":-3300},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"Bring Him Home (Les Miserables)","id":1992700,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":255000,"h":{"br":320000,"fid":0,"size":10234993,"vd":2481},"m":{"br":192000,"fid":0,"size":6141083,"vd":5507},"l":{"br":128000,"fid":0,"size":4094128,"vd":5354},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":754011,"mv":5323062,"publishTime":1327939200007},{"name":"Gabriel's Oboe","id":1992758,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":147000,"h":{"br":320000,"fid":0,"size":5899705,"vd":-24400},"m":{"br":192000,"fid":0,"size":3539907,"vd":-21700},"l":{"br":128000,"fid":0,"size":2360008,"vd":-19900},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"Unaccompanied Cello Suite No. 1 in G major, Prelude (Johann Sebastian Bach)","id":1992798,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":13,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":163000,"h":{"br":320000,"fid":0,"size":6537088,"vd":20948},"m":{"br":192000,"fid":0,"size":3922336,"vd":23253},"l":{"br":128000,"fid":0,"size":2614959,"vd":24256},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Berlin","id":405477010,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":null,"fee":8,"v":6,"crbt":null,"cf":"","al":{"id":34535727,"name":"Berlin","picUrl":"http://p1.music.126.net/MsKzIMr79RYy9szpDbjssg==/109951163437843124.jpg","tns":[],"pic_str":"109951163437843124","pic":109951163437843120},"dt":240613,"h":{"br":320000,"fid":0,"size":9625644,"vd":-16700},"m":{"br":192000,"fid":0,"size":5775404,"vd":-14000},"l":{"br":128000,"fid":0,"size":3850284,"vd":-12200},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":401408,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1367769600007},{"name":"Come, Come Ye Saints","id":1992755,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":348000,"h":{"br":320000,"fid":0,"size":13947515,"vd":-13900},"m":{"br":192000,"fid":0,"size":8368595,"vd":-11100},"l":{"br":128000,"fid":0,"size":5579136,"vd":-9700},"a":null,"cd":"1","no":2,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Winter Wind","id":1992742,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":8,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":264000,"h":{"br":320000,"fid":0,"size":10582769,"vd":-9000},"m":{"br":192000,"fid":0,"size":6349679,"vd":-6400},"l":{"br":128000,"fid":0,"size":4233133,"vd":-4900},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1286812800007},{"name":"Tender Mercies","id":1992766,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":420000,"h":{"br":320000,"fid":0,"size":16829337,"vd":-30300},"m":{"br":192000,"fid":0,"size":10097687,"vd":-27700},"l":{"br":128000,"fid":0,"size":6731861,"vd":-25900},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Cello Wars (Radio Edit)","id":1992698,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":7,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":189000,"h":{"br":320000,"fid":0,"size":7575720,"vd":-19300},"m":{"br":192000,"fid":0,"size":4545516,"vd":-16800},"l":{"br":128000,"fid":0,"size":3030414,"vd":-15000},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":5322062,"publishTime":1327939200007},{"name":"Simple Gifts","id":1992762,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":12,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":239000,"h":{"br":320000,"fid":0,"size":9588192,"vd":-15900},"m":{"br":192000,"fid":0,"size":5752999,"vd":-13300},"l":{"br":128000,"fid":0,"size":3835402,"vd":-11500},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"The Manger","id":515223894,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":null,"fee":8,"v":7,"crbt":null,"cf":"","al":{"id":36515776,"name":"Christmas Together","picUrl":"http://p1.music.126.net/BalbBVABjjQjX5WlaFbxSQ==/18422317323651038.jpg","tns":[],"pic_str":"18422317323651038","pic":18422317323651040},"dt":240404,"h":{"br":320000,"fid":0,"size":9617285,"vd":2277},"m":{"br":192000,"fid":0,"size":5770388,"vd":4387},"l":{"br":128000,"fid":0,"size":3846940,"vd":6159},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1509033600007},{"name":"Miracles","id":1322373224,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303563,"name":"Marshall McDonald","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":373995,"h":{"br":320000,"fid":0,"size":14959848,"vd":0},"m":{"br":192000,"fid":0,"size":8975926,"vd":0},"l":{"br":128000,"fid":0,"size":5983965,"vd":0},"a":null,"cd":"01","no":13,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"Charlie Brown Medley","id":1992701,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":"","fee":8,"v":9,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":181000,"h":{"br":320000,"fid":0,"size":7248664,"vd":571},"m":{"br":192000,"fid":0,"size":4349281,"vd":2032},"l":{"br":128000,"fid":0,"size":2899589,"vd":0},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322063,"publishTime":1327939200007},{"name":"Rock Meets Rachmaninoff","id":1992702,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":8,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":199000,"h":{"br":320000,"fid":0,"size":7989499,"vd":-2},"m":{"br":192000,"fid":0,"size":4793783,"vd":0},"l":{"br":128000,"fid":0,"size":3195925,"vd":411},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":5322070,"publishTime":1327939200007},{"name":"Gloria / Hark! The Herald Angels Sing","id":515223889,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":null,"fee":8,"v":7,"crbt":null,"cf":"","al":{"id":36515776,"name":"Christmas Together","picUrl":"http://p1.music.126.net/BalbBVABjjQjX5WlaFbxSQ==/18422317323651038.jpg","tns":[],"pic_str":"18422317323651038","pic":18422317323651040},"dt":233952,"h":{"br":320000,"fid":0,"size":9358150,"vd":-12600},"m":{"br":192000,"fid":0,"size":5614907,"vd":-10000},"l":{"br":128000,"fid":0,"size":3743286,"vd":-8300},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1509033600007},{"name":"Be Still My Soul (Jean Sibelius)","id":1992812,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":163000,"h":{"br":320000,"fid":0,"size":6545412,"vd":21612},"m":{"br":192000,"fid":0,"size":3927315,"vd":24463},"l":{"br":128000,"fid":0,"size":2618267,"vd":26709},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Chorale O, Savior Thou Who Wearest a Crown (Johann Sebastian Bach)","id":1992820,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":148000,"h":{"br":320000,"fid":0,"size":5961342,"vd":7108},"m":{"br":192000,"fid":0,"size":3576884,"vd":9482},"l":{"br":128000,"fid":0,"size":2384656,"vd":9921},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Praise to the Man","id":1992788,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":375000,"h":{"br":320000,"fid":0,"size":15019577,"vd":-23400},"m":{"br":192000,"fid":0,"size":9011832,"vd":-20800},"l":{"br":128000,"fid":0,"size":6007959,"vd":-19100},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"God Be with You Till We Meet Again (William Tomer)","id":1992841,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":269000,"h":{"br":320000,"fid":0,"size":10799209,"vd":31363},"m":{"br":192000,"fid":0,"size":6479601,"vd":33953},"l":{"br":128000,"fid":0,"size":4319797,"vd":36397},"a":null,"cd":"1","no":12,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Carol of the Bells / God Rest Ye Merry Gentlemen","id":1331912994,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":8,"v":3,"crbt":null,"cf":"","al":{"id":74813093,"name":"Silent Night - A Classical Christmas","picUrl":"http://p1.music.126.net/oX8fcIVI_j9cmQdQoc8hrg==/109951163711969430.jpg","tns":[],"pic_str":"109951163711969430","pic":109951163711969420},"dt":201038,"h":{"br":320000,"fid":0,"size":8041578,"vd":-2},"m":{"br":192000,"fid":0,"size":4824964,"vd":-2},"l":{"br":128000,"fid":0,"size":3216657,"vd":-1},"a":null,"cd":"01","no":15,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":401408,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1544112000000},{"name":"Come Come Ye Saints (feat. Steven Sharp Nelson)","id":1383196600,"pst":0,"t":0,"ar":[{"id":31698175,"name":"Camille Nelson","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":8,"v":3,"crbt":null,"cf":"","al":{"id":80868897,"name":"Lead Me Home","picUrl":"http://p1.music.126.net/6taMLhUprV5zOAWLKDth3g==/109951164279226072.jpg","tns":[],"pic_str":"109951164279226072","pic":109951164279226080},"dt":256640,"h":{"br":320000,"fid":0,"size":10268256,"vd":-26572},"m":{"br":192000,"fid":0,"size":6160971,"vd":-23940},"l":{"br":128000,"fid":0,"size":4107328,"vd":-22148},"a":null,"cd":"01","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270464,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":743010,"mv":0,"publishTime":1502985600000},{"name":"Away In a Manger","id":1992726,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":6,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":193000,"h":{"br":320000,"fid":0,"size":7742737,"vd":50119},"m":{"br":192000,"fid":0,"size":4645659,"vd":52759},"l":{"br":128000,"fid":0,"size":3097120,"vd":53984},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":131072,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1286812800007},{"name":"Still, Still, Still","id":1992727,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":317000,"h":{"br":320000,"fid":0,"size":12687194,"vd":-4700},"m":{"br":192000,"fid":0,"size":7612333,"vd":-2200},"l":{"br":128000,"fid":0,"size":5074903,"vd":-500},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007},{"name":"We Three Kings","id":1992736,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":247000,"h":{"br":320000,"fid":0,"size":9882688,"vd":17600},"m":{"br":192000,"fid":0,"size":5929630,"vd":20300},"l":{"br":128000,"fid":0,"size":3953101,"vd":22100},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007},{"name":"Lo, How a Rose E'er Blooming","id":1992739,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":275000,"h":{"br":320000,"fid":0,"size":11041479,"vd":-5700},"m":{"br":192000,"fid":0,"size":6624905,"vd":-3100},"l":{"br":128000,"fid":0,"size":4416617,"vd":-1500},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007}],"trackIds":[{"id":1992696,"v":12,"alg":null},{"id":1491163,"v":53,"alg":null},{"id":1992693,"v":11,"alg":null},{"id":1491007,"v":11,"alg":null},{"id":1992707,"v":10,"alg":null},{"id":1992705,"v":11,"alg":null},{"id":1992751,"v":5,"alg":null},{"id":1992785,"v":6,"alg":null},{"id":1992703,"v":10,"alg":null},{"id":1992695,"v":11,"alg":null},{"id":437827057,"v":8,"alg":null},{"id":1322369834,"v":6,"alg":null},{"id":1992718,"v":9,"alg":null},{"id":1992833,"v":4,"alg":null},{"id":1992804,"v":6,"alg":null},{"id":1992713,"v":9,"alg":null},{"id":1992697,"v":8,"alg":null},{"id":1322369837,"v":6,"alg":null},{"id":437827055,"v":11,"alg":null},{"id":437827058,"v":11,"alg":null},{"id":1992774,"v":6,"alg":null},{"id":1992808,"v":6,"alg":null},{"id":437827059,"v":8,"alg":null},{"id":1992699,"v":5,"alg":null},{"id":1992780,"v":6,"alg":null},{"id":437827062,"v":8,"alg":null},{"id":1992700,"v":10,"alg":null},{"id":1992758,"v":11,"alg":null},{"id":1992798,"v":13,"alg":null},{"id":405477010,"v":6,"alg":null},{"id":1992755,"v":4,"alg":null},{"id":1992742,"v":8,"alg":null},{"id":1992766,"v":4,"alg":null},{"id":1992698,"v":7,"alg":null},{"id":1992762,"v":12,"alg":null},{"id":515223894,"v":7,"alg":null},{"id":1322373224,"v":6,"alg":null},{"id":1992701,"v":9,"alg":null},{"id":1992702,"v":8,"alg":null},{"id":515223889,"v":7,"alg":null},{"id":1992812,"v":4,"alg":null},{"id":1992820,"v":5,"alg":null},{"id":1992788,"v":4,"alg":null},{"id":1992841,"v":6,"alg":null},{"id":1331912994,"v":3,"alg":null},{"id":1383196600,"v":3,"alg":null},{"id":1992726,"v":6,"alg":null},{"id":1992727,"v":4,"alg":null},{"id":1992736,"v":4,"alg":null},{"id":1992739,"v":5,"alg":null}],"updateFrequency":null,"backgroundCoverId":0,"backgroundCoverUrl":null,"titleImage":0,"titleImageUrl":null,"englishTitle":null,"opRecommend":false,"description":null,"status":0,"trackUpdateTime":1588319690841,"coverImgUrl":"http://p2.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","updateTime":1587005967154,"ordered":false,"trackCount":50,"commentThreadId":"A_PL_0_4971080683","privacy":0,"specialType":0,"userId":1188120,"newImported":false,"coverImgId":1709740581192562,"createTime":1587005966973,"highQuality":false,"trackNumberUpdateTime":1587005967154,"playCount":2,"adType":0,"tags":[],"subscribedCount":0,"cloudTrackCount":0,"name":"Steven Sharp Nelson","id":4971080683,"shareCount":0,"commentCount":0}
     * urls : null
     * privileges : [{"id":1992696,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1491163,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992693,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1491007,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992707,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992705,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992751,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992785,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992703,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992695,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":437827057,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1322369834,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992718,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992833,"fee":0,"payed":0,"st":0,"pl":320000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992804,"fee":0,"payed":0,"st":0,"pl":320000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992713,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992697,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1322369837,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":437827055,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":437827058,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992774,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992808,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":437827059,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992699,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992780,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":437827062,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992700,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992758,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992798,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":405477010,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992755,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992742,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992766,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992698,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992762,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":515223894,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1322373224,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992701,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992702,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":515223889,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992812,"fee":0,"payed":0,"st":0,"pl":320000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992820,"fee":0,"payed":0,"st":0,"pl":320000,"dl":999000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992788,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992841,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":256,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1331912994,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":128000,"toast":false,"flag":4,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1383196600,"fee":8,"payed":0,"st":0,"pl":128000,"dl":0,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":999000,"fl":128000,"toast":false,"flag":5,"preSell":false,"playMaxbr":999000,"downloadMaxbr":999000},{"id":1992726,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":0,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992727,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992736,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000},{"id":1992739,"fee":0,"payed":0,"st":0,"pl":320000,"dl":320000,"sp":7,"cp":1,"subp":1,"cs":false,"maxbr":320000,"fl":320000,"toast":false,"flag":128,"preSell":false,"playMaxbr":320000,"downloadMaxbr":320000}]
     */

    private int code;
    private Object relatedVideos;
    private PlaylistBean playlist;
    private Object urls;
    private List<PrivilegesBean> privileges;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getRelatedVideos() {
        return relatedVideos;
    }

    public void setRelatedVideos(Object relatedVideos) {
        this.relatedVideos = relatedVideos;
    }

    public PlaylistBean getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlaylistBean playlist) {
        this.playlist = playlist;
    }

    public Object getUrls() {
        return urls;
    }

    public void setUrls(Object urls) {
        this.urls = urls;
    }

    public List<PrivilegesBean> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<PrivilegesBean> privileges) {
        this.privileges = privileges;
    }

    public static class PlaylistBean {
        /**
         * subscribers : []
         * subscribed : false
         * creator : {"defaultAvatar":false,"province":1000000,"authStatus":0,"followed":false,"avatarUrl":"http://p1.music.126.net/MpL69azafwespE5rEDduMQ==/109951163714288219.jpg","accountStatus":0,"gender":1,"city":1010000,"birthday":690134400000,"userId":1188120,"userType":0,"nickname":"razrday","signature":"安静的程序员","description":"","detailDescription":"","avatarImgId":109951163714288220,"backgroundImgId":109951163715930580,"backgroundUrl":"http://p1.music.126.net/6DMX4zA5KiOo0ogiy2FW_Q==/109951163715930569.jpg","authority":0,"mutual":false,"expertTags":null,"experts":null,"djStatus":0,"vipType":0,"remarkName":null,"avatarImgIdStr":"109951163714288219","backgroundImgIdStr":"109951163715930569","avatarImgId_str":"109951163714288219"}
         * tracks : [{"name":"The Cello Song","id":1992696,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":8,"v":12,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":196000,"h":{"br":320000,"fid":0,"size":7867237,"vd":-2},"m":{"br":192000,"fid":0,"size":4720423,"vd":-2},"l":{"br":128000,"fid":0,"size":3147015,"vd":-2},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323076,"publishTime":1327939200007},{"name":"Michael Meets Mozart - 1 Piano, 2 Guys, 100 Cello Tracks","id":1491163,"pst":0,"t":0,"ar":[{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":100,"st":0,"rt":"","fee":0,"v":53,"crbt":null,"cf":"","al":{"id":152099,"name":"Michael Meets Mozart - 1 Piano, 2 Guys, 100 Cello Tracks","picUrl":"http://p1.music.126.net/up91ipndPwLz_ZQElBDxAA==/1748223488163882.jpg","tns":[],"pic":1748223488163882},"dt":316000,"h":{"br":320000,"fid":0,"size":12664225,"vd":-2},"m":{"br":192000,"fid":0,"size":7598560,"vd":-2},"l":{"br":128000,"fid":0,"size":5065727,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":392423,"publishTime":1305820800007},{"name":"Michael Meets Mozart","id":1992693,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":316000,"h":{"br":320000,"fid":0,"size":12664370,"vd":-2},"m":{"br":192000,"fid":0,"size":7598705,"vd":-2},"l":{"br":128000,"fid":0,"size":5065872,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":392423,"publishTime":1327939200007},{"name":"Without You - Piano/Cello Cover","id":1491007,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":0,"v":11,"crbt":null,"cf":"","al":{"id":152078,"name":"Without You - Piano/cello Cover","picUrl":"http://p1.music.126.net/F3eCyYNE9r-MaWO4j-kbwA==/1749322999791636.jpg","tns":[],"pic":1749322999791636},"dt":218000,"h":{"br":320000,"fid":0,"size":8747053,"vd":-1800},"m":{"br":192000,"fid":0,"size":5248316,"vd":361},"l":{"br":128000,"fid":0,"size":3498948,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322064,"publishTime":1320595200007},{"name":"Twinkle Lullaby","id":1992707,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":90,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":111000,"h":{"br":320000,"fid":0,"size":4452512,"vd":4845},"m":{"br":192000,"fid":0,"size":2671588,"vd":7114},"l":{"br":128000,"fid":0,"size":1781126,"vd":9119},"a":null,"cd":"1","no":13,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323083,"publishTime":1327939200007},{"name":"More Than Words","id":1992705,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":80,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":236000,"h":{"br":320000,"fid":0,"size":9451304,"vd":2364},"m":{"br":192000,"fid":0,"size":5670863,"vd":4064},"l":{"br":128000,"fid":0,"size":3780642,"vd":1346},"a":null,"cd":"1","no":12,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322067,"publishTime":1327939200000},{"name":"Lead, Kindly Light","id":1992751,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":147000,"h":{"br":320000,"fid":0,"size":5896574,"vd":-28100},"m":{"br":192000,"fid":0,"size":3538030,"vd":-25400},"l":{"br":128000,"fid":0,"size":2358758,"vd":-23400},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Homeward Bound","id":1992785,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":75,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":520000,"h":{"br":320000,"fid":0,"size":20830252,"vd":-17000},"m":{"br":192000,"fid":0,"size":12498235,"vd":-14299},"l":{"br":128000,"fid":0,"size":8332227,"vd":-12700},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"All Of Me","id":1992703,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":70,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":182000,"h":{"br":320000,"fid":0,"size":7314481,"vd":-20400},"m":{"br":192000,"fid":0,"size":4388767,"vd":-17800},"l":{"br":128000,"fid":0,"size":2925910,"vd":-16000},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322060,"publishTime":1327939200007},{"name":"Without You","id":1992695,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":218000,"h":{"br":320000,"fid":0,"size":8747039,"vd":-1800},"m":{"br":192000,"fid":0,"size":5248302,"vd":361},"l":{"br":128000,"fid":0,"size":3498934,"vd":-2},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322064,"publishTime":1327939200007},{"name":"Celloopa","id":437827057,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":166680,"h":{"br":320000,"fid":0,"size":6669627,"vd":-7900},"m":{"br":192000,"fid":0,"size":4001794,"vd":-5100},"l":{"br":128000,"fid":0,"size":2667877,"vd":-3700},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"Limitless","id":1322369834,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":270994,"h":{"br":320000,"fid":0,"size":10839815,"vd":0},"m":{"br":192000,"fid":0,"size":6503906,"vd":0},"l":{"br":128000,"fid":0,"size":4335952,"vd":0},"a":null,"cd":"01","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"The cello song","id":1992718,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":65,"st":0,"rt":"","fee":8,"v":9,"crbt":null,"cf":"","al":{"id":200918,"name":"The Cello Song","picUrl":"http://p1.music.126.net/t90WqDXQtRytvu4u2QW9RQ==/1788905418392957.jpg","tns":[],"pic":1788905418392957},"dt":196000,"h":{"br":320000,"fid":0,"size":7867258,"vd":-2},"m":{"br":192000,"fid":0,"size":4720444,"vd":140},"l":{"br":128000,"fid":0,"size":3147036,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5323076,"publishTime":1305475200007},{"name":"O My Father (James McGranahan)","id":1992833,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":55,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":247000,"h":{"br":320000,"fid":0,"size":9911023,"vd":23069},"m":{"br":192000,"fid":0,"size":5946680,"vd":26202},"l":{"br":128000,"fid":0,"size":3964508,"vd":27356},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Clair de Lune (Claude Debussy)","id":1992804,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":0,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":492000,"h":{"br":320000,"fid":0,"size":19704853,"vd":3273},"m":{"br":192000,"fid":0,"size":11822979,"vd":6272},"l":{"br":128000,"fid":0,"size":7882042,"vd":8360},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Moonlight","id":1992713,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":0,"v":9,"crbt":null,"cf":"","al":{"id":200917,"name":"Moonlight","picUrl":"http://p1.music.126.net/U7feDF075rl9fEll6D8d5g==/1695446930032043.jpg","tns":[],"pic":1695446930032043},"dt":206000,"h":{"br":320000,"fid":0,"size":8269498,"vd":-2},"m":{"br":192000,"fid":0,"size":4961769,"vd":-2},"l":{"br":128000,"fid":0,"size":3307905,"vd":-2},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":5323073,"publishTime":1310313600007},{"name":"Rolling In The Deep","id":1992697,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":50,"st":0,"rt":"","fee":8,"v":8,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":232000,"h":{"br":320000,"fid":0,"size":9297708,"vd":-2},"m":{"br":192000,"fid":0,"size":5578707,"vd":852},"l":{"br":128000,"fid":0,"size":3719206,"vd":0},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1327939200007},{"name":"North Cape","id":1322369837,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":35,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":179670,"h":{"br":320000,"fid":0,"size":7187897,"vd":0},"m":{"br":192000,"fid":0,"size":4312755,"vd":0},"l":{"br":128000,"fid":0,"size":2875185,"vd":0},"a":null,"cd":"01","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"Okay","id":437827055,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":11,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":210560,"h":{"br":320000,"fid":0,"size":8425056,"vd":-25900},"m":{"br":192000,"fid":0,"size":5055051,"vd":-23400},"l":{"br":128000,"fid":0,"size":3370048,"vd":-21600},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"The Jungle Book / Sarabande","id":437827058,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":31146982,"name":"Fernando S. Gallegos","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":11,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":222120,"h":{"br":320000,"fid":0,"size":8887946,"vd":-24800},"m":{"br":192000,"fid":0,"size":5332785,"vd":-22200},"l":{"br":128000,"fid":0,"size":3555204,"vd":-20600},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5443372,"publishTime":1477584000007},{"name":"Thanks Be to Thee","id":1992774,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":214000,"h":{"br":320000,"fid":0,"size":8591365,"vd":-6800},"m":{"br":192000,"fid":0,"size":5154904,"vd":-4200},"l":{"br":128000,"fid":0,"size":3436674,"vd":-2500},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"The Water Is Wide (American Traditional)","id":1992808,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":201000,"h":{"br":320000,"fid":0,"size":8069919,"vd":15819},"m":{"br":192000,"fid":0,"size":4842020,"vd":17846},"l":{"br":128000,"fid":0,"size":3228070,"vd":19238},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Holding On","id":437827059,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":206560,"h":{"br":320000,"fid":0,"size":8265187,"vd":-18600},"m":{"br":192000,"fid":0,"size":4959129,"vd":-16000},"l":{"br":128000,"fid":0,"size":3306101,"vd":-14200},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":131072,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"O Fortuna (Carmina Burana)","id":1992699,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":200000,"h":{"br":320000,"fid":0,"size":8010400,"vd":-10800},"m":{"br":192000,"fid":0,"size":4806325,"vd":-8200},"l":{"br":128000,"fid":0,"size":3204288,"vd":-6700},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1327939200007},{"name":"New World","id":1992780,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":394000,"h":{"br":320000,"fid":0,"size":15762491,"vd":-17700},"m":{"br":192000,"fid":0,"size":9457577,"vd":-15000},"l":{"br":128000,"fid":0,"size":6305120,"vd":-13300},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"Uncharted","id":437827062,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":null,"fee":8,"v":8,"crbt":null,"cf":"","al":{"id":34928494,"name":"Uncharted","picUrl":"http://p1.music.126.net/sZBwnCP7G0CszagKtfhdCA==/18747772766054527.jpg","tns":[],"pic_str":"18747772766054527","pic":18747772766054530},"dt":212133,"h":{"br":320000,"fid":0,"size":8487750,"vd":-7500},"m":{"br":192000,"fid":0,"size":5092667,"vd":-5000},"l":{"br":128000,"fid":0,"size":3395126,"vd":-3300},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1477584000007},{"name":"Bring Him Home (Les Miserables)","id":1992700,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":10,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":255000,"h":{"br":320000,"fid":0,"size":10234993,"vd":2481},"m":{"br":192000,"fid":0,"size":6141083,"vd":5507},"l":{"br":128000,"fid":0,"size":4094128,"vd":5354},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":754011,"mv":5323062,"publishTime":1327939200007},{"name":"Gabriel's Oboe","id":1992758,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":11,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":147000,"h":{"br":320000,"fid":0,"size":5899705,"vd":-24400},"m":{"br":192000,"fid":0,"size":3539907,"vd":-21700},"l":{"br":128000,"fid":0,"size":2360008,"vd":-19900},"a":null,"cd":"1","no":3,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"Unaccompanied Cello Suite No. 1 in G major, Prelude (Johann Sebastian Bach)","id":1992798,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":25,"st":0,"rt":"","fee":8,"v":13,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":163000,"h":{"br":320000,"fid":0,"size":6537088,"vd":20948},"m":{"br":192000,"fid":0,"size":3922336,"vd":23253},"l":{"br":128000,"fid":0,"size":2614959,"vd":24256},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Berlin","id":405477010,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":null,"fee":8,"v":6,"crbt":null,"cf":"","al":{"id":34535727,"name":"Berlin","picUrl":"http://p1.music.126.net/MsKzIMr79RYy9szpDbjssg==/109951163437843124.jpg","tns":[],"pic_str":"109951163437843124","pic":109951163437843120},"dt":240613,"h":{"br":320000,"fid":0,"size":9625644,"vd":-16700},"m":{"br":192000,"fid":0,"size":5775404,"vd":-14000},"l":{"br":128000,"fid":0,"size":3850284,"vd":-12200},"a":null,"cd":"1","no":1,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":401408,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1367769600007},{"name":"Come, Come Ye Saints","id":1992755,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":348000,"h":{"br":320000,"fid":0,"size":13947515,"vd":-13900},"m":{"br":192000,"fid":0,"size":8368595,"vd":-11100},"l":{"br":128000,"fid":0,"size":5579136,"vd":-9700},"a":null,"cd":"1","no":2,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Winter Wind","id":1992742,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":8,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":264000,"h":{"br":320000,"fid":0,"size":10582769,"vd":-9000},"m":{"br":192000,"fid":0,"size":6349679,"vd":-6400},"l":{"br":128000,"fid":0,"size":4233133,"vd":-4900},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1286812800007},{"name":"Tender Mercies","id":1992766,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":420000,"h":{"br":320000,"fid":0,"size":16829337,"vd":-30300},"m":{"br":192000,"fid":0,"size":10097687,"vd":-27700},"l":{"br":128000,"fid":0,"size":6731861,"vd":-25900},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"Cello Wars (Radio Edit)","id":1992698,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":7,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":189000,"h":{"br":320000,"fid":0,"size":7575720,"vd":-19300},"m":{"br":192000,"fid":0,"size":4545516,"vd":-16800},"l":{"br":128000,"fid":0,"size":3030414,"vd":-15000},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":5322062,"publishTime":1327939200007},{"name":"Simple Gifts","id":1992762,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":12,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":239000,"h":{"br":320000,"fid":0,"size":9588192,"vd":-15900},"m":{"br":192000,"fid":0,"size":5752999,"vd":-13300},"l":{"br":128000,"fid":0,"size":3835402,"vd":-11500},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1222358400007},{"name":"The Manger","id":515223894,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]},{"id":35371,"name":"Jon Schmidt","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":null,"fee":8,"v":7,"crbt":null,"cf":"","al":{"id":36515776,"name":"Christmas Together","picUrl":"http://p1.music.126.net/BalbBVABjjQjX5WlaFbxSQ==/18422317323651038.jpg","tns":[],"pic_str":"18422317323651038","pic":18422317323651040},"dt":240404,"h":{"br":320000,"fid":0,"size":9617285,"vd":2277},"m":{"br":192000,"fid":0,"size":5770388,"vd":4387},"l":{"br":128000,"fid":0,"size":3846940,"vd":6159},"a":null,"cd":"1","no":11,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1509033600007},{"name":"Miracles","id":1322373224,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303563,"name":"Marshall McDonald","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":74215660,"name":"Limitless","picUrl":"http://p1.music.126.net/WlvOjiKzJzMORexeqf_POQ==/109951163641826746.jpg","tns":[],"pic_str":"109951163641826746","pic":109951163641826750},"dt":373995,"h":{"br":320000,"fid":0,"size":14959848,"vd":0},"m":{"br":192000,"fid":0,"size":8975926,"vd":0},"l":{"br":128000,"fid":0,"size":5983965,"vd":0},"a":null,"cd":"01","no":13,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270336,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1541692800000},{"name":"Charlie Brown Medley","id":1992701,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":"","fee":8,"v":9,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":181000,"h":{"br":320000,"fid":0,"size":7248664,"vd":571},"m":{"br":192000,"fid":0,"size":4349281,"vd":2032},"l":{"br":128000,"fid":0,"size":2899589,"vd":0},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":5322063,"publishTime":1327939200007},{"name":"Rock Meets Rachmaninoff","id":1992702,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":20,"st":0,"rt":"","fee":0,"v":8,"crbt":null,"cf":"","al":{"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562},"dt":199000,"h":{"br":320000,"fid":0,"size":7989499,"vd":-2},"m":{"br":192000,"fid":0,"size":4793783,"vd":0},"l":{"br":128000,"fid":0,"size":3195925,"vd":411},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":5322070,"publishTime":1327939200007},{"name":"Gloria / Hark! The Herald Angels Sing","id":515223889,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":303576,"name":"Al van der Beek","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":null,"fee":8,"v":7,"crbt":null,"cf":"","al":{"id":36515776,"name":"Christmas Together","picUrl":"http://p1.music.126.net/BalbBVABjjQjX5WlaFbxSQ==/18422317323651038.jpg","tns":[],"pic_str":"18422317323651038","pic":18422317323651040},"dt":233952,"h":{"br":320000,"fid":0,"size":9358150,"vd":-12600},"m":{"br":192000,"fid":0,"size":5614907,"vd":-10000},"l":{"br":128000,"fid":0,"size":3743286,"vd":-8300},"a":null,"cd":"1","no":6,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1509033600007},{"name":"Be Still My Soul (Jean Sibelius)","id":1992812,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":163000,"h":{"br":320000,"fid":0,"size":6545412,"vd":21612},"m":{"br":192000,"fid":0,"size":3927315,"vd":24463},"l":{"br":128000,"fid":0,"size":2618267,"vd":26709},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Chorale O, Savior Thou Who Wearest a Crown (Johann Sebastian Bach)","id":1992820,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":148000,"h":{"br":320000,"fid":0,"size":5961342,"vd":7108},"m":{"br":192000,"fid":0,"size":3576884,"vd":9482},"l":{"br":128000,"fid":0,"size":2384656,"vd":9921},"a":null,"cd":"1","no":7,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1157472000007},{"name":"Praise to the Man","id":1992788,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200925,"name":"Tender Mercies: The Sacred Cello Series","picUrl":"http://p1.music.126.net/8hfh9JaPVeC6JXfJlFqIbQ==/1754820557931903.jpg","tns":[],"pic":1754820557931903},"dt":375000,"h":{"br":320000,"fid":0,"size":15019577,"vd":-23400},"m":{"br":192000,"fid":0,"size":9011832,"vd":-20800},"l":{"br":128000,"fid":0,"size":6007959,"vd":-19100},"a":null,"cd":"1","no":10,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":0,"mv":0,"publishTime":1222358400007},{"name":"God Be with You Till We Meet Again (William Tomer)","id":1992841,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":15,"st":0,"rt":"","fee":8,"v":6,"crbt":null,"cf":"","al":{"id":200928,"name":"Sacred Cello","picUrl":"http://p1.music.126.net/F-ABO9g8JdxSXnQvYlvGRA==/1695446930032057.jpg","tns":[],"pic":1695446930032057},"dt":269000,"h":{"br":320000,"fid":0,"size":10799209,"vd":31363},"m":{"br":192000,"fid":0,"size":6479601,"vd":33953},"l":{"br":128000,"fid":0,"size":4319797,"vd":36397},"a":null,"cd":"1","no":12,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":2,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":655010,"mv":0,"publishTime":1157472000007},{"name":"Carol of the Bells / God Rest Ye Merry Gentlemen","id":1331912994,"pst":0,"t":0,"ar":[{"id":99093,"name":"The Piano Guys","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":8,"v":3,"crbt":null,"cf":"","al":{"id":74813093,"name":"Silent Night - A Classical Christmas","picUrl":"http://p1.music.126.net/oX8fcIVI_j9cmQdQoc8hrg==/109951163711969430.jpg","tns":[],"pic_str":"109951163711969430","pic":109951163711969420},"dt":201038,"h":{"br":320000,"fid":0,"size":8041578,"vd":-2},"m":{"br":192000,"fid":0,"size":4824964,"vd":-2},"l":{"br":128000,"fid":0,"size":3216657,"vd":-1},"a":null,"cd":"01","no":15,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":401408,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1544112000000},{"name":"Come Come Ye Saints (feat. Steven Sharp Nelson)","id":1383196600,"pst":0,"t":0,"ar":[{"id":31698175,"name":"Camille Nelson","tns":[],"alias":[]},{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":8,"v":3,"crbt":null,"cf":"","al":{"id":80868897,"name":"Lead Me Home","picUrl":"http://p1.music.126.net/6taMLhUprV5zOAWLKDth3g==/109951164279226072.jpg","tns":[],"pic_str":"109951164279226072","pic":109951164279226080},"dt":256640,"h":{"br":320000,"fid":0,"size":10268256,"vd":-26572},"m":{"br":192000,"fid":0,"size":6160971,"vd":-23940},"l":{"br":128000,"fid":0,"size":4107328,"vd":-22148},"a":null,"cd":"01","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":270464,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":743010,"mv":0,"publishTime":1502985600000},{"name":"Away In a Manger","id":1992726,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":6,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":193000,"h":{"br":320000,"fid":0,"size":7742737,"vd":50119},"m":{"br":192000,"fid":0,"size":4645659,"vd":52759},"l":{"br":128000,"fid":0,"size":3097120,"vd":53984},"a":null,"cd":"1","no":4,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":131072,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":7001,"mv":0,"publishTime":1286812800007},{"name":"Still, Still, Still","id":1992727,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":317000,"h":{"br":320000,"fid":0,"size":12687194,"vd":-4700},"m":{"br":192000,"fid":0,"size":7612333,"vd":-2200},"l":{"br":128000,"fid":0,"size":5074903,"vd":-500},"a":null,"cd":"1","no":5,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007},{"name":"We Three Kings","id":1992736,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":4,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":247000,"h":{"br":320000,"fid":0,"size":9882688,"vd":17600},"m":{"br":192000,"fid":0,"size":5929630,"vd":20300},"l":{"br":128000,"fid":0,"size":3953101,"vd":22100},"a":null,"cd":"1","no":8,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":262144,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007},{"name":"Lo, How a Rose E'er Blooming","id":1992739,"pst":0,"t":0,"ar":[{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}],"alia":[],"pop":10,"st":0,"rt":"","fee":0,"v":5,"crbt":null,"cf":"","al":{"id":200919,"name":"Christmas Cello","picUrl":"http://p1.music.126.net/8p7hdTVzTPA9jDWDbK8KOQ==/5722958022641748.jpg","tns":[],"pic":5722958022641748},"dt":275000,"h":{"br":320000,"fid":0,"size":11041479,"vd":-5700},"m":{"br":192000,"fid":0,"size":6624905,"vd":-3100},"l":{"br":128000,"fid":0,"size":4416617,"vd":-1500},"a":null,"cd":"1","no":9,"rtUrl":null,"ftype":0,"rtUrls":[],"djId":0,"copyright":1,"s_id":0,"mark":393216,"originCoverType":0,"noCopyrightRcmd":null,"rtype":0,"rurl":null,"mst":9,"cp":5003,"mv":0,"publishTime":1286812800007}]
         * trackIds : [{"id":1992696,"v":12,"alg":null},{"id":1491163,"v":53,"alg":null},{"id":1992693,"v":11,"alg":null},{"id":1491007,"v":11,"alg":null},{"id":1992707,"v":10,"alg":null},{"id":1992705,"v":11,"alg":null},{"id":1992751,"v":5,"alg":null},{"id":1992785,"v":6,"alg":null},{"id":1992703,"v":10,"alg":null},{"id":1992695,"v":11,"alg":null},{"id":437827057,"v":8,"alg":null},{"id":1322369834,"v":6,"alg":null},{"id":1992718,"v":9,"alg":null},{"id":1992833,"v":4,"alg":null},{"id":1992804,"v":6,"alg":null},{"id":1992713,"v":9,"alg":null},{"id":1992697,"v":8,"alg":null},{"id":1322369837,"v":6,"alg":null},{"id":437827055,"v":11,"alg":null},{"id":437827058,"v":11,"alg":null},{"id":1992774,"v":6,"alg":null},{"id":1992808,"v":6,"alg":null},{"id":437827059,"v":8,"alg":null},{"id":1992699,"v":5,"alg":null},{"id":1992780,"v":6,"alg":null},{"id":437827062,"v":8,"alg":null},{"id":1992700,"v":10,"alg":null},{"id":1992758,"v":11,"alg":null},{"id":1992798,"v":13,"alg":null},{"id":405477010,"v":6,"alg":null},{"id":1992755,"v":4,"alg":null},{"id":1992742,"v":8,"alg":null},{"id":1992766,"v":4,"alg":null},{"id":1992698,"v":7,"alg":null},{"id":1992762,"v":12,"alg":null},{"id":515223894,"v":7,"alg":null},{"id":1322373224,"v":6,"alg":null},{"id":1992701,"v":9,"alg":null},{"id":1992702,"v":8,"alg":null},{"id":515223889,"v":7,"alg":null},{"id":1992812,"v":4,"alg":null},{"id":1992820,"v":5,"alg":null},{"id":1992788,"v":4,"alg":null},{"id":1992841,"v":6,"alg":null},{"id":1331912994,"v":3,"alg":null},{"id":1383196600,"v":3,"alg":null},{"id":1992726,"v":6,"alg":null},{"id":1992727,"v":4,"alg":null},{"id":1992736,"v":4,"alg":null},{"id":1992739,"v":5,"alg":null}]
         * updateFrequency : null
         * backgroundCoverId : 0
         * backgroundCoverUrl : null
         * titleImage : 0
         * titleImageUrl : null
         * englishTitle : null
         * opRecommend : false
         * description : null
         * status : 0
         * trackUpdateTime : 1588319690841
         * coverImgUrl : http://p2.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg
         * updateTime : 1587005967154
         * ordered : false
         * trackCount : 50
         * commentThreadId : A_PL_0_4971080683
         * privacy : 0
         * specialType : 0
         * userId : 1188120
         * newImported : false
         * coverImgId : 1709740581192562
         * createTime : 1587005966973
         * highQuality : false
         * trackNumberUpdateTime : 1587005967154
         * playCount : 2
         * adType : 0
         * tags : []
         * subscribedCount : 0
         * cloudTrackCount : 0
         * name : Steven Sharp Nelson
         * id : 4971080683
         * shareCount : 0
         * commentCount : 0
         */

        private boolean subscribed;
        private CreatorBean creator;
        private Object updateFrequency;
        private int backgroundCoverId;
        private Object backgroundCoverUrl;
        private int titleImage;
        private Object titleImageUrl;
        private Object englishTitle;
        private boolean opRecommend;
        private Object description;
        private int status;
        private long trackUpdateTime;
        private String coverImgUrl;
        private long updateTime;
        private boolean ordered;
        private int trackCount;
        private String commentThreadId;
        private int privacy;
        private int specialType;
        private int userId;
        private boolean newImported;
        private long coverImgId;
        private long createTime;
        private boolean highQuality;
        private long trackNumberUpdateTime;
        private int playCount;
        private int adType;
        private int subscribedCount;
        private int cloudTrackCount;
        private String name;
        private long id;
        private int shareCount;
        private int commentCount;
        private List<?> subscribers;
        private List<TracksBean> tracks;
        private List<TrackIdsBean> trackIds;
        private List<?> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getUpdateFrequency() {
            return updateFrequency;
        }

        public void setUpdateFrequency(Object updateFrequency) {
            this.updateFrequency = updateFrequency;
        }

        public int getBackgroundCoverId() {
            return backgroundCoverId;
        }

        public void setBackgroundCoverId(int backgroundCoverId) {
            this.backgroundCoverId = backgroundCoverId;
        }

        public Object getBackgroundCoverUrl() {
            return backgroundCoverUrl;
        }

        public void setBackgroundCoverUrl(Object backgroundCoverUrl) {
            this.backgroundCoverUrl = backgroundCoverUrl;
        }

        public int getTitleImage() {
            return titleImage;
        }

        public void setTitleImage(int titleImage) {
            this.titleImage = titleImage;
        }

        public Object getTitleImageUrl() {
            return titleImageUrl;
        }

        public void setTitleImageUrl(Object titleImageUrl) {
            this.titleImageUrl = titleImageUrl;
        }

        public Object getEnglishTitle() {
            return englishTitle;
        }

        public void setEnglishTitle(Object englishTitle) {
            this.englishTitle = englishTitle;
        }

        public boolean isOpRecommend() {
            return opRecommend;
        }

        public void setOpRecommend(boolean opRecommend) {
            this.opRecommend = opRecommend;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<TracksBean> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksBean> tracks) {
            this.tracks = tracks;
        }

        public List<TrackIdsBean> getTrackIds() {
            return trackIds;
        }

        public void setTrackIds(List<TrackIdsBean> trackIds) {
            this.trackIds = trackIds;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 1000000
             * authStatus : 0
             * followed : false
             * avatarUrl : http://p1.music.126.net/MpL69azafwespE5rEDduMQ==/109951163714288219.jpg
             * accountStatus : 0
             * gender : 1
             * city : 1010000
             * birthday : 690134400000
             * userId : 1188120
             * userType : 0
             * nickname : razrday
             * signature : 安静的程序员
             * description :
             * detailDescription :
             * avatarImgId : 109951163714288220
             * backgroundImgId : 109951163715930580
             * backgroundUrl : http://p1.music.126.net/6DMX4zA5KiOo0ogiy2FW_Q==/109951163715930569.jpg
             * authority : 0
             * mutual : false
             * expertTags : null
             * experts : null
             * djStatus : 0
             * vipType : 0
             * remarkName : null
             * avatarImgIdStr : 109951163714288219
             * backgroundImgIdStr : 109951163715930569
             * avatarImgId_str : 109951163714288219
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private Object experts;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String avatarImgIdStr;
            private String backgroundImgIdStr;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public Object getExperts() {
                return experts;
            }

            public void setExperts(Object experts) {
                this.experts = experts;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        public static class TracksBean {
            /**
             * name : The Cello Song
             * id : 1992696
             * pst : 0
             * t : 0
             * ar : [{"id":43811,"name":"Steven Sharp Nelson","tns":[],"alias":[]}]
             * alia : []
             * pop : 100
             * st : 0
             * rt :
             * fee : 8
             * v : 12
             * crbt : null
             * cf :
             * al : {"id":200915,"name":"The Piano Guys: Hits Volume 1","picUrl":"http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg","tns":[],"pic":1709740581192562}
             * dt : 196000
             * h : {"br":320000,"fid":0,"size":7867237,"vd":-2}
             * m : {"br":192000,"fid":0,"size":4720423,"vd":-2}
             * l : {"br":128000,"fid":0,"size":3147015,"vd":-2}
             * a : null
             * cd : 1
             * no : 4
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * djId : 0
             * copyright : 1
             * s_id : 0
             * mark : 393216
             * originCoverType : 0
             * noCopyrightRcmd : null
             * rtype : 0
             * rurl : null
             * mst : 9
             * cp : 7001
             * mv : 5323076
             * publishTime : 1327939200007
             */

            private String name;
            private int id;
            private int pst;
            private int t;
            private int pop;
            private int st;
            private String rt;
            private int fee;
            private int v;
            private Object crbt;
            private String cf;
            private AlBean al;
            private int dt;
            private HBean h;
            private MBean m;
            private LBean l;
            private Object a;
            private String cd;
            private int no;
            private Object rtUrl;
            private int ftype;
            private int djId;
            private int copyright;
            private int s_id;
            private int mark;
            private int originCoverType;
            private Object noCopyrightRcmd;
            private int rtype;
            private Object rurl;
            private int mst;
            private int cp;
            private int mv;
            private long publishTime;
            private List<ArBean> ar;
            private List<?> alia;
            private List<?> rtUrls;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPst() {
                return pst;
            }

            public void setPst(int pst) {
                this.pst = pst;
            }

            public int getT() {
                return t;
            }

            public void setT(int t) {
                this.t = t;
            }

            public int getPop() {
                return pop;
            }

            public void setPop(int pop) {
                this.pop = pop;
            }

            public int getSt() {
                return st;
            }

            public void setSt(int st) {
                this.st = st;
            }

            public String getRt() {
                return rt;
            }

            public void setRt(String rt) {
                this.rt = rt;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
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

            public int getDt() {
                return dt;
            }

            public void setDt(int dt) {
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

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public int getDjId() {
                return djId;
            }

            public void setDjId(int djId) {
                this.djId = djId;
            }

            public int getCopyright() {
                return copyright;
            }

            public void setCopyright(int copyright) {
                this.copyright = copyright;
            }

            public int getS_id() {
                return s_id;
            }

            public void setS_id(int s_id) {
                this.s_id = s_id;
            }

            public int getMark() {
                return mark;
            }

            public void setMark(int mark) {
                this.mark = mark;
            }

            public int getOriginCoverType() {
                return originCoverType;
            }

            public void setOriginCoverType(int originCoverType) {
                this.originCoverType = originCoverType;
            }

            public Object getNoCopyrightRcmd() {
                return noCopyrightRcmd;
            }

            public void setNoCopyrightRcmd(Object noCopyrightRcmd) {
                this.noCopyrightRcmd = noCopyrightRcmd;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public int getMst() {
                return mst;
            }

            public void setMst(int mst) {
                this.mst = mst;
            }

            public int getCp() {
                return cp;
            }

            public void setCp(int cp) {
                this.cp = cp;
            }

            public int getMv() {
                return mv;
            }

            public void setMv(int mv) {
                this.mv = mv;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
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

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            public static class AlBean {
                /**
                 * id : 200915
                 * name : The Piano Guys: Hits Volume 1
                 * picUrl : http://p1.music.126.net/sXXUzUKOiKVmemKba5EGSQ==/1709740581192562.jpg
                 * tns : []
                 * pic : 1709740581192562
                 */

                private int id;
                private String name;
                private String picUrl;
                private long pic;
                private List<?> tns;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
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

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public List<?> getTns() {
                    return tns;
                }

                public void setTns(List<?> tns) {
                    this.tns = tns;
                }
            }

            public static class HBean {
                /**
                 * br : 320000
                 * fid : 0
                 * size : 7867237
                 * vd : -2
                 */

                private int br;
                private int fid;
                private int size;
                private int vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }
            }

            public static class MBean {
                /**
                 * br : 192000
                 * fid : 0
                 * size : 4720423
                 * vd : -2
                 */

                private int br;
                private int fid;
                private int size;
                private int vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }
            }

            public static class LBean {
                /**
                 * br : 128000
                 * fid : 0
                 * size : 3147015
                 * vd : -2
                 */

                private int br;
                private int fid;
                private int size;
                private int vd;

                public int getBr() {
                    return br;
                }

                public void setBr(int br) {
                    this.br = br;
                }

                public int getFid() {
                    return fid;
                }

                public void setFid(int fid) {
                    this.fid = fid;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public int getVd() {
                    return vd;
                }

                public void setVd(int vd) {
                    this.vd = vd;
                }
            }

            public static class ArBean {
                /**
                 * id : 43811
                 * name : Steven Sharp Nelson
                 * tns : []
                 * alias : []
                 */

                private int id;
                private String name;
                private List<?> tns;
                private List<?> alias;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
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

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class TrackIdsBean {
            /**
             * id : 1992696
             * v : 12
             * alg : null
             */

            private long id;
            private int v;
            private Object alg;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public int getV() {
                return v;
            }

            public void setV(int v) {
                this.v = v;
            }

            public Object getAlg() {
                return alg;
            }

            public void setAlg(Object alg) {
                this.alg = alg;
            }
        }
    }

    public static class PrivilegesBean {
        /**
         * id : 1992696
         * fee : 8
         * payed : 0
         * st : 0
         * pl : 128000
         * dl : 0
         * sp : 7
         * cp : 1
         * subp : 1
         * cs : false
         * maxbr : 320000
         * fl : 128000
         * toast : false
         * flag : 0
         * preSell : false
         * playMaxbr : 320000
         * downloadMaxbr : 320000
         */

        private int id;
        private int fee;
        private int payed;
        private int st;
        private int pl;
        private int dl;
        private int sp;
        private int cp;
        private int subp;
        private boolean cs;
        private int maxbr;
        private int fl;
        private boolean toast;
        private int flag;
        private boolean preSell;
        private int playMaxbr;
        private int downloadMaxbr;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public int getPayed() {
            return payed;
        }

        public void setPayed(int payed) {
            this.payed = payed;
        }

        public int getSt() {
            return st;
        }

        public void setSt(int st) {
            this.st = st;
        }

        public int getPl() {
            return pl;
        }

        public void setPl(int pl) {
            this.pl = pl;
        }

        public int getDl() {
            return dl;
        }

        public void setDl(int dl) {
            this.dl = dl;
        }

        public int getSp() {
            return sp;
        }

        public void setSp(int sp) {
            this.sp = sp;
        }

        public int getCp() {
            return cp;
        }

        public void setCp(int cp) {
            this.cp = cp;
        }

        public int getSubp() {
            return subp;
        }

        public void setSubp(int subp) {
            this.subp = subp;
        }

        public boolean isCs() {
            return cs;
        }

        public void setCs(boolean cs) {
            this.cs = cs;
        }

        public int getMaxbr() {
            return maxbr;
        }

        public void setMaxbr(int maxbr) {
            this.maxbr = maxbr;
        }

        public int getFl() {
            return fl;
        }

        public void setFl(int fl) {
            this.fl = fl;
        }

        public boolean isToast() {
            return toast;
        }

        public void setToast(boolean toast) {
            this.toast = toast;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public boolean isPreSell() {
            return preSell;
        }

        public void setPreSell(boolean preSell) {
            this.preSell = preSell;
        }

        public int getPlayMaxbr() {
            return playMaxbr;
        }

        public void setPlayMaxbr(int playMaxbr) {
            this.playMaxbr = playMaxbr;
        }

        public int getDownloadMaxbr() {
            return downloadMaxbr;
        }

        public void setDownloadMaxbr(int downloadMaxbr) {
            this.downloadMaxbr = downloadMaxbr;
        }
    }
}
