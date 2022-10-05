package com.solvd.myBatisMapper.mapper;

import com.solvd.entities.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountMapper  {
    final String getOne="SELECT * FROM account WHERE id_account=#{id_account}";
    final String getAll="SELECT * FROM account";
    final String insert="INSERT INTO account (customer_id, branch_id, account_status_id,opening_date, balance) VALUES (#{customerId}, #{branchId} ,#{accountStatusId}, #{openingDate}, #{balance})";
    final String update=" UPDATE account SET customer_id=#{customerId}, branch_id=#{branchId}, account_status_id=#{accountStatusId}, opening_date=#{openingDate}, balance=#{balance}WHERE id_account=#{id}";
    final String delete="DELETE FROM account WHERE id_account=#{id_account}";
    @Select(getOne)
    @Results(value = {
            @Result(property = "id_account", column = "id_account"),
            @Result(property="customerId", column = "customer_id"),
            @Result(property="branchId", column = "branch_id"),
            @Result(property="accountStatusId", column = "account_status_id"),
            @Result(property="openingDate", column = "opening_date"),
            @Result(property="balance", column = "balance"),
    })
    public Account getOne (Integer id);


    @Select(getAll)
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


    @Insert(insert)
    @Options(useGeneratedKeys = true, keyProperty = "id_account")
    public void insert(Account account);

    @Update(update)
    public void update(Account account, Integer id);

    @Delete(delete)
    public void delete(Integer id);
}
