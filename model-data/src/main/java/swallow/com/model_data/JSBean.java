package swallow.com.model_data;

import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class JSBean {

    /**
     * sid : 3093
     * tts : http://news.iciba.com/admin/tts/2018-08-14-day.mp3
     * content : I love the broken sound in my body and the healing process.
     * note : 我喜欢我身体破碎的声音和不断愈合的过程。
     * love : 1253
     * translation : 投稿来自木檀。他想说的话：一场疾病打破了我所有的思绪，一开始并没有想到能坚持上学甚至是坚持到学期末考试。是啊，即便这无望的人生也是我所爱着的，尽管很糟糕甚至是勉强，也不知道未来会怎样。但吃到好吃的东西，看到想看的景，还是会热泪盈眶，十七岁的清茶二十岁的宣言，此刻还在努力的生长！出自《万物生长》，作者余秀华。
     * picture : http://cdn.iciba.com/news/word/20180814.jpg
     * picture2 : http://cdn.iciba.com/news/word/big_20180814b.jpg
     * caption : 词霸每日一句
     * dateline : 2018-08-14
     * s_pv : 0
     * sp_pv : 0
     * tags : [{"id":null,"name":null}]
     * fenxiang_img : http://cdn.iciba.com/web/news/longweibo/imag/2018-08-14.jpg
     */

    private String sid;
    private String tts;
    private String content;
    private String note;
    private String love;
    private String translation;
    private String picture;
    private String picture2;
    private String caption;
    private String dateline;
    private String s_pv;
    private String sp_pv;
    private String fenxiang_img;
    private List<TagsBean> tags;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTts() {
        return tts;
    }

    public void setTts(String tts) {
        this.tts = tts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getS_pv() {
        return s_pv;
    }

    public void setS_pv(String s_pv) {
        this.s_pv = s_pv;
    }

    public String getSp_pv() {
        return sp_pv;
    }

    public void setSp_pv(String sp_pv) {
        this.sp_pv = sp_pv;
    }

    public String getFenxiang_img() {
        return fenxiang_img;
    }

    public void setFenxiang_img(String fenxiang_img) {
        this.fenxiang_img = fenxiang_img;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        /**
         * id : null
         * name : null
         */

        private Object id;
        private Object name;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }
    }
}
