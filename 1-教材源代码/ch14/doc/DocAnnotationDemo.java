package ch14.doc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 本类用于演示文档注解。
 * 
 * @author 胡平
 * @version 2.0
 */

public class DocAnnotationDemo {
    /**
     * 根据指定的语言，得到当前时间的字符串描述。
     * 
     * @param lang
     *            指定的语言。
     * @return 当前时间的字符串描述。
     * @throws UnsupportedLanguageException
     *             若指定的语言未定义。
     * @since 2.0
     * @see Language
     */
    public String getTime(Language lang) throws UnsupportedLanguageException {
        String timeFormatStr;
        if (lang == Language.CN) {
            timeFormatStr = "yyyy年MM月dd日 HH时mm分ss秒";
        } else if (lang == Language.EN) {
            timeFormatStr = "MM/dd/yyyy HH:mm:ss";
        } else {
            throw new UnsupportedLanguageException();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormatStr);
        return sdf.format(new Date());
    }

    /**
     * 根据默认的语言，得到当前时间的字符串描述。
     * 
     * @deprecated 从2.0开始，由 getTime(Language lang) 取代。
     * @return 当前时间的字符串描述。
     * @see #getTime(Language)
     */
    @Deprecated
    public String getTime() {
        return getTime(Language.EN);
    }

}