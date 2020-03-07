package com.talk51.similar;

import com.talk51.similar.util.image.similarity.ImageHanmingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

/**
 * @author cailin
 * 20200306
 */
@RestController
public class SimilarController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 计算两张图片的相似度
     *
     * @param source 原图url
     * @param candi  目标图url
     * @return 整形数字，数字小于10说明二者相似度越高
     */
    @GetMapping("/similar")
    public Integer imageSimilar(@RequestParam(value = "source", required = true) String source,
                                @RequestParam(value = "candi", required = true) String candi) {
        ImageHanmingUtil hanmingHash = new ImageHanmingUtil();
        int distence = 0;
        try {
            distence = hanmingHash.distance(new URL(source), new URL(candi));
        } catch (Exception e) {
            logger.error("相似度计算错误", e);
        }
        return distence;
    }


    /**
     * 计算单图片的汉明码
     *
     * @param url 待计算的图片的url
     * @return 二级制的汉明码
     */
    @GetMapping("/hanmingcode")
    public String getHanMingDis(@RequestParam(value = "url", required = true) String url) {
        ImageHanmingUtil hanmingHash = new ImageHanmingUtil();
        String hanmingCode="";
        try {
            hanmingCode = hanmingHash.hash(new URL(url));
        } catch (Exception e) {
            logger.error("汉明码计算错误", e);
        }
        return hanmingCode;
    }


}
