package com.solvd.myBatisMapper.mapper;

import com.solvd.entities.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountMapper  {
    @Select("SELECT * FROM account WHERE id_account=#{id_account}")
    @Results(value = {
            @Result(property = "id_account", column = "id_account"),
            @Result(property="customerId", column = "customer_id"),
            @Result(property="branchId", column = "branch_id"),
            @Result(property="accountStatusId", column = "account_status_id"),
            @Result(property="openingDate", column = "opening_date"),
            @Result(property="balance", column = "balance"),
//            @Result(property = "addresses", javaType = List.class,
//                    column = "personId", many=@Many(select = "getAddresses"))
    })
    public Account getOne (Integer id);


    @Select("SELECT * FROM account")
    @Results(value = {
            @Result(property = "id_account", column = "id_account"),
            @Result(property="customerId", column = "customer_id"),
            @Result(property="branchId", column = "branch_id"),
            @Result(property="accountStatusId", column = "account_status_id"),
            @Result(property="openingDate", column = "opening_date"),
            @Result(property="balance", column = "balance"),
//            @Result(property = "addresses", javaType = List.class,
//                    column = "personId", many=@Many(select = "getAddresses"))
    })
    public List<Account> getAll();


    @Insert("INSERT INTO account (customer_id, branch_id, account_status_id,opening_date, balance) VALUES (#{customer_id}, #{branch_id} ,#{account_status_id}, #{opening_date}, #{balance})")
    public void insert(Account account);

    @Update(" UPDATE account SET customerId= #{customer_id}, branchId= #{branch_id}, accountStatusId= #{account_status_id}, openingDate= #{opening_date}, balance= #{balance}WHERE id_account=#{id}")
    public void update(Account account, Integer id);

    @Delete("DELETE FROM account WHERE id_account=#{id_account}")
    public void delete(Integer id);
}
