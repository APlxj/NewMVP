package swallow.com.model_ui.ocr;

import java.util.List;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class ResultOcrModel {

    /**
     * log_id : 3893878422596735722
     * direction : 0
     * words_result_num : 11
     * words_result : [{"words":" TimetableView"},{"words":"个非常漂亮的 Android课程表控件,"},{"words":"设置数据源"},{"words":"颜色设置,控件内置17种颜色"},{"words":"触感反馈,每种内置颜色都有对应的"},{"words":"日期显示与高亮"},{"words":"课表ltem点击事件处理"},{"words":"解决课程重叠、交又的问题,解决的"},{"words":"高效的切换周次"},{"words":"·获取某天要上的课程"},{"words":"运行效果"}]
     */

    private long log_id;
    private int direction;
    private int words_result_num;
    private List<WordsResultBean> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words :  TimetableView
         */

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
