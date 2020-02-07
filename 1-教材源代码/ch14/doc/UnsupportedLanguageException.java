package ch14.doc;

/**
 * 当指定的语言未定义时，抛出此异常。
 * 
 * @see Language
 * @author 胡平
 */
public class UnsupportedLanguageException extends RuntimeException {
    /**
     * 调用父类的构造方法，传入异常描述信息为"尚不支持指定的语言"。
     */
    public UnsupportedLanguageException() {
        super("尚不支持指定的语言");
    }
}