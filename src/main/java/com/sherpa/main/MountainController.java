package com.sherpa.main;

import com.sherpa.mountain.parse.Mountain;
import com.sherpa.mountain.parse.MountainInfomationParse;
import com.sherpa.v1.mountain.MountainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MountainController {

    List<Mountain> mountains = MountainInfomationParse.shared.parse();

    @Autowired
    private MountainServiceImpl mountainServiceImpl;

    @RequestMapping("/insert/mountainInfo")
    public void insertMountainInfo() {
        System.out.print(mountains.get(0));
        mountainServiceImpl.add(mountains.get(0).toMountainDTO());
    }
}
