package com.ramble.springbootzgnetsdk.controller;

import com.ramble.springbootzgnetsdk.controller.param.ChangePTZParam;
import com.ramble.springbootzgnetsdk.controller.param.GetPTZParam;
import com.ramble.springbootzgnetsdk.dto.PtzDto;
import com.ramble.springbootzgnetsdk.support.ZgSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.controller
 * Class       ZgController
 * date        2024/1/24 10:14
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */

@Api(tags = "紫光 - api")
@Slf4j
@RestController
@RequestMapping("/zg")
public class ZgController {

    @Autowired(required = false)
    private ZgSupport zgSupport;

    /**
     * 改变 ptz
     *
     * @param param
     * @return
     * @throws InterruptedException
     */
    @ApiOperation("改变ptz")
    @PutMapping("/ptz")
    public Boolean changePtz(@RequestBody ChangePTZParam param) {
        try {
            zgSupport.setPtz(param.getIp(), param.getPort(), param.getUsername(), param.getPassword(), param.getChannelId(), param.getP(), param.getT(), param.getZ());
            return true;
        } catch (Exception e) {
            log.error("changePtz-error,e={},stackTrace={}", e.getMessage(), e.getStackTrace());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取 ptz
     *
     * @return
     */
    @ApiOperation("获取ptz")
    @PostMapping("/ptz")
    public PtzDto getPtz(@RequestBody GetPTZParam param) {
        float[] result = zgSupport.getPtz(param.getIp(), param.getPort(), param.getUsername(), param.getPassword(), null);
        PtzDto ptz = new PtzDto();
        ptz.setP(result[0]);
        ptz.setT(result[1]);
        ptz.setZ(result[2]);
        return ptz;
    }


}
