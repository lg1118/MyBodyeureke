package com.czxy.controller;

import com.czxy.domain.Order;
import com.czxy.domain.Shop;
import com.czxy.domain.ShopPage;
import com.czxy.service.OrderService;
import com.czxy.service.ShopService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private ShopService shopService;
    @Resource
    private OrderService orderService;

    /**
     * 查询所有订单
     * @param shopPage
     * @return
     */
    @GetMapping
    public ResponseEntity<PageInfo> fandAllByPage(ShopPage shopPage){
        PageInfo<Shop> slist = shopService.fandAllByPage(shopPage);
        return ResponseEntity.ok(slist);
    }

    /**
     * 订单类型
     * @return
     */
    @GetMapping("/type")
    public ResponseEntity<List<Order>> fandOrder(){
        List<Order> olist = orderService.fandOrder();
       System.out.println(olist);
        return ResponseEntity.ok(olist);
    }

    /**
     * 发布订单
     * @param shop
     * @return
     */
    @PostMapping("/release")
    public ResponseEntity<String> release(@RequestBody Shop shop){
        System.out.println(shop);
        shopService.release(shop);
        return ResponseEntity.ok("发布成功");
    }

    /**
     * 接单
     * @param uids
     * @param shop
     * @return
     */
    @PostMapping("/join/{uids}")
    public ResponseEntity<String> join(@PathVariable("uids") Integer uids,@RequestBody Shop shop){
        System.out.println(uids);
        shopService.join(shop,uids);

//        shopService.release(shop);
        return ResponseEntity.ok("接单成功");
    }
    /**
     * 查看自己已接订单
     */
    @GetMapping("/{uid}")
    public ResponseEntity<PageInfo> selectByUid(@PathVariable("uid") Integer uid ,ShopPage ShopPage){
        PageInfo<Shop> slist = shopService.selectByUid(uid,ShopPage);
        return ResponseEntity.ok(slist);
    }
}
