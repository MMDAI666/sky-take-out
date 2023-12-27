package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 套餐相关接口
 * @author 萌萌哒AI
 * @date 2023/12/27
 */
@RestController
@RequestMapping("/admin/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    private SetmealService setmealService;
    /**
     * 新增套餐
     * @param setmealDTO
     * @return {@link Result}
     */
    @PostMapping
    public Result save(@RequestBody SetmealDTO setmealDTO)
    {
        log.info("新增套餐：{}",setmealDTO);
        setmealService.save(setmealDTO);
        return Result.success();
    }


    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return {@link Result}<{@link PageResult}>
     */
    @GetMapping("/page")
    private Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO)
    {
        log.info("查询第{}页，每页{}条",setmealPageQueryDTO.getPage(),setmealPageQueryDTO.getPageSize());
        PageResult pageResult=setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }


}
