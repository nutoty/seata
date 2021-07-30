package cn.tedu.storage.service;

/**
 * @Author Wu Yong
 * @Date 2021/7/29 20:32
 * @Description
 */
public interface StorageService {
    void decrease(Long productId, Integer count) throws Exception;
}
