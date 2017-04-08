package org.cboard.dao;

import org.cboard.pojo.DashboardCity;
import org.cboard.pojo.DashboardUser;
import org.cboard.pojo.DashboardUserRole;
import org.cboard.pojo.DashboardUserCity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by yfyuan on 2016/12/2.
 */
@Repository
public interface UserDao {
    int save(DashboardUser user);

    List<DashboardUser> getUserList();

    int update(DashboardUser user);

    int saveUserRole(List<DashboardUserRole> list);

    int deleteUserRole(Map<String, Object> param);

    List<DashboardUserRole> getUserRoleList();

    DashboardUser getUserByLoginName(String loginName);

    int saveNewUser(String userId, String user_name, String loginName);

    int updateUserPassword(String userId, String passowrd, String newPassword);

    int deleteUserRoleByRoleId(String roleId);

    //create by lijiang
    int saveUserCity(List<DashboardUserCity> list);

    int deleteUserCity(String userId);

    List<DashboardCity> getCityList();

    List<DashboardUserCity> getUserCityList(String userId);
}
