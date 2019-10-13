package com.leyou.item.web;

import com.leyou.item.pojo.Item;
import com.leyou.item.service.ItemService;
import javax.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangyi
 * @date 2019/10/13 9:10
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> saveItem(Item item) {

        if (item.getPrice() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        item =itemService.saveItem(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
}
