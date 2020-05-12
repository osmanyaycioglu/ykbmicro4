package com.ykb.cloud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/organization")
public class OrganizationRest {

    @Autowired
    private RestTemplate rt;

    @Autowired
    private EurekaClient ec;

    @GetMapping("/hello")
    public String hello() {
        String result = this.rt.getForObject("http://EMPLOYEE/employee/greet",
                                             String.class);
        return result;
    }

    @GetMapping("/hello2")
    public String hello2() {
        Application applicationLoc = this.ec.getApplication("EMPLOYEE");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc.getIPAddr() + ":" + instanceInfoLoc.getPort());
        }
        InstanceInfo ni = this.ec.getNextServerFromEureka("EMPLOYEE",
                                                          false);
        RestTemplate rtmp = new RestTemplate();
        String result = rtmp.getForObject("http://" + ni.getIPAddr() + ":" + ni.getPort() + "/employee/greet",
                                          String.class);

        return result;
    }

}

