package cn.tedu.order.service;

import cn.tedu.order.entity.Order;
import cn.tedu.order.feign.AccountClient;
import cn.tedu.order.feign.EasyIdGeneratorClient;
import cn.tedu.order.feign.StorageClient;
import cn.tedu.order.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author Wu Yong
 * @Date 2021/7/29 20:47
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    EasyIdGeneratorClient easyIdClient;
    @Autowired
    private AccountClient accountClient;
    @Autowired
    private StorageClient storageClient;

    @GlobalTransactional
    @Override
    public void create(Order order) {
        //从全局唯一id发号器获得id，这里暂时随机产生一个 orderId
        String s = easyIdClient.nextId("order_business");
        Long orderId = Long.valueOf(s);

        order.setId(orderId);
        orderMapper.create(order);

//        if (Math.random() < 0.5) {
//            throw new RuntimeException("模拟异常");
//        }
        // 修改库存
        storageClient.decrease(order.getProductId(), order.getCount());

        // 修改账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());

    }
}
