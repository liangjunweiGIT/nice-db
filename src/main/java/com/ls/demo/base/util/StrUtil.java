package com.ls.demo.base.util;

import com.alibaba.fastjson.JSON;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/21
 */
public final class StrUtil {

    public static String convertUnicode(String ori) {
        if (isEmpty(ori)) {
            return "";
        }
        char aChar;
        int len = ori.length();
        StringBuilder outBuffer = new StringBuilder(len);
        for (int x = 0; x < len; ) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);

        }
        return outBuffer.toString();
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        } else {
            return str.length();
        }
    }

    public static List<String> split(String src, String... splits) {
        List<String> list = new LinkedList<String>();
        if (src == null || src.length() < 1) {
            return list;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < src.length(); ) {
            boolean flag = true;
            if (splits != null) {
                for (String s : splits) {
                    if (s != null && src.startsWith(s, i)) {
                        i += s.length();
                        if (builder.length() > 0) {
                            list.add(builder.toString());
                            builder = new StringBuilder();
                        }
                        flag = false;
                        break;
                    }
                }
            }
            if (i < src.length() && flag) {
                builder.append(src.charAt(i));
                i++;
            }
        }
        if (builder.length() > 0) {
            list.add(builder.toString());
        }
        return list;
    }

    public static String getStatementParameter(String str, Object... objects) {
        if (!isBlank(str)) {
            if (objects != null && objects.length > 0) {
                for (int i = 0; i < objects.length; i++) {
                    str = str.replace("${" + i + "}", objects[i] == null ? ""
                            : objects[i].toString());
                }
            }
        }
        return str;
    }

    /**
     * 获取异常打印信息
     *
     * @param e
     * @return
     */
    public static String toString(Throwable e) {
        StringWriter sw = new StringWriter(1024);
        e.printStackTrace(new PrintWriter(sw));
        return sw.getBuffer().toString();
    }

    public static String fillBlank(Object o, int length) {
        StringBuilder s = new StringBuilder(length);
        s.append(String.valueOf(o));
        while (s.length() < length) {
            s.append(" ");
        }
        return s.toString();
    }

    public static String fillBlankPre(Object o, int length) {
        StringBuilder s = new StringBuilder(length);
        String str = String.valueOf(o);
        while (s.length() + str.length() < length) {
            s.append(" ");
        }
        s.append(str);
        return s.toString();
    }

    /**
     * build如果已经有数据则添加 逗号
     *
     * @param builder
     * @param value
     */
    public static void appendAndPreComma(StringBuilder builder, String value) {
        if (builder.length() > 1) {
            builder.append(",");
        }
        builder.append(value);
    }

    public static boolean isNotEmpty(String s) {
        return nEmpty(s);
    }

    public static boolean isEmpty(String s) {
        return empty(s);
    }

    public static boolean nEmpty(String s) {
        return s != null && s.length() > 0;
    }

    public static boolean empty(String s) {
        return !nEmpty(s);
    }

    public static boolean isBlank(String str) {
        if (isEmpty(str))
            return true;
        for (int i = 0; i < str.length(); i++)
            if (!Character.isWhitespace(str.charAt(i)))
                return false;

        return true;
    }

    private static String toString(int i, FormatType type, Object... objects) {
        String s = null;
        if (objects != null && i >= 0 && i < objects.length) {
            if (type == FormatType.JSON) {
                s = JSON.toJSONString(objects[i]);
            } else if (type == FormatType.STRING) {
                s = String.valueOf(objects[i]);
            }
        }
        return String.valueOf(s);
    }

    public static String getStackDesc(StackTraceElement[] stack, int start, int offset) {
        if (stack == null) {
            return "stack is null";
        }
        int len = stack.length;
        if (offset < 1 || len < 1 || start < 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder((50 * len) + 10);
        for (int i = start; i < offset && i < len; i++) {
            builder.append(stack[i]).append("\n");
        }
        return builder.toString();
    }

    public static String getStackDesc(StackTraceElement[] stack) {
        return getStackDesc(stack, 0, stack.length);
    }

    public static String getNotNull(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return "";
    }

    public static enum FormatType {
        JSON, STRING;
    }

    private StrUtil() {

    }

    /**
     * Description: 去掉字符串前后的空格
     *
     * @param value
     * @return
     */
    public static String toTrim(String value) {
        return null == value ? null : value.trim();
    }

    /**
     * Description: 只剩下中文英文字母及数字
     *
     * @param character
     * @return
     */
    public static String filterChineseAlphabetNumber(String character) {
        if (isEmpty(character)) return character;
        return character.replaceAll("[^0-9a-zA-Z\\u4e00-\\u9fa5]", "");
    }

    public static String notNull(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

}
