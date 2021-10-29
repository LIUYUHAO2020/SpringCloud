package com.atguigu.springcloud.mapper;


import com.atguigu.entities.entities.po.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @Author wz
 * @Date 2021/10/28 18:02
 * @Version 1.0
 */
@Mapper
public interface PaymentMapper {

    /**
     * Options注解：
     *          useGeneratedKeys = true:返回自增后主键的值
     *          keyProperty = "id":主键的名称
     * @param payment
     * @return
     */
    @Insert("insert into payment (serial) values (#{serial})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Long create(Payment payment);

    @Select("select id,serial from payment where id=#{id}")
    public Payment getPayment(Long id);
}
