package com.leyou.item.web;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.pojo.Item;
import com.leyou.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item")
public class itemControler {
    @Autowired
    private ItemService itemService;

    //@ResponseBody 响应体 默认返回json，返回值放入web的body中 此处不能用ResponseBody
    //ResponseEntity是一个完整的http响应 （响应头 响应尾 状态 响应体）此处Item 为响应体
    @PostMapping //@PostMapping是一个组合注解，是@RequestMapping(method = RequestMethod.POST)的缩写
    public ResponseEntity<Item> saveItem(Item item) {
        if (item.getPrice() == null) {
            throw new LyException(ExceptionEnum.PRICE_CANNOT_BE_NULL);
        }
        itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
