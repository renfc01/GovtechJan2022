package com.example.govtech;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class Controller {
    Handler handler = new Handler();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String GetUsers(@RequestParam Map<String, String> params) throws JSONException {
        System.out.println("Greetings from users path");
        float min = params.containsKey("min") ? Float.parseFloat(params.get("min")):0;
        float max = params.containsKey("max") ? Float.parseFloat(params.get("max")):0;
        int offset = params.containsKey("offset") ? Integer.parseInt(params.get("offset")):0;
        int limit = params.containsKey("limit") ? Integer.parseInt(params.get("limit")):0;
        String sort = params.getOrDefault("sort", "");
        JSONObject result = handler.GetUsers(min, max, offset, limit, sort);
        String resString = result.toString();
        System.out.println(resString);
        return resString;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String PostUpload() {
        System.out.println("Greetings from upload path");
        return "";
    }

}