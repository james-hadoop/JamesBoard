package org.cboard.dao;

import org.cboard.pojo.DashboardRole;
import org.cboard.pojo.DashboardRoleRes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yfyuan on 2016/12/6.
 */
@Repository
public interface RoleDao {
    int save(DashboardRole role);

    List<DashboardRole> getRoleList(String userId);

    int update(DashboardRole role);

    List<DashboardRoleRes> getRoleResList();

    int saveRoleRes(List<DashboardRoleRes> list);

    int deleteRoleRes(String roleId);

    List<Long> getRoleResByResIds(String userId, String resType);

    DashboardRole getRole(String roleId);

    int deleteRole(String roleId);
}
