package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetmealService {
    /**
     * 新增套餐
     * @param setmealDTO
     */
    void save(SetmealDTO setmealDTO);

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return {@link PageResult}
     */
    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 批量删除套餐
     * @param ids
     */
    void deleteBarch(List<Long> ids);

    /**
     * 根据id查询套餐，用于页面回显
     *
     * @param id
     * @return {@link SetmealVO}
     */
    SetmealVO getById(Long id);

    /**
     * 修改套餐信息及管理的套餐-菜品信息
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);
}
