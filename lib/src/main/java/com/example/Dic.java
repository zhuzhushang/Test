package com.example;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 汉字本地字典。 <br/>
 * 本地字典数据来自于<a href=http://www.zdic.net/search/?c=2>汉典</a>
 * 实现了一下常用的需求，例如返回拼音，五笔，拼音首字母，笔画数目，笔画顺序。
 *
 * @author siqi
 *
 */
public class Dic {

    /**
     * 设置是否输出调试信息
     */
    private static boolean DEBUG = true;

    /**
     * 默认编码
     */
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /**
     * 汉字Unicode最小编码
     */
    public static final int CN_U16_CODE_MIN = 0x4e00;

    /**
     * 汉字Unicode最大编码
     */
    public static final int CN_U16_CODE_MAX = 0x9fa5;

    /**
     * 本地字典文件名
     */
    public static final String DIC_FILENAME = "D:/data.txt";

    /**
     * 字典数据
     */
    public static byte[] bytes = new byte[0];

    /**
     * 字典汉字数目
     */
    public static int count = 0;

    /**
     * 汉字unicode值在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_UNICODE = 0;
    /**
     * 汉字在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_CHARACTER = 1;
    /**
     * 汉字部首在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_BUSHOU = 2;
    /**
     * 汉字笔画在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_BIHUA = 3;
    /**
     * 汉字笔画顺序在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_BISHUN = 4;
    /**
     * 汉字五笔在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_WUBI = 5;
    /**
     * 汉字郑码在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_ZHENGMA = 6;
    /**
     * 第一个汉字拼音（英文字母）在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_PINYIN_EN = 7;
    /**
     * 第一个汉字拼音（中文字母）在一条汉字信息的位置<br/>
     * 汉字信息，例："25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá"
     */
    public static int INDEX_PINYIN_CN = 8;

    /**
     * 装载字典
     */
    static {
        long time = System.currentTimeMillis();

        try {
            LoadDictionary();
            count = count();
            if (DEBUG) {
                System.out.println("成功载入字典" + new File(DIC_FILENAME).getCanonicalPath() + " ，用时："
                        + (System.currentTimeMillis() - time) + "毫秒，载入字符数"+count);
            }
        } catch (Exception e) {
            try {
                System.out.println("载入字典失败" + new File(DIC_FILENAME).getCanonicalPath()+"\r\n");
            } catch (Exception e1) {
            }
            e.printStackTrace();
        }

    }

