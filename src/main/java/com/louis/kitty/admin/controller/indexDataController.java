package com.louis.kitty.admin.controller;

import com.louis.kitty.admin.core.http.HttpResult;
import com.louis.kitty.admin.core.page.PageRequest;
import com.louis.kitty.admin.model.*;
import com.louis.kitty.admin.sevice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/indexData")
public class indexDataController {

    @Autowired
    public HObjectService hObjectService;
    @Autowired
    public HObjectDataService hObjectDataService;
    @Autowired
    public BackHObjectService backHObjectService;
    @Autowired
    public BackHObjectDataService backHObjectDataService;

    @GetMapping(value = "/demo")
    public HttpResult demo(String type) {

        return HttpResult.ok("123");
    }

    @GetMapping(value = "/indexOne")
    public HttpResult indexOne(String type) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            mapResult.put("formSize", hObjectService.getCount(new HObject()));
            mapResult.put("poopleSize", hObjectDataService.getCount(new HObjectData()));
            mapResult.put("backFormSize", backHObjectService.getCount(new BackHObject()));
            mapResult.put("backPeopleSize", backHObjectDataService.getCount(new BackHObjectData()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.ok(mapResult);
    }

    @GetMapping(value = "/indexTwo")
    public HttpResult indexTwo(String type) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            mapResult.put("formSize", hObjectService.getCount(new HObject()));
            mapResult.put("poopleSize", hObjectDataService.getCount(new HObjectData()));
            mapResult.put("backFormSize", backHObjectService.getCount(new BackHObject()));
            mapResult.put("backPeopleSize", backHObjectDataService.getCount(new BackHObjectData()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.ok(mapResult);
    }

    @GetMapping(value = "/indexThree")
    public HttpResult indexThree(String type) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            mapResult.put("formSize", hObjectService.getCount(new HObject()));
            mapResult.put("poopleSize", hObjectDataService.getCount(new HObjectData()));
            mapResult.put("backFormSize", "15");
            mapResult.put("backPeopleSize", "10");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.ok(mapResult);
    }

    @GetMapping(value = "/indexFour")
    public HttpResult indexFour(String type) {
        List<Map<String, Object>> list = new LinkedList<>();
        try {
            List<HObject> hObjects = hObjectService.findAll();
            if (hObjects.size() > 0) {
                for (HObject hObject : hObjects) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", hObject.getFormname());
                    HObjectData hObjectData = new HObjectData();
                    hObjectData.setObjid(hObject.getId());
                    map.put("value", hObjectDataService.getCount(hObjectData));
                    list.add(map);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HttpResult.ok(list);
    }
}
