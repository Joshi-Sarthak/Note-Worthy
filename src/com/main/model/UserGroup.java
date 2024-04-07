package com.main.model;

import com.main.DAO.UserGroupDAO;

public class UserGroup {
    public UserGroup(String groupId, String groupName, String dateJoined) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.dateJoined = dateJoined;
        UserGroupDAO dataBaseHelper = new UserGroupDAO();
        this.creator = dataBaseHelper.getCreator(groupId);
        lastPostDate = dataBaseHelper.getLastPostDate(groupId);
    }
    public String getGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public String getCreator() {
        return creator;
    }

    public String getLastPostDate() {
        return lastPostDate;
    }

    String groupId;
    String groupName;
    String dateJoined;
    String creator;
    String lastPostDate;
    int groupMemberId;
}
