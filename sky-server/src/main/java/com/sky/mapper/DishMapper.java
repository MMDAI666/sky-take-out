package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /**
     * 插入菜品信息
     * @param dish
     */
    @AutoFill(OperationType.INSERT)
    void insert(Dish dish);

    /**
     * 分页查询
     * @param dishPageQueryDTO
     * @return {@link PageResult}
     */
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据id查询
     * @param id
     * @return boolean
     */
    @Select("select * from dish where id=#{id}")
    Dish getBydId(Long id);

    /**
     * 根据id删除菜品数据
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    /**
     * 动态更新菜品数据
     * @param dish
     */
    @AutoFill(OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 根据分类id查询启售中的菜品
     * @param dish
     * @return {@link List}<{@link Dish}>
     */
    List<Dish> list(Dish dish);

    /**
     * 根据套餐查询菜品
     *
     * @param isetmealId
     * @return {@link List}<{@link Dish}>
     */
    @Select("select d.* from dish d left join setmeal_dish s on d.id = s.dish_id where s.setmeal_id =#{setmealId}")
    List<Dish> getBySetmealId(Long isetmealId);
}
