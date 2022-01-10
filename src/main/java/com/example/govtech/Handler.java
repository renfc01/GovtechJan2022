package com.example.govtech;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
            } else if (max != 0 && curr.getSalary() > max) {
                continue;
            } else if (offset > 0) {
                offset--;
            } else if (limit != 0 && userList.size() >= limit) {
                break;
            } else {
                userList.add(curr);
            }
        }

        if (sort.equals(SORT_NAME)) {
            UserNameComparator userComparator = new UserNameComparator();
            userList.sort(userComparator);
        } else if (sort.equals(SORT_SALARY)) {
            UserSalaryComparator userComparator = new UserSalaryComparator();
            userList.sort(userComparator);
        }

        return res.put("results", userList);
    }


    public boolean Update(String filename) {
        ArrayList<String> user = new ArrayList<>();
        ArrayList<Float> salary = new ArrayList<>();
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine(); // Remove header role
            while ((line = br.readLine()) != null) {
                String[] userString = line.split(",");
                if (userString.length > 2) { return false; }
                try {
                    user.add(userString[0]);
                    salary.add(Float.parseFloat(userString[1]));
                } catch (Exception e) {
                    return false;
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashMap<String, User> DB = GovtechApplication.DB;
        for (int i = 0; i < user.size(); i++) {
            if (salary.get(i) < 0) { continue; }
            DB.put(user.get(i), new User(user.get(i), salary.get(i)));
        }
        System.out.println("success");
        return true;
    }
}