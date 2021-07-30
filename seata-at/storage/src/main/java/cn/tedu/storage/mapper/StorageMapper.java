package cn.tedu.storage.mapper;

import cn.tedu.storage.entity.Storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Author Wu Yong
 * @Date 2021/7/29 20:29
 * @Description
 */
public interface StorageMapper extends BaseMapper<Storage> {
    void decrease(Long productId, Integer count);

}
