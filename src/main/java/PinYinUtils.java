package main.java;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtils {


    public static String toPinYin(String content) {
        return toPinYin(content, " ", false, null);
    }

    public static String toPinYin(String content, String spera, boolean firstUpperCase, HanyuPinyinOutputFormat format) {
        if (content == null || content.trim().length() == 0) {
            return "";
        }
        if (spera == null) {
            spera = "";
        }
        if (format == null) {
            format = new HanyuPinyinOutputFormat();
        }

        StringBuilder pyBuilder = new StringBuilder();
        String temp;
        String[] pyArray = null;
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            if ((int) c <= 128) {
                pyBuilder.append(c);
            } else {
                try {
                    pyArray = PinyinHelper.toHanyuPinyinStringArray(c, format);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
                if (pyArray == null) {
                    pyBuilder.append(c);
                } else {
                    temp = pyArray[0];
                    if (firstUpperCase) {
                        temp = pyArray[0].toUpperCase().charAt(0) + temp.substring(1);
                    }
                    pyBuilder.append(temp).append(i == content.length() - 1 ? "" : spera);
                }
            }
        }

        return pyBuilder.toString().trim();
    }
}
