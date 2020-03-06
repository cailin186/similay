package com.talk51.similar;


import com.talk51.similar.util.image.similarity.ImagePHash;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

@RestController
/**
 * @autor cailin
 * 20200306
 */
public class SimilarController {
    @GetMapping("/similar")
    public Integer imagesimilar(@RequestParam(value = "source", required = true) String source,
                                @RequestParam(value = "candi", required = true) String candi) {
        ImagePHash p = new ImagePHash();
        int dis = 0;
        try {
            dis = p.distance(new URL(source), new URL(candi));
            System.out.println(dis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dis;
    }
}
