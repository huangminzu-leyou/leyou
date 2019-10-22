package com.leyou.item.web;

import com.leyou.item.service.CategoryService;
import com.leyou.item.pojo.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huangyi
 * @date 2019/10/15 11:37
 */
@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据parentId查询类目
     *
     * @param pid
     * @return
     */
    @RequestMapping("list")
    public ResponseEntity<List<Category>> queryCategoryListByParentId(@RequestParam(value = "pid", defaultValue = "0") Long pid) {
        // return ResponseEntity.ok(categoryService.queryCategoryListByParentId(pid));
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.queryCategoryListByParentId(pid));
    }
}
