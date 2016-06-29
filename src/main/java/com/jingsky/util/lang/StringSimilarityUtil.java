package com.jingsky.util.lang;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

/**
 * 字符串相似度比较工具.<br/>
 * 依赖commons-lang3-*.jar,commons-collections-*.jar,IKAnalyzer2012FF_u1.jar
 * Created by 朱志杰 on 16/3/17.
 */
public class StringSimilarityUtil {

    /**
     * 两个字符串进行比对
     * @param content1 字符串1
     * @param content2 字符串2
     * @return Double 相似度
     * @throws IOException
     */
    public static Double compare(String content1,String content2) throws IOException {
        Map<String, Integer> tf1 = getTF(content1);
        Map<String, Integer> tf2 = getTF(content2);
        Map<String, MutablePair<Integer, Integer>> tfs = new HashMap<String, MutablePair<Integer, Integer>>();
        for (String key : tf1.keySet()) {
            MutablePair<Integer, Integer> pair = new MutablePair<Integer, Integer>(tf1.get(key), 0);
            tfs.put(key, pair);
        }
        for (String key : tf2.keySet()) {
            MutablePair<Integer, Integer> pair = tfs.get(key);
            if (null == pair) {
                pair = new MutablePair<Integer, Integer>(0, tf2.get(key));
            } else {
                pair.setRight(tf2.get(key));
            }
        }
        double d = caclIDF(tfs);
        return d;
    }

    public static Map<String, Integer> getTF(String str) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(str), true);
        Lexeme lexeme = null;
        while ((lexeme = ikSegmenter.next()) != null) {
            String key = lexeme.getLexemeText();
            Integer count = map.get(key);
            if (null == count) {
                count = 1;
            } else {
                count = count + 1;
            }
            map.put(key, count);
        }
        return map;
    }

    public static double caclIDF(Map<String, MutablePair<Integer, Integer>> tf) {
        double d = 0;
        if (MapUtils.isEmpty(tf)) {
            return d;
        }
        double denominator = 0;
        double sqdoc1 = 0;
        double sqdoc2 = 0;
        Pair<Integer, Integer> count = null;
        for (String key : tf.keySet()) {
            count = tf.get(key);
            denominator += count.getLeft() * count.getRight();
            sqdoc1 += count.getLeft() * count.getLeft();
            sqdoc2 += count.getRight() * count.getRight();
        }
        d = denominator / (Math.sqrt(sqdoc1) * Math.sqrt(sqdoc2));
        return d;
    }
}
