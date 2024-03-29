package com.ramble.springbootzgnetsdk.util;

import com.sun.jna.Platform;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.util
 * Class       OSUtils
 * date        2024/1/24 10:29
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */

@Slf4j
public class OSUtils {

    // 获取操作平台信息
    public static String getOsPrefix() {
        String arch = System.getProperty("os.arch").toLowerCase();
        log.info("arch is : {}", arch);
        final String name = System.getProperty("os.name");
        String osPrefix;
        switch (Platform.getOSType()) {
            case Platform.WINDOWS: {
                if ("i386".equals(arch))
                    arch = "x86";
                osPrefix = "win32-" + arch;
            }
            break;
            case Platform.LINUX: {
                if ("x86".equals(arch)) {
                    arch = "i386";
                } else if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                osPrefix = "linux-" + arch;
                boolean arm = Platform.isARM();
                log.info("is arm ={}", arm);
                if (arm) {
                    osPrefix = "arm-" + "linux-" + arch;
                }
            }
            break;
            default: {
                osPrefix = name.toLowerCase();
                if ("x86".equals(arch)) {
                    arch = "i386";
                }
                if ("x86_64".equals(arch)) {
                    arch = "amd64";
                }
                int space = osPrefix.indexOf(" ");
                if (space != -1) {
                    osPrefix = osPrefix.substring(0, space);
                }
                osPrefix += "-" + arch;
            }
            break;

        }
        log.info("osPrefix:{}", osPrefix);
        return osPrefix;
    }

    public static String getOsName() {
        String osName = "";
        String osPrefix = getOsPrefix();
        if (osPrefix.toLowerCase().startsWith("win32-x86")
                || osPrefix.toLowerCase().startsWith("win32-amd64")) {
            osName = "win";
        } else if (osPrefix.toLowerCase().startsWith("linux-i386")
                || osPrefix.toLowerCase().startsWith("linux-amd64")
                || osPrefix.toLowerCase().startsWith("arm-linux")
        ) {
            osName = "linux";
        } else {
            log.error("unknown osName");
        }
        log.info("osName={}", osName);
        return osName;
    }


    /**
     * 获取库文件
     * 区分win、linux
     *
     * @return
     */
    public static String getLoadLibrary() {
        log.info("coming-getLoadLibrary");
        String userDir = System.getProperty("user.dir");
        log.info("getLoadLibrary-userDir={}", userDir);
        String loadLibrary = "";
        String library = "";
        String osPrefix = getOsPrefix();
        if (osPrefix.toLowerCase().startsWith("win32-x86")) {

        } else if (osPrefix.toLowerCase().startsWith("win32-amd64")) {
            loadLibrary = System.getProperty("user.dir") + File.separator + "sdk" + File.separator + "zgwin64" + File.separator;
            library = "idm_netsdk.dll";
        } else if (osPrefix.toLowerCase().startsWith("linux-i386")) {

        } else if (osPrefix.toLowerCase().startsWith("linux-amd64")) {
            //方式一：使用系统默认的加载库路径，在系统的/usr/lib文件中加入你Java工程所需要使用的so文件，然后将HCNetSDKCom文件夹下的组件库也复制到/usr/lib目录，HCNetSDKCom文件夹中的组件库不要随意更换路径进行替换。CentOS 64位需拷贝/usr/lib64下。
            //loadLibrary = "/usr/lib64/lib/hkliblinux64/";
            //方式二：配置LD_LIBRARY_PATH环境变量加载库文件；配置/etc/ld.so.conf，加上你自己的Java工程所需要的so文件的路径
            //针对方式二，无需添加前缀，程序会从linux系统的so共享库中查找libhcnetsdk.so
            loadLibrary = System.getProperty("user.dir") + File.separator + "sdk" + File.separator + "zglinux64" + File.separator;;
            //loadLibrary = System.getProperty("user.dir") + File.separator + "sdk" + File.separator + "hklinux64" + File.separator;
            library = "idm_netsdk.so";
        } else if (osPrefix.toLowerCase().startsWith("arm-linux-aarch64")) {
            loadLibrary = System.getProperty("user.dir") + File.separator + "sdk" + File.separator + "zglinux64" + File.separator;
            library = "idm_netsdk.so";
        }

        log.info("================= Load library Path :{} ==================", loadLibrary + library);
        return loadLibrary + library;
    }


}
