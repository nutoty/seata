package cn.tedu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author Wu Yong
 * @Date 2021/7/30 23:27
 * @Description
 */
@FeignClient(name = "EASY-ID-GENERATOR")
public interface EasyIdGeneratorClient {
    @GetMapping("/segment/ids/next_id")
    String nextId(@RequestParam String businessType);
}
