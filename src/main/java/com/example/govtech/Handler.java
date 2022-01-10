package com.example.govtech;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;


public class Handler {
    public static String SORT_NAME = "NAME";
    public static String SORT_SALARY = "SALARY";

    public JSONObject GetUsers(float min, float max, int offset, int limit, String sort) throws JSONException {
        LinkedHashMap<String, User> DB = GovtechApplication.DB;
        JSONObject res = new JSONObject();
        ArrayList<User> userList = new ArrayList<>();
        for (String key : DB.keySet()) {
            User curr = DB.get(key);
            if (min != 0 && curr.getSalary() < min) {
                continue;
            }
            else if (max != 0 && curr.getSalary() > max) {
                continue;
            } else if (offset > 0) {
                offset--;
            }
            else if (limit != 0 && userList.size() >= limit) {
                break;
            }
            else {
                userList.add(curr);
            }
        }
        System.out.println(sort);
        if (sort.equals(SORT_NAME)) {
            UserNameComparator userComparator = new UserNameComparator();
            userList.sort(userComparator);
        } else if (sort.equals(SORT_SALARY)) {
            UserSalaryComparator userComparator = new UserSalaryComparator();
            userList.sort(userComparator);
        }

        return res.put("results", userList);
    }


}