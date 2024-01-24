package com.ramble.springbootzgnetsdk.support;

import com.ramble.springbootzgnetsdk.handler.exception.BizServiceException;
import com.ramble.springbootzgnetsdk.lib.ZgNetSdk;
import com.ramble.springbootzgnetsdk.util.CopyUtil;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;


/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.support
 * Class       ZgSupport
 * date        2024/1/24 10:16
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */


@Slf4j
public class ZgSupport {

    private ZgNetSdk zgNetSdk;

    /**
     * 在构造函数中初始化sdk
     */
    public ZgSupport() {
        log.info("开始初始化sdk");
        zgNetSdk = ZgNetSdk.INSTANCE;
        log.info("sdk初始化完毕");
    }


    /**
     * 登录
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param deviceId  默认 0
     * @param loginMode
     * @param userId    相当于返回值
     */
    public void login(String ip, short port, String username, String password, String deviceId, int loginMode, IntByReference userId) {
        log.info("++紫光设备: 登录login 参数：ip {} port {} username {} password {} ", ip, port, username, password);
        ZgNetSdk.IDM_DEV_USER_LOGIN_INFO_S.ByValue loginInfo = new ZgNetSdk.IDM_DEV_USER_LOGIN_INFO_S.ByValue();
        ZgNetSdk.IDM_DEV_DEVICE_INFO_S.ByReference deviceInfo = new ZgNetSdk.IDM_DEV_DEVICE_INFO_S.ByReference();

        CopyUtil.copyStringToArray(ip, loginInfo.szDeviceIP);
        loginInfo.usPort = port;
        CopyUtil.copyStringToArray(username, loginInfo.szUsername);
        CopyUtil.copyStringToArray(password, loginInfo.szPassword);
        deviceId = StringUtils.isEmpty(deviceId) ? "0" : deviceId;
        CopyUtil.copyStringToArray(deviceId, loginInfo.szDeviceID);
        loginInfo.lLoginMode = loginMode;
        int loginStatus = zgNetSdk.IDM_DEV_Login(loginInfo, deviceInfo, userId);
        log.info("++紫光设备: {}登录login 返回状态：{} userId:{}", ip, loginStatus, userId.getValue());
        if (userId.getValue() > 0) {
            log.info("登录成功");
        } else {
            log.error("登录失败,userId={}", userId.getValue());
            throw new RuntimeException("紫光sdk登录失败");
        }
    }

    /**
     * 退出
     *
     * @param userId
     */
    public void logout(IntByReference userId) {
        int result = zgNetSdk.IDM_DEV_Logout(userId.getValue());
        log.info("++紫光设备: 登出logout:{}", result);
    }

    /**
     * 获取ptz
     *
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param channelId
     * @return
     */
    public float[] getPtz(String ip, short port, String username, String password, Integer channelId) {
        log.info("++紫光设备: 获取getPtz 参数：ip {} port {} username {} password {} channelId {}", ip, port, username, password, channelId);
        IntByReference userId = new IntByReference();
        login(ip, port, username, password, "0", 0, userId);
        ZgNetSdk.IDM_DEV_PTZ_PT_ZOOM_INFO_S info = new ZgNetSdk.IDM_DEV_PTZ_PT_ZOOM_INFO_S.ByReference();
        Pointer pointer = info.getPointer();
        info.write();
        int ret = zgNetSdk.IDM_DEV_GetConfig(userId.getValue(), ZgNetSdk.CONFIG_PTZ_PT_ZOOM, channelId, pointer, info.size());
        info.read();
        logout(userId);
        log.info("++紫光设备: 获取getPtz 返回状态{} ", ret);
        if (ret == 0) {
            log.info("++紫光设备: {}获取getPtz结果：p {} t {} z {} ucFocusFlag {}", ip, info.iPtX / 1000f, info.iPtY / 1000f, info.iPtZ / 1000f, info.ucFocusFlag);
            return new float[]{info.iPtX / 1000f, info.iPtY / 1000f, info.iPtZ / 1000f, info.ucFocusFlag};
        } else {
            log.info("++紫光设备: 获取getPtz失败");
            return null;
        }
    }

    /**
     * @param ip
     * @param port
     * @param username
     * @param password
     * @param channelId
     * @param p
     * @param t
     * @param z
     * @return
     */
    public boolean setPtz(String ip, short port, String username, String password, Integer channelId, float p, float t, float z) {
        log.info("++紫光设备: 设置setPtz 参数：ip {} port {} username {} password {} channelId {} p {} t {} z {}", ip, port, username, password, channelId, p, t, z);
        IntByReference userId = new IntByReference();
        login(ip, port, username, password, "0", 0, userId);
        ZgNetSdk.IDM_DEV_PTZ_PT_ZOOM_INFO_S info = new ZgNetSdk.IDM_DEV_PTZ_PT_ZOOM_INFO_S.ByReference();
        info.iPtX = (int) (p * 1000);
        info.iPtY = (int) (t * 1000);
        info.iPtZ = (int) (z * 1000);
        Pointer pointer = info.getPointer();
        info.write();
        int ret = zgNetSdk.IDM_DEV_SetConfig(userId.getValue(), ZgNetSdk.CONFIG_PTZ_PT_ZOOM, channelId, pointer, info.size());
        info.read();
        logout(userId);
        log.info("++紫光设备: 设置setPtz结果" + ret);
        return true;
    }

}
