package com.solvd.myBatisMapper.mapper;

import com.solvd.entities.AccountStatus;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAccountStatusMapper {
    final String GETONE="SELECT * FROM account_status WHERE id_account_status=#{id_accountStatus}";
    final String GETALL="SELECT * FROM account_status";
    final String INSERT="INSERT INTO account_status (status) VALUES (#{status})";
    final String UPDATE=" UPDATE account_status SET status=#{status} WHERE id_account_status=#{id_accountStatus}";
    final String DELETE="DELETE FROM account_status WHERE id_account_status=#{id}";

    @Select(GETONE)
    @Results(value = {
            @Result(property = "id_accountStatus", column = "id_account_status"),
            @Result(property="status", column = "status"),
    })
    public AccountStatus getOne (Integer id);


    @Select(GETALL)
    @Results(value = {
            @Result(property = "id_accountStatus", column = "id_account_status"),
            @Result(property="status", column = "status"),
    })
    public List<AccountStatus> getAll();


    @Insert(INSERT)
    @Options(useGeneratedKeys = true, keyProperty = "id_accountStatus")
    public void insert(AccountStatus accountStatus);

    @Update(UPDATE)
    public void update(AccountStatus modifiedAAccountStatus);

    @Delete(DELETE)
    public void delete(Integer id);
}