    /**
     * 获取汉字unicode值
     *
     * @param ch
     *            汉字
     * @return 返回汉字的unicode值
     * @throws Exception
     */
    public static String GetUnicode(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_UNICODE);
    }

    /**
     * 获取拼音（英文字母）
     *
     * @param ch
     *            单个汉字字符
     * @return 返回汉字的英文字母拼音。如 "大"->"da4"。
     * @throws Exception
     */
    public static String GetPinyinEn(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_PINYIN_EN);
    }

    /**
     * 返回汉字字符串的拼音（英文字母）
     *
     * @param str
     *            汉字字符串
     * @return 返回汉字字符串的拼音。将字符串中的汉字替换成拼音，其他字符不变。拼音中间会有空格。 注意，对于多音字，返回的拼音可能不正确。
     * @throws Exception
     */
    public static String GetPinyinEn(String str) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isChineseChar(ch)) {
                sb.append(GetPinyinEn(ch) + " ");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString().trim();
    }

    /**
     * 获取拼音（中文字母）
     *
     * @param ch
     *            单个汉字字符
     * @return 返回汉字的中文字母拼音。如 "打"->"dǎ"。
     * @throws Exception
     */
    public static String GetPinyinCn(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_PINYIN_CN);
    }

    /**
     * 返回汉字字符串的拼音（中文字母）
     *
     * @param str
     *            汉字字符串
     * @return 返回汉字字符串的拼音。将字符串中的汉字替换成拼音，其他字符不变。拼音中间会有空格。 注意，对于多音字，返回的拼音可能不正确。
     * @throws Exception
     */
    public static String GetPinyinCn(String str) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isChineseChar(ch)) {
                sb.append(GetPinyinCn(ch) + " ");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString().trim();
    }

    /**
     * 返回拼音首字母
     *
     * @param ch
     * @return
     * @throws Exception
     */
    public static String GetFirstLetter(Character ch) throws Exception {
        if (isChineseChar(ch)) {
            return GetPinyinEn(ch).substring(0, 1);
        } else {
            return "";
        }
    }

    /**
     * 返回汉字字符串拼音首字母，如果不是汉字，会被忽略掉。
     *
     * @param str
     *            汉字字符串
     * @return
     * @throws Exception
     */
    public static String GetFirstLetter(String str) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isChineseChar(ch)) {
                sb.append(GetFirstLetter(ch));
            }
        }

        return sb.toString().trim();
    }

    /**
     * 获取汉字部首
     *
     * @param ch
     *            汉字
     * @return 返回汉字的部首
     * @throws Exception
     */
    public static String GetBushou(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_BUSHOU);
    }

    /**
     * 获取汉字笔画数目
     *
     * @param ch
     *            汉字
     * @return 返回汉字的笔画数目
     * @throws Exception
     */
    public static String GetBihua(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_BIHUA);
    }

    /**
     * 获取汉字笔画顺序
     *
     * @param ch
     *            汉字
     * @return 返回汉字的笔画顺序
     * @throws Exception
     */
    public static String GetBishun(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_BISHUN);
    }

    /**
     * 获取汉字五笔
     *
     * @param ch
     *            汉字
     * @return 返回汉字五笔
     * @throws Exception
     */
    public static String GetWubi(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_WUBI);
    }

    /**
     * 获取汉字郑码
     *
     * @param ch
     *            汉字
     * @return 返回汉字郑码
     * @throws Exception
     */
    public static String GetZhengma(Character ch) throws Exception {
        return GetCharInfo(ch, INDEX_ZHENGMA);
    }

    /**
     * 从字典中获取汉字信息
     *
     * @param ch
     *            要查询的汉字
     * @return 返回汉字信息，如"25171,打,扌,5,12112,RSH,DAI,da3,dǎ,da2,dá" <br/>
     *         第一是汉字unicode值<br/>
     *         第二是汉字<br/>
     *         第三是汉字部首<br/>
     *         第四是汉字笔画<br/>
     *         第五是汉字笔画顺序("12345"分别代表"横竖撇捺折")<br/>
     *         第六是汉字五笔<br/>
     *         第七是汉字郑码<br/>
     *         第八及以后是汉字的拼音（英文字母拼音和中文字母拼音）<br/>
     * @throws Exception
     */
    public static String GetCharInfo(Character ch) throws Exception {
        if (!isChineseChar(ch)) {
            throw new Exception("'" + ch + "' 不是一个汉字！");
        }

        String result = "";

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedReader br = new BufferedReader(new InputStreamReader(bais));

        String strWord;
        while ((strWord = br.readLine()) != null) {
            if (strWord.startsWith(String.valueOf(ch.hashCode()))) {
                result = strWord;
                break;
            }
        }
        br.close();
        bais.close();

        return result;
    }

    /**
     * 返回汉字信息
     *
     * @param ch
     *            汉字
     * @param index
     *            信息所在的Index
     * @return
     * @throws Exception
     */
    private static String GetCharInfo(Character ch, int index) throws Exception {
        if (!isChineseChar(ch)) {
            throw new Exception("'" + ch + "' 不是一个汉字！");
        }

        // 获取汉字信息
        String charInfo = GetCharInfo(ch);

        String result = "";
        try {
            result = charInfo.split(",")[index];
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("请查看字典中" + ch + "汉字记录是否正确！");
        }

        return result;
    }

    /**
     * 载入字典文件到内存。
     * @throws Exception
     */
    private static void LoadDictionary() throws Exception {
        File file = new File(DIC_FILENAME);
        bytes = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes, 0, bytes.length);
        fis.close();
    }

    /**
     * 判断字符是否为汉字，在测试的时候，我发现汉字的字符的hashcode值 跟汉字Unicode
     * 16的值一样，所以可以用hashcode来判断是否为汉字。
     *
     * @param ch
     *            汉字
     * @return 是汉字返回true，否则返回false。
     */
    public static boolean isChineseChar(Character ch) {
        if (ch.hashCode() >= CN_U16_CODE_MIN
                && ch.hashCode() <= CN_U16_CODE_MAX) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return 返回字典包含的汉字数目。
     * @throws Exception
     */
    private static int count() throws Exception {
        int cnt = 0;
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedReader br = new BufferedReader(new InputStreamReader(bais));

        while (br.readLine() != null) {
            cnt++;
        }
        br.close();
        bais.close();

        return cnt;
    }
}
