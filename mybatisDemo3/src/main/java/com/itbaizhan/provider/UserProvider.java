package com.itbaizhan.provider;

import com.itbaizhan.pojo.User;

public class UserProvider {
    // Éú³É¶¯Ì¬sqlÓï¾ä
    public String findByConditionSql(User user){
        StringBuffer sb = new StringBuffer("select * from user where 1 = 1");
        if(user.getUsername() != null && user.getUsername().length() > 0){
            sb.append(" and username like #{username}");
        }
        if(user.getSex() != null && user.getSex().length() > 0){
            sb.append(" and sex = #{sex}");
        }
        if(user.getAddress() != null && user.getAddress().length() > 0){
            sb.append(" and address = #{address}");
        }
        return sb.toString();
    }
}
