package com.ramble.springbootzgnetsdk.lib;

import com.ramble.springbootzgnetsdk.support.ZgSupport;
import com.ramble.springbootzgnetsdk.util.OSUtils;
import com.sun.jna.*;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project     springboot-zgnetsdk
 * Package     com.ramble.springbootzgnetsdk.lib
 * Class       ZgNetSdk
 * date        2024/1/24 10:22
 * author      cml
 * Email       liangchen_beijing@163.com
 * Description
 */

public interface ZgNetSdk extends Library {
    public static final int IDM_SUCCESS = 0;
    public static final int IDM_SERIAL_NUMBER_LEN = 64;
    public static final int IDM_MAC_ADDRESS_LEN = 64;
    public static final int IDM_DEVICE_ID_LEN = 64;
    public static final int IDM_DEVICE_NAME_LEN = 64;
    public static final int IDM_DEVICE_IP_MAX_LEN = 16;
    public static final int IDM_USERNAME_MAX_LEN = 64;
    public static final int IDM_PASSWORD_MAX_LEN = 64;
    public static final int PLAYBACK_GET_SEEK = 8;
    public static final int PLAYBACK_SPEED = 3;
    public static final int PTZ_LIGHT = 1;
    public static final int PTZ_WIPER = 3;
    public static final int PTZ_FOCUS_NEAR = 11;
    public static final int PTZ_FOCUS_FAR = 12;
    public static final int PTZ_ZOOM_IN = 13;
    public static final int PTZ_ZOOM_OUT = 14;
    public static final int PTZ_IRIS_OPEN = 15;
    public static final int PTZ_IRIS_CLOSE = 16;
    public static final int PTZ_UP = 21;
    public static final int PTZ_DOWN = 22;
    public static final int PTZ_LEFT = 23;
    public static final int PTZ_RIGHT = 24;
    public static final int PTZ_LEFT_UP = 25;
    public static final int PTZ_RIGHT_UP = 26;
    public static final int PTZ_LEFT_DOWN = 27;
    public static final int PTZ_RIGHT_DOWN = 28;
    public static final int PTZ_AUTO_FOCUS = 30;
    public static final int PTZ_3D_ZOOM = 32;
    public static final int PTZ_SETUP_PRESET = 51;
    public static final int PTZ_CLEAR_PRESET = 52;
    public static final int PTZ_GOTO_PRESET = 53;
    public static final int PTZ_START_RUN_CRUISE = 63;
    public static final int PTZ_STOP_RUN_CRUISE = 64;
    public static final int PTZ_CLEAR_CRUISE = 65;
    public static final int PTZ_ASSIST_FOCUS = 74;


    public static final int CONFIG_SYSTEM_TIME = 1;
    public static final int CONFIG_SYSTEM_INFO = 2;
    public static final int CONFIG_SYSTEM_INFO_V2 = 3;
    public static final int CONFIG_SYSTEM_TIME_V2 = 4;
    public static final int CONFIG_SYSTEM_RUN_MODE = 5;
    public static final int CONFIG_IMAGE_CALIBRATION = 6;
    public static final int CONFIG_IMAGE_STITCH_DISTANCE = 7;

    public static final int CONFIG_NET_PARAM = 257;
    public static final int CONFIG_NET_DDNS = 258;
    public static final int CONFIG_NET_PPPOE = 259;
    public static final int CONFIG_NET_UPNP = 260;
    public static final int CONFIG_NET_NTP = 261;
    public static final int CONFIG_NET_GB_ACCESS = 262;
    public static final int CONFIG_NET_PASSIVE = 263;

    public static final int CONFIG_CHAN_ADD_DEVICE = 769;    //添加设备 IDM_DEV_IPPARACFG_S
    public static final int CONFIG_CHAN_MODIFY_DEVICE = 770;   //修改设备 IDM_DEV_IPPARACFG_S
    public static final int CONFIG_CHAN_DELETE_DEVICE = 771;   //删除设备 IDM_DEV_IPPARACFG_S
    public static final int CONFIG_CHAN_QUERY_DEVICES = 772;   //查询设备 IDM_DEV_QUEIPPARACFG_S
    public static final int CONFIG_CHAN_DELETE_DEVICES = 773;   //批量删除设备  IDM_DEV_IPPARACFG_S 设备ID逗号隔开


    public static final int CONFIG_VIDEO_CFG = 1026;
    public static final int CONFIG_AUDIO_CFG = 1027;
    public static final int CONFIG_VIDEO_OSD_V2 = 1028;

    public static final int CONFIG_PTZ_PRESET_INFO = 1281;
    public static final int CONFIG_PTZ_CRUISE_INFO = 1282;
    public static final int CONFIG_PTZ_WATCH_INFO = 1283;
    public static final int CONFIG_PTZ_PRESET_LIST = 1284;
    public static final int CONFIG_PTZ_CALIBRATIONS_LIST = 1285;
    public static final int CONFIG_PTZ_LINKAGE_CFG = 1286;
    public static final int CONFIG_PTZ_LINKAGE_INIT_POS = 1287;
    public static final int CONFIG_LINKAGE_PTZ_POS = 1288;
    public static final int CONFIG_PTZ_PANTRACK_ABLILITY = 1289;
    public static final int CONFIG_PTZ_PT_ZOOM = 1296;
    public static final int CONFIG_PTZ_CRUISE_INFO_V2 = 1297;


    public static final int CONFIG_INTELLIGENCE_AIUNITE = 1537;
    public static final int CONFIG_INTELLIGENCE_PARKING = 1538;
    public static final int CONFIG_INTELLIGENCE_SPEED = 1539;
    public static final int CONFIG_INTELLIGENCE_PERIMETER = 1540;

    public static final int CONFIG_ALARM_OUTPUT = 1793;
    public static final int CONFIG_ALARM_LINKAGE = 1794;
    public static final int CONFIG_ALARM_GUARDPLAN = 1795;

    public static final int CONFIG_VOICE_LIST = 2049;
    public static final int CONFIG_VOICE_INFO = 2050;
    public static final int CONFIG_VOICE_LIST_V2 = 2051;

    public static final int CONFIG_DEV_IMAGE = 4097;
    public static final int CONFIG_DEV_ROI = 4098;
    public static final int CONFIG_DEV_VIDEO_COVER = 4099;


    ZgNetSdk INSTANCE = (ZgNetSdk) Native.loadLibrary(OSUtils.getLibraryPath(), ZgNetSdk.class);


    public static class IDM_DEV_DEVICE_INFO_S extends Structure {
        public static class ByReference extends IDM_DEV_DEVICE_INFO_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_DEVICE_INFO_S implements Structure.ByValue {

        }

        public byte[] szDeviceID = new byte[IDM_DEVICE_ID_LEN];
        public byte[] szDeviceName = new byte[IDM_DEVICE_NAME_LEN];
        public byte[] szSerialNum = new byte[IDM_SERIAL_NUMBER_LEN];
        public byte[] szMacAddress = new byte[IDM_MAC_ADDRESS_LEN];
        public byte[] szIP = new byte[IDM_DEVICE_IP_MAX_LEN];
        public int ulChannel;
        public short usPort;
        public byte ucRemainLoginTimes;
        public byte ucPasswordLevel;
        public byte[] szLocalIP = new byte[IDM_DEVICE_IP_MAX_LEN];
        public int ulRemainLockTime;
        public byte[] aucRes = new byte[3000];

        @SuppressWarnings("rawtypes")
        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szDeviceID");
            arrList.add("szDeviceName");
            arrList.add("szSerialNum");
            arrList.add("szMacAddress");
            arrList.add("szIP");
            arrList.add("ulChannel");
            arrList.add("usPort");
            arrList.add("ucRemainLoginTimes");
            arrList.add("ucPasswordLevel");
            arrList.add("szLocalIP");
            arrList.add("ulRemainLockTime");
            arrList.add("aucRes");
            return arrList;
        }
    }


    public static interface IDM_DEV_Login_Callback_PF extends Callback {
        public void invoke(int lUserID, int lResult,
                           IDM_DEV_DEVICE_INFO_S pstDeviceInfo, Pointer pUser);
    }

    public static class IDM_DEV_USER_LOGIN_INFO_S extends Structure {
        public byte[] szDeviceIP = new byte[IDM_DEVICE_IP_MAX_LEN];
        public short usPort;
        public short usRes;
        public byte[] szUsername = new byte[IDM_USERNAME_MAX_LEN];
        public byte[] szPassword = new byte[IDM_PASSWORD_MAX_LEN];
        public byte[] szDeviceID = new byte[IDM_DEVICE_ID_LEN];
        public int lLoginMode = 0;
        public IDM_DEV_Login_Callback_PF pfLoginCallBack;
        public Pointer pUserData;
        public byte[] szTargetIP = new byte[43];
        public byte[] aucRes = new byte[64];

        public IDM_DEV_USER_LOGIN_INFO_S() {

        }

        public static class ByReference extends IDM_DEV_USER_LOGIN_INFO_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_USER_LOGIN_INFO_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szDeviceIP");
            arrList.add("usPort");
            arrList.add("usRes");
            arrList.add("szUsername");
            arrList.add("szPassword");
            arrList.add("szDeviceID");
            arrList.add("lLoginMode");
            arrList.add("pfLoginCallBack");
            arrList.add("pUserData");
            arrList.add("szTargetIP");
            arrList.add("aucRes");
            return arrList;
        }
    }

    public static class IDM_DEV_ALARM_DEVICE_INFO_S extends Structure {
        public byte[] szDeviceID = new byte[IDM_DEVICE_ID_LEN];
        public byte[] szDeviceName = new byte[IDM_DEVICE_ID_LEN];
        public byte[] szSerialNum = new byte[IDM_DEVICE_ID_LEN];
        public byte[] szMacAddress = new byte[IDM_DEVICE_ID_LEN];
        public byte[] szIP = new byte[IDM_DEVICE_ID_LEN];
        public int ulChannel;
        public short usPort;
        public byte[] ucRes = new byte[258];

        public static class ByReference extends IDM_DEV_ALARM_DEVICE_INFO_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARM_DEVICE_INFO_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szDeviceID");
            arrList.add("szDeviceName");
            arrList.add("szSerialNum");
            arrList.add("szMacAddress");
            arrList.add("szIP");
            arrList.add("ulChannel");
            arrList.add("usPort");
            arrList.add("ucRes");
            return arrList;
        }
    }

    interface IDM_DEV_Message_Callback_PF extends Callback {
        void invoke(int lUserID, int ulCommand, Pointer pBuffer, int ulBufferSize,
                    IDM_DEV_ALARM_DEVICE_INFO_S.ByReference pstAlarmDeviceInfo, Pointer pUserData);
    }

    /*
     *@brief: 给指定告警布防绑定事件接收回调
     *@param: IN lAlarmHandle 布防句柄
     *@param: IN IDM_DEV_Message_Callback_PF 回调
     *@param: IN pUserData 用户自定义信息
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_BindAlarmCallback(int lAlarmHandle, Pointer pUserData, IDM_DEV_Message_Callback_PF pfAlarmCallback);


    public static class IDM_DEV_ALARM_PARAM_S extends Structure {
        public int ulLevel;
        public String pcSubscribes;
        public int ulSubscribesLen;
        public byte ucType;
        public byte ucLinkMode;
        public byte ucOneSubLink;
        public byte[] ucRes = new byte[127];

        public IDM_DEV_ALARM_PARAM_S() {

        }

        public static class ByReference extends IDM_DEV_ALARM_PARAM_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARM_PARAM_S implements Structure.ByValue {
            @Override
            public String toString() {
                return "ByValue{" +
                        "ulLevel=" + ulLevel +
                        ", pcSubscribes='" + pcSubscribes + '\'' +
                        ", ulSubscribesLen=" + ulSubscribesLen +
                        ", ucType=" + ucType +
                        ", ucLinkMode=" + ucLinkMode +
                        ", ucOneSubLink=" + ucOneSubLink +
                        ", ucRes=" + Arrays.toString(ucRes) +
                        '}';
            }
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulLevel");
            arrList.add("pcSubscribes");
            arrList.add("ulSubscribesLen");
            arrList.add("ucType");
            arrList.add("ucLinkMode");
            arrList.add("ucOneSubLink");
            arrList.add("ucRes");
            return arrList;
        }
    }

    public static class IDM_DEV_ALARM_BUFFER_S extends Structure {
        public int ulIndex;
        public short usType;
        public short usSubType;
        public ByteByReference pBuffer;
        public NativeLong ulBufferSize;

        public static class ByReference extends IDM_DEV_ALARM_BUFFER_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARM_BUFFER_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulIndex");
            arrList.add("usType");
            arrList.add("usSubType");
            arrList.add("pBuffer");
            arrList.add("ulBufferSize");
            return arrList;
        }
    }

    public static class IDM_DEV_ALARM_EVENT_S extends Structure {
        public IDM_DEV_ALARM_BUFFER_S stEvent;
        public NativeLong ulBufferNumber;
        public IDM_DEV_ALARM_BUFFER_S[] astBuffers = (IDM_DEV_ALARM_BUFFER_S[]) new IDM_DEV_ALARM_BUFFER_S().toArray(16);
        public int ulEventType;
        public byte[] ucRes = new byte[60];

        public IDM_DEV_ALARM_EVENT_S(Pointer pointer) {
            super(pointer);
            read();
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("stEvent");
            arrList.add("ulBufferNumber");
            arrList.add("astBuffers");
            arrList.add("ulEventType");
            arrList.add("ucRes");
            return arrList;
        }


    }

    /* 名单库信息结构体 */
    public static class IDM_DEV_REPOSITORY_INFO_S extends Structure {
        public int ulRepoID;
        public byte[] szCreaterName = new byte[64];
        public byte[] szRepoName = new byte[64];
        public byte[] szRepoDesc = new byte[256];
        public float fThreshold;
        public byte[] szCreateTime = new byte[64];
        public byte[] szUpdateTime = new byte[64];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoID");
            arrList.add("szCreaterName");
            arrList.add("szRepoName");
            arrList.add("szRepoDesc");
            arrList.add("fThreshold");
            arrList.add("szCreateTime");
            arrList.add("szUpdateTime");
            return arrList;
        }

    }

    /* 名单库信息结构体 */
    public static class IDM_DEV_REPOSITORY2_INFO_S extends Structure {
        public int ulRepoID;
        public byte[] szCreaterName = new byte[64];
        public byte[] szRepoName = new byte[64];
        public byte[] szRepoDesc = new byte[256];
        public float fThreshold;
        public byte[] szCreateTime = new byte[64];
        public byte[] szUpdateTime = new byte[64];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoID");
            arrList.add("szCreaterName");
            arrList.add("szRepoName");
            arrList.add("szRepoDesc");
            arrList.add("fThreshold");
            arrList.add("szCreateTime");
            arrList.add("szUpdateTime");
            return arrList;
        }
    }

    /* 名单库删除结构体 */
    public static class IDM_DEV_REPOSITORY_DELETE_S extends Structure {
        public int ulRepoID;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoID");
            return arrList;
        }
    }

    /* 打开名单库结构体 */
    public static class IDM_DEV_REPOSITORY_OPEN_S extends Structure {
        public int lUserID;
        public int ulRepoID;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("lUserID");
            arrList.add("ulRepoID");
            return arrList;
        }
    }

    /* 关闭名单库结构体 */
    public static class IDM_DEV_REPOSITORY_CLOSE_S extends Structure {
        public int ulRepoHandle;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoHandle");
            return arrList;
        }
    }

    /* 创建建模任务结构体 */
    public static class IDM_DEV_REPOSITORY_CREATEMODEL_S extends Structure {
        public int ulRepoID;
        public int ulRange;
        public int[] ulFaceID = new int[1024];
        public int ulFaceNum;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoID");
            arrList.add("ulRange");
            arrList.add("ulFaceID");
            arrList.add("ulFaceNum");
            return arrList;
        }
    }

    /* 查询建模任务结构体 */
    public static class IDM_DEV_REPOSITORY_QUERYMODEL_S extends Structure {
        public int ulModelingID;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulModelingID");
            return arrList;
        }
    }

    /* 查询建模任务结构体 */
    public static class IDM_DEV_REPOSITORY_QUERYMODEL_RESULT_S extends Structure {
        public int ulTotalNum;
        public int ulSuccedNum;
        public int ulFailedNum;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulTotalNum");
            arrList.add("ulSuccedNum");
            arrList.add("ulFailedNum");
            return arrList;
        }
    }

    /* 名单库查询条件结构体 */
    public static class IDM_DEV_REPOSITORY_QUERYCOND_S extends Structure {
        public int ulRepoID;
        public byte[] szCreaterName = new byte[64];
        public byte[] szRepoName = new byte[64];
        public int ulPageNo;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRepoID");
            arrList.add("szCreaterName");
            arrList.add("szRepoName");
            arrList.add("ulPageNo");
            return arrList;
        }
    }

    /* 名单库查询结果结构体 */
    public static class IDM_DEV_REPOSITORY_QUERYRESULT_S extends Structure {
        public int ulResultNum;
        public int ulTotalNum;
        public int ulPageNo;
        public IDM_DEV_REPOSITORY_INFO_S[] stResult = (IDM_DEV_REPOSITORY_INFO_S[]) new IDM_DEV_REPOSITORY_INFO_S().toArray(10);

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulResultNum");
            arrList.add("ulTotalNum");
            arrList.add("ulPageNo");
            arrList.add("stResult");
            return arrList;
        }
    }

    /* 名单库操作输入参数结构体 */
    public static final int IDM_CREATEREPO = 1;
    public static final int IDM_MODIFYREPO = 2;
    public static final int IDM_DELETEREPO = 3;
    public static final int IDM_QUERYREPO = 4;
    public static final int IDM_OPENREPO = 5;
    public static final int IDM_CLOSEREPO = 6;
    public static final int IDM_MODELREPO = 7;
    public static final int IDM_QUEMODELREPO = 8;

    public static class IDM_DEV_REPOSITORY_OPT_PARAM_S extends Structure {
        public NativeLong ulParamType;
        public tag_union union;

        public static class ByReference extends IDM_DEV_REPOSITORY_OPT_PARAM_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_REPOSITORY_OPT_PARAM_S implements Structure.ByValue {

        }

        public static class tag_union extends Union {
            public IDM_DEV_REPOSITORY_INFO_S stCreatRepo;      /* 创建名单库结构体 */
            public IDM_DEV_REPOSITORY2_INFO_S stModifyRepo;     /* 设置名单库结构体 */
            public IDM_DEV_REPOSITORY_DELETE_S stDeleteRepo;   /* 删除名单库结构体 */
            public IDM_DEV_REPOSITORY_QUERYCOND_S stQueryRepo; /* 查询名单库结构体 */
            public IDM_DEV_REPOSITORY_OPEN_S stOpenRepo;       /* 打开名单库结构体 */
            public IDM_DEV_REPOSITORY_CLOSE_S stCloseRepo;     /* 关闭名单库结构体 */
            public IDM_DEV_REPOSITORY_CREATEMODEL_S stCreateModel; /* 创建建模任务结构体 */
            public IDM_DEV_REPOSITORY_QUERYMODEL_S stQueryModel;   /* 查询建模进度结构体 */
        }

        @Override
        public void read() {
            super.read();
            switch (ulParamType.intValue()) {
                case IDM_CREATEREPO:
                    union.setType(IDM_DEV_REPOSITORY_INFO_S.class);
                    break;
                case IDM_MODIFYREPO:
                    union.setType(IDM_DEV_REPOSITORY2_INFO_S.class);
                    break;
                case IDM_DELETEREPO:
                    union.setType(IDM_DEV_REPOSITORY_DELETE_S.class);
                    break;
                case IDM_QUERYREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYCOND_S.class);
                    break;
                case IDM_OPENREPO:
                    union.setType(IDM_DEV_REPOSITORY_OPEN_S.class);
                    break;
                case IDM_CLOSEREPO:
                    union.setType(IDM_DEV_REPOSITORY_CLOSE_S.class);
                    break;
                case IDM_MODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_CREATEMODEL_S.class);
                    break;
                case IDM_QUEMODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYMODEL_S.class);
                    break;
            }
            union.read();
        }

        @Override
        public void write() {
            super.write();
            switch (ulParamType.intValue()) {
                case IDM_CREATEREPO:
                    union.setType(IDM_DEV_REPOSITORY_INFO_S.class);
                    break;
                case IDM_MODIFYREPO:
                    union.setType(IDM_DEV_REPOSITORY2_INFO_S.class);
                    break;
                case IDM_DELETEREPO:
                    union.setType(IDM_DEV_REPOSITORY_DELETE_S.class);
                    break;
                case IDM_QUERYREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYCOND_S.class);
                    break;
                case IDM_OPENREPO:
                    union.setType(IDM_DEV_REPOSITORY_OPEN_S.class);
                    break;
                case IDM_CLOSEREPO:
                    union.setType(IDM_DEV_REPOSITORY_CLOSE_S.class);
                    break;
                case IDM_MODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_CREATEMODEL_S.class);
                    break;
                case IDM_QUEMODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYMODEL_S.class);
                    break;
            }
            union.write();
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulParamType");
            arrList.add("union");
            return arrList;
        }
    }

    /* 名单库操作输出参数结构体 */
    public static class IDM_DEV_REPOSITORY_OPT_PARAMOUT_S extends Structure {
        public NativeLong ulParamType;
        public tag_union union;

        public static class ByReference extends IDM_DEV_REPOSITORY_OPT_PARAMOUT_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_REPOSITORY_OPT_PARAMOUT_S implements Structure.ByValue {

        }

        public static class tag_union extends Union {
            public int ulCreatRepoID;                      /* 创建的名单库ID */
            public int ulModifyRepoID;                     /* 修改的名单库ID */
            public int ulDeleteRepoID;                     /* 删除的名单库ID */
            public IDM_DEV_REPOSITORY_QUERYRESULT_S stQueryRepo; /* 名单库查询结果 */
            public int ulOpenRepoHandle;                   /* 打开名单库句柄 */
            public int ulReleaseRepoHandle;                /* 关闭名单库句柄 */
            public int ulModelingID;                       /* 创建的建模任务ID */
            public IDM_DEV_REPOSITORY_QUERYMODEL_RESULT_S stQueryModel; /* 建模任务查询结果 */

        }

        @Override
        public void read() {
            super.read();
            switch (ulParamType.intValue()) {
                case IDM_CREATEREPO:
                case IDM_MODIFYREPO:
                case IDM_DELETEREPO:
                    union.setType(NativeLong.class);
                    break;
                case IDM_QUERYREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYRESULT_S.class);
                    break;
                case IDM_OPENREPO:
                case IDM_CLOSEREPO:
                case IDM_MODELREPO:
                    union.setType(NativeLong.class);
                    break;
                case IDM_QUEMODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYMODEL_RESULT_S.class);
                    break;
                default:
                    union.setType(NativeLong.class);
                    break;
            }
            union.read();
        }

        @Override
        public void write() {
            super.write();
            switch (ulParamType.intValue()) {
                case IDM_CREATEREPO:
                case IDM_MODIFYREPO:
                case IDM_DELETEREPO:
                    union.setType(NativeLong.class);
                    break;
                case IDM_QUERYREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYRESULT_S.class);
                    break;
                case IDM_OPENREPO:
                case IDM_CLOSEREPO:
                case IDM_MODELREPO:
                    union.setType(NativeLong.class);
                    break;
                case IDM_QUEMODELREPO:
                    union.setType(IDM_DEV_REPOSITORY_QUERYMODEL_RESULT_S.class);
                    break;
                default:
                    union.setType(NativeLong.class);
                    break;
            }
            union.write();
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulParamType");
            arrList.add("union");
            return arrList;
        }
    }


    /* 名单库人物信息结构体 */
    public static class IDM_REPOSITORY_PERSON_INFO_S extends Structure {
        public byte[] szName = new byte[64];
        public int ulgender;
        public int ulIDType;
        public byte[] szIDNumber = new byte[64];
        public byte[] szBirthday = new byte[32];
        public int ulNation;
        public int ulProvince;
        public int ulCity;
        public int ulCounty;
        public byte[] szDesc = new byte[256];
        public byte[] szPicName = new byte[256];
        public byte[] szPicFormat = new byte[8];
        public ByteByReference pImage;
        public int ulImageLenth;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szName");
            arrList.add("ulgender");
            arrList.add("ulIDType");
            arrList.add("szIDNumber");
            arrList.add("szBirthday");
            arrList.add("ulNation");
            arrList.add("ulProvince");
            arrList.add("ulCity");
            arrList.add("ulCounty");
            arrList.add("szDesc");
            arrList.add("szPicName");
            arrList.add("szPicFormat");
            arrList.add("pImage");
            arrList.add("ulImageLenth");
            return arrList;
        }
    }

    /* 名单库人物导入结构体 */
    public static class IDM_REPOSITORY_HUMAN_IMPORT_S extends Structure {
        public short usImportType;
        public short usPersonCount;
        public IDM_REPOSITORY_PERSON_INFO_S[] stPersonList = (IDM_REPOSITORY_PERSON_INFO_S[]) new IDM_REPOSITORY_PERSON_INFO_S().toArray(10);

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("usImportType");
            arrList.add("usPersonCount");
            arrList.add("stPersonList");
            return arrList;
        }
    }

    /* 名单库人物属性修改结构体 */
    public static class IDM_REPOSITORY_HUMAN_MODIFY_S extends Structure {
        public NativeLong ulRecordID;
        public IDM_REPOSITORY_PERSON_INFO_S stPersonInfo;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRecordID");
            arrList.add("stPersonInfo");
            return arrList;
        }
    }

    /* 名单库人物删除结构体 */
    public static class IDM_REPOSITORY_HUMAN_DELETE_S extends Structure {
        public NativeLong[] ulRecordID = new NativeLong[20];
        public NativeLong ulPersonCount;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulRecordID");
            arrList.add("ulPersonCount");
            return arrList;
        }
    }

    /* 筛选条件结构体 */
    public static class IDM_REPOSITORY_HUMAN_CONDITION_S extends Structure {
        public byte[] szKey = new byte[128];
        public byte[] szValue = new byte[256];
        public NativeLong ulOperator;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szKey");
            arrList.add("szValue");
            arrList.add("ulOperator");
            return arrList;
        }
    }

    /* 排序条件结构体 */
    public static class IDM_REPOSITORY_HUMAN_ORDER_S extends Structure {
        public NativeLong ulOrder;
        public byte[] szKey = new byte[128];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulOrder");
            arrList.add("szKey");
            return arrList;
        }
    }

    /* 名单库人物查询结构体 */
    public static class IDM_REPOSITORY_HUMAN_QUERY_S extends Structure {
        public NativeLong ulPageNo;
        public NativeLong ulPageSize;
        public NativeLong ulCondLogic;
        public short usCondNum;
        public short usOrderNum;
        public NativeLong ulRecordNum;
        public NativeLong[] ulRecordID = new NativeLong[50];
        public IDM_REPOSITORY_HUMAN_CONDITION_S[] stConds = (IDM_REPOSITORY_HUMAN_CONDITION_S[]) new IDM_REPOSITORY_HUMAN_CONDITION_S().toArray(16);
        public IDM_REPOSITORY_HUMAN_ORDER_S[] stOrder = (IDM_REPOSITORY_HUMAN_ORDER_S[]) new IDM_REPOSITORY_HUMAN_ORDER_S().toArray(3);

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulPageNo");
            arrList.add("ulPageSize");
            arrList.add("ulCondLogic");
            arrList.add("usCondNum");
            arrList.add("usOrderNum");
            arrList.add("ulRecordNum");
            arrList.add("ulRecordID");
            arrList.add("stConds");
            arrList.add("stOrder");
            return arrList;
        }
    }

    /* 名单库内容操作结构体 */
    public static final int IDM_IMPORTFACE = 1;
    public static final int IDM_MODIFYFACE = 2;
    public static final int IDM_DELETEFACE = 4;
    public static final int IDM_QUERYFACE = 3;

    public static class IDM_REPOSITORY_CONTROL_PARAM_S extends Structure {
        public NativeLong ulParamType;
        public tag_union union;

        public static class ByReference extends IDM_REPOSITORY_CONTROL_PARAM_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_REPOSITORY_CONTROL_PARAM_S implements Structure.ByValue {

        }

        public static class tag_union extends Union {
            public IDM_REPOSITORY_HUMAN_IMPORT_S stImport;     /* 名单库人物导入结构体 */
            public IDM_REPOSITORY_HUMAN_MODIFY_S stModify;     /* 名单库人物属性修改结构体 */
            public IDM_REPOSITORY_HUMAN_DELETE_S stDelete;     /* 名单库人物删除结构体 */
            public IDM_REPOSITORY_HUMAN_QUERY_S stQuery;      /* 名单库人物查询结构体 */
        }

        @Override
        public void read() {
            super.read();
            switch (ulParamType.intValue()) {
                case 1:
                    union.setType(IDM_REPOSITORY_HUMAN_IMPORT_S.class);
                    break;
                case 2:
                    union.setType(IDM_REPOSITORY_HUMAN_MODIFY_S.class);
                    break;
                case 4:
                    union.setType(IDM_REPOSITORY_HUMAN_DELETE_S.class);
                    break;
                case 3:
                    union.setType(IDM_REPOSITORY_HUMAN_QUERY_S.class);
                    break;
            }
            union.read();
        }

        @Override
        public void write() {
            super.write();
            switch (ulParamType.intValue()) {
                case 1:
                    union.setType(IDM_REPOSITORY_HUMAN_IMPORT_S.class);
                    break;
                case 2:
                    union.setType(IDM_REPOSITORY_HUMAN_MODIFY_S.class);
                    break;
                case 4:
                    union.setType(IDM_REPOSITORY_HUMAN_DELETE_S.class);
                    break;
                case 3:
                    union.setType(IDM_REPOSITORY_HUMAN_QUERY_S.class);
                    break;
            }
            union.write();
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulParamType");
            arrList.add("union");
            return arrList;
        }
    }

    /* 名单库内容操作结构体 */
    public static class IDM_REPOSITORY_CONTROL_RESULT_S extends Structure {
        public NativeLong ulParamType;
        public ByteByReference pszResult;
        public NativeLong ulResultSize;

        public static class ByReference extends IDM_REPOSITORY_CONTROL_RESULT_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_REPOSITORY_CONTROL_RESULT_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulParamType");
            arrList.add("pszResult");
            arrList.add("ulResultSize");
            return arrList;
        }
    }

    /*主动注册回调函数*/
    public static interface IDM_DEV_Connect_Callback_PF extends Callback {
        public void invoke(String pszDeviceID, Pointer pUserData);
    }


    public static class IDM_DEV_PLAYBACK_COND_NAME_S extends Structure {
        public byte[] szFileName = new byte[256];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szFileName");
            return arrList;
        }
    }

    public static class IDM_DEV_TIME_PARAM_S extends Structure {
        public short usYear;                                 /* 年 */
        public short usMonth;                                /* 月 */
        public short usDay;                                  /* 日 */
        public short usHour;                                 /* 时 */
        public short usMinute;                               /* 分 */
        public short usSecond;                               /* 秒 */

        public static class ByReference extends IDM_DEV_TIME_PARAM_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_TIME_PARAM_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("usYear");
            arrList.add("usMonth");
            arrList.add("usDay");
            arrList.add("usHour");
            arrList.add("usMinute");
            arrList.add("usSecond");
            return arrList;
        }
    }

    public static class IDM_DEV_PLAYBACK_COND_TIME_S extends Structure {
        public int ulChannel;
        public int ulStreamType;
        public IDM_DEV_TIME_PARAM_S stStartTime;
        public IDM_DEV_TIME_PARAM_S stEndTime;
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulChannel");
            arrList.add("ulStreamType");
            arrList.add("stStartTime");
            arrList.add("stEndTime");
            arrList.add("aucRes");
            return arrList;
        }
    }

    public static class IDM_DEV_ALARMOUT_STATUS_S extends Structure {
        public int ulAlarmOutNum;
        public byte[] acAlarmOutStatus = new byte[128];

        public static class ByReference extends IDM_DEV_ALARMOUT_STATUS_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARMOUT_STATUS_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulAlarmOutNum");
            arrList.add("acAlarmOutStatus");
            return arrList;
        }
    }

    public static class IDM_DEV_PLAYBACK_COND_S extends Structure {
        public short usType;
        public byte ucRecordType;
        public byte ucDownloadModel;
        public byte ucRecordDomainLevel;
        public int ulChannel;
        public long llFileSize;

        public byte ucStreamTimeout;
        public tag_union union;

        public static class ByReference extends IDM_DEV_PLAYBACK_COND_S implements Structure.ByReference {


        }

        public static class ByValue extends IDM_DEV_PLAYBACK_COND_S implements Structure.ByValue {

        }

        public static class tag_union extends Union {
            public IDM_DEV_PLAYBACK_COND_NAME_S stNameCond;
            public IDM_DEV_PLAYBACK_COND_TIME_S stTimeCond;
        }

        @Override
        public void read() {
            super.read();
            switch (usType) {
                case 0:
                    union.setType(IDM_DEV_PLAYBACK_COND_NAME_S.class);
                    break;
                case 1:
                    union.setType(IDM_DEV_PLAYBACK_COND_TIME_S.class);
                    break;
            }
            union.read();
        }

        @Override
        public void write() {
            super.write();
            switch (usType) {
                case 0:
                    union.setType(IDM_DEV_PLAYBACK_COND_NAME_S.class);
                    break;
                case 1:
                    union.setType(IDM_DEV_PLAYBACK_COND_TIME_S.class);
                    break;
            }
            union.write();
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("usType");
            arrList.add("ucRecordType");
            arrList.add("ucDownloadModel");
            arrList.add("ucRecordDomainLevel");
            arrList.add("ulChannel");
            arrList.add("llFileSize");
            arrList.add("ucStreamTimeout");
            arrList.add("union");
            return arrList;
        }
    }

    /* 报警联动录像通道配置 */
    public static class IDM_DEV_ALARMOUT_LINKRECORD_S extends Structure {
        public int ulChannelNo;
        public byte[] aucRes = new byte[32];

        public static class ByReference extends IDM_DEV_ALARMOUT_LINKRECORD_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARMOUT_LINKRECORD_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulChannelNo");
            arrList.add("aucRes");
            return arrList;
        }
    }

    ;

    /* 报警联动录像通道配置 */
    public static class IDM_DEV_ALARMOUT_LINKSWITCH_S extends Structure {
        public int ulSwitchNo;
        public byte ucEnable;
        public byte[] aucRes = new byte[31];

        public static class ByReference extends IDM_DEV_ALARMOUT_LINKSWITCH_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARMOUT_LINKSWITCH_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulSwitchNo");
            arrList.add("ucEnable");
            arrList.add("aucRes");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_ALARMOUT_LINKAGE_CFG_S extends Structure {
        public int ulChannelNo;
        public int ulEventType;
        public int ulLibID;
        public byte[] szLibName = new byte[64];
        public byte ucLinkEmail;
        public byte ucLinkFTP;
        public byte ucLinkUploadCenter;
        public byte ucLinkAudio;
        public byte ucLinkRecod;

        public byte ucIsLocalAlarmOutEnabled;
        public byte ucIsTotalEnabled;
        public byte[] aucRes = new byte[1];
        public int ulRecordDelay;
        public int ulLinkRecordSize;
        public int ulLinkRecordNum;
        public IDM_DEV_ALARMOUT_LINKRECORD_S.ByReference[] pstRecordCfg;
        public int ulLinkSwitchSize;
        public int ulLinkSwitchNum;
        public IDM_DEV_ALARMOUT_LINKSWITCH_S.ByReference[] pstSwitchCfg;
        public int ulRemotChannelSize;
        public int ulRemotChanelNum;
        public IDM_DEV_REMOT_CHANNEL_S.ByReference[] pstRemotChannelCfg;
        public int ulPlayVoiceNo;
        public int ulVoiceListSize;
        public int ulVoiceListNum;
        public IDM_DEV_VOICE_INFO_S.ByReference[] pstVoiceInfoCfg;
        public byte[] aucRes2 = new byte[128];


//        public byte[] aucRes = new byte[3];
//        public int ulRecordDelay;
//        public int ulLinkRecordSize;
//        public int ulLinkRecordNum;
//        public IDM_DEV_ALARMOUT_LINKRECORD_S.ByReference[] pstRecordCfg;
//        public int ulLinkSwitchSize;
//        public int ulLinkSwitchNum;
//        public int ulRemotChannelSize;
//        public int ulRemotChanelNum;
//        public int ulPlayVoiceNo;
//        public int ulVoiceListSize;
//        public int ulVoiceListNum;
//        public IDM_DEV_ALARMOUT_LINKSWITCH_S.ByReference[] pstSwitchCfg;
//        public IDM_DEV_REMOT_CHANNEL_S.ByReference[] pstRemotChannelCfg;
//        public IDM_DEV_VOICE_INFO_S.ByReference[] pstVoiceInfoCfg;
//        public byte[] aucRes2 = new byte[128];

//        @Override
//        public void write() {
//            int i = 0;
//            i = 1;
//            i = 2;
//            super.write();
//        }

        public static class ByReference extends IDM_DEV_ALARMOUT_LINKAGE_CFG_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_ALARMOUT_LINKAGE_CFG_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulChannelNo");
            arrList.add("ulEventType");
            arrList.add("ulLibID");

            arrList.add("szLibName");
            arrList.add("ucLinkEmail");
            arrList.add("ucLinkFTP");

            arrList.add("ucLinkUploadCenter");
            arrList.add("ucLinkAudio");
            arrList.add("ucLinkRecod");

            arrList.add("ucIsLocalAlarmOutEnabled");
            arrList.add("ucIsTotalEnabled");
            arrList.add("aucRes");

            arrList.add("ulRecordDelay");
            arrList.add("ulLinkRecordSize");
            arrList.add("ulLinkRecordNum");

            arrList.add("pstRecordCfg");
            arrList.add("ulLinkSwitchSize");
            arrList.add("ulLinkSwitchNum");

            arrList.add("pstSwitchCfg");
            arrList.add("ulRemotChannelSize");
            arrList.add("ulRemotChanelNum");

            arrList.add("pstRemotChannelCfg");
            arrList.add("ulPlayVoiceNo");
            arrList.add("ulVoiceListSize");
            arrList.add("ulVoiceListNum");

            arrList.add("pstVoiceInfoCfg");
            arrList.add("aucRes2");


            return arrList;
        }


    }

    /**
     * 设置视频模式结构体
     */
    public static class IDM_DEV_SET_VIDEO_MODE_S extends Structure {
        public int uiChannelNo;/*通道号，从0开始*/
        public int iVideoMode;/*视频模式，取值范围[0-正常，1-双相，2-彩色，3-红外，4-融合，5-自动]*/

        public byte[] ucRes = new byte[64];

        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "iVideoMode", "ucRes");
        }

        public static class ByReference extends IDM_DEV_SET_VIDEO_MODE_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_SET_VIDEO_MODE_S implements Structure.ByValue {

        }
    }

    /* 设备系统信息 */
    public static class IDM_DEV_SYSTEM_INFO_S extends Structure {
        public byte[] szDeviceModel = new byte[64];                      /* 设备型号 */
        public byte[] szSerialNum = new byte[64];                        /* 设备序列号 */
        public byte[] szAuthCode = new byte[32];                         /* 设备验证码 */
        public byte[] szMacAddress = new byte[32];                       /* 设备Mac地址 */
        public byte[] szSoftwareVersion = new byte[64];                  /* 软件版本号 */
        public IDM_DEV_TIME_PARAM_S stSoftwareTime;         /* 软件生成时间 */
        public short usDeviceClass;                          /* 设备类别：0：IPC高清网络摄像机 1:ITC智能交通摄像机 100:IVR智能网络硬盘录像机 101:NVR网络硬盘录像机 */
        public short usDigitalChannelNum;                    /* 数字通道个数 */
        public byte ucAnalogChannelNum;                     /* 模拟通道个数 */
        public byte ucDiskNum;                              /* 硬盘个数 */
        public short usHttpPort;                             /* HTTP端口号，默认80 */
        public short usHttpsPort;                            /* HTTPS端口号，默认443 */
        public short usRtspPort;                             /* RTSP端口号，默认554 */
        public short usSdkPort;                              /* SDK端口号 */
        public byte ucAlarmInNum;                           /* 报警输入个数 */
        public byte ucAlarmOutNum;                          /* 报警输出个数 */
        public byte[] aucRes = new byte[240];

        public static class ByReference extends IDM_DEV_SYSTEM_INFO_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_SYSTEM_INFO_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szDeviceModel");
            arrList.add("szSerialNum");
            arrList.add("szAuthCode");
            arrList.add("szMacAddress");
            arrList.add("szSoftwareVersion");
            arrList.add("stSoftwareTime");
            arrList.add("usDeviceClass");
            arrList.add("usDigitalChannelNum");
            arrList.add("ucAnalogChannelNum");
            arrList.add("ucDiskNum");
            arrList.add("usHttpPort");
            arrList.add("usHttpsPort");
            arrList.add("usRtspPort");
            arrList.add("usSdkPort");
            arrList.add("ucAlarmInNum");
            arrList.add("ucAlarmOutNum");
            arrList.add("aucRes");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_GB28181_INFO_S extends Structure {
        public byte[] szDeviceRegID = new byte[IDM_DEVICE_ID_LEN];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szDeviceRegID");
            arrList.add("aucRes");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_STREAM_URL_S extends Structure {
        public byte[] szRtspUrl = new byte[256];       /* 主码流 */
        public byte[] szSubRtspUrl = new byte[256];    /* 子码流 */
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szRtspUrl");
            arrList.add("szSubRtspUrl");
            arrList.add("aucRes");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_IPPARACFG_S extends Structure {
        public int ulEnable;                               /* 设备是否启用，不支持设置由设备返回 0:未启用，其他:启用*/
        public byte[] szDeviceID = new byte[IDM_DEVICE_ID_LEN];          /* 设备ID，不支持设置由设备返回 */
        public byte[] szDeviceName = new byte[IDM_DEVICE_NAME_LEN];      /* 设备名称 */
        public byte[] szDeviceIP = new byte[IDM_DEVICE_IP_MAX_LEN];      /* 设备IP地址 */
        public byte[] szDeviceModel = new byte[64];    /* 设备型号，不支持设置由设备返回*/
        public short usPort;                                 /* 设备端口号 */
        public byte ucProtocol;                             /* 设备接入类型:0：ONVIF,1：GB/T28181,2：SDK,3：RTSP协议*/
        public byte ucOnline;                               /* 设备是否在线:0:离线，1:在线，不支持设置由设备返回*/
        public byte[] szUsername = new byte[IDM_USERNAME_MAX_LEN];       /* 登录用户名 */
        public byte[] szPassword = new byte[IDM_PASSWORD_MAX_LEN];       /* 登录密码 */
        public short usChannelSize;                          /* 设备通道总数，最大256*/
        public short usChannelNum;                           /* 添加的设备通道数，最大256*/
        public byte[] szChannelEnable = new byte[32];                    /* 设备接入通道使能，按位定义,0:不使能,1:使能*/
        public byte[] szLocalChanNo = new byte[256];                     /* 对应本地通道号*/
        public byte[] szLocalChanOnline = new byte[32];                  /* 对应本地通道在线状态，按位定义,0:不在线,1:在线*/
        public byte ucIsAddAllChannels;                     /* 是否添加所有获取到的通道 false受用户指定限制 true后台添加所有获取到的通道 默认为false*/
        public Pointer szMultiDeviceID;                        /* 内存用户自行管理 删除多设备时传入以,分割的设备ID构成的字符串 如"id1,id2"*/
        public short usHttpPort;                                /* http访问端口*/
        public short usHttpsPort;                                /* https访问端口*/
        public short usRtspPort;                                /* rtsp端口 */
        public byte[] aucRes = new byte[21];
        public tag_union union;

        public static class tag_union extends Union {
            public IDM_DEV_GB28181_INFO_S stGB28181Info;
            public IDM_DEV_STREAM_URL_S stStreamUrl;
        }

        public IDM_DEV_IPPARACFG_S() {
            super();
        }

        @Override
        public void read() {
            super.read();
            switch (ucProtocol) {
                case 1:
                    union.setType(IDM_DEV_GB28181_INFO_S.class);
                    break;
                default:
                    union.setType(IDM_DEV_STREAM_URL_S.class);
                    break;
            }
            union.read();
        }

        @Override
        public void write() {
            super.write();
            switch (ucProtocol) {
                case 1:
                    union.setType(IDM_DEV_GB28181_INFO_S.class);
                    break;
                default:
                    union.setType(IDM_DEV_STREAM_URL_S.class);
                    break;
            }
            union.write();
        }

        public static class ByReference extends IDM_DEV_IPPARACFG_S implements Structure.ByReference {

        }

        public static class ByValue extends IDM_DEV_IPPARACFG_S implements Structure.ByValue {

        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulEnable");
            arrList.add("szDeviceID");
            arrList.add("szDeviceName");
            arrList.add("szDeviceIP");
            arrList.add("szDeviceModel");
            arrList.add("usPort");
            arrList.add("ucProtocol");
            arrList.add("ucOnline");
            arrList.add("szUsername");
            arrList.add("szPassword");
            arrList.add("usChannelSize");
            arrList.add("usChannelNum");
            arrList.add("szChannelEnable");
            arrList.add("szLocalChanNo");
            arrList.add("szLocalChanOnline");

            arrList.add("ucIsAddAllChannels");
            arrList.add("szMultiDeviceID");
            arrList.add("usHttpPort");
            arrList.add("usHttpsPort");

            arrList.add("usRtspPort");

            arrList.add("aucRes");
            arrList.add("union");
            return arrList;


        }
    }

    ;

    public static class IDM_DEV_QUEIPPARACFG_S extends Structure {
        public int ulDevNum;
        public IDM_DEV_IPPARACFG_S.ByReference[] pstIPCfg;

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulDevNum");
            arrList.add("pstIPCfg");
            return arrList;
        }

        public static class ByReference extends IDM_DEV_QUEIPPARACFG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_QUEIPPARACFG_S implements Structure.ByValue {
        }
    }

    ;

    public static class IDM_DEV_POINT_S extends Structure {
        public short usX;                                    /* X坐标：[0,10000] */
        public short usY;                                    /* Y坐标：[0,10000] */

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("usX");
            arrList.add("usY");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_POINTREGION_S extends Structure {
        public int ulValidNum;                               /* 有效点数量*/
        public IDM_DEV_POINT_S[] stPointList = (IDM_DEV_POINT_S[]) new IDM_DEV_POINT_S().toArray(10);

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulValidNum");
            arrList.add("stPointList");
            return arrList;
        }
    }

    ;

    public static class IDM_DEV_INTELLIGENCE_AIUNITE_CFG_S extends Structure {
        public int ulChannelNo;                              /* 通道号*/
        public byte ucSensitivity;                            /* 检测灵敏度 1~100*/
        public byte ucVehicleStatistic;                       /* 是否开启车流量统计。0-关闭，1-开启*/
        public byte ucSnapShot;                               /* 快照开关。0-关闭，1-开启*/
        public byte ucFaceCompare;                            /* 人脸比对开关。0-关闭，1-开启*/
        public byte ucPlateExpos;                             /* 车牌曝光开关。0-关闭，1-开启*/
        public byte ucAILed;                                  /* AI补光开关。0-关闭，1-开启*/
        public byte ucAILedTime;                              /* AI补光持续时间 1~100 秒*/
        public byte ucFaceExpos;                              /* 人脸曝光开关。0-关闭，1-开启*/
        public byte ucFaceExposLumi;                          /* 人脸曝光亮度 0~100*/
        public byte ucMaskVerify;                             /* 口罩校验开关。0-关闭，1-开启*/
        public short usFaceExposTime;                         /* 人脸曝光时间。 1~3600 秒*/
        public short usFaceAnaInterval;                       /* 人脸分析时间间隔。 1~600 秒*/
        public short usFollowTime;                            /* 尾随时间*/
        public byte ucFollowSpeak;                            /* 尾随播报开关。0-关闭，1-开启*/
        public byte ucRegionAttr;                             /* 区域属性。1-选中区域，2-屏蔽区域*/
        public byte ucDetectMode;                             /* 检测模式。0-混行检测，1-机动车检测，2-非机动车检测，3-行人检测*/
        public byte ucImageQuality;                           /* 图片质量。0~100*/
        public short usDetectTime;                            /* 检测时间*/
        public byte ucMaxPointNum;                            /* 规则框坐标点最大值 3~10*/
        public byte ucMinPointNum;                            /* 规则框坐标点最小值 3~10*/
        public byte ucMaxRegionNum;                           /* 最大规则区域个数 1~4*/
        public byte ucMinRegionNum;                           /* 最小规则区域个数 1~4*/
        public byte ucPerson;                                /* 行人解析开关。0-关闭，1-开启*/
        public byte ucVehicle;                                /* 车辆解析开关。0-关闭，1-开启*/
        public byte ucNonVehicle;                             /* 非机动车解析开关。0-关闭，1-开启*/
        public byte ucFace;                                   /* 人脸解析开关。0-关闭，1-开启*/
        public short usNonTruckTime;                          /* 非卡车上报时间间隔*/
        public byte ucNonTruckFilter;                         /* 非卡车过滤开关。0-关闭，1-开启*/
        public byte ucRuleRegionNum;                          /* 合一算法规则区域个数*/
        public byte ucTruckRegionNum;                         /* 非卡车过滤区域个数*/
        public byte aucRes;
        public IDM_DEV_POINTREGION_S stMinRegion;              /* 最小检测区域*/
        public IDM_DEV_POINTREGION_S stMaxRegion;              /* 最大检测区域*/
        public IDM_DEV_POINTREGION_S[] stRuleRegion = (IDM_DEV_POINTREGION_S[]) new IDM_DEV_POINTREGION_S().toArray(4);         /* 合一算法规则区域列表*/
        public IDM_DEV_POINTREGION_S[] stTruckRegion = (IDM_DEV_POINTREGION_S[]) new IDM_DEV_POINTREGION_S().toArray(4);        /* 非卡车过滤区域*/
        public byte[] aucRes2 = new byte[128];

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ulChannelNo");
            arrList.add("ucSensitivity");
            arrList.add("ucVehicleStatistic");
            arrList.add("ucSnapShot");
            arrList.add("ucFaceCompare");
            arrList.add("ucPlateExpos");
            arrList.add("ucAILed");
            arrList.add("ucAILedTime");
            arrList.add("ucFaceExpos");
            arrList.add("ucFaceExposLumi");
            arrList.add("ucMaskVerify");
            arrList.add("usFaceExposTime");
            arrList.add("usFaceAnaInterval");
            arrList.add("usFollowTime");
            arrList.add("ucFollowSpeak");
            arrList.add("ucRegionAttr");
            arrList.add("ucDetectMode");
            arrList.add("ucImageQuality");
            arrList.add("usDetectTime");
            arrList.add("ucMaxPointNum");
            arrList.add("ucMinPointNum");
            arrList.add("ucMaxRegionNum");
            arrList.add("ucMinRegionNum");
            arrList.add("ucPerson");
            arrList.add("ucVehicle");
            arrList.add("ucNonVehicle");
            arrList.add("ucFace");
            arrList.add("usNonTruckTime");
            arrList.add("ucNonTruckFilter");
            arrList.add("ucRuleRegionNum");
            arrList.add("ucTruckRegionNum");
            arrList.add("aucRes");
            arrList.add("stMinRegion");
            arrList.add("stMaxRegion");
            arrList.add("stRuleRegion");
            arrList.add("stTruckRegion");
            arrList.add("aucRes2");
            return arrList;
        }
    }

    ;


    public static class IDM_DEV_PTZ_3D_ZOOM_INFO_S extends Structure {
        public short usTopX;                               /* 起始X坐标：[0,10000] */
        public short usTopY;                               /* 起始Y坐标：[0,10000] */
        public short usBottomX;                            /* 结束X坐标：[0,10000] */
        public short usBottomY;                            /* 结束Y坐标：[0,10000] */

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("usTopX");
            arrList.add("usTopY");
            arrList.add("usBottomX");
            arrList.add("usBottomY");
            return arrList;
        }
    }

    public static class IDM_DEV_PTZ_CONTROL_INFO_S extends Structure {
        public byte ucSpeed;                                /* 速度：[1,100], 0 表示默认速度50 */
        public byte ucAction;                               /* 动作：0-开始 1-停止 */
        public byte ucPtNo;                                /* 云台编号 默认值为0 */
        public byte[] aucRes = new byte[2];

        public static class ByReference extends IDM_DEV_PTZ_CONTROL_INFO_S implements Structure.ByReference {
        }


        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("ucSpeed");
            arrList.add("ucAction");
            arrList.add("ucPtNo");
            arrList.add("aucRes");
            return arrList;
        }
    }

    public static interface IDM_DEV_Exception_Callback_PF extends Callback {
        public void invoke(int lUserID, int lHandle, int ulType, Pointer pUserData);
    }


    /*音频播报文件上传扩展参数*/
    public static class IDM_DEV_TRANS_EXTRA_ALARM_AUDIO_S extends Structure {
        public int[] uiBindEvents = new int[10];       /*音频文件绑定的事件id, 暂时限定最多绑定10个事件,再多考虑使用事件族*/
        public int uiEventCount;                        /*绑定的事件个数*/
        public byte[] uRes = new byte[256];             /*保留扩展*/

        public static class ByReference extends IDM_DEV_TRANS_EXTRA_ALARM_AUDIO_S implements Structure.ByReference {
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("uiBindEvents");
            arrList.add("uiEventCount");
            arrList.add("uRes");
            return arrList;
        }
    }

    /*文件传输参数结构体*/
    public static class IDM_DEV_TRANS_FILE_INFOS_S extends Structure {

        public byte[] szTaskName = new byte[128];             /*任务名称*/
        public int ulSrvType;                               /*业务类型：0-通用文件上传 1-配置文件上传 2-算法包文件上传 3-音频播报文件上传 4-设备升级包上传 100-通用文件下载 101-配置文件下载 102-算法包文件下载 999-所有*/
        public int ulFileID;                                /*文件id*/
        public byte[] szFileMD5 = new byte[64];              /*文件MD5值*/
        public int ulFileSize;                              /*文件大小*/
        public byte[] szFileDestPath = new byte[256];      /*文件传输目的路径*/
        public byte[] szFileName = new byte[256];             /*文件名称*/
        public byte cHasExtraParam;                        /*是否有扩展参数. 1有,其它值没有*/
        public Pointer pstExtraParam;                               /*扩展参数结构体指针*/

        public static class ByReference extends IDM_DEV_TRANS_FILE_INFOS_S implements Structure.ByReference {
        }

        @Override
        protected List getFieldOrder() {
            List<String> arrList = new ArrayList<>();
            arrList.add("szTaskName");
            arrList.add("ulSrvType");
            arrList.add("ulFileID");
            arrList.add("szFileMD5");
            arrList.add("ulFileSize");
            arrList.add("szFileDestPath");
            arrList.add("szFileName");
            arrList.add("cHasExtraParam");
            arrList.add("pstExtraParam");
            return arrList;
        }
    }


    /*
     *@brief: 获取SDK版本号
     *@return: 版本号
     */
    public int IDM_DEV_GetSDKVersion();

    /*
     *@brief: SDK初始化
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_Init();

    /*
     *@brief: 设备登录
     *@param: IN stLoginInfo 登录结构体
     *@param: OUT pstDeviceInfo 设备信息
     *@param: OUT plUserID 登录成功分配的设备句柄
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_Login(IDM_DEV_USER_LOGIN_INFO_S.ByValue stLoginInfo, IDM_DEV_DEVICE_INFO_S.ByReference pstDeviceInfo, IntByReference plUserID);

    /*
     *@brief: 设备登出
     *@param: IN lUserID 设备句柄
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_Logout(int lUserID);

    /*
     *@brief: 设置报警布防回调函数
     *@param: IN ulIndex 布防回调函数索引 暂不支持多个回调 默认0
     *@param: IN pfAlarmCallback 报警消息回调函数
     *@param: IN pUserData 用户数据
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_SetAlarmCallback(int ulIndex, IDM_DEV_Message_Callback_PF pfAlarmCallback, Pointer pUserData);

    /*
     *@brief: 建立报警布防上传通道
     *@param: IN lUserID 设备句柄
     *@param: IN stAlarmParam 报警布防参数
     *@param: OUT plAlarmHandle 布防句柄
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_StartAlarmUp(int lUserID, IDM_DEV_ALARM_PARAM_S.ByValue stAlarmParam, IntByReference plAlarmHandle);

    /*
     *@brief: 撤销已建立的布防通道
     *@param: IN lAlarmHandle 布防句柄
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_StopAlarmUp(int lAlarmHandle);

    /*
     *@brief: 名单库库配置
     *@param: IN lUserID 设备句柄
     *@param: IN stParamIn 输入名单库操作信息
     *@param: OUT pstParamOut 输出名单库操作结果信息
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public NativeLong IDM_DEV_RepositoryOpt(NativeLong lUserID, IDM_DEV_REPOSITORY_OPT_PARAM_S.ByValue stParamIn, IDM_DEV_REPOSITORY_OPT_PARAMOUT_S.ByReference pstParamOut);

    /*
     *@brief: 名单库库内容配置
     *@param: IN plRepoHandle 通过IDM_DEV_RepositoryOpt加载名单库返回的句柄
     *@param: IN stParam 输入命令和对应参数的结构体
     *@param: OUT pszResult 输出操作结果JSON字符串数据的缓冲指针
     *@param: OUT pulResultSize 输出数据的缓冲长度
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public NativeLong IDM_DEV_RepositoryControl(NativeLong lRepoHandle, IDM_REPOSITORY_CONTROL_PARAM_S.ByValue stParam, IDM_REPOSITORY_CONTROL_RESULT_S.ByReference pstResult);

    /*
     *@brief: 开启被动模式监听服务
     *@param: IN usSerPort 监听端口
     *@param: IN pUserData 回调函数返回的用户数据
     *@param: IN pfConnectCallback 设备连接后从回调函数中返回
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public NativeLong IDM_DEV_StartServer(short usSerPort, Pointer pUserData, IDM_DEV_Connect_Callback_PF pfConnectCallback);

    /*
     *@brief: 关闭被动模式监听服务
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public NativeLong IDM_DEV_StopServer();


    public int IDM_DEV_DownloadFile(int lUserID, IDM_DEV_PLAYBACK_COND_S.ByReference pstDownloadCond, String pcSavedFileName, IntByReference plFileHandle);

    /*
     *@brief: 设置设备报警输出
     *@param: IN lUserID 设备句柄
     *@param: IN ulAlarmID 报警输出号
     *@param: IN ulAlarmOutStatus 0-停止输出，1-输出
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_SetAlarmOut(int lUserID, int ulAlarmID, int ulAlarmOutStatus);

    /*
     *@brief: 获取设备报警输出
     *@param: IN lUserID 设备句柄
     *@param: OUT pstAlarmOutStatus 报警输出状态
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_GetAlarmOut(int lUserID, IDM_DEV_ALARMOUT_STATUS_S.ByReference pstAlarmOutStatus);

    /*
     *@brief: 获取设备参数
     *@param: IN lUserID 设备句柄
     *@param: IN ulCommand 设备配置命令
     *@param: IN ulChannel 通道号
     *@param: OUT pBuffer 接收数据的缓冲指针
     *@param: IN ulBufferSize 接收数据的缓冲长度
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_GetConfig(int lUserID, int ulCommand, int lChannel, Pointer pBuffer, int ulBufferSize);

    /*
     *@brief: 设置设备参数
     *@param: IN lUserID 设备句柄
     *@param: IN ulCommand 设备配置命令
     *@param: IN ulChannel 通道号
     *@param: IN pBuffer 输入数据的缓冲指针
     *@param: IN ulBufferSize 输入数据的缓冲长度
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_SetConfig(int lUserID, int ulCommand, int ulChannel, Pointer pBuffer, int ulBufferSize);


    /*
     *@brief: 设置异常消息接收回调函数
     *@param: IN pfExceptionCallback 异常消息回调函数
     *@param: IN pUserData 用户数据
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_SetExceptionCallback(IDM_DEV_Exception_Callback_PF pfExceptionCallback, Pointer pUserData);

    /*
     *@brief: 云台控制
     *@param: IN lUserID 设备句柄
     *@param: IN ulChannel 通道号
     *@param: IN ulCommand 命令号
     *@param: IN pBuffer 参数指针，根据命令号对应不同结构体
     *@param: IN ulBufferSize 参数长度
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    public int IDM_DEV_PTZControl(int lUserID, int ulChannel, int ulCommand, Pointer pBuffer, int ulBufferSize);

    /*
     *@brief: 设置保存日志到文件
     *@param: IN ucLogLevel 日志等级  0-关闭日志 1-error级别 2-info级别 3-debug级别
     *@param: IN ucLogMode 日志存储模式 未实现 填0
     *@param: IN szLogDirectory 日志文件路径
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SaveLogToFile(byte ucLogLevel, byte ucLogMode, String szLogDirectory);


    /*
     *@brief: 创建文件上传任务
     *@param: IN lUsrID 设备句柄
     *@param: IN psTransFileInfo 创建文件上传任务参数结构体
     *@param: OUT plTaskID 创建文件上传任务返回任务ID
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_CreatUploadFileTask(int lUserID, IDM_DEV_TRANS_FILE_INFOS_S.ByReference psTransFileInfo, IntByReference plTaskID);

    /*
     *@brief: 上传文件
     *@param: IN lUsrID 设备句柄
     *@param: IN pSendBuf 文件流数据缓冲区
     *@param: IN ulBufSize 文件流数据大小
     *@param: IN lTaskID  文件上传任务ID
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UploadFile(int lUserID, Pointer pSendBuf, int ulBufSize, int lTaskID);

    /*
     *@brief: 创建文件上传输任务
     *@param: IN lUsrID 设备句柄
     *@param: IN TaskID 文件传输任务ID
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DestroyFileTransTask(int lUserID, int TaskID);


    public static class IDM_DEV_IP_ADDRESS_S extends Structure {
        // IPv4地址
        public byte[] szIPv4 = new byte[16];
        // IPv6地址
        public byte[] szIPv6 = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szIPv4", "szIPv6");
        }

        public static class ByReference extends IDM_DEV_IP_ADDRESS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_IP_ADDRESS_S implements Structure.ByValue {
        }
    }


    public static class IDM_DEV_GB_S28181_INFO_S extends Structure {
        public byte[] szDeviceRegID = new byte[64];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDeviceRegID", "aucRes");
        }

        public static class ByReference extends IDM_DEV_GB_S28181_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_GB_S28181_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TIMESPAN_PARAM_S extends Structure {
        // 时
        public short usHour;
        // 分
        public short usMinute;
        // 秒
        public short usSecond;
        public byte[] aucRes = new byte[2];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usHour", "usMinute", "usSecond", "aucRes");
        }

        public static class ByReference extends IDM_DEV_TIMESPAN_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TIMESPAN_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VIDEO_ENCODE_PARAM_S extends Structure {
        // 码流类型：0-主码流 1-子码流 2-三码流
        public byte ucStreamType;
        // 视频类型：0-视频流 1-复合流
        public byte ucVideoType;
        // 视频编码类型： 0-MPEG2 1--MJPEG 2-H264 3-H265 4-MPEG4
        public byte ucEncodeType;
        // 编码等级(复杂度)：0-低 1-中 2-高
        public byte ucEncodeLevel;
        // 是否启用智能编码：0-否 1-是
        public byte ucSmartEncode;
        // 图像质量：0-低 1-中 2-高
        public byte ucQuality;
        // 码率类型：0-定码率 1-变码率
        public byte ucBitrateType;
        // 码流平滑：[1,100]
        public byte ucSmoothing;
        // I帧间隔：[1,400]
        public short usIFrameInterval;
        // 视频分辨率：        // 0-D1(704*576)        // 1-CIF(352*288/352*240)        // 2-QCIF(176*144/176*120)        // 3-DCIF(528*384/528*320)        // 4-2CIF(704*288/704*240)        // 5-VGA(640*780)        // 6-SVGA(800*600)        // 7-XVGA(1280*960)        // 8-QVGA(320*240)        // 9-720P(1280*720)        // 10-1080P(1920*1080)        // 11-QQVGA(160*120)        // 12-XGA(1024*768)        // 13-SXGA(1280*1024)        // 14-QSXGA(2560*2048)        // 15-HSXGA(5120*4096)        // 16-UXGA(1600*1200)        // 17-QUXGA(3200*2400)        // 18-1.3M(1280*960)        // 19-HXGA(4096*3072)        // 20-HUXGA(6400*4800)        // 21-WXGA(1280*800)        // 22-WXGA+(1440*900)        // 23-WSXGA+(1680*1050)        // 24-WUXGA(1920*1200)        // 25-WQXGA(2560*1600)        // 26-2160P(3840*2160)        // 27-900P(1600*900)        // 28-1440P(2560*1440)        // 29-WQUXGA(3840*2400)        // 30-4320P(7680*4320)
        public short usResolution;
        // 视频帧率(fps)
        public short usFrameRate;
        // 视频码率
        public short usBitrate;
        // 视频图像宽度 非必填,当usResolution=99时必须要填写实际分辨率
        public short usImageWidth;
        // 视频图像高度 非必填,当usResolution=99时必须要填写实际分辨率
        public short usImageHeight;
        // 第三码流是否开启,非必填 1开启,0关闭,默认0, 适用A3工程商款
        public byte ucThirdStreamEnable;
        // BNC接口模拟输出开关, 非必填. 1开启,0关闭, 默认0
        public byte ucBncOutputEnable;
        public byte[] aucRes = new byte[10];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucStreamType", "ucVideoType", "ucEncodeType", "ucEncodeLevel", "ucSmartEncode", "ucQuality", "ucBitrateType", "ucSmoothing", "usIFrameInterval", "usResolution", "usFrameRate", "usBitrate", "usImageWidth", "usImageHeight", "ucThirdStreamEnable", "ucBncOutputEnable", "aucRes");
        }

        public static class ByReference extends IDM_DEV_VIDEO_ENCODE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VIDEO_ENCODE_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_AUDIO_ENCODE_PARAM_S extends Structure {
        // 码流类型：0-主码流 1-子码流 2-三码流
        public byte ucStreamType;
        // 音频编码类型：1-ADPCM 2-G722 3-G.711U 4-G711.A 5-G.726 6-AAC 7-MP2L2 8-PCM 9-G722.1
        public byte ucEncodeType;
        // 音频码率：1-5.3Kbps 2-6.3Kbps 3-8Kbps 4-24Kbps 5-40Kbps 6-48Kbps 7-56Kbps 8-64Kbps 9-80Kbps 10-96Kbps 11-112Kbps 12-144Kbps 13-160Kbps 14-192Kbps 15-224Kbps 16-256Kbps 17-320Kbps 18-384Kbps
        public byte ucBitrate;
        // 音频采样率：1-4KHz 2-8KHz 3-11.025KHz 4-16KHz 5-20KHz 6-22.05KHz 7-32KHz 8-32KHz 9-48KHz 10-64KHz 11-96KHz 12-128KHz 13-192KHz
        public byte ucSamplingRate;
        // 音频输入类型：1-MicIn 2-LineIn
        public byte ucAudioInType;
        // 音频输入音量：[0,100]
        public byte ucAudioInVolume;
        // 音频输出音量：[0,100]
        public byte ucAudioOutVolume;
        // 是否开启环境噪声过滤：0-关闭 1-开启
        public byte ucNoiseReduce;
        public byte[] aucRes = new byte[16];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucStreamType", "ucEncodeType", "ucBitrate", "ucSamplingRate", "ucAudioInType", "ucAudioInVolume", "ucAudioOutVolume", "ucNoiseReduce", "aucRes");
        }

        public static class ByReference extends IDM_DEV_AUDIO_ENCODE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_AUDIO_ENCODE_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_STREAM_PARAM_S extends Structure {
        // 视频编码参数
        public IDM_DEV_VIDEO_ENCODE_PARAM_S stVideoEncode;
        // 音频编码参数
        public IDM_DEV_AUDIO_ENCODE_PARAM_S stAudioEncode;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("stVideoEncode", "stAudioEncode");
        }

        public static class ByReference extends IDM_DEV_STREAM_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_STREAM_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_RGB_PARAM_S extends Structure {
        // R：[0,255]
        public byte ucRed;
        // G：[0,255]
        public byte ucGreen;
        // B：[0,255]
        public byte ucBlue;
        public byte ucRes;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucRed", "ucGreen", "ucBlue", "ucRes");
        }

        public static class ByReference extends IDM_DEV_RGB_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_RGB_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_OSD_ITEMS_PARAM_S extends Structure {
        // 字符叠加项左上角坐标X：[0,10000]
        public short usX;
        // 字符叠加项左上角坐标Y：[0,10000]
        public short usY;
        // 字符叠加内容
        public byte[] szContent = new byte[64];
        // 是否显示字符叠加项
        public byte ucShow;
        public byte[] aucRes = new byte[3];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usX", "usY", "szContent", "ucShow", "aucRes");
        }

        public static class ByReference extends IDM_DEV_OSD_ITEMS_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_OSD_ITEMS_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VIDEO_OSD_PARAM_S extends Structure {
        // OSD对齐方式：0-自适应 1-左对齐 2-右对齐
        public byte ucOsdAlign;
        // OSD属性：0-透明+闪烁 1-透明+不闪烁 2-不透明+闪烁 3-不透明+不闪烁
        public byte ucOsdAttribute;
        // OSD字体大小：0-16x16 1-32x32 2-48x48 3-64x64
        public byte ucFontSize;
        // OSD字体颜色类型：0-黑白 1-自定义
        public byte ucColorType;
        // OSD字体自定义颜色
        public IDM_DEV_RGB_PARAM_S stColor;
        // 是否显示日期：0-否 1-是
        public byte ucShowDate;
        // 是否显示星期：0-否 1-是
        public byte ucShowWeek;
        // 时间格式：0-12小时制 1-24小时制
        public byte ucTimeFormat;
        // 日期格式：0-XXXX-XX-XX年月日 1-XX-XX-XXXX月日年 2-XX-XX-XXXX日月年
        public byte ucDateFormat;
        // 时间日期左上角坐标X：[0,10000]
        public short usTimeX;
        // 时间日期左上角坐标Y：[0,10000]
        public short usTimeY;
        // 是否显示通道名称：0-否 1-是
        public byte ucShowChannelName;
        public byte ucRes;
        // 通道名称
        public byte[] szChannelName = new byte[64];
        // 通道名称左上角坐标X：[0,10000]
        public short usChannelNameX;
        // 通道名称左上角坐标Y：[0,10000]
        public short usChannelNameY;
        // 字符叠加项
        public IDM_DEV_OSD_ITEMS_PARAM_S[] astOsdItems = new IDM_DEV_OSD_ITEMS_PARAM_S[8];
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucOsdAlign", "ucOsdAttribute", "ucFontSize", "ucColorType", "stColor", "ucShowDate", "ucShowWeek", "ucTimeFormat", "ucDateFormat", "usTimeX", "usTimeY", "ucShowChannelName", "ucRes", "szChannelName", "usChannelNameX", "usChannelNameY", "astOsdItems", "aucRes");
        }

        public static class ByReference extends IDM_DEV_VIDEO_OSD_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VIDEO_OSD_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_OSD_ITEMS_PARAM_S_V2 extends Structure {
        // 字符叠加项左上角坐标X：[0,10000]
        public short usX;
        // 字符叠加项左上角坐标Y：[0,10000]
        public short usY;
        // 是否显示字符叠加项
        public byte ucShow;
        // 字符叠加内容 和V1主要差距
        public byte[] szContent = new byte[128];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usX", "usY", "ucShow", "szContent", "aucRes");
        }

        public static class ByReference extends IDM_DEV_OSD_ITEMS_PARAM_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_OSD_ITEMS_PARAM_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VIDEO_OSD_PARAM_S_V2 extends Structure {
        // OSD对齐方式：0-自适应 1-左对齐 2-右对齐
        public byte ucOsdAlign;
        // OSD属性：0-透明+闪烁 1-透明+不闪烁 2-不透明+闪烁 3-不透明+不闪烁
        public byte ucOsdAttribute;
        // OSD字体大小：0-16x16 1-32x32 2-48x48 3-64x64
        public byte ucFontSize;
        // OSD字体颜色类型：0-黑白 1-自定义
        public byte ucColorType;
        // OSD字体自定义颜色
        public IDM_DEV_RGB_PARAM_S stColor;
        // 是否显示日期：0-否 1-是
        public byte ucShowDate;
        // 是否显示星期：0-否 1-是
        public byte ucShowWeek;
        // 时间格式：0-12小时制 1-24小时制
        public byte ucTimeFormat;
        // 日期格式：0-XXXX-XX-XX年月日 1-XX-XX-XXXX月日年 2-XX-XX-XXXX日月年
        public byte ucDateFormat;
        // 时间日期左上角坐标X：[0,10000]
        public short usTimeX;
        // 时间日期左上角坐标Y：[0,10000]
        public short usTimeY;
        // 是否显示通道名称：0-否 1-是
        public byte ucShowChannelName;
        public byte ucRes;
        // 通道名称左上角坐标X：[0,10000]
        public short usChannelNameX;
        // 通道名称左上角坐标Y：[0,10000]
        public short usChannelNameY;
        // 通道名称
        public byte[] szChannelName = new byte[128];
        public byte[] aucRes = new byte[128];
        // 字符叠加项
        public IDM_DEV_OSD_ITEMS_PARAM_S_V2[] astOsdItems = (IDM_DEV_OSD_ITEMS_PARAM_S_V2[]) new IDM_DEV_OSD_ITEMS_PARAM_S_V2().toArray(8);

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucOsdAlign", "ucOsdAttribute", "ucFontSize", "ucColorType", "stColor", "ucShowDate", "ucShowWeek", "ucTimeFormat", "ucDateFormat", "usTimeX", "usTimeY", "ucShowChannelName", "ucRes", "usChannelNameX", "usChannelNameY", "szChannelName", "aucRes", "astOsdItems");
        }

        public static class ByReference extends IDM_DEV_VIDEO_OSD_PARAM_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VIDEO_OSD_PARAM_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ETHERNET_PARAM_S extends Structure {
        // 网卡编号
        public int ulEthernetNo;
        // 网卡名称
        public byte[] szEthernetName = new byte[32];
        // 网卡类型：0-自适应 1-10M半双工 2-10M全双工 3-100M半双工 4-100M全双工 5-1000M全双工
        public int ulType;
        // 是否启用DHCP：0-否 1-是
        public int lDhcpEnable;
        // IPv6地址分配方式：0-自动获取 1-手动配置 2-路由公告
        public int ulIPv6Mode;
        // MTU
        public int ulMtu;
        // MAC地址
        public byte[] szMacAdderss = new byte[64];
        // IP地址
        public IDM_DEV_IP_ADDRESS_S stIP;
        // 子网掩码
        public IDM_DEV_IP_ADDRESS_S stSubnetMask;
        // 网关
        public IDM_DEV_IP_ADDRESS_S stGateway;
        // 组播地址
        public IDM_DEV_IP_ADDRESS_S stMulticast;
        // DNS分配方式：0-自动获取 1-手动配置
        public int ulDnsMode;
        // 首选DNS
        public IDM_DEV_IP_ADDRESS_S stPreferredDns;
        // 备用DNS
        public IDM_DEV_IP_ADDRESS_S stStandbyDns;
        public byte[] aucRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulEthernetNo", "szEthernetName", "ulType", "lDhcpEnable", "ulIPv6Mode", "ulMtu", "szMacAdderss", "stIP", "stSubnetMask", "stGateway", "stMulticast", "ulDnsMode", "stPreferredDns", "stStandbyDns", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ETHERNET_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ETHERNET_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_BONDING_PARAM_S extends Structure {
        // 工作模式：0-负载均衡 1-网络容错
        public int ulWorkMode;
        // 虚拟网卡绑定的物理网卡，下标为网卡编号，值为0-不使用 1-使用
        public byte[] aucBonding = new byte[16];
        public IDM_DEV_ETHERNET_PARAM_S stEthernet;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulWorkMode", "aucBonding", "stEthernet", "aucRes");
        }

        public static class ByReference extends IDM_DEV_BONDING_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_BONDING_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_NET_PARAM_S extends Structure {
        // 是否启用Bonding：0-否 1-是
        public int lBondingEnable;
        // 默认网卡编号
        public int ulDefaultEthernetNo;
        // Bonding网卡数
        public int ulBondingNumber;
        // 以太网卡数
        public int ulEthernetNumber;
        // Bonding网卡参数
        public IDM_DEV_BONDING_PARAM_S[] astBonding = new IDM_DEV_BONDING_PARAM_S[2];
        // 以太网卡参数
        public IDM_DEV_ETHERNET_PARAM_S[] astEthernet = new IDM_DEV_ETHERNET_PARAM_S[4];
        public short[] ausRes = new short[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lBondingEnable", "ulDefaultEthernetNo", "ulBondingNumber", "ulEthernetNumber", "astBonding", "astEthernet", "ausRes");
        }

        public static class ByReference extends IDM_DEV_NET_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_NET_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPNP_PORT_S extends Structure {
        // 是否启用：0-否 1-是
        public int lEnable;
        // 映射的外部端口号
        public short usPort;
        public short usRes;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lEnable", "usPort", "usRes");
        }

        public static class ByReference extends IDM_DEV_UPNP_PORT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPNP_PORT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPNP_PARAM_S extends Structure {
        // 是否启用UPnP：0-否 1-是
        public int lUpnpEnable;
        // 端口映射方式：0-自动 1-手动
        public int ulUpnpMode;
        // 端口映射：0-HTTP 1-HTTPS 2-RTSP 3-SDK
        public IDM_DEV_UPNP_PORT_S[] astUpnpPort = new IDM_DEV_UPNP_PORT_S[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lUpnpEnable", "ulUpnpMode", "astUpnpPort");
        }

        public static class ByReference extends IDM_DEV_UPNP_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPNP_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_NTP_PARAM_S extends Structure {
        // 是否启用：0-否 1-是
        public int lEnable;
        // NTP服务器IP/域名
        public byte[] szNtpServer = new byte[64];
        // NTP服务器端口
        public short usNtpPort;
        // 更新周期：[1,10080], 默认1440
        public short usInterval;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lEnable", "szNtpServer", "usNtpPort", "usInterval");
        }

        public static class ByReference extends IDM_DEV_NTP_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_NTP_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PPPOE_PARAM_S extends Structure {
        // 是否启用：0-否 1-是
        public int lEnable;
        // 用户名
        public byte[] szUsername = new byte[64];
        // 密码
        public byte[] szPassword = new byte[64];
        // IP
        public IDM_DEV_IP_ADDRESS_S stIPAddress;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lEnable", "szUsername", "szPassword", "stIPAddress");
        }

        public static class ByReference extends IDM_DEV_PPPOE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PPPOE_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_DDNS_PARAM_S extends Structure {
        // 是否启用：0-否 1-是
        public int lEnable;
        // 类型：0-DynDNS(暂不支持) 1-NO-IP
        public int ulType;
        // DDNS服务器IP/域名
        public byte[] szServerName = new byte[64];
        // 域名
        public byte[] szDomainName = new byte[64];
        // DDNS端口号
        public short usPort;
        public short usRes;
        // 用户名
        public byte[] szUsername = new byte[64];
        // 密码
        public byte[] szPassword = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("lEnable", "ulType", "szServerName", "szDomainName", "usPort", "usRes", "szUsername", "szPassword");
        }

        public static class ByReference extends IDM_DEV_DDNS_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DDNS_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_REQUEST_PARAM_S extends Structure {
        // 请求URL,例： GET /api/esp/network/ddns
        public Pointer pcUrl;
        // 请求URL长度
        public int ulUrlLen;
        // 输入缓冲区(JSON格式)，即HTTP Body
        public Pointer pcBuffer;
        // 输入缓冲区大小
        public int ulBufferSize;
        // 超时时间：单位：ms，默认10s
        public int ulTimeout;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pcUrl", "ulUrlLen", "pcBuffer", "ulBufferSize", "ulTimeout");
        }

        public static class ByReference extends IDM_DEV_REQUEST_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_REQUEST_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_RESPONSE_PARAM_S extends Structure {
        // 输出缓冲区(JSON格式)，即HTTP Body
        public Pointer pcBuffer;
        // 输出缓冲区大小
        public int ulBufferSize;
        // 实际输出的JSON长度
        public int ulReturnSize;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pcBuffer", "ulBufferSize", "ulReturnSize");
        }

        public static class ByReference extends IDM_DEV_RESPONSE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_RESPONSE_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PRESET_NAME_S extends Structure {
        // 预置点编号
        public short usPresetNum;
        // 预置位状态(只读)：1-已定义，2-未定义，3-特殊预置位
        public short usStatus;
        // 预置位名称
        public byte[] szName = new byte[64];
        // 云台编号[可选] 默认为0
        public short usPtNo;
        public byte[] aucRes = new byte[62];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usPresetNum", "usStatus", "szName", "usPtNo", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PRESET_NAME_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PRESET_NAME_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PREST_INFOS_S extends Structure {
        // [in] 分页号[1-N]
        public short usPageNO;
        // [in] 每页数据条数
        public short usPageSize;
        // [out] 预置点结构体数组,用于get时,内部申请并返回
        public IDM_DEV_PRESET_NAME_S.ByReference[] pstPrests;
        // [out] pstPrests中的预置点个数
        public short usCount;
        // [out] 所有预置点总数
        public short usTotalCount;
        // 保留数据
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usPageNO", "usPageSize", "pstPrests", "usCount", "usTotalCount", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PREST_INFOS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PREST_INFOS_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PRESET_LIST_S extends Structure {
        // 预置点编号
        public short usPresetNum;
        // 延时时间：5~120
        public short usDelayTime;
        // 速度：1~40
        public short usSpeed;
        public byte[] aucRes = new byte[2];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usPresetNum", "usDelayTime", "usSpeed", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PRESET_LIST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PRESET_LIST_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PRESET_LIST_S_V2 extends Structure {
        // 预置点编号
        public short usPresetNum;
        // 延时时间：5~120
        public short usDelayTime;
        // 速度：1~40
        public short usSpeed;
        public byte[] aucRes = new byte[58];

        /**
         * 获取结构体大小
         *
         * @return
         */
        public static int getSize() {
            return Native.getNativeSize(short.class) * 3 + Native.getNativeSize(byte.class) * 58;
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usPresetNum", "usDelayTime", "usSpeed", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PRESET_LIST_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PRESET_LIST_S_V2 implements Structure.ByValue {
        }
    }


    public static class IDM_DEV_CRUISE_INFO_S extends Structure {
        // 巡航路径编号
        public short usCruiseNum;
        // 是否启用：0-否，1-是
        public short usEnable;
        // 设置预置位个数
        public int ulPresetCount;
        public IDM_DEV_PRESET_LIST_S[] stPresetList = new IDM_DEV_PRESET_LIST_S[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usCruiseNum", "usEnable", "ulPresetCount", "stPresetList");
        }

        public static class ByReference extends IDM_DEV_CRUISE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CRUISE_INFO_S implements Structure.ByValue {
        }
    }

    /*巡航路径信息结构体 CONFIG_PTZ_CRUISE_INFO_V2 */
    public class IDM_DEV_CRUISE_INFO_S_V2 extends Structure {
        public int uiStructSize; // 本结构体变量大小-必填 否则报错
        public short usCruiseNum; // 巡航路径编号
        public short usEnable; // 是否启用：0-否，1-是
        public int uiPresetCount; // 预置位列表长度
        public IDM_DEV_PRESET_LIST_S_V2[] stPresetList = (IDM_DEV_PRESET_LIST_S_V2[]) new IDM_DEV_PRESET_LIST_S_V2().toArray(256); // 预置位列表
        public byte ucOperationType; // 操作类型 默认0 0-全量操作 1-增量添加 2-增量删除 增量删除模式下usDelayTime和usSpeed可不填写
        public byte[] aucRes = new byte[255];

        public static int getSize() {
            return Native.getNativeSize(int.class) * 2 +
                    Native.getNativeSize(short.class) * 2 +
                    IDM_DEV_PRESET_LIST_S_V2.getSize() * 256 +
                    Native.getNativeSize(byte.class) * 256;
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiStructSize", "usCruiseNum", "usEnable", "uiPresetCount", "stPresetList", "ucOperationType", "aucRes");
        }

        public static class ByReference extends IDM_DEV_CRUISE_INFO_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CRUISE_INFO_S_V2 implements Structure.ByValue {
        }

//        @Override
//        public void write(){
//
//        }

    }


    public static class IDM_DEV_WATCH_INFO_S extends Structure {
        // 是否启用：0-否，1-是
        public short usEnable;
        // 守望动作类型：0-巡航扫描 1-花样扫描 2-预置点 3-帧扫描 4-自动扫描 5-随机扫描 6-全景扫描 7-垂直扫描
        public short usActionType;
        // 守望动作对应的ID：巡航扫描、花样扫描、预置点ID
        public short usActionID;
        // 守望等待时间：5~720秒        public short usWaitTime;
        public short usWaitTime;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usEnable", "usActionType", "usActionID", "usWaitTime", "aucRes");
        }

        public static class ByReference extends IDM_DEV_WATCH_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_WATCH_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_REPOSITORY_QUERY_CONDITION_S extends Structure {
        // 条件字段
        public byte[] szKey = new byte[128];
        // 条件参数
        public byte[] szValue = new byte[256];
        // 条件操作符
        public int ulOperator;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szKey", "szValue", "ulOperator");
        }

        public static class ByReference extends IDM_REPOSITORY_QUERY_CONDITION_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_REPOSITORY_QUERY_CONDITION_S implements Structure.ByValue {
        }
    }

    public static class IDM_REPOSITORY_QUERY_ORDER_S extends Structure {
        // 排序方向
        public int ulOrder;
        // 排序字段
        public byte[] szKey = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulOrder", "szKey");
        }

        public static class ByReference extends IDM_REPOSITORY_QUERY_ORDER_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_REPOSITORY_QUERY_ORDER_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PASSIVE_CONNECT_DEVINFO_S extends Structure {
        // 设备ID
        public byte[] szDeviceID = new byte[64];
        // 设备型号
        public byte[] szDeviceModel = new byte[32];
        // 验证码
        public byte[] szDeviceAuthCode = new byte[32];
        // 固件名称
        public byte[] szDeviceFirmWareName = new byte[128];
        // 软件版本号
        public byte[] szSoftVersion = new byte[64];
        // 设备IP
        public byte[] szDevIP = new byte[64];
        // 未使用字段
        public byte[] unUsed = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDeviceID", "szDeviceModel", "szDeviceAuthCode", "szDeviceFirmWareName", "szSoftVersion", "szDevIP", "unUsed");
        }

        public static class ByReference extends IDM_DEV_PASSIVE_CONNECT_DEVINFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PASSIVE_CONNECT_DEVINFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PREVIEW_INFO_S extends Structure {
        // 通道号
        public int ulChannel;
        // 码流类型：0-主码流 1-子码流 2-三码流
        public int ulStreamType;
        // 连接方式：0-TCP 1-UDP 2-多播 3-RTP/RTSP，暂时只支持TCP
        public int ulLinkMode;
        // 收流超时时间(秒)[5-120] 不在范围内,默认30秒
        public byte ulStreamTimeout;
        // 流模式, 0:音频复合流, 1:纯视频流 2:纯音频流
        public byte ucStreamMode;
        public byte[] aucRes = new byte[254];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannel", "ulStreamType", "ulLinkMode", "ulStreamTimeout", "ucStreamMode", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PREVIEW_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PREVIEW_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PACKET_INFO_S extends Structure {
        // 帧序号
        public int ulFrameNum;
        // 数据类型: 帧类型，0xF1-视频I帧，0xF2-视频P帧，0xF3-MJPEG图片帧，0xF4-辅助帧，0xF5-音频帧，0xF6-视频B帧
        public int ulPacketType;
        // 编码类型: 视频帧时: (只在I帧时才有编码格式) 1: MJPEG  2: H.264  3: H.265  4:  MPEG4        // 音频帧时: 1: ADPCM 2:G.722 3:G.711U 4:G.711A 5:G.726 6:AAC 7:MP2L2 8:PCM 9:G.722.1
        public int ulEncodeType;
        // 打包方式  0: 默认
        public int ulPacketMode;
        // 时间戳低位  时间戳的低位4个字节
        public int ulTimeStamp;
        // 时间戳高位  时间戳的高位4个字节  可以定义 8 字节的 时间戳 取  高位左移32位和低位相加        // 比如 unsigned long long  timestamp =  hight << 32  + low;
        public int ulTimeStampHight;
        // 帧率
        public int ulFrameRate;
        // 宽度
        public short usWidth;
        // 高度
        public short usHeight;
        // 数据大小
        public int ulBufferSize;
        // 数据缓冲指针 数据是H264/H265裸流帧数据
        public Pointer pucBuffer;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulFrameNum", "ulPacketType", "ulEncodeType", "ulPacketMode", "ulTimeStamp", "ulTimeStampHight", "ulFrameRate", "usWidth", "usHeight", "ulBufferSize", "pucBuffer", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PACKET_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PACKET_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_COND_S extends Structure {
        // 搜索结果页码号
        public int ulPageNum;
        // 通道号
        public int ulChannel;
        // 录像类型 1-常规录像, 2-移动侦测录像, 3-报警录像, 252-断网录像, 253-手动录像, 254-所有类型
        public int ulFileType;
        // 码流类型 0-主码流, 1-辅码流, 2-三码流, N-N码流（以此类推）, 253-辅码流优先（N->0）同时只查一种, 254-主码流优先（0->N）同时只查一种, 255-查询所有满足其他条件的码流
        public int ulStreamType;
        // 录像锁定状态 0-未锁定, 1-锁定, 254-所有
        public int ulLockStatus;
        // 起始时间
        public IDM_DEV_TIME_PARAM_S stStartTime;
        // 结束时间
        public IDM_DEV_TIME_PARAM_S stEndTime;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulPageNum", "ulChannel", "ulFileType", "ulStreamType", "ulLockStatus", "stStartTime", "stEndTime", "aucRes");
        }

        public static class ByReference extends IDM_DEV_FILE_COND_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_COND_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TIME_SPAN_S extends Structure {
        // 起始时间
        public IDM_DEV_TIME_PARAM_S stStartTime;
        // 结束时间
        public IDM_DEV_TIME_PARAM_S stEndTime;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("stStartTime", "stEndTime");
        }

        public static class ByReference extends IDM_DEV_TIME_SPAN_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TIME_SPAN_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_COND_EX_S extends Structure {
        // 搜索结果页码号1-N
        public int ulPageNum;
        // 通道号列表
        public int[] aulChannel = new int[16];
        //        public int[] aulChannel = {1,2,3,4,5,6,7,0,0,0,0,0,0,0,0,0,0,0};
        // 录像类型列表
        public int[] aulFileType = new int[32];
        // 码流类型列表
        public int[] aulStreamType = new int[10];
        // 录像锁定状态 0-未锁定, 1-锁定, 254-所有
        public int ulLockStatus;
        // 时间段列表
//        public IDM_DEV_TIME_SPAN_S[] astTimeSpan = new IDM_DEV_TIME_SPAN_S[8];
//        public IDM_DEV_TIME_SPAN_S[] astTimeSpan = {new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S(),
//                new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S(),new IDM_DEV_TIME_SPAN_S()};
        public IDM_DEV_TIME_SPAN_S[] astTimeSpan = (IDM_DEV_TIME_SPAN_S[]) new IDM_DEV_TIME_SPAN_S().toArray(8);
        // 通道号数量
        public byte ucChannelNum;
        // 录像类型数量
        public byte ucFileTypeNum;
        // 码流类型数量
        public byte ucStreamTypeNum;
        // 时间段数量
        public byte ucTimeSpanNum;
        // 待检索日历的录像所属域级别， 0-本级域(本地)，1-1级域(远程)，当前最大支持1级
        public byte ucRecordDomainLevel;
        public byte[] aucRes = new byte[63];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulPageNum", "aulChannel", "aulFileType", "aulStreamType", "ulLockStatus", "astTimeSpan", "ucChannelNum", "ucFileTypeNum", "ucStreamTypeNum", "ucTimeSpanNum", "ucRecordDomainLevel", "aucRes");
        }

        public static class ByReference extends IDM_DEV_FILE_COND_EX_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_COND_EX_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_COND_V_S3 extends Structure {
        // 搜索结果页码号1-N
        public int ulPageNum;
        // 每页数量
        public int uiPageSize;
        // 通道号列表
        public int[] aulChannel = new int[16];
        // 录像类型列表
        public int[] aulFileType = new int[32];
        // 码流类型列表
        public int[] aulStreamType = new int[10];
        // 录像锁定状态 0-未锁定, 1-锁定, 254-所有
        public int ulLockStatus;
        // 时间段列表
        public IDM_DEV_TIME_SPAN_S[] astTimeSpan = new IDM_DEV_TIME_SPAN_S[8];
        // 通道号数量
        public byte ucChannelNum;
        // 录像类型数量
        public byte ucFileTypeNum;
        // 码流类型数量
        public byte ucStreamTypeNum;
        // 时间段数量
        public byte ucTimeSpanNum;
        // 待检索日历的录像所属域级别， 0-本级域(本地)，1-1级域(远程)，当前最大支持1级
        public byte ucRecordDomainLevel;
        public byte[] aucRes = new byte[63];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulPageNum", "uiPageSize", "aulChannel", "aulFileType", "aulStreamType", "ulLockStatus", "astTimeSpan", "ucChannelNum", "ucFileTypeNum", "ucStreamTypeNum", "ucTimeSpanNum", "ucRecordDomainLevel", "aucRes");
        }

        public static class ByReference extends IDM_DEV_FILE_COND_V_S3 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_COND_V_S3 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_RECORD_S extends Structure {
        // 文件名
        public byte[] szFileName = new byte[256];
        // 文件大小
        public int ulFileSize;
        // 文件所属通道号
        public int ulChannelNo;
        // 录像类型 1-常规录像, 2-移动侦测录像, 3-报警录像, 252-断网录像, 253-手动录像
        public int ulRecordType;
        // 码流类型 0-主码流, 1-辅码流, 2-三码流, N-N码流(以此类推)
        public int ulStreamType;
        // 录像锁定状态 0:未锁定，1:锁定
        public int ulLockStatus;
        // 起始时间
        public IDM_DEV_TIME_PARAM_S stStartTime;
        // 结束时间
        public IDM_DEV_TIME_PARAM_S stEndTime;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szFileName", "ulFileSize", "ulChannelNo", "ulRecordType", "ulStreamType", "ulLockStatus", "stStartTime", "stEndTime");
        }

        public static class ByReference extends IDM_DEV_FILE_RECORD_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_RECORD_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_RESULT_S extends Structure {
        // 当前页码
        public int ulPageNum;
        // 总页码
        public int ulTotalNum;
        // 返回的记录数量
        public int ulRecordNum;
        // 返回的文件信息
        public IDM_DEV_FILE_RECORD_S[] stRecord = new IDM_DEV_FILE_RECORD_S[20];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulPageNum", "ulTotalNum", "ulRecordNum", "stRecord");
        }

        public static class ByReference extends IDM_DEV_FILE_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_RESULT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FILE_RESULT_V_S3 extends Structure {
        // 当前页码
        public int ulPageNo;
        // 记录总数
        public int ulTotalNum;
        // 当前页返回的记录数量
        public int ulRecordNum;
        // 返回的文件信息 (内部分配,需要外部释放IDM_DEV_Free)
        public IDM_DEV_FILE_RECORD_S.ByReference pFileArray;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulPageNo", "ulTotalNum", "ulRecordNum", "pFileArray");
        }

        public static class ByReference extends IDM_DEV_FILE_RESULT_V_S3 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FILE_RESULT_V_S3 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MRD_SEARCH_PARAM_S extends Structure {
        // 通道号
        public int ulChannel;
        // 年
        public short usYear;
        // 月
        public short usMonth;
        // 码流类型： 0-主码流, 1-辅码流, 2-三码流, N-N码流(以此类推)
        public int ulStreamType;
        // 录像文件类型：1-常规录像, 2-移动侦测录像, 3-报警录像, 252-断网录像, 253-手动录像 254-所有
        public int ulFileType;
        public byte[] aucRes = new byte[28];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannel", "usYear", "usMonth", "ulStreamType", "ulFileType", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MRD_SEARCH_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MRD_SEARCH_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MRD_SEARCH_PARAM_EX_S extends Structure {
        // 通道号
        public int[] aulChannel = new int[16];
        // 年
        public short usYear;
        // 月
        public short usMonth;
        // 码流类型： 0-主码流, 1-辅码流, 2-三码流, N-N码流(以此类推)
        public int[] aulStreamType = new int[32];
        // 录像文件类型：1-常规录像, 2-移动侦测录像, 3-报警录像, 252-断网录像, 253-手动录像 254-所有
        public int[] aulFileType = new int[10];
        // 通道号数量
        public byte ucChannelNum;
        // 录像类型数量
        public byte ucFileTypeNum;
        // 码流类型数量
        public byte ucStreamTypeNum;
        // 待检索日历的录像所属域级别， 0-本级域(本地)，1-1级域(远程)，当前最大支持1级
        public byte ucRecordDomainLevel;
        public byte[] aucRes = new byte[28];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("aulChannel", "usYear", "usMonth", "aulStreamType", "aulFileType", "ucChannelNum", "ucFileTypeNum", "ucStreamTypeNum", "ucRecordDomainLevel", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MRD_SEARCH_PARAM_EX_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MRD_SEARCH_PARAM_EX_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MRD_SEARCH_RESULT_S extends Structure {
        public byte[] ucDay = new byte[32];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucDay", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MRD_SEARCH_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MRD_SEARCH_RESULT_S implements Structure.ByValue {
        }
    }


    public static class IDM_DEV_RECTANGLE_S extends Structure {
        // X坐标：[0,10000]
        public short usX;
        // Y坐标：[0,10000]
        public short usY;
        // 宽：[0,10000]
        public short usWidth;
        // 高：[0,10000]
        public short usHeight;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usX", "usY", "usWidth", "usHeight");
        }

        public static class ByReference extends IDM_DEV_RECTANGLE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_RECTANGLE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ALARM_IMAGE_INFO_S extends Structure {
        // 图片数据
        public Pointer pImage;
        // 图片长度
        public int ulImageSize;
        // 宽
        public short usWidth;
        // 高
        public short usHeight;
        // 图片编码格式：0-JPEG
        public byte ucFormat;
        // 图片传输方式：0-二进制 1-URL
        public byte ucTransMode;
        public byte[] aucRes = new byte[6];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pImage", "ulImageSize", "usWidth", "usHeight", "ucFormat", "ucTransMode", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ALARM_IMAGE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARM_IMAGE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ALARMOUT_CFG_S extends Structure {
        // 报警输出名称
        public byte[] szAlarmOutName = new byte[32];
        // 报警状态持续时间
        public int lContinuedTime;
        // 报警输出模式，0-关闭，1-自动
        public short usAlarmOutMode;
        // 报警输出状态，只能获取无法配置，0-未报警；1-报警中
        public short usAlarmOutStatus;
        public byte[] aucRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szAlarmOutName", "lContinuedTime", "usAlarmOutMode", "usAlarmOutStatus", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ALARMOUT_CFG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARMOUT_CFG_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ALARMOUT_CONTROL_S extends Structure {
        // 报警输出口ID
        public int ulAlarmID;
        // 报警输出状态 0-无输出 1-有输出 2-一次脉冲输出
        public int ulAlarmOutStatus;
        // 脉冲输出持续时间，单位:秒
        public int ulTimeOut;
        // 报警输出远端通道，从0开始。本机报警通道号为0xFFFF
        public int ulChannelNo;
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulAlarmID", "ulAlarmOutStatus", "ulTimeOut", "ulChannelNo", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ALARMOUT_CONTROL_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARMOUT_CONTROL_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ALARMOUT_REMOT_S extends Structure {
        // 开关量输出ID 从0开始
        public int ulAlarmOutID;
        // 是否启用联动开关量输出
        public byte ucEnable;
        public byte[] aucRes = new byte[31];

        @Override
        public void write() {
            int i = 0;
            i = 1;
            i = 2;
            super.write();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulAlarmOutID", "ucEnable", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ALARMOUT_REMOT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARMOUT_REMOT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_REMOT_CHANNEL_S extends Structure {
        public int ulChannelNo;
        public int ulRemotAlarmOutSize;
        public int ulRemotAlarmOutNum;
        public IDM_DEV_ALARMOUT_REMOT_S.ByReference[] pstAlamOutCfg;
        public byte[] aucRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannelNo", "ulRemotAlarmOutSize", "ulRemotAlarmOutNum", "pstAlamOutCfg", "aucRes");
        }

        public static class ByReference extends IDM_DEV_REMOT_CHANNEL_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_REMOT_CHANNEL_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VOICE_INFO_S extends Structure {
        // 需要联动播报的语音文件序号
        public int ulVoiceNo;
        public byte[] szVoiceName = new byte[64];
        public byte[] aucRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulVoiceNo", "szVoiceName", "aucRes");
        }

        public static class ByReference extends IDM_DEV_VOICE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VOICE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_GUARDPLAN_TIME_S extends Structure {
        // 时间段数量 0~8
        public int ulSpanNum;
        // 起始时间 精确到分
        public IDM_DEV_TIMESPAN_PARAM_S[] stStartTime = (IDM_DEV_TIMESPAN_PARAM_S[]) new IDM_DEV_TIMESPAN_PARAM_S().toArray(8);
        // 结束时间 精确到分
        public IDM_DEV_TIMESPAN_PARAM_S[] stEndTime = (IDM_DEV_TIMESPAN_PARAM_S[]) new IDM_DEV_TIMESPAN_PARAM_S().toArray(8);
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulSpanNum", "stStartTime", "stEndTime", "aucRes");
        }

        public static class ByReference extends IDM_DEV_GUARDPLAN_TIME_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_GUARDPLAN_TIME_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ALARM_GUARDPLAN_S extends Structure {
        // 通道号
        public int ulChannelNo;
        // 布防业务类型。0.移动侦测，1.遮挡报警，2.报警输入，3.报警输出，4.人脸抓拍图片上报
        public int ulGuardType;
        // 布防控制类型。布防业务类型不为2和3时有效。1.控制事件产生，2.控制事件上报
        public int ulGuardCtrlType;
        // 报警输入输出ID号，布防业务类型为2和3时有效
        public int ulAlarmPutID;
        // 布防时间段 数组下标0~6:周一~周日
        public IDM_DEV_GUARDPLAN_TIME_S[] stTimeSpan = (IDM_DEV_GUARDPLAN_TIME_S[]) new IDM_DEV_GUARDPLAN_TIME_S().toArray(7);
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannelNo", "ulGuardType", "ulGuardCtrlType", "ulAlarmPutID", "stTimeSpan", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ALARM_GUARDPLAN_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARM_GUARDPLAN_S implements Structure.ByValue {
        }
    }

    public static class IDM_VOICELIST_INFO_S extends Structure {
        // 语音序号，从1开始
        public int ulVoiceNo;
        // 语音名称
        public byte[] szVoiceName = new byte[64];
        // 语音文件格式，1 ACC
        public int ulFileFormat;
        // 是否预置语音，预置语音不支持用户重新导入覆盖
        public byte ucIsInner;
        // 语音文件播放时长 单位：秒
        public int ulTimeLen;
        // 报警语音播放次数，范围 1~10
        public int ulPlayCount;

        public IDM_VOICELIST_INFO_S() {
        }

        public IDM_VOICELIST_INFO_S(Pointer p) {
            super(p);
            read();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulVoiceNo", "szVoiceName", "ulFileFormat", "ucIsInner", "ulTimeLen", "ulPlayCount");
        }

        @Override
        public void read() {
            super.read();

        }

        public static class ByReference extends IDM_VOICELIST_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_VOICELIST_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VOICELIST_S extends Structure {
        // 通道号
        public int ulChannelNo;
        // 语音列表数量 0~13
        public int ulListNum;
        // 语音列表信息
        public IDM_VOICELIST_INFO_S[] stVoiceInfo = (IDM_VOICELIST_INFO_S[]) new IDM_VOICELIST_INFO_S().toArray(13);

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannelNo", "ulListNum", "stVoiceInfo");
        }

        public static class ByReference extends IDM_DEV_VOICELIST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VOICELIST_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PTZ__S3D_ZOOM_INFO extends Structure {
        // 起始X坐标：[0,10000]
        public short usTopX;
        // 起始Y坐标：[0,10000]
        public short usTopY;
        // 结束X坐标：[0,10000]
        public short usBottomX;
        // 结束Y坐标：[0,10000]
        public short usBottomY;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usTopX", "usTopY", "usBottomX", "usBottomY");
        }

        public static class ByReference extends IDM_DEV_PTZ__S3D_ZOOM_INFO implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PTZ__S3D_ZOOM_INFO implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PTZ_LIMIT_INFO_S extends Structure {
        // 限位模式：0-键控限位 1-扫描限位
        public byte ucMode;
        // 动作：0-设置 1-清除
        public byte ucAction;
        public byte[] aucRes = new byte[2];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucMode", "ucAction", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PTZ_LIMIT_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PTZ_LIMIT_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_IPDEVINFO_S extends Structure {
        // 设备是否启用
        public short usEnable;
        // 端口号
        public short usPort;
        // 设备IP
        public byte[] szIPv4 = new byte[16];
        // 设备名称
        public byte[] szDeviceName = new byte[64];
        // 用户名
        public byte[] szUsername = new byte[64];
        // 密码
        public byte[] szPassword = new byte[64];
        public byte[] aucRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usEnable", "usPort", "szIPv4", "szDeviceName", "szUsername", "szPassword", "aucRes");
        }

        public static class ByReference extends IDM_DEV_IPDEVINFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_IPDEVINFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MANUALSNAP_S extends Structure {
        public int ulChanID;
        public int ulStreamType;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChanID", "ulStreamType", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MANUALSNAP_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MANUALSNAP_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MANUALSNAP_RESULT_S extends Structure {
        // 数据缓冲区指针
        public Pointer pBuffer;
        // 数据缓冲区长度
        public int ulBufferSize;
        // 图片大小
        public int ulPictureSize;
        public IDM_DEV_TIME_PARAM_S stTime;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pBuffer", "ulBufferSize", "ulPictureSize", "stTime", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MANUALSNAP_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MANUALSNAP_RESULT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MANUALSNAP_EX_S extends Structure {
        // 通道号
        public int ulChannel;
        // 车道号
        public byte ucLaneNo;
        public byte[] aucRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannel", "ucLaneNo", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MANUALSNAP_EX_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MANUALSNAP_EX_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_MANUALSNAP_RESULT_EX_S extends Structure {
        // 车辆类型
        public byte[] szVehicleType = new byte[8];
        // 车辆主品牌
        public byte[] szVehicleBrand = new byte[32];
        // 车辆子品牌
        public byte[] szVehicleModel = new byte[32];
        // 车辆年款
        public byte[] szVehicleStyle = new byte[32];
        // 车身颜色：1-黑 2-白 3-灰 4-红 5-蓝 6-黄 7-橙 8-棕 9-绿 10-紫 11-青 12-粉 13-透明 80-黄绿 81-渐变绿82-金 83-银 99-其他
        public byte ucVehicleColor;
        // 车牌类型：1-大型汽车号牌 2-小型汽车号牌 3-使馆汽车号牌 4-领馆汽车号牌 5-境外汽车号牌        // 6-外籍汽车号牌 7-普通摩托号牌 8-轻便摩托号牌 9-使馆摩托号牌 10-领馆摩托号牌        // 11-境外摩托号牌 12-外籍摩托号牌 13-低速车号牌 14-拖拉机号牌 15-挂车号牌        // 16-教练车号牌 17-教练摩托车号牌 20-临时入境汽车号牌 21-临时入境摩托车号牌 22-临时行驶车号牌        // 23-警用汽车号牌 24-警用摩托车号牌 25-原农机号牌 26-香港出入境号牌 27-澳门出入境号牌        // 31-武警号牌 32-军队号牌 70-农用摩托车号牌 71-实验汽车号牌 72-时延摩托车号牌        // 73-小型新能源车号牌 74-大型新能源车号牌 99-其他
        public byte ucPlateType;
        // 车牌颜色：1-黑 2-白 5-蓝 6-黄 9-绿 80-黄绿 81-渐变绿 99-其他
        public byte ucPlateColor;
        // 车牌置信度：[0,100]
        public byte ucPlateConfidence;
        // 车牌号码
        public byte[] szPlateNo = new byte[16];
        // 车牌坐标
        public IDM_DEV_RECTANGLE_S stPlateRect;
        // 抓拍时间
        public IDM_DEV_TIME_PARAM_S stSnapTime;
        // 车辆特写图指针
        public Pointer pVehicle;
        // 车辆特写图长度
        public int ulVehicleSize;
        // 车牌图片指针
        public Pointer pPlate;
        // 车牌图片长度
        public int ulPlateSize;
        // 场景图片指针
        public Pointer pScene;
        // 场景图片长度
        public int ulSceneSize;
        // 车牌二值图片指针
        public Pointer pPlateBinary;
        // 车牌二值图片长度
        public int ulPlateBinarySize;
        public byte[] aucRes = new byte[16];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szVehicleType", "szVehicleBrand", "szVehicleModel", "szVehicleStyle", "ucVehicleColor", "ucPlateType", "ucPlateColor", "ucPlateConfidence", "szPlateNo", "stPlateRect", "stSnapTime", "pVehicle", "ulVehicleSize", "pPlate", "ulPlateSize", "pScene", "ulSceneSize", "pPlateBinary", "ulPlateBinarySize", "aucRes");
        }

        public static class ByReference extends IDM_DEV_MANUALSNAP_RESULT_EX_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_MANUALSNAP_RESULT_EX_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_DEVICE_SEARCH_INFO_S extends Structure {
        public int ulRes1;
        // 是否已经激活
        public int ulActived;
        // 是否支持设备重置
        public int ulResetAbility;
        // 是否支持密码重置
        public int ulPasswdReset;
        // 是否开启dhcp
        public int ulDHCP;
        // 报警输入通道数量
        public int ulAlarmInNum;
        // 报警输出通道数量
        public int ulAlarmOutNum;
        // 硬盘个数
        public int ulDiskNum;
        // IP类型
        public int ulIPType;
        // IP地址
        public byte[] szIP = new byte[64];
        // 子网掩码
        public byte[] szMask = new byte[64];
        // 网关
        public byte[] szGateway = new byte[64];
        // 私有协议端口
        public short usDevPort;
        // HTTP端口
        public short usHttpPort;
        // 设备MAC地址
        public byte[] szDevMac = new byte[64];
        public byte[] szAdapterMac = new byte[64];
        // 软件版本
        public byte[] szSoftwareVer = new byte[64];
        // 设备开机时间
        public byte[] szBootTime = new byte[64];
        // 设备型号 设备类型的字符串描述
        public byte[] szDevModel = new byte[64];
        // 设备序列号
        public byte[] szSerialNum = new byte[64];
        // OEM厂商信息
        public byte[] szOemInfo = new byte[64];
        // 设备当前时间
        public byte[] szDevCurTime = new byte[64];
        // 模拟通道数
        public int ulAnalogChannelNum;
        // 数字通道数
        public int ulDigitalChannelNum;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulRes1", "ulActived", "ulResetAbility", "ulPasswdReset", "ulDHCP", "ulAlarmInNum", "ulAlarmOutNum", "ulDiskNum", "ulIPType", "szIP", "szMask", "szGateway", "usDevPort", "usHttpPort", "szDevMac", "szAdapterMac", "szSoftwareVer", "szBootTime", "szDevModel", "szSerialNum", "szOemInfo", "szDevCurTime", "ulAnalogChannelNum", "ulDigitalChannelNum", "aucRes");
        }

        public static class ByReference extends IDM_DEV_DEVICE_SEARCH_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DEVICE_SEARCH_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ACTIVATE_INFO_S extends Structure {
        // 密码
        public byte[] szPassword = new byte[64];
        public byte[] szDeviceSN = new byte[64];
        public byte[] szPhoneNum = new byte[32];
        public byte[] szEmailAddr = new byte[256];
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szPassword", "szDeviceSN", "szPhoneNum", "szEmailAddr", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ACTIVATE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ACTIVATE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_VOICECOM_INFO_S extends Structure {
        // 通道号
        public int ulChannel;
        // 通道类型：0-远程通道 1-本地通道
        public byte ucChannelType;
        public byte[] aucRes = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannel", "ucChannelType", "aucRes");
        }

        public static class ByReference extends IDM_DEV_VOICECOM_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VOICECOM_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_TRANS_REQUEST_PARAM_S extends Structure {
        // 方法 不需要用户填写
        public byte[] szMethod = new byte[128];
        // JSON数据长度
        public int ulBufferSize;
        // JSON数据 如果传空JSON 传入"{}" 不要将地址置空 空间需要用户自行申请和释放
        public Pointer pcBuffer;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szMethod", "ulBufferSize", "pcBuffer");
        }

        public static class ByReference extends IDM_UNI_TRANS_REQUEST_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_TRANS_REQUEST_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CARD_INFO_S extends Structure {
        // 网卡编号
        public int ulLanID;
        // 网卡名称
        public byte[] szLanName = new byte[32];
        // 是否启用了PPPoE, 0 - 未启用， 1-启用
        public byte ucPPPoeEnable;
        // 网口link状态，0-no link，1-link ok
        public byte ucPortLinkStatus;
        // 支持网卡类型的数量
        public int ulCardSupportNum;
        // 支持网卡的类型
        public int[] ulCardSupport = new int[6];
        // 网卡类型
        public int ulConfigDuplex;
        // 是否启用自动获取ip地址
        public byte ucAutomatic;
        // 网卡IPv4地址
        public byte[] szIPv4Addr = new byte[64];
        // IPv4子网掩码
        public byte[] szIPv4Mask = new byte[64];
        // IPv4默认网关
        public byte[] szIPv4Gateway = new byte[64];
        // IPv6地址获取方式 0-自动获取，1-手工配置，2-路由公告
        public int ulIPv6Mode;
        // IPv6地址
        public byte[] szIPv6Addr = new byte[64];
        // IPv6子网掩码长度
        public int ulIPv6MaskLength;
        // IPv6默认网关
        public byte[] szIPv6Gateway = new byte[64];
        // 网卡MAC地址
        public byte[] szMacAddr = new byte[32];
        // MTU
        public int ulMTU;
        // 组播地址，暂不支持
        public byte[] szMultiAddr = new byte[64];
        // 是否启用组播搜索，暂不支持
        public byte ucMultiEnableSearch;
        // 首先DNS服务器
        public byte[] szPreDNS = new byte[64];
        // 备选DNS服务器
        public byte[] szStandbyDNS = new byte[64];
        // 是否绑定虚拟网卡，0-否，1-是
        public byte ucBooding;
        // 网卡绑定模式 BalanceALB:适配器适应性均衡负载，ActiveBackup:容错模式
        public byte[] szMode = new byte[32];
        // 虚拟网卡绑定物理网卡lan_id的个数
        public int ulMembersSize;
        // 虚拟网卡绑定各物理网卡成员编号，lan_id数组
        public int[] ulMembers = new int[6];
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulLanID", "szLanName", "ucPPPoeEnable", "ucPortLinkStatus", "ulCardSupportNum", "ulCardSupport", "ulConfigDuplex", "ucAutomatic", "szIPv4Addr", "szIPv4Mask", "szIPv4Gateway", "ulIPv6Mode", "szIPv6Addr", "ulIPv6MaskLength", "szIPv6Gateway", "szMacAddr", "ulMTU", "szMultiAddr", "ucMultiEnableSearch", "szPreDNS", "szStandbyDNS", "ucBooding", "szMode", "ulMembersSize", "ulMembers", "aucRes");
        }

        public static class ByReference extends IDM_DEV_CARD_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CARD_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_TRANS_RESPONSE_PARAM_S extends Structure {
        // 输出缓冲区(JSON格式)
        public Pointer pcBuffer;
        // 实际输出的JSON长度
        public int ulReturnSize;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pcBuffer", "ulReturnSize");
        }

        public static class ByReference extends IDM_UNI_TRANS_RESPONSE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_TRANS_RESPONSE_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_SUPPORT_EVENTS_S extends Structure {
        // 私有协议事件类型
        public int ulEventType;
        // 事件名称
        public byte[] szEventName = new byte[128];
        // 事件级别
        public byte ucEventLevel;
        public byte[] ucUnRes = new byte[123];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulEventType", "szEventName", "ucEventLevel", "ucUnRes");
        }

        public static class ByReference extends IDM_UNI_SUPPORT_EVENTS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_SUPPORT_EVENTS_S implements Structure.ByValue {
        }
    }

    public static class IDM_INSTALLED_ALGO_S extends Structure {
        // 算法唯一标识
        public byte[] szAlgoIdentify = new byte[64];
        // 是否通用化算法
        public byte ucIsUniAlgo;
        // 是否正在运行
        public byte ucIsRunning;
        public byte[] ucUnRes = new byte[2];
        // 算法名称
        public byte[] szAlgoName = new byte[64];
        // 算法厂商
        public int ulManuFact;
        // 算法厂商展示名称
        public byte[] szManuFactName = new byte[64];
        // 算法版本
        public byte[] szAlgoVersion = new byte[64];
        // 安装时间 ISO8601 2020-11-19T14:23:44.123+0800
        public byte[] szInstallTime = new byte[64];
        // 算法支持的算法类型列表 通用化算法必填
        public IDM_UNI_SUPPORT_EVENTS_S.ByReference pstSupportEventsList;
        // 列表长度
        public int ulSupportEventListLen;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szAlgoIdentify", "ucIsUniAlgo", "ucIsRunning", "ucUnRes", "szAlgoName", "ulManuFact", "szManuFactName", "szAlgoVersion", "szInstallTime", "pstSupportEventsList", "ulSupportEventListLen");
        }

        public static class ByReference extends IDM_INSTALLED_ALGO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_INSTALLED_ALGO_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_QUERY_INSTALLED_ALGO_RESPONSE_S extends Structure {
        // 已安装的算法列表
        public IDM_INSTALLED_ALGO_S.ByReference pstInstalledAlgoList;
        // 已安装的算法列表长度
        public int ulInstalledAlgoListLen;
        // 是否支持通用化算法 不携带则意味着不支持
        public byte ucIsSupportUniAlgo;
        public byte[] ucUnRes = new byte[53];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pstInstalledAlgoList", "ulInstalledAlgoListLen", "ucIsSupportUniAlgo", "ucUnRes");
        }

        public static class ByReference extends IDM_UNI_QUERY_INSTALLED_ALGO_RESPONSE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_QUERY_INSTALLED_ALGO_RESPONSE_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_SWITCH_ALGO_S extends Structure {
        // 通道编号从0开始 无效0xFFFF
        public int ulChannelNo;
        // 算法唯一标识
        public byte[] szAlgoIdentify = new byte[64];
        // 算法厂商
        public int ulManuFact;
        // 算法版本号
        public byte[] szAlgoVersion = new byte[32];
        // 内部使用
        public byte ucFlag;
        public byte[] ucUnRes = new byte[141];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannelNo", "szAlgoIdentify", "ulManuFact", "szAlgoVersion", "ucFlag", "ucUnRes");
        }

        public static class ByReference extends IDM_UNI_SWITCH_ALGO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_SWITCH_ALGO_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_URL_INFO_S extends Structure {
        // HTTP下载地址
        public byte[] szHTTPIPAddress = new byte[64];
        // HTTP文件访问的路径
        public byte[] szUrl = new byte[256];
        // 访问token
        public byte[] szToken = new byte[48];
        // HTTP访问端口
        public short usHTTPPort;
        public byte[] ucUnRes = new byte[142];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szHTTPIPAddress", "szUrl", "szToken", "usHTTPPort", "ucUnRes");
        }

        public static class ByReference extends IDM_UNI_URL_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_URL_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_LOAD_ALGO_REQUEST_S extends Structure {
        // 算法加载或升级任务的ID
        public byte[] szTaskID = new byte[64];
        // 算法唯一标识
        public byte[] szAlgoIdentify = new byte[64];
        // 算法名称
        public byte[] szAlgoName = new byte[64];
        // 算法厂商
        public int ulManuFact;
        // 算法厂商展示名称
        public byte[] szManuFactName = new byte[64];
        // 算法版本号
        public byte[] szAlgoVersion = new byte[32];
        // 算法包大小 单位字节
        public int ulAlgoSize;
        // 算法版本来源 1-设备web 2-算法仓web 3-工具
        public byte ucLoadSource;
        // 加载模式 1-安装 2-升级 3-工具
        public byte ucLoadType;
        public byte[] ucUnRes = new byte[2];
        // 通道列表长度
        public int ulChannelNoListLen;
        // 待加载算法的通道列表 本机不需要带; 如果VMS通过EC216给接入的IPC加载或升级算法则需要
        public IntByReference pulChannelNoList;
        // 工具包下载URL信息
        public IDM_UNI_URL_INFO_S stUrlInfo;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szTaskID", "szAlgoIdentify", "szAlgoName", "ulManuFact", "szManuFactName", "szAlgoVersion", "ulAlgoSize", "ucLoadSource", "ucLoadType", "ucUnRes", "ulChannelNoListLen", "pulChannelNoList", "stUrlInfo");
        }

        public static class ByReference extends IDM_UNI_LOAD_ALGO_REQUEST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_LOAD_ALGO_REQUEST_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TRANS_FILE_INFO_S extends Structure {
        // 业务类型：0-通用文件上传 1-配置文件上传 2-算法包文件上传 3-音频播报文件上传 4-设备升级包上传 100-通用文件下载 101-配置文件下载 102-算法包文件下载 999-所有
        public int ulSrvType;
        // 文件传输源路径
        public byte[] sFileSrcPath = new byte[256];
        // 文件传输目的路径
        public byte[] szFileDestPath = new byte[256];
        // 文件名称
        public byte[] szFileName = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulSrvType", "sFileSrcPath", "szFileDestPath", "szFileName");
        }

        public static class ByReference extends IDM_DEV_TRANS_FILE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TRANS_FILE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TCPIP_CFG_S extends Structure {
        // 设备序列号
        public byte[] szDevSN = new byte[64];
        // 默认使用的网卡ID，多网卡下必填
        public int ulDefaultLanID;
        // 物理网卡列表的大小
        public int CardListNum;
        // 物理网卡信息
        public IDM_DEV_CARD_INFO_S[] stCardInfo = new IDM_DEV_CARD_INFO_S[5];
        // 是否存在虚拟网卡 0-不存在，1-存在
        public byte ucExitBond;
        // 虚拟网卡信息
        public IDM_DEV_CARD_INFO_S stBond;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDevSN", "ulDefaultLanID", "CardListNum", "stCardInfo", "ucExitBond", "stBond", "aucRes");
        }

        public static class ByReference extends IDM_DEV_TCPIP_CFG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TCPIP_CFG_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_START_DEV_AUTO_SEARCH_ADD_S extends Structure {
        // 搜索设备登录鉴权类型：1-使用本设备admin用户及密码登录搜索设备鉴权，2-使用自定义用户和密码登录搜索设备鉴权
        public int ulAuthType;
        // 搜索到设备的登录用户名，使用自定义用户名密码鉴权时必填
        public byte[] szUerName = new byte[64];
        // 搜索到设备的登录密码，使用自定义用户名密码鉴权时必填
        public byte[] szPassword = new byte[64];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulAuthType", "szUerName", "szPassword", "aucRes");
        }

        public static class ByReference extends IDM_DEV_START_DEV_AUTO_SEARCH_ADD_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_START_DEV_AUTO_SEARCH_ADD_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_QUERY_DEV_AUTO_ADD_PROGRESS_S extends Structure {
        // 添加成功的设备数量
        public int ulAddSucceedNum;
        // 添加时发先已存在的设备数量
        public int ulAlreadyExistNum;
        // 添加失败的设备数量
        public int ulAddFailedNum;
        // 搜索得到的设备总数量
        public int ulTotalSearchNum;
        // 处理百分比进度，取值范围[0,100]
        public int ulProcessPercent;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulAddSucceedNum", "ulAlreadyExistNum", "ulAddFailedNum", "ulTotalSearchNum", "ulProcessPercent", "aucRes");
        }

        public static class ByReference extends IDM_DEV_QUERY_DEV_AUTO_ADD_PROGRESS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_QUERY_DEV_AUTO_ADD_PROGRESS_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CREAT_TRANSFILE_RESULT_S extends Structure {
        // 文件上传任务ID
        public int ulTaskID;
        // 单个文件块大小
        public int ulPerChunkSize;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulTaskID", "ulPerChunkSize");
        }

        public static class ByReference extends IDM_DEV_CREAT_TRANSFILE_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CREAT_TRANSFILE_RESULT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPLOAD_FILE_CHUNK_S extends Structure {
        // 文件上传任务ID
        public int ulTaskID;
        // 需要上传的文件块总数
        public int ulFileChunkNum;
        // 当前上传文件块索引，从1开始，当为总数时为结束
        public int ulCurChunkIdx;
        // 当前文件块在Option消息体中的索引，默认为1
        public int ulChunkOptonIdx;
        // 单个文件块大小
        public int ulPerChunkSize;
        // 文件大小
        public int ulFileSize;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulTaskID", "ulFileChunkNum", "ulCurChunkIdx", "ulChunkOptonIdx", "ulPerChunkSize", "ulFileSize");
        }

        public static class ByReference extends IDM_DEV_UPLOAD_FILE_CHUNK_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPLOAD_FILE_CHUNK_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_DOWNLOAD_FILE_INFO_S extends Structure {
        // 任务名称，非必填
        public byte[] szTaskName = new byte[128];
        // 业务类型：0-通用文件上传 1-配置文件上传 2-算法包文件上传 3-音频播报文件上传 4-设备升级包上传 100-通用文件下载 101-配置文件下载 102-算法包文件下载 999-所有
        public int ulSrvType;
        // 服务端下载文件路径，如果业务类型已经隐含了下载路径，则不需要填写
        public byte[] szFileSrctPath = new byte[256];
        // 文件名称，如果业务类型已经隐含了文件名，不需要填写，由服务端返回
        public byte[] szFileName = new byte[256];
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szTaskName", "ulSrvType", "szFileSrctPath", "szFileName", "aucRes");
        }

        public static class ByReference extends IDM_DEV_DOWNLOAD_FILE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DOWNLOAD_FILE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CREAT_DOWNLOAD_RESULT_S extends Structure {
        // 文件下载任务ID
        public int ulTaskID;
        // 文件名称
        public byte[] szFileName = new byte[256];
        // 文件大小
        public int ulFileSize;
        // 文件MD5值
        public byte[] szFileMD5 = new byte[64];
        // 单个文件块大小
        public int ulPerChunkSize;
        // 文件传输块总量
        public int ulFileChunksNum;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulTaskID", "szFileName", "ulFileSize", "szFileMD5", "ulPerChunkSize", "ulFileChunksNum");
        }

        public static class ByReference extends IDM_DEV_CREAT_DOWNLOAD_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CREAT_DOWNLOAD_RESULT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TRIGGER_ALARM_VOICE_S extends Structure {
        // 通道号，从0开始，可选
        public int ulChannel;
        // 语音序号，从1开始
        public int ulVoiceNo;
        // 触发动作：0 - 关闭；1 - 触发
        public int ulTriggerAction;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannel", "ulVoiceNo", "ulTriggerAction");
        }

        public static class ByReference extends IDM_DEV_TRIGGER_ALARM_VOICE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TRIGGER_ALARM_VOICE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_STUN_INFO_S extends Structure {
        // STUN服务公网地址
        public byte[] szPublicIP = new byte[64];
        // STUN服务公网端口
        public int ulPublicPort;
        public byte[] aucRes = new byte[16];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szPublicIP", "ulPublicPort", "aucRes");
        }

        public static class ByReference extends IDM_DEV_STUN_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_STUN_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_P_S2P_THROUGH_NET extends Structure {
        // APP公网IP地址（必填）
        public byte[] szAPPPublicIP = new byte[64];
        // APP公网端口（必填）
        public int ulAPPPlblicPort;
        // APP端NAT类型：1-全锥型，2-IP限制型，3-端口限制型，4-对称型（必填）
        public int ulAPPNatType;
        // P2P打洞超时时间，单位：秒（必填）
        public int ulP2PTimeout;
        // P2P打洞链路唯一标识，由APP侧生成（必填）
        public byte[] szP2PToken = new byte[64];
        // STUN的数量（必填）
        public int STUNServeNum;
        // STUN信息（必填）
        public IDM_DEV_STUN_INFO_S[] stSTUN = new IDM_DEV_STUN_INFO_S[5];
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szAPPPublicIP", "ulAPPPlblicPort", "ulAPPNatType", "ulP2PTimeout", "szP2PToken", "STUNServeNum", "stSTUN", "aucRes");
        }

        public static class ByReference extends IDM_DEV_P_S2P_THROUGH_NET implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_P_S2P_THROUGH_NET implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_P_S2P_THROUGH_RESULT extends Structure {
        // 设备公网IP地址
        public byte[] szDevPublicIP = new byte[64];
        // 设备公网端口
        public int ulDevPublicPort;
        // 设备端NAT类型：1-全锥型，2-IP限制型，3-端口限制型，4-对称型
        public int ulDevNatType;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDevPublicIP", "ulDevPublicPort", "ulDevNatType");
        }

        public static class ByReference extends IDM_DEV_P_S2P_THROUGH_RESULT implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_P_S2P_THROUGH_RESULT implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SYSTEM_INFO_V2_S extends Structure {
        // 设备型号
        public byte[] szDeviceModel = new byte[64];
        // 设备序列号
        public byte[] szSerialNum = new byte[64];
        // 设备验证码
        public byte[] szAuthCode = new byte[32];
        // 设备Mac地址
        public byte[] szMacAddress = new byte[32];
        // 软件版本号
        public byte[] szSoftwareVersion = new byte[64];
        // 软件生成时间
        public byte[] stSoftwareBuildTime = new byte[64];
        // 设备类别：0：IPC高清网络摄像机 1:ITC智能交通摄像机 100:IVR智能网络硬盘录像机 101:NVR网络硬盘录像机
        public short usDeviceClass;
        // 数字通道个数
        public short usDigitalChannelNum;
        // 模拟通道个数
        public byte ucAnalogChannelNum;
        // 硬盘个数
        public byte ucDiskNum;
        // HTTP端口号，默认80
        public short usHttpPort;
        // HTTPS端口号，默认443
        public short usHttpsPort;
        // RTSP端口号，默认554
        public short usRtspPort;
        // SDK端口号
        public short usSdkPort;
        // 报警输入个数
        public byte ucAlarmInNum;
        // 报警输出个数
        public byte ucAlarmOutNum;
        // 设备IP地址
        public byte[] szDevIP = new byte[64];
        // 设备主动注册时 连接到netsdk的 IP地址 不一定是公网IP
        public byte[] szPubNetIP = new byte[64];
        // 子网掩码
        public byte[] szNetMask = new byte[64];
        // 网关IP地址
        public byte[] szGetWayIP = new byte[64];
        // 网关MAC地址
        public byte[] szGetWayMac = new byte[32];
        // 固件名称
        public byte[] szFirmwareName = new byte[128];
        // 设备开机时间
        public byte[] szBootTime = new byte[64];
        // OEM厂商信息
        public byte[] szOEMInfo = new byte[64];
        // 是否支持设备重置
        public byte ucIsResetAbility;
        // 是否支持密码重置
        public byte ucIsResetPasswrdResetAbility;
        // 是否已激活
        public byte ucIsActivated;
        // IP地址类型
        public byte ucIPType;
        // 前端IPC类型大类
        public byte ucIpcClass;
        // DHCP是否开启
        public byte ucIsDHCP;
        /* 设备名称 */
        public byte[] szDevName = new byte[64];
        // IN - 是否带通道号查询 0-默认不携带  表示查询本机设备信息 1-携带 表示查询通道设备信息
        public byte ucEnableChannel;
        public byte[] aucRes = new byte[73];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDeviceModel", "szSerialNum", "szAuthCode", "szMacAddress", "szSoftwareVersion", "stSoftwareBuildTime", "usDeviceClass", "usDigitalChannelNum", "ucAnalogChannelNum", "ucDiskNum", "usHttpPort", "usHttpsPort", "usRtspPort", "usSdkPort", "ucAlarmInNum", "ucAlarmOutNum", "szDevIP", "szPubNetIP", "szNetMask", "szGetWayIP", "szGetWayMac", "szFirmwareName", "szBootTime", "szOEMInfo", "ucIsResetAbility", "ucIsResetPasswrdResetAbility", "ucIsActivated", "ucIPType", "ucIpcClass", "ucIsDHCP", "szDevName", "ucEnableChannel", "aucRes");
        }

        public static class ByReference extends IDM_DEV_SYSTEM_INFO_V2_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SYSTEM_INFO_V2_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_QR_RESPONSE_S extends Structure {
        public byte[] szQrCode = new byte[64];
        public byte[] unUsed = new byte[192];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szQrCode", "unUsed");
        }

        public static class ByReference extends IDM_DEV_QR_RESPONSE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_QR_RESPONSE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ADDED_CHANNEL_S extends Structure {
        // 本地通道号
        public int ulLocalChannelNo;
        // 远程通道号
        public int ulRemoteChannelNo;
        // 通道名称
        public byte[] szChannelName = new byte[128];
        // 通道是否在线
        public byte isOnline;
        public byte[] unUsed = new byte[119];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulLocalChannelNo", "ulRemoteChannelNo", "szChannelName", "isOnline", "unUsed");
        }

        public static class ByReference extends IDM_DEV_ADDED_CHANNEL_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ADDED_CHANNEL_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_QUERY_DEV_INFO_S extends Structure {
        // 设备ID
        public byte[] szDeviceID = new byte[64];
        // 设备名称
        public byte[] szName = new byte[128];
        // 设备IP
        public byte[] szIPAddress = new byte[64];
        // 远程通道总数
        public int ulTotalChannelNum;
        // 已添加的设备通道数量
        public int ulAddedChannelNum;
        // 已添加的设备通道列表
        public IDM_DEV_ADDED_CHANNEL_S.ByReference[] pstAddedChannelList;
        // 设备端口
        public short usPort;
        // 设备是否在线 0-离线 1-在线
        public byte ucIsOnline;
        // 接入协议
        public byte ucProtocol;
        // 用户名
        public byte[] szUserName = new byte[64];
        // 密码
        public byte[] szPassword = new byte[64];
        // 设备型号
        public byte[] szDeviceType = new byte[32];
        // 设备注册ID 国标接入必选
        public byte[] szDevRegID = new byte[32];
        // RTSP接入时主码流URL
        public byte[] szMainURL = new byte[256];
        // RTSP接入时子码流URL
        public byte[] szSubURL = new byte[256];
        // HTTP服务端口
        public short usHTTPPort;
        // HTTPS服务端口
        public short usHTTPSPort;
        // RTSP服务端口
        public short usRTSPPort;
        // 网络传输协议
        public byte ucTransProtocol;
        // 密码等级 0-弱密码 1-中密码 2-强密码
        public byte ucSecurity;
        public byte[] unUsed = new byte[40];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDeviceID", "szName", "szIPAddress", "ulTotalChannelNum", "ulAddedChannelNum", "pstAddedChannelList", "usPort", "ucIsOnline", "ucProtocol", "szUserName", "szPassword", "szDeviceType", "szDevRegID", "szMainURL", "szSubURL", "usHTTPPort", "usHTTPSPort", "usRTSPPort", "ucTransProtocol", "ucSecurity", "unUsed");
        }

        public static class ByReference extends IDM_DEV_QUERY_DEV_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_QUERY_DEV_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SNAP_TIME_SPAN_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 开始时间，“HH:mm”格式，24小时制
        public byte[] szBeginTime = new byte[32];
        // 结束时间，“HH:mm”格式，24小时制
        public byte[] szEndTime = new byte[32];
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "szBeginTime", "szEndTime", "aucRes");
        }

        public static class ByReference extends IDM_DEV_SNAP_TIME_SPAN_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SNAP_TIME_SPAN_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SCHEDULE_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 抓图计划天数
        public int ulDayNum;
        // 天序号列表，如果是天计划，固定为1，如果是周计划代表星期几，        // 从1-7代表星期一到星期天；如果是月计划代表是当月的几号，取值从1-31，        // 不到31天的月份最后不存在的那几天的时间段计划忽略；        // 注意：天序号不能重复
        public int[] aulDayNo = new int[31];
        // 时间段的个数
        public int ulTimeSpanNum;
        // 抓图计划时间段信息
        public IDM_DEV_SNAP_TIME_SPAN_S.ByReference pstTimeSpan;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulDayNum", "aulDayNo", "ulTimeSpanNum", "pstTimeSpan", "aucRes");
        }

        // 从1-7代表星期一到星期天；如果是月计划代表是当月的几号，取值从1-31，        // 不到31天的月份最后不存在的那几天的时间段计划忽略；        // 注意：天序号不能重复
        public static class ByReference extends IDM_DEV_SCHEDULE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SCHEDULE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CHANNEL_SNAP_PLAN_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 通道号，从0开始
        public int ulChannelNo;
        // 流类型
        public byte ucStreamType;
        public byte[] aucRes = new byte[63];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulChannelNo", "ucStreamType", "aucRes");
        }

        public static class ByReference extends IDM_DEV_CHANNEL_SNAP_PLAN_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CHANNEL_SNAP_PLAN_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SNAP_TASK_INFO_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 抓图计划任务id
        public byte[] szTaskID = new byte[64];
        // 抓图计划通道配置信息个数
        public int ulChannelInfoNum;
        // 抓图计划通道配置信息
        public IDM_DEV_CHANNEL_SNAP_PLAN_S.ByReference pstChannelSnapPlan;
        // 抓拍时间间隔，单位：ms
        public int ulCaptureInterval;
        // 总共有多少计划
        public int ulScheduleNum;
        // 每一计划的抓图计划信息
        public IDM_DEV_SCHEDULE_S.ByReference pstSchedule;
        // 计划类型1：天计划；2：周计划；3：月计划
        public byte ucSecheduleType;
        // 计划是否使能，0-不使能，1-使能
        public byte ucPlanEnable;
        public byte[] aucRes = new byte[62];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "szTaskID", "ulChannelInfoNum", "pstChannelSnapPlan", "ulCaptureInterval", "ulScheduleNum", "pstSchedule", "ucSecheduleType", "ucPlanEnable", "aucRes");
        }

        public static class ByReference extends IDM_DEV_SNAP_TASK_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SNAP_TASK_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ANALISYS_TASK_SNAP_PLAN_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 任务个数
        public int ulTaskInfoNum;
        // 抓图计划通道配置信息
        public IDM_DEV_SNAP_TASK_INFO_S.ByReference pstSnapTaskInfo;
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulTaskInfoNum", "pstSnapTaskInfo", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ANALISYS_TASK_SNAP_PLAN_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ANALISYS_TASK_SNAP_PLAN_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TASK_ID_INFO_S extends Structure {
        // 抓图计划任务id
        public byte[] szTaskID = new byte[64];
        // 是否使能，0-否，1-是（该字段用于设置抓图任务使能状态接口）
        public byte ucEnable;
        // 预留
        public byte[] ucRes = new byte[3];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szTaskID", "ucEnable", "ucRes");
        }

        public static class ByReference extends IDM_DEV_TASK_ID_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TASK_ID_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TASK_ID_S extends Structure {
        // 抓图计划任务id的个数（用于公有云解析任务抓图计划时，当个数为0时，代表查询所有任务）
        public int ulTaskIDNum;
        // 抓图计划任务id信息
        public IDM_DEV_TASK_ID_INFO_S.ByReference pstTaskID;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulTaskIDNum", "pstTaskID");
        }

        public static class ByReference extends IDM_DEV_TASK_ID_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TASK_ID_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SAP_PIC_BATCH_DOWONLOAD_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 通道号，从0开始
        public int ulChannelNo;
        // 算法类型：2-人脸识别；6-视频结构化；15-卡口智能；16-电警智能；39-全目标识别（全结构化）
        public int ulAlgoType;
        // 数据类型。当ulAlgoType=2时：0-所有，1-无库人脸，2-有库人脸        // 当ulAlgoType=6时：0-所有，3-行人，4-机动车，5-非机动车        // 当ulAlgoType=15或16时：取值为交通行业/违法事件类型        // 当ulAlgoType=39时：0-所有，1-无库人脸，2-有库人脸，3-行人，4-机动车，5-非机动车
        public int ulDataType;
        // 人脸库编号，当（ulAlgoType为2或39）且（ulDataType为0或2）时，本字段必填
        public int ulFaceLibNo;
        // 开始时间，ISO8601格式
        public byte[] szStartTime = new byte[64];
        // 结束时间，ISO8601格式
        public byte[] szEndTime = new byte[64];
        public byte[] aucRes = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulChannelNo", "ulAlgoType", "ulDataType", "ulFaceLibNo", "szStartTime", "szEndTime", "aucRes");
        }

        // 当ulAlgoType=6时：0-所有，3-行人，4-机动车，5-非机动车        // 当ulAlgoType=15或16时：取值为交通行业/违法事件类型        // 当ulAlgoType=39时：0-所有，1-无库人脸，2-有库人脸，3-行人，4-机动车，5-非机动车
        public static class ByReference extends IDM_DEV_SAP_PIC_BATCH_DOWONLOAD_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SAP_PIC_BATCH_DOWONLOAD_S implements Structure.ByValue {
        }
    }

    public static class IDM_START_PIC_DOWNLOAD_RESULT_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 抓图批量下载会话ID
        public byte[] szPicDownloadSessionID = new byte[64];
        // 满足条件的图片总张数
        public int ulTotalPicNum;
        public byte[] aucRes = new byte[32];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "szPicDownloadSessionID", "ulTotalPicNum", "aucRes");
        }

        public static class ByReference extends IDM_START_PIC_DOWNLOAD_RESULT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_START_PIC_DOWNLOAD_RESULT_S implements Structure.ByValue {
        }
    }

    public static class IDM_FILES_INFO_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 文件id标识，根据业务需要填写，没有明确要求不填写
        public int ulFileID;
        // 文件名
        public byte[] szFileName = new byte[256];
        public byte[] aucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulFileID", "szFileName", "aucRes");
        }

        public static class ByReference extends IDM_FILES_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_FILES_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DOWNLOAD_FILES_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 业务类型：0-通用文件上传 1-配置文件上传 2-算法包文件上传 3-音频播报文件上传 4-设备升级包上传 100-通用文件下载 101-配置文件下载 102-算法包文件下载 999-所有
        public int ulSrvType;
        // 服务下载文件所在路径，如果业务类型隐含下载路径，则不需要填写
        public byte[] szSrcPath = new byte[256];
        // 文件信息的个数
        public int ulFilesInfoNum;
        // 文件信息
        public IDM_FILES_INFO_S.ByReference pstFilesInfo;
        public byte[] aucRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "ulSrvType", "szSrcPath", "ulFilesInfoNum", "pstFilesInfo", "aucRes");
        }

        public static class ByReference extends IDM_DOWNLOAD_FILES_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DOWNLOAD_FILES_S implements Structure.ByValue {
        }
    }

    public static class IDM_SNAP_PIC_DOWNLOAD_PROGRESS_S extends Structure {
        // 当前结构体大小
        public int ulStructSize;
        // 图片流批量下载进度[0-100]
        public int iProgress;
        // 图片已下载数量
        public int iCurrentNum;
        // 下载失败图片数量
        public int iCountFail;
        // 下载失败文件名称(pNameFail)长度
        public int uiNameLength;
        // 下载失败图片名称 以,隔开(需要使用IDM_FREE释放)
        public Pointer pNamesFail;
        // 图片总张数
        public int uiTotalPicNum;
        // 0-下载中 1-下载完成 2-无数据(查询图片数为0/下载过程中设备SD卡拔出)
        public byte cDownlaodStatus;
        public byte[] aucRes = new byte[3];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulStructSize", "iProgress", "iCurrentNum", "iCountFail", "uiNameLength", "pNamesFail", "uiTotalPicNum", "cDownlaodStatus", "aucRes");
        }

        public static class ByReference extends IDM_SNAP_PIC_DOWNLOAD_PROGRESS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_SNAP_PIC_DOWNLOAD_PROGRESS_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPGRADE_REQUEST_S extends Structure {
        // 升级镜像包名称
        public byte[] szImageName = new byte[128];
        // 升级镜像下载URL地址
        public byte[] szImageUrl = new byte[256];
        // 镜像包大小 单位字节
        public long ulImageSize;
        public byte[] unUsed = new byte[120];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szImageName", "szImageUrl", "ulImageSize", "unUsed");
        }

        public static class ByReference extends IDM_DEV_UPGRADE_REQUEST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPGRADE_REQUEST_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPGRADE_SESSION_S extends Structure {
        // 升级回话ID
        public byte[] szUpgradeSessionID = new byte[64];
        public byte[] unused = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szUpgradeSessionID", "unused");
        }

        public static class ByReference extends IDM_DEV_UPGRADE_SESSION_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPGRADE_SESSION_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_UPGRADE_STATUS_S extends Structure {
        // 升级进度 0-100
        public short usRate;
        // 升级状态 0-空闲 1-升级初始化中 2-文件上传中 3-下载中 4-成功 5-失败
        public byte ucUpgradeStatus;
        public byte[] unused = new byte[13];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usRate", "ucUpgradeStatus", "unused");
        }

        public static class ByReference extends IDM_DEV_UPGRADE_STATUS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_UPGRADE_STATUS_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SAVE_DATA_INFO_S extends Structure {
        // 录制文件最大切包时长 大于0有效 单位秒
        public int uFileTime;
        // 录制文件最大切包大小 大于0有效 单位字节
        public int uFileSize;
        // 录制文件名称 包含路径和名称(如:c:/test/test.mp4)，        // 切文件时文件名在末尾追加_part1,_part2,...,(c:/test/test_part1.mp4)        // 满足下列其中一个条件将会切文件继续录制:        // 1.文件大小达到最大切包大小(默认2G)且是视频关键帧时，        // 2.文件时长达到最大切包时长(默认1小时)且是视频关键帧时，        // 3.编码格式改变时会切文件时
        public byte[] szFileName = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uFileTime", "uFileSize", "szFileName");
        }

        // 切文件时文件名在末尾追加_part1,_part2,...,(c:/test/test_part1.mp4)        // 满足下列其中一个条件将会切文件继续录制:        // 1.文件大小达到最大切包大小(默认2G)且是视频关键帧时，        // 2.文件时长达到最大切包时长(默认1小时)且是视频关键帧时，        // 3.编码格式改变时会切文件时
        public static class ByReference extends IDM_DEV_SAVE_DATA_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SAVE_DATA_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_WGET_IMAGE_S extends Structure {
        // 通道号
        public int uiChannelNo;
        // 图片URL
        public byte[] szImgUrl = new byte[256];
        // 待检索的图片所属域级别， 0-本级域(本地)，1-1级域(远程)，当前最大支持1级
        public byte ucImgDomainLevel;
        public byte[] szUnused = new byte[251];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "szImgUrl", "ucImgDomainLevel", "szUnused");
        }

        public static class ByReference extends IDM_DEV_WGET_IMAGE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_WGET_IMAGE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_IMAGE_RESPONSE_S extends Structure {
        // 图片宽度
        public int uiImgWidth;
        // 图片高度 单位像素
        public int uiImgHeight;
        // 图片格式
        public byte[] szImgFormat = new byte[16];
        // 图片数据大小
        public int uiImgSize;
        // 图片数据  消息头中二进制数据 子类型为100标识一般图片
        public Pointer pucImgBuffer;
        public byte[] unUsed = new byte[224];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiImgWidth", "uiImgHeight", "szImgFormat", "uiImgSize", "pucImgBuffer", "unUsed");
        }

        public static class ByReference extends IDM_DEV_IMAGE_RESPONSE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_IMAGE_RESPONSE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CERTIFICATE_INFO_S extends Structure {
        // 根证书数据长度
        public int uiRootCertLength;
        // 根证书数据
        public Pointer pucRootCertData;
        // 平台证书数据长度
        public int uiPlatformCertLength;
        // 平台证书数据
        public Pointer pucPlatformCertData;
        // 平台私钥数据长度
        public int uiPrivateKeyLength;
        // 平台私钥数据
        public Pointer pucPrivateKeyData;
        public byte[] aucRes = new byte[90];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiRootCertLength", "pucRootCertData", "uiPlatformCertLength", "pucPlatformCertData", "uiPrivateKeyLength", "pucPrivateKeyData", "aucRes");
        }

        public static class ByReference extends IDM_DEV_CERTIFICATE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CERTIFICATE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_CHECKPOINT_RADAR_INFO_S extends Structure {
        // 雷达序号 0-5
        public byte ucIndex;
        // 是否启用 1:启用, 0不启用
        public byte ucEnable;
        // 车道序号 1-6
        public byte ucLaneIndex;
        // 抓拍次数,1-3
        public byte ucSnapTimes;
        // 间隔类型：0-时间，1-距离
        public byte ucIntervaType;
        // 雷达类型. 0:无 1：慧昌单车道雷达 2：慧昌多车道雷达 3-森思泰克雷达
        public byte ucRadarType;
        // 关联串口 0:无 ，1～n:根据设备实际的485、232个数而定，先排485，再排232
        public byte ucSerialLink;
        // [0-6]
        public byte ucIntervalNum;
        // 连续抓拍时间间隔(单位:毫秒) 连续抓拍距离(单位:分米)
        public int[] uiIntervals = new int[6];
        public byte[] uRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucIndex", "ucEnable", "ucLaneIndex", "ucSnapTimes", "ucIntervaType", "ucRadarType", "ucSerialLink", "ucIntervalNum", "uiIntervals", "uRes");
        }

        public static class ByReference extends IDM_DEV_ITS_CHECKPOINT_RADAR_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_CHECKPOINT_RADAR_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PERIMETER_PARAM_S extends Structure {
        // [可选]请求参数 芯片ID  EC用 0开始 暂未使用
        public int uiChipNo;
        // 请求参数 周界检测模式 0-入侵 1-进入 2-离开
        public byte ucMode;
        // 是否启用检测并上报 0-静默不上报 1-正常工作
        public byte ucEnabled;
        // 最短停留时间 1-100s 区域入侵时 该参数必填
        public short usMinTime;
        // 规则框最大个数
        public short usMaxRegionNum;
        // 规则框最小个数
        public short usMinRegionNum;
        // 规则框最大点数 默认10
        public short usMaxPointNum;
        // 规则框最小点数 默认3
        public short usMinPointNum;
        // 最小尺寸规则框 顺时针 4坐标点
        public IDM_DEV_POINT_S[] astMinSizeRegion = new IDM_DEV_POINT_S[4];
        // 最大尺寸规则框 顺时针 4坐标点
        public IDM_DEV_POINT_S[] astMaxSizeRegion = new IDM_DEV_POINT_S[4];
        // 区域规则列表 最多支持4个
        public IDM_DEV_POINTREGION_S[] astRegionList = new IDM_DEV_POINTREGION_S[4];
        // 区域规则列表长度
        public int uiRegionNum;
        // 是否检测行人
        public byte ucIsDetectPerson;
        // 是否检测行非机动车
        public byte ucIsDetectNonVehicle;
        // 是否检测行机动车
        public byte ucIsDetectVehicle;
        public short[] ausRes = new short[253];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChipNo", "ucMode", "ucEnabled", "usMinTime", "usMaxRegionNum", "usMinRegionNum", "usMaxPointNum", "usMinPointNum", "astMinSizeRegion", "astMaxSizeRegion", "astRegionList", "uiRegionNum", "ucIsDetectPerson", "ucIsDetectNonVehicle", "ucIsDetectVehicle", "ausRes");
        }

        public static class ByReference extends IDM_DEV_PERIMETER_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PERIMETER_PARAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_UNI_ALGO_OP_S extends Structure {
        // 请求参数- 通道号 默认填0
        public int uiChannelNo;
        // 请求参数- 操作类型  0-关闭  1-启动  2-获取状态
        public byte ucOpType;
        // ucOpType为2时 本字段填充查询到的算法状态 其余操作无效
        public byte ucIsRunning;
        public byte[] ucUnUsed = new byte[250];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "ucOpType", "ucIsRunning", "ucUnUsed");
        }

        public static class ByReference extends IDM_UNI_ALGO_OP_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_UNI_ALGO_OP_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_RESET_PASSWORD_S extends Structure {
        // 用户名
        public byte[] szUserName = new byte[64];
        // 新密码
        public byte[] szNewPassword = new byte[64];
        // 旧密码
        public byte[] szOldPassword = new byte[64];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szUserName", "szNewPassword", "szOldPassword");
        }

        public static class ByReference extends IDM_DEV_RESET_PASSWORD_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_RESET_PASSWORD_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_CHECKPOINT_RADAR_S extends Structure {
        // [0,6]
        public byte ucRadarCount;
        public IDM_DEV_ITS_CHECKPOINT_RADAR_INFO_S[] stRadars = new IDM_DEV_ITS_CHECKPOINT_RADAR_INFO_S[6];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucRadarCount", "stRadars");
        }

        public static class ByReference extends IDM_DEV_ITS_CHECKPOINT_RADAR_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_CHECKPOINT_RADAR_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_LANE_EVENT_S extends Structure {
        // 事件类型
        public byte ucType;
        // 是否开启 1开启,0不开启
        public byte ucEnabled;
        // 抓拍次数
        public short usSnapTimes;
        public byte[] cRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucType", "ucEnabled", "usSnapTimes", "cRes");
        }

        public static class ByReference extends IDM_DEV_LANE_EVENT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_LANE_EVENT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_LANE_INFO_S extends Structure {
        // 车道ID,范围[1,6]
        public byte ucLaneID;
        // 车道方向 0:未知, 1:左转,2: 右转 ,3:左转 + 右转 ,4:直行 ,5:直行 + 左转 ,6:直行 + 右转,7:直行 + 左转 + 右转 ,8:掉头 ,9:掉头 + 直行 ,10:掉头 + 左转
        public byte ucLaneDirection;
        // 车辆行驶方向 0: 未知 ,1: 下行 ,2: 上行 ,3: 从左往右 ,4: 从右往左 ,5: 停车
        public byte ucDriveDirection;
        // 车道用途 0: 未知 ,1 : 普通车道 ,2: 公交车专用道 ,3: 非机动车道 ,4: 禁止货车车道 ,5: 应急车道 ,6: 禁止调头车道
        public byte ucLaneUsage;
        // 雷达类型 0:无 1：慧昌单车道雷达 2：慧昌多车道雷达 3-森思泰克雷达
        public byte ucRadarType;
        // 关联串口 0:无 ，1～n:根据设备实际的485、232个数而定，先排485，再排232
        public byte ucRadarSerialLink;
        // 左车道线类型 0: 未知 ,1: 车道间白实线 ,2: 车道间黄实线 ,3: 车道间白虚线 ,4: 车道间黄虚线 ,5: 车道停止线 ,6: 顶部车道停止线 ,7: 左边车道停止线 ,8: 右边车道停止线 ,9: 抓拍线,10: 最左车道线延伸到人行道的线，用于大弯小转 ,11: 底部礼让行人线 ,12: 顶部礼让行人线
        public byte ucLeftLineType;
        // 左车道线坐标数组中有效数据数量
        public byte ucLeftLinePointNum;
        // 左车道线坐标数组(坐标x,y范围[0,10000]
        public IDM_DEV_POINT_S[] stLeftLinePoints = new IDM_DEV_POINT_S[2];
        // 单号限行true:限行 false：不限行
        public byte ucTailNumberOddLimit;
        // 双号限行true:限行 false：不限行
        public byte ucTailNumberEvenLimit;
        // 右车道线类型.(取值范围同左车道线)
        public byte ucRightLineType;
        // 右车道线点数量
        public byte ucRightLinePointNum;
        // 右车道线点数组
        public IDM_DEV_POINT_S[] stRightLinePoints = new IDM_DEV_POINT_S[2];
        // 抓拍触发线点数量
        public byte ucTriggerLinePointNum;
        // 机动车通用事件配置数量
        public byte ucMotorVehicleEventNum;
        // 非机动车通用事件配置数量
        public byte ucNonMotorVehicleEventNum;
        // 行人通用事件配置数量
        public byte ucPedestrainsEventNum;
        // 抓拍触发线点数组
        public IDM_DEV_POINT_S[] stTriggerLinePoints = new IDM_DEV_POINT_S[2];
        // 机动车通用事件配置
        public IDM_DEV_LANE_EVENT_S[] stMotorVehicleEvents = new IDM_DEV_LANE_EVENT_S[100];
        // 非机动车通用事件配置
        public IDM_DEV_LANE_EVENT_S[] stNonMotorVehicleEvents = new IDM_DEV_LANE_EVENT_S[20];
        // 行人通用事件配置
        public IDM_DEV_LANE_EVENT_S[] stPedestrainsEvents = new IDM_DEV_LANE_EVENT_S[20];
        // 违停触发时间单位秒,默认5.[5,21600]
        public int uiParkingTriggerTime;
        // 违停持续时间单位秒,默认10. 范围[5,21600]
        public int uiParkingDurationTime;
        // 压线灵敏度,默认50. 范围[1,100]
        public short usPressLineSensitivity;
        // 违法变道灵敏度,默认80 范围[1,100]
        public short usChangeLineSensitivity;
        // 逆行灵敏度,默认100, 范围.[50,300]
        public short usConversSensitivity;
        // 倒车灵敏度,默认100,范围[50,300]
        public short usBackDriveSensitivity;
        // 不礼让行人最大抓拍距离，单位是车道 100对应1车道 (浮点数字符串表示)
        public byte[] szComityThreshold = new byte[12];
        // 外地牌照的默认省份(一个汉字)
        public byte[] szNonLocalLicenseProvince = new byte[8];
        // 小车限高速值，默认120.单位：km/h  范围[1,250]
        public short usCarMinSpeedLimit;
        // 小车限低速值，默认70,单位：km/h 范围[1,250]
        public short usCarMaxSpeedLimit;
        // 大车限高速值，默认120. 单位：km/h 范围[1,250]
        public short usBigMinSpeedLimit;
        // 大车限低速值，默认70 单位：km/h 范围[1,250]
        public short usBigMaxSpeedLimit;
        // 小车限速偏差值,默认10. 范围[1,250]
        public short usCarSpeedLimitDeviation;
        // 大车限速偏差值,默认10. 范围[1,250]
        public short usBigSpeedLimitDeviation;
        // 小车速度的最高值，单位：km/h .默认180,范围[1,250]
        public short usCarMaxSpeed;
        // 大车速度的最高值，单位：km/h. 默认180,范围[1,250]
        public short usBigMaxSpeed;
        // 连拍间隔时间（单位：毫秒），连拍间隔距离（单位：分米）数量范围[1,6]
        public short[] usIntervalValue = new short[8];
        // 间隔值数量;[1,6]
        public byte ucIntervalValueCount;
        // 间隔类型：0-时间，1-距离
        public byte ucIntervalType;
        // 闪光灯闪烁模式 0：同时闪烁 1：轮流闪烁
        public byte ucFlashLightMode;
        // 爆闪灯使能数量[0,4]
        public byte ucFlashLightCount;
        // 爆闪灯使能
        public byte[] ucFlashLightEnable = new byte[4];
        public byte[] cRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucLaneID", "ucLaneDirection", "ucDriveDirection", "ucLaneUsage", "ucRadarType", "ucRadarSerialLink", "ucLeftLineType", "ucLeftLinePointNum", "stLeftLinePoints", "ucTailNumberOddLimit", "ucTailNumberEvenLimit", "ucRightLineType", "ucRightLinePointNum", "stRightLinePoints", "ucTriggerLinePointNum", "ucMotorVehicleEventNum", "ucNonMotorVehicleEventNum", "ucPedestrainsEventNum", "stTriggerLinePoints", "stMotorVehicleEvents", "stNonMotorVehicleEvents", "stPedestrainsEvents", "uiParkingTriggerTime", "uiParkingDurationTime", "usPressLineSensitivity", "usChangeLineSensitivity", "usConversSensitivity", "usBackDriveSensitivity", "szComityThreshold", "szNonLocalLicenseProvince", "usCarMinSpeedLimit", "usCarMaxSpeedLimit", "usBigMinSpeedLimit", "usBigMaxSpeedLimit", "usCarSpeedLimitDeviation", "usBigSpeedLimitDeviation", "usCarMaxSpeed", "usBigMaxSpeed", "usIntervalValue", "ucIntervalValueCount", "ucIntervalType", "ucFlashLightMode", "ucFlashLightCount", "ucFlashLightEnable", "cRes");
        }

        public static class ByReference extends IDM_DEV_ITS_LANE_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_LANE_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_CHECKPOINT_VIDEO_S extends Structure {
        // 通道ID. 0主机, 1从机
        public byte ucChannelID;
        // 抓拍类型,默认1. 0: 机非人全部抓拍 1:仅抓拍机动车 2:仅抓拍非机动车
        public byte ucSnapType;
        // 场景类型 0:普通道路 1:高速公路
        public byte ucSceneType;
        // 测速类型  0:无测速 1:视频测速 2:雷达测速
        public byte ucSpeedType;
        // 补光模式  0：频闪抓拍  1：爆闪抓拍
        public byte ucFlashMode;
        // 区域框坐标点的最大个数,默认10
        public byte ucMaxPointNum;
        // 区域框坐标点的最小个数
        public byte ucMinPointNum;
        // 过车区域检测框点数量
        public byte ucPassDetectAreaPointCount;
        // 过车区域检测框点数组 最多10个
        public IDM_DEV_POINT_S[] stPassDetectAreaPoints = new IDM_DEV_POINT_S[10];
        public byte ucStopLinePointCount;
        public byte ucCrossBttomLinePointCount;
        public byte ucCrossTopLinePointCount;
        public byte ucIllegalParkPointCount;
        // 违法停车检测框点,最多10个
        public IDM_DEV_POINT_S[] stIllegalParkPoints = new IDM_DEV_POINT_S[10];
        // 卡口违规检测人行横道顶端线
        public IDM_DEV_POINT_S[] stCrossTopLinePoints = new IDM_DEV_POINT_S[2];
        // 卡口违规检测人行横道底端线
        public IDM_DEV_POINT_S[] stCrossBttomLinePoints = new IDM_DEV_POINT_S[2];
        // 卡口违规检测停止线,最多10个
        public IDM_DEV_POINT_S[] stStopLinePoints = new IDM_DEV_POINT_S[2];
        // 违法停车检测框雷达测速,等待前时间单位毫秒,默认1000
        public int uiAreaBeforeWaitTime;
        // 违法停车检测框雷达测速, 等待后时间, 单位毫秒,默认1000
        public int uiAreaAfterWaitTime;
        // 车道数量[1,6]
        public int uiLaneNum;
        // 车道信息
        public IDM_DEV_ITS_LANE_INFO_S[] stLaneInfos = new IDM_DEV_ITS_LANE_INFO_S[6];
        public byte[] ucRes = new byte[256];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucChannelID", "ucSnapType", "ucSceneType", "ucSpeedType", "ucFlashMode", "ucMaxPointNum", "ucMinPointNum", "ucPassDetectAreaPointCount", "stPassDetectAreaPoints", "ucStopLinePointCount", "ucCrossBttomLinePointCount", "ucCrossTopLinePointCount", "ucIllegalParkPointCount", "stIllegalParkPoints", "stCrossTopLinePoints", "stCrossBttomLinePoints", "stStopLinePoints", "uiAreaBeforeWaitTime", "uiAreaAfterWaitTime", "uiLaneNum", "stLaneInfos", "ucRes");
        }

        public static class ByReference extends IDM_DEV_ITS_CHECKPOINT_VIDEO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_CHECKPOINT_VIDEO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_RAFFIC_LIGHT_S extends Structure {
        // 交通灯个数 0：单个 1：三个
        public byte ucLightNum;
        // 交通灯使能
        public byte ucEnable;
        // 交通灯放置方式 0：水平放置 1：竖直放置
        public byte ucLightType;
        // 交通灯颜色 0： 红  1：绿 2：黄
        public byte ucColorType;
        // 交通灯方向 :1：左转  16：直行 256：右转 4096：掉头
        public short usDirection;
        public short usPointCount;
        // 交通灯位置
        public IDM_DEV_POINT_S[] points = new IDM_DEV_POINT_S[20];
        public byte[] rcRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucLightNum", "ucEnable", "ucLightType", "ucColorType", "usDirection", "usPointCount", "points", "rcRes");
        }

        public static class ByReference extends IDM_DEV_ITS_RAFFIC_LIGHT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_RAFFIC_LIGHT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_TRAFFIC_EPOLICE_S extends Structure {
        // 抓拍类型 0: 机非人全部抓拍 1:仅抓拍机动车 2:仅抓拍非机动车
        public byte ucSnapType;
        // 通道ID 0:主机 1:从机
        public byte ucChannelID;
        // 场景类型 0:普通道路 1:高速公路
        public byte ucSceneType;
        // 测速类型  0:无测速 1:视频测速 2:雷达测速
        public byte ucSpeedType;
        // 规则框坐标点数量最大值
        public byte ucMaxPointNum;
        // 规则框坐标点数量最小值
        public byte ucMinPointNum;
        // 使用外部交通灯信息
        public byte ucExternLightEnable;
        // 是否使能信号灯强制转换
        public byte ucForceLightEnable;
        // [0,10]
        public short usDetectRegionPointCount;
        // 车道总数[1,6]
        public short usLaneNum;
        // 检测框坐标,最多10个点.
        public IDM_DEV_POINT_S[] stDetectReginPoints = new IDM_DEV_POINT_S[10];
        // 车道信息
        public IDM_DEV_ITS_LANE_INFO_S[] stLaneInfos = new IDM_DEV_ITS_LANE_INFO_S[6];
        // 电警违规检测停止线
        public IDM_DEV_POINT_S[] stStopLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测直行触发线
        public IDM_DEV_POINT_S[] stStraightLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测左转边界线
        public IDM_DEV_POINT_S[] stTurnLeftLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测右转边界线
        public IDM_DEV_POINT_S[] stTurnRightLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测人行横道顶端线
        public IDM_DEV_POINT_S[] stCrossTopLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测人行横道底端线
        public IDM_DEV_POINT_S[] stCrossBttomLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测大弯小转线
        public IDM_DEV_POINT_S[] stSmallTurnLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测对面来车停止线
        public IDM_DEV_POINT_S[] stOppositeStopLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测前置线
        public IDM_DEV_POINT_S[] stFrontLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测中置线
        public IDM_DEV_POINT_S[] stCenterLinePoints = new IDM_DEV_POINT_S[2];
        // 电警违规检测后置线
        public IDM_DEV_POINT_S[] stBackLinePoints = new IDM_DEV_POINT_S[2];
        // 雷达测速,等待前时间单位毫秒
        public int uiRadarBeforeWaitTime;
        // 雷达测速,等待后时间,单位毫秒
        public int uiRadarAfterWaitTime;
        public int usTrafficLightCount;
        // 交通灯信息 最大12个
        public IDM_DEV_ITS_RAFFIC_LIGHT_S[] stTrafficLights = new IDM_DEV_ITS_RAFFIC_LIGHT_S[12];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucSnapType", "ucChannelID", "ucSceneType", "ucSpeedType", "ucMaxPointNum", "ucMinPointNum", "ucExternLightEnable", "ucForceLightEnable", "usDetectRegionPointCount", "usLaneNum", "stDetectReginPoints", "stLaneInfos", "stStopLinePoints", "stStraightLinePoints", "stTurnLeftLinePoints", "stTurnRightLinePoints", "stCrossTopLinePoints", "stCrossBttomLinePoints", "stSmallTurnLinePoints", "stOppositeStopLinePoints", "stFrontLinePoints", "stCenterLinePoints", "stBackLinePoints", "uiRadarBeforeWaitTime", "uiRadarAfterWaitTime", "usTrafficLightCount", "stTrafficLights");
        }

        public static class ByReference extends IDM_DEV_ITS_TRAFFIC_EPOLICE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_TRAFFIC_EPOLICE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_TRAFFIC_FLOWRATE_S extends Structure {
        // 车流量使能
        public byte ucTrafficFlowEnable;
        // 车道平均速度使能
        public byte ucAverageSpeedEnable;
        // 车头时距使能
        public byte ucHeadTimeDistanceEnable;
        // 车头间距使能
        public byte ucHeadSpaceDistanceEnable;
        // 车道时间占有率使能
        public byte ucLaneOccupancyTimeEnable;
        // 车道空间占有率使能
        public byte ucLaneOccupancySpaceEnable;
        // 排队长度使能
        public byte ucQueueLengthEnable;
        // 饱和度使能
        public byte ucSaturationEnable;
        // 统计间隔使能
        public int ucStatisticInterval;
        // 拥堵排队长度
        public int ucJamThreshold;
        // 拥堵评价使能
        public byte ucJamThresholdEnable;
        // 过车统计使能
        public byte ucPassCountEnable;
        // 过车统计osd叠加使能开关
        public byte ucPassCountOsdEnable;
        // 通道ID 0:主机 1:从机
        public byte ucChannelID;
        // 算法类型：15：卡口  16：电警
        public byte ucAlgoType;
        public byte[] cRes = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucTrafficFlowEnable", "ucAverageSpeedEnable", "ucHeadTimeDistanceEnable", "ucHeadSpaceDistanceEnable", "ucLaneOccupancyTimeEnable", "ucLaneOccupancySpaceEnable", "ucQueueLengthEnable", "ucSaturationEnable", "ucStatisticInterval", "ucJamThreshold", "ucJamThresholdEnable", "ucPassCountEnable", "ucPassCountOsdEnable", "ucChannelID", "ucAlgoType", "cRes");
        }

        public static class ByReference extends IDM_DEV_ITS_TRAFFIC_FLOWRATE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_TRAFFIC_FLOWRATE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_TRAFFIC_RAOD_EVENT_S extends Structure {
        // 拥堵检测规则是否启用 1启用,0不启用
        public byte ucJamEventEnable;
        // 拥堵检测规则取证图片数目,默认1,[1-1]
        public byte ucJamePictureNum;
        // 拥堵检测规则拥堵统计周期（分）[1-60] 默认10
        public byte ucJamPeriod;
        // 拥堵检测规则拥堵阈值[1,100] 默认80
        public byte ucJamThreshold;
        // 拥堵检测规则上报过滤时间（分）[1,720],默认10
        public short usJamReportFilterTime;
        // 事故检测规则是否启用 1启用,0不启用
        public byte ucAccidentEnable;
        // 事故检测规则取证图片数目,默认1,[1-1]
        public byte ucAccidentPictureNum;
        // 事故检测规则事故车辆阈值, [1,100]默认50
        public short usAccidentThreshold;
        // 事故检测规则上报过滤时间（分）[1,720],默认10
        public short usAccidentReportFilterTime;
        // 最大取证区域数量 默认10
        public byte ucMaxAreaNum;
        // 最小规则框数量--不画规则框 默认0
        public byte ucMinAreaNum;
        // 行人检测规则是否启用. 1启用,0不启用
        public byte ucPedestrianEnable;
        // 行人检测规则取证图片数目[1,1]
        public byte ucPedestrianPictureNum;
        // 行人检测规则 行人持续时间(秒),[1-300] 默认10
        public short usPedestrianDuration;
        // 行人检测规则上报过滤时间（分）[1-720],默认10
        public short usPedestrianReportFilterTime;
        // 行人检测规则
        public byte[] ucPedestrianRegionPointCount = new byte[12];
        // 行人检测规则框
        public IDM_DEV_POINT_S[] stReginPoints = new IDM_DEV_POINT_S[((12) * (20))];
        // 最多多边形点数量 默认10
        public byte ucMaxPointNum;
        // 最少多边形点数量 默认0
        public byte ucMinPointNum;
        // 抛洒物检测规则是否启用. 1启用,0不启用
        public byte ucAbandonEventEnable;
        // 抛洒物检测规则灵敏度.[1-100] 默认50
        public byte ucAbandonEventSensitivity;
        // 抛洒物检测规检测区域 只有4个点
        public IDM_DEV_POINT_S[] stAbandonAreaPoints = new IDM_DEV_POINT_S[4];
        // 是否启用路障事件检测
        public byte ucRoadBlockEventEnable;
        // 路障事件检测灵敏度[1,10]
        public byte ucRoadBlockEventSensitivity;
        // 是否启用施工事件检测. 1启用,0不启用
        public byte ucConstructionEventEnable;
        // 通道ID 0:主机 1:从机
        public byte ucChannelID;
        // 算法类型15：卡口  16：电警
        public byte ucAlgoType;
        public byte[] ucRes = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucJamEventEnable", "ucJamePictureNum", "ucJamPeriod", "ucJamThreshold", "usJamReportFilterTime", "ucAccidentEnable", "ucAccidentPictureNum", "usAccidentThreshold", "usAccidentReportFilterTime", "ucMaxAreaNum", "ucMinAreaNum", "ucPedestrianEnable", "ucPedestrianPictureNum", "usPedestrianDuration", "usPedestrianReportFilterTime", "ucPedestrianRegionPointCount", "stReginPoints", "ucMaxPointNum", "ucMinPointNum", "ucAbandonEventEnable", "ucAbandonEventSensitivity", "stAbandonAreaPoints", "ucRoadBlockEventEnable", "ucRoadBlockEventSensitivity", "ucConstructionEventEnable", "ucChannelID", "ucAlgoType", "ucRes");
        }

        public static class ByReference extends IDM_DEV_ITS_TRAFFIC_RAOD_EVENT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_TRAFFIC_RAOD_EVENT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SIGNAL_LIGHT_CORRECT_S extends Structure {
        // 信号灯编号，取值范围[1,5]
        public byte ucLedID;
        // 是否手动添加过信号灯，[1-已添加；0-删除]
        public byte ucEnable;
        // 检测灵敏度，取值范围[0,100],默认50
        public byte ucSensitivity;
        // 饱和度，取值范围[0,100],默认50
        public byte ucSaturation;
        // 信号灯位置坐标区域，一个矩形框。坐标无默认值，根据区域放大位置和倍数不同而不同。
        public IDM_DEV_POINT_S[] stPoints = new IDM_DEV_POINT_S[4];
        public byte[] uRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucLedID", "ucEnable", "ucSensitivity", "ucSaturation", "stPoints", "uRes");
        }

        public static class ByReference extends IDM_DEV_SIGNAL_LIGHT_CORRECT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SIGNAL_LIGHT_CORRECT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ITS_LED_CORRECT_S extends Structure {
        // 是否启动信号灯校正功能：1:启动；0:关闭
        public byte ucEnable;
        public byte ucRes1;
        public short usCount;
        // 信号灯的校正参数
        public IDM_DEV_SIGNAL_LIGHT_CORRECT_S[] stLedCorrect = new IDM_DEV_SIGNAL_LIGHT_CORRECT_S[5];
        public byte[] ucRes = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucEnable", "ucRes1", "usCount", "stLedCorrect", "ucRes");
        }

        public static class ByReference extends IDM_DEV_ITS_LED_CORRECT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ITS_LED_CORRECT_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_CHANNEL_S_V2 extends Structure {
        // 1.4.5.1 通道 名称
        public byte[] szName = new byte[128];
        // 1.4.5.2 通道 唯一编号
        public int ulUniqueChannel;
        // 1.4.5.3 通道 远程编号
        public int ulRemoteChannel;
        // 1.4.5.4 通道 是否在线，0：不在线，1：在线
        public byte ucIsOnline;
        public byte[] ucUnused = new byte[200];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szName", "ulUniqueChannel", "ulRemoteChannel", "ucIsOnline", "ucUnused");
        }

        public static class ByReference extends IDM_DEV_CHANNEL_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CHANNEL_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_DEVICE_S_V2 extends Structure {
        // 1.4.1 设备标识
        public byte[] szId = new byte[64];
        // 1.4.2 设备名称
        public byte[] szName = new byte[64];
        // 1.4.3 设备IP
        public byte[] szIPAddress = new byte[16];
        // 1.4.4 设备大类；        // "IPC"：普通网络摄像机；        // "ITC"：智能交通摄像机；        // "NVR"：分销NVR；        // "EC"：边缘计算节点；        // "ES"：边缘服务器；        // "ITS"：路口主机；
        public byte[] szDeviceClass = new byte[32];
        // 1.4.6 该设备下的通道信息列表
        public IDM_DEV_CHANNEL_S_V2.ByReference pChannelList;
        // 数量
        public int ulChannelListLen;
        // 1.4.5 设备协议0：Onvif，1,：GB28181，2：华智私有协议，3：RTSP；4：华智私有协议主动注册
        public byte ucProtocol;
        public byte[] ucUnused = new byte[200];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szId", "szName", "szIPAddress", "szDeviceClass", "pChannelList", "ulChannelListLen", "ucProtocol", "ucUnused");
        }

        // "IPC"：普通网络摄像机；        // "ITC"：智能交通摄像机；        // "NVR"：分销NVR；        // "EC"：边缘计算节点；        // "ES"：边缘服务器；        // "ITS"：路口主机；
        public static class ByReference extends IDM_DEV_DEVICE_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DEVICE_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_LOCAL_CHANNEL_S_V2 extends Structure {
        // 本地通道名称
        public byte[] szName = new byte[128];
        // 唯一本地通道号 0开始
        public int uiUniqueChannelNo;
        public byte[] szUnuse = new byte[124];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szName", "uiUniqueChannelNo", "szUnuse");
        }

        public static class ByReference extends IDM_LOCAL_CHANNEL_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_LOCAL_CHANNEL_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_DEVICE_TREE_S_V2 extends Structure {
        // 1.1 设备树名称
        public byte[] szName = new byte[128];
        // 1.2 通道总数
        public int ulChannelTotal;
        // 1.3 通道在线数量
        public int ulChannelOnline;
        // 1.4 下级设备树
        public IDM_DEV_DEVICE_S_V2.ByReference pDevices;
        // 1.5 下级设备数量
        public int ulDevicesCount;
        // 1.6 本地模拟通道列表
        public IDM_LOCAL_CHANNEL_S_V2.ByReference pstLocalChannelList;
        // 1.7 本地模拟通道列表长度
        public int uiLocalChanelLisLen;
        public byte[] ucUnused = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szName", "ulChannelTotal", "ulChannelOnline", "pDevices", "ulDevicesCount", "pstLocalChannelList", "uiLocalChanelLisLen", "ucUnused");
        }

        public static class ByReference extends IDM_DEV_DEVICE_TREE_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DEVICE_TREE_S_V2 implements Structure.ByValue {
        }
    }

    public static class DEV_TREE_GET_RESPONSE_S_V2 extends Structure {
        // 1.设备树
        public IDM_DEV_DEVICE_TREE_S_V2 stDeviceTree;

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("stDeviceTree");
        }

        public static class ByReference extends DEV_TREE_GET_RESPONSE_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends DEV_TREE_GET_RESPONSE_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_TIME_PARAM_S_V2 extends Structure {
        // 系统时间，ISO8601格式
        public byte[] szDateTime = new byte[64];
        public byte[] unUsed = new byte[128];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szDateTime", "unUsed");
        }

        public static class ByReference extends IDM_DEV_TIME_PARAM_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_TIME_PARAM_S_V2 implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_RECONNECT_INFO_S extends Structure {
        // 重连时间间隔，单位 : 毫秒(最小值3000)
        public int uiInterval;
        // 是否重连，0 - 不重连，1 - 重连，默认值为0
        public byte ucEnable;
        public byte[] ucRes = new byte[123];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiInterval", "ucEnable", "ucRes");
        }

        public static class ByReference extends IDM_DEV_RECONNECT_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_RECONNECT_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SYSMGR_RUN_MODE_S extends Structure {
        // 设备运行模式：0 工作模式；1 标定模式
        public byte ucMode;
        public byte[] szUnused = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucMode", "szUnused");
        }

        public static class ByReference extends IDM_DEV_SYSMGR_RUN_MODE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SYSMGR_RUN_MODE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SYSMGR_CALIBRATION_S extends Structure {
        // 角标之间宽度，单位：毫米，取值范围： 900- 1100
        public short usWidth;
        // 角标之间高度，单位：毫米，取值范围：600-800
        public short usHeight;
        public byte[] szUnused = new byte[124];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usWidth", "usHeight", "szUnused");
        }

        public static class ByReference extends IDM_DEV_SYSMGR_CALIBRATION_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SYSMGR_CALIBRATION_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_SYSMGR_STITCH_DISTANCE_S extends Structure {
        // 拼接距离，单位：米，取值范围：0~10
        public byte ucDistance;
        public byte[] szUnused = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucDistance", "szUnused");
        }

        public static class ByReference extends IDM_DEV_SYSMGR_STITCH_DISTANCE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_SYSMGR_STITCH_DISTANCE_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FORCE_I_FRAME_STREAM_S extends Structure {
        // 通道号从0开始 0xFFFF无效值
        public int uiChannelNo;
        // 码流类型 0-主码流 1-辅码流 2-三码流 3-四码流 4-五码流
        public int uiStreamType;
        public byte[] ucUnused = new byte[52];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "uiStreamType", "ucUnused");
        }

        public static class ByReference extends IDM_DEV_FORCE_I_FRAME_STREAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FORCE_I_FRAME_STREAM_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_FORCE_I_FRAME_S extends Structure {
        // 参数类型 0-填入句柄 1-填入通道和码流类型 2-填入会话标识<预留 暂不支持>
        public int uiParamType;
        public field1_union field1;
        //  超时时间毫秒 0-使用SDK默认时间 参数有效范围 50-10000ms
        public short usTimeOut;
        public byte[] ucUnused = new byte[60];

        public static class field1_union extends Union {
            // 参数类型0 实时预览句柄
            public int uiRealPlayHandle;
            // 参数类型1 填入通道号和码流类型方式
            public IDM_DEV_FORCE_I_FRAME_STREAM_S stStreamInfo;
            // 参数类型2 填入实况会话标识方式
            public int uiStreamSessionID;

            public field1_union() {
                super();
            }

            public field1_union(int uiRealPlayHandle_or_uiStreamSessionID) {
                super();
                this.uiStreamSessionID = this.uiRealPlayHandle = uiRealPlayHandle_or_uiStreamSessionID;
                setType(Integer.TYPE);
            }

            public field1_union(IDM_DEV_FORCE_I_FRAME_STREAM_S stStreamInfo) {
                super();
                this.stStreamInfo = stStreamInfo;
                setType(IDM_DEV_FORCE_I_FRAME_STREAM_S.class);
            }

            public static class ByReference extends field1_union implements Structure.ByReference {
            }

            public static class ByValue extends field1_union implements Structure.ByValue {
            }
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiParamType", "field1", "ucUnused");
        }

        public static class ByReference extends IDM_DEV_FORCE_I_FRAME_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_FORCE_I_FRAME_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_PTZ_PT_ZOOM_INFO_S extends Structure {
        // 水平坐标，范围：[0, (360000 - 1)]
        public int iPtX;
        // 垂直坐标，范围：[-20 * 1000, 90 * 1000]
        public int iPtY;
        // 变倍Zoom值，范围：[1*1000, 44*1000]
        public int iPtZ;
        // 聚焦标志位[只读] 0-未聚焦 1-已聚焦
        public byte ucFocusFlag;
        // 预留
        public byte[] unUsed = new byte[245];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("iPtX", "iPtY", "iPtZ", "ucFocusFlag", "unUsed");
        }

        public static class ByReference extends IDM_DEV_PTZ_PT_ZOOM_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PTZ_PT_ZOOM_INFO_S implements Structure.ByValue {
        }
    }

    public static class IDM_DEV_ASSIST_FOCUS_INFO_S extends Structure {
        // 是否聚焦标识
        public byte ucFocusFlag;
        // 预留
        public byte[] unUsed = new byte[127];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucFocusFlag", "unUsed");
        }

        public static class ByReference extends IDM_DEV_ASSIST_FOCUS_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ASSIST_FOCUS_INFO_S implements Structure.ByValue {
        }
    }

    public class IDM_DEV_PASSIVE_PARAM_S extends Structure {
        public byte[] szServerIP = new byte[64]; // 主动注册服务地址
        public byte[] szDeviceID = new byte[64]; // 设备ID
        public int uiServerPort; // 服务端口号 1-65535
        public byte ucEnable; // 是否启用主动注册 0-不启用 1-启用 默认为0
        public byte ucNetReplenishment; // 是否启用断网补传 0-不启用 1-启用 默认为0 选填
        public byte[] ucUnuse = new byte[124]; // 预留

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szServerIP", "szDeviceID", "uiServerPort", "ucEnable", "ucNetReplenishment", "ucUnuse");
        }

        public static class ByReference extends IDM_DEV_PASSIVE_PARAM_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PASSIVE_PARAM_S implements Structure.ByValue {
        }
    }

    public class IDM_DEV_ACCESS_CHANNEL_INFO_S extends Structure {
        public byte[] szChannelCode = new byte[24]; //通道编码,20位国标编码
        public byte[] szDeviceName = new byte[68]; //设备名称,查询操作有效
        public byte[] szChannelName = new byte[68]; //通道名称,查询操作有效
        public int uiChannelNo; //通道唯一编号(序号),有通道时必填写[0-N]
        public byte ucChannelType; //通道类型; 0视频通道,1音频通道,2报警通道
        public byte ucAlarmLevel; //报警级别,数值越小,报警级别越高. 范围[1-6]
        public String aucRes = new String(new char[126]); //保留扩展字段

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szChannelCode", "szDeviceName", "szChannelName", "uiChannelNo", "ucChannelType", "ucAlarmLevel", "aucRes");
        }

        public static class ByReference extends IDM_DEV_ACCESS_CHANNEL_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ACCESS_CHANNEL_INFO_S implements Structure.ByValue {
        }

    }


    public class IDM_DEV_PLATFORM_ACCESS_INFO_S extends Structure {
        public byte[] szUserAuthID = new byte[24]; //SIP用户认证ID 20位国标编码
        public byte[] szUserName = new byte[24]; //SIP用户名
        public byte[] szPassword = new byte[36]; //SIP认证密码[1,31]位字符
        public byte[] szServerID = new byte[24]; //SIP服务器ID 20位国标编码
        public byte[] szServerDomain = new byte[12]; //SIP服务器域  ServerID的前10位
        public byte[] szCivilCode = new byte[24]; //行政区域,默认值:6532 长度只能为2,4,6,8,20
        public byte[] szServerIP = new byte[48]; //SIP服务器IP
        public short usServerPort; //SIP服务器端口
        public short usLocalPort; //本地SIP端口 默认值6060
        public byte ucConnectionMode; //SIP连接模式 0:UDP, 1:TCP
        public byte ucEnableStreamKeepAlive; //是否启用流保活 0:不启用,1:启用
        public byte ucEnableMultTCPTrans; //是否启用多响应TCP传输
        public byte ucOnline; //注册状态. 0离线, 1在线
        public byte ucEnable; //是否启用平台接入配置. 0:不启用,1启用
        public byte ucMaxtHeartbeatTimes; //最大心跳次数 ,默认3. 范围[3-180]
        public byte ucGBVersion; //国标协议版本 0:2011 1:2016
        public byte ucStreamType; //码流类型.0:主码流,1子码流, 2:第三码流,3:第四码流
        public int uiRegistExpires; //注册有效期,单位秒,默认3600秒 [3600-10000]
        public short usHeartbeatPeriod; //心跳周期,默认60秒.范围 [5-170]
        public short usRegistInterval; //注册间隔, 范围60-600, 国标2016版本必选, 2011版本不需要
        public byte ucStreamProtocol; //取流协议. 0:UDP, 1:TCP 国标2016版本必选, 2011版本缺省默认UDP
        public byte ucGB35114Enable; //是否启用35114 0:不启用, 1:启用
        public short usChannelCount; //通道列表中的通道数量
        public IDM_DEV_ACCESS_CHANNEL_INFO_S pChannelList; //通道列表 查询时,由内部申请,需要调用IDM_DEV_Free方法释放
        public int uiPlatformCertStatus; //35114平台证情况 0:认证成功,1001017004:未认证,1001017005:认证失败
        public int uiCryptoDeviceStatus; //35114加密设备状态 0:正常
        public byte ucNetType; //网域类型 0:局域网, 1:公网
        public byte ucGB35114Support; //是否支持GB35114 0不支持,1支持
        public byte[] aucRes = new byte[512]; //保留扩展字段

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("szUserAuthID", "szUserName", "szPassword", "szServerID", "szServerDomain", "szCivilCode", "szServerIP", "usServerPort", "usLocalPort", "ucConnectionMode", "ucEnableStreamKeepAlive", "ucEnableMultTCPTrans", "ucOnline", "ucEnable", "ucMaxtHeartbeatTimes", "ucGBVersion", "ucStreamType", "uiRegistExpires", "usHeartbeatPeriod", "usRegistInterval", "ucStreamProtocol", "ucGB35114Enable", "usChannelCount", "pChannelList", "uiPlatformCertStatus", "uiCryptoDeviceStatus", "ucNetType", "ucGB35114Support", "aucRes");
        }

        public static class ByReference extends IDM_DEV_PLATFORM_ACCESS_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PLATFORM_ACCESS_INFO_S implements Structure.ByValue {
        }


    }

    public class IDM_DEV_LINKAGE_CFG_S extends Structure {
        public short usTrackTime; // 持续跟踪时间  0 ~ 300(秒)
        public byte ucTrackRatio; // 跟踪倍率 1 ~ 10
        public byte ucTrackEnable; // 启用全景跟踪功能 0 不启用  1 启用
        public byte ucLinkageAlgo; // 获取时不返回 1:设置联动参数同步切换对应算法，0:只保存配置不联动算法。
        public byte[] acRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usTrackTime", "ucTrackRatio", "ucTrackEnable", "ucLinkageAlgo", "acRes");
        }

        public static class ByReference extends IDM_DEV_LINKAGE_CFG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_LINKAGE_CFG_S implements Structure.ByValue {
        }
    }

    public class IDM_DEV_CALIBRATION_INFOLIST_S extends Structure {
        public int uiChannelNo; // 通道号, 用于适配多云台设备, 查询时需要调用者传入
        public int uiCalInfosCount; // 标定参数列表的个数
        public IDM_DEV_CALIBRATION_INFO_S pstCalInfos; // 标定参数列表. 设置时由用户分配, 查询时由 NETSDK 内部分配, 需要调用者调用IDM_DEV_Free 传入IDM_DEV_CALIBRATION_INFOLIST_S 的结构体指针 释放
        public byte ucCalType; // 标定方式。0:手动，1:自动
        public byte[] acRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "uiCalInfosCount", "pstCalInfos", "ucCalType", "acRes");
        }

        public static class ByReference extends IDM_DEV_CALIBRATION_INFOLIST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CALIBRATION_INFOLIST_S implements Structure.ByValue {
        }

    }

    public class IDM_DEV_CALIBRATION_INFO_S extends Structure {
        public short usX; // 枪机 x坐标, 范围0~1000
        public short usY; // 枪机 y坐标, 范围0~10000
        public int uiCalPTZListCount; // 球机PTZ参数个数
        public IDM_DEV_CAL_PTZ_LIST_S pstCalPTZList; // 球机PTZ参数列表
        public byte ucId; // 标定点序号，范围[0,11]
        public byte ucValid; //  数据是否有效 0 无效  1 有效
        public byte[] acRes = new byte[30];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("usX", "usY", "uiCalPTZListCount", "pstCalPTZList", "ucId", "ucValid", "acRes");
        }

        public static class ByReference extends IDM_DEV_CALIBRATION_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CALIBRATION_INFO_S implements Structure.ByValue {
        }
    }

    public class IDM_DEV_CAL_PTZ_LIST_S extends Structure {
        public int uiPtX; // 球机 水平坐标，范围0~359999
        public int iPtY; // 球机 垂直坐标，范围-20*1000~90*1000
        public byte ucZoom; //球机 变倍倍数Zoom值，范围1~44
        public byte[] acRes = new byte[31];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiPtX", "iPtY", "ucZoom", "acRes");
        }

        public static class ByReference extends IDM_DEV_CAL_PTZ_LIST_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_CAL_PTZ_LIST_S implements Structure.ByValue {
        }
    }

    // 设置枪球联动球机初始位置
    public class IDM_DEV_LINKAGE_PTZ_POS_S extends Structure {

        public int uiChannelNo; // 通道号
        public IDM_DEV_CAL_PTZ_LIST_S stPTZList = new IDM_DEV_CAL_PTZ_LIST_S(); // 云台位置
        public byte[] ucRes = new byte[32]; // 预留位

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "stPTZList", "ucRes");
        }

        public static class ByReference extends IDM_DEV_LINKAGE_PTZ_POS_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_LINKAGE_PTZ_POS_S implements Structure.ByValue {
        }


    }

    public class IDM_DEV_PANTRACK_ABILITY extends Structure {
        public int[] uiCoordinateNum = new int[64]; // 每个场景标定点个数 数组 NETSDK内部申请 size就是ucSenceNum场景数量
        public int uiMasterChannelNo; // 全景相机通道号
        public int[] uiSlaveChannelNo = new int[64]; // 特写相机通道号 数组 NETSDK内部申请
        public byte ucSenceNum; // 场景数量
        public byte ucSlaveChannelCount; // 特写相机通道号个数  count内的元素为有效
        public byte[] ucRes = new byte[30];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiCoordinateNum", "uiMasterChannelNo", "uiSlaveChannelNo", "ucSenceNum", "ucSlaveChannelCount", "ucRes");
        }

        public static class ByReference extends IDM_DEV_PANTRACK_ABILITY implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_PANTRACK_ABILITY implements Structure.ByValue {
        }
    }

    /* 图像调整；*/
    public class IDM_DEV_EFFECT_S extends Structure {
        public byte ucLuminance; // 亮度，取值范围[0, 100]；
        public byte ucContrast; // 对比度，取值范围[0, 100]；
        public byte ucSaturation; //    Number    饱和度，取值范围[0, 100]；
        public byte ucSharpness; //     Number    锐度，取值范围[0, 100]；
        public byte ucUnUse; //  预留

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucLuminance", "ucContrast", "ucSaturation", "ucSharpness", "ucUnUse");
        }

        public static class ByReference extends IDM_DEV_EFFECT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_EFFECT_S implements Structure.ByValue {
        }
    }

    /* exposure	Object	曝光调节 */
    public class IDM_DEV_EXPOSURE_S extends Structure {
        public byte ucExpMode; // Number    曝光模式，[0-自动 1-自定义 2-光圈优先 3-快门优先 4-抗闪烁50HZ 5-抗闪烁60HZ 6-低拖影 7-手动]；
        public byte ucExpTime; /* Number    曝光(快门)时间类型，[0-1/25 1-1/30 2-1/50 3-1/60 4-1/75 5-1/100 6-1/120 7-1/150 8-1/200 9-1/225 10-1/240 11-1/250
						12-1/300 13-1/425 14-1/480 15-1/600 16-1/960 17-1/1000 18-1/1024 19-1/1250 20-1/1750 21-1/2000 22-1/2500 23-1/3500 24-1/4000 25-1/6000 26-1/8000
						27-1/10000 28-1/16000 29-1/30000 30-1/100000]；*/
        public byte ucExpTimeRangeMin; //Number    最小快门限制，[同exp_time]；
        public byte ucExpTimeRangeMax; //Number    最大快门限制，[同exp_time]；
        public byte ucGainValue; //     Number    曝光增益，取值范围[0, 100]；
        public byte ucGainMax; //    Number    曝光增益限制，取值范围[0, 100]；
        public byte ucIrisValue; //    Number    光圈，取值范围[0, 100]；
        public byte ucIrisRangeMin; //    Number    最小光圈限制，取值范围[0, 100]；
        public byte ucIrisRangeMax; //   Number    最大光圈限制，取值范围[0, 100]；
        public byte ucSlowShutter; //    Number    低照度电子快门，[0-关闭 7-1/3 6-1/4 5-1/6 4-1/8 3-1/12 2-1/15 1-1/20]；
        public byte ucLightCompensation; //    Number    亮度补偿，取值范围[0, 100]；
        public byte ucIrisType; //    Number    镜头类型，[0-DC-IRIS 1-P-IRIS]；
        public byte ucIrisMode; //    Number    光圈模式，[0-自动 1-手动]；
        public byte ucIrisManualLevel; //    Number    光圈等级，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucExpMode", "ucExpTime", "ucExpTimeRangeMin", "ucExpTimeRangeMax", "ucGainValue", "ucGainMax", "ucIrisValue", "ucIrisRangeMin", "ucIrisRangeMax", "ucSlowShutter", "ucLightCompensation", "ucIrisType", "ucIrisMode", "ucIrisManualLevel");
        }

        public static class ByReference extends IDM_DEV_EXPOSURE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_EXPOSURE_S implements Structure.ByValue {
        }
    }

    /* 	 day_night 日夜切换 */
    public class IDM_DEV_DAYNIGHT_S extends Structure {
        public byte ucDayNightMode; //    Number    日夜切换模式，[0-自动 1-白天 2-黑夜]；
        public byte ucSensitivity; //    Number    灵敏度，取值范围[0-100]；
        public byte ucDelayTime; //    Number    延迟时间，取值范围[0-2秒，1-3秒，2-4秒，3-5秒，4-6秒，5-7秒，6-8秒，7-9秒，8-10秒]；
        public byte ucjudgeType; //    Number    日夜切换判决类型，[0-亮度，1-时间]；
        public byte[] szBeginTime = new byte[32]; //    String    开始时间，（HH:MM:SS）；
        public byte[] szEndTime = new byte[32]; //    String    结束时间，（HH:MM:SS）；
        public byte ucLightingMode; // Number    补光模式，[0白光模式，1混合模式]；
        public byte ucSmartInfraredMode; //    Number    防补光过曝模式，[0关闭, 1-自动，2手动，3-smartIR]；
        public byte ucNearLevel; // Number    近光灯亮度等级, 取值范围[0, 100]；
        public byte ucMidLevel; // Number    中光灯亮度等级, 取值范围[0, 100]；
        public byte ucFarLevel; // Number    远光灯亮度等级，取值范围[0, 100]；
        public byte ucNearRedLevel; // Number    红外光近光灯级别，取值范围[0, 100]；
        public byte ucFarRedLevel; //     Number    红外光远光灯级别，取值范围[0, 100]；
        public byte ucNearWhiteLevel; //     Number    白外光近光灯级别，取值范围[0, 100]；
        public byte ucFarWhiteLevel; //     Number    白光远光灯级别，取值范围[0, 100]；
        public byte ucSuppressLevel; //     Number    防补光过曝抑制等级，取值范围[0, 100]；
        public byte ucLaserMode; // Number    激光控制模式，[0-关闭 1-自动 2-手动；
        public byte ucLaserLevel; //     Number    激光亮度，取值范围[0, 100]；
        public byte ucLaserAngle; //     Number    激光角度，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucDayNightMode", "ucSensitivity", "ucDelayTime", "ucjudgeType", "szBeginTime", "szEndTime", "ucLightingMode", "ucSmartInfraredMode", "ucNearLevel", "ucMidLevel", "ucFarLevel", "ucNearRedLevel", "ucFarRedLevel", "ucNearWhiteLevel", "ucFarWhiteLevel", "ucSuppressLevel", "ucLaserMode", "ucLaserLevel", "ucLaserAngle");
        }

        public static class ByReference extends IDM_DEV_DAYNIGHT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_DAYNIGHT_S implements Structure.ByValue {
        }
    }

    /* white_balance	Object	白平衡 */
    public class IDM_DEV_WHITE_BALANCE_S extends Structure {
        public byte ucWhiteBalanceMode; // Number    白平衡模式，[0-自动 1-手动 2-晴天 3-阴天 4-黄昏 5-白炽灯 6-钠灯 7-日光灯]；
        public byte ucR; //Number    红色增益，取值范围[0, 100]；
        public byte ucG; //Number    绿色增益，取值范围[0, 100]，暂不使用；
        public byte ucB; //Number    蓝色增益，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucWhiteBalanceMode", "ucR", "ucG", "ucB");
        }

        public static class ByReference extends IDM_DEV_WHITE_BALANCE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_WHITE_BALANCE_S implements Structure.ByValue {
        }
    }

    /* 图像增强；*/
    public class IDM_DEV_ENHANCE_S extends Structure {
        public byte ucFog; //    Number    透雾，[0-关闭 1-自动 2-手动 4-打开(光学透雾)]；
        public byte ucFogLevel; //    Number    透雾等级，取值范围[0, 100]；
        public byte ucDis; // Number    电子防抖，[0-关闭 1-自动 3-手动(预留)]；
        public byte ucLdc; // Number    畸变矫正模式，[0-关闭 2-手动]；
        public byte ucLdcLevel; // Number    畸变矫正等级，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucFog", "ucFogLevel", "ucDis", "ucLdc", "ucLdcLevel");
        }

        public static class ByReference extends IDM_DEV_ENHANCE_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ENHANCE_S implements Structure.ByValue {
        }
    }

    /* 背光 */
    public class IDM_DEV_BACKLIGHT_S extends Structure {
        public byte ucBlMode; //    Number    背光模式，[0 - 关闭 1 - 背光补偿 2 - 强光抑制]；
        public byte ucBlcMode; //    Number    背光补偿模式，[0 - 自动 1 - 手动]；
        public byte ucBlcValue; //    Number    背光补偿等级，取值范围[0, 100]；
        public IDM_DEV_POINTREGION_S astBlcRegion; // 背光补偿自定义区域，4个点；
        public byte ucHlcMode; //     Number    强光抑制模式，[0-自动 1-手动]；
        public byte ucHlcValue; //    Number    强光抑制等级，不超出能力集范围；
        public IDM_DEV_POINTREGION_S astHlcRegion; // 强光抑制自定义区域，4个点；
        public byte ucWdrMode; //    Number    宽动态模式，[0-关闭 1-开启 2-自动]；
        public byte ucWdrValue; //Number    宽动态等级，取值范围[0, 100]；
        public byte ucWdrOpenSens; //    Number    宽动态开启灵敏度，取值范围[0, 100]；
        public byte ucWdrCloseSens; //    Number    宽动态关闭灵敏度，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ucBlMode", "ucBlcMode", "ucBlcValue", "astBlcRegion", "ucHlcMode", "ucHlcValue", "astHlcRegion", "ucWdrMode", "ucWdrValue", "ucWdrOpenSens", "ucWdrCloseSens");
        }

        public static class ByReference extends IDM_DEV_BACKLIGHT_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_BACKLIGHT_S implements Structure.ByValue {
        }
    }


    public class IDM_DEV_IMAGE_CONFIG_S extends Structure {
        public int uiChannelNo; // 通道编号，从0开始
        public short usSceneMode; // 场景，[0-通用，1-室内，2-低照，3-逆光，4-雾天，5-虚拟卡口，6-人脸，7-车窗人脸，8-客观，9-自定义，10-23为新增自定义]；
        public byte ucVideoMode; // 视频模式，[0-正常，1-双相，2-彩色，3-红外，4-融合，5-自动]；
        public byte ucVideoChannel; // 视频通道，[0-实况、1-抓拍、2-视频1、3-视频2、4-彩色视频、5-彩色抓拍、6-红外视频、7-红外抓拍]；
        public IDM_DEV_EFFECT_S stEffect; // 图像调整；
        public IDM_DEV_EXPOSURE_S stExposure; // 曝光调节；
        public IDM_DEV_DAYNIGHT_S stDayNight; // 日夜切换
        public IDM_DEV_WHITE_BALANCE_S stWhiteBalance; // 白平衡
        public IDM_DEV_ENHANCE_S stEnhance; // 图像增强；
        public IDM_DEV_BACKLIGHT_S stBackLight; // 背光；
        // 视频调整；
        public byte ucShapeMirror; //    Number    视频镜像，[0-关闭 1-上下 2-左右 3-中心]；
        public byte ucShapeRotate; //    Number    视频旋转，[0-关闭 1-走廊模式1 2- 翻转 3-走廊模式2]；
        public byte ucShapeFrameMode; //    Number    视频帧率设定，[0-PAL-25(50HZ) 1-PAL-50(50HZ) 2-NTSC-30(60HZ) 3-NTSC-60(60HZ)]； 暂时只支持0、1；
        // 聚焦；
        public byte ucFocusMode; // Number    聚焦模式，[0-自动 1-半自动 2-手动]；
        public byte ucFocusNearLimit; //    Number    最小聚焦距离，[3-1.5米 4-3米 5-6米 6-10米 7-20米 8-50米 9-无穷远]；
        // 降噪；
        public byte ucDenoisemode; //    Number    数字降噪，[0-关闭 1-自动 2-手动]；
        public byte ucDenoiseLevel; //    Number    降噪级别，取值范围[0, 100]；
        public byte nDenoise2dLevel; //    Number    空域降噪等级，取值范围[0, 100]；
        public byte nDenoise3dLevel; //    Number    时域降噪等级，取值范围[0, 100]；

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "usSceneMode", "ucVideoMode", "ucVideoChannel", "stEffect", "stExposure", "stDayNight", "stWhiteBalance", "stEnhance", "stBackLight", "ucShapeMirror", "ucShapeRotate", "ucShapeFrameMode", "ucFocusMode", "ucFocusNearLimit", "ucDenoisemode", "ucDenoiseLevel", "nDenoise2dLevel", "nDenoise3dLevel");
        }

        public static class ByReference extends IDM_DEV_IMAGE_CONFIG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_IMAGE_CONFIG_S implements Structure.ByValue {
        }
    }

    /* 视频遮挡参数配置结构体 */
    public class IDM_DEV_VIDEO_COVER_CONFIG_S extends Structure {

        public int uiChannelNo; // 通道号
        public byte ucEnabled; // 是否启用  1-启用 0-不启用
        public byte ucUnUse1; // 预留
        public short usRegionListNum; // 视频遮挡区域个数 范围1-8个
        public IDM_DEV_POINTREGION_S[] astRegionList = (IDM_DEV_POINTREGION_S[]) new IDM_DEV_POINTREGION_S().toArray(8); // 视频遮挡区域列表  区域坐标4个点 左上角开始顺时针旋转  x y坐标范围均是 范围[0,10000]
        //        public IDM_DEV_POINTREGION_S[] astRegionList = new IDM_DEV_POINTREGION_S[8];
        public byte[] ucUnUse2 = new byte[120]; // 预留

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "ucEnabled", "ucUnUse1", "usRegionListNum", "astRegionList", "ucUnUse2");
        }

        public static class ByReference extends IDM_DEV_VIDEO_COVER_CONFIG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VIDEO_COVER_CONFIG_S implements Structure.ByValue {
        }
    }


    /* ROI参数配置结构体 */
    public class IDM_DEV_ROI_CONFIG_S extends Structure {
        public int uiChannelNo; //    IN 通道号
        public short usStreamType; //  IN 码流类型，取值见附录B.53
        public byte ucRegionIndex; //    IN 区域编号，范围[1,8]
        public byte ucEnabled; //  是否启用  1-启用 0-不启用
        public byte[] szRegionName = new byte[128]; // 区域名称，范围【0-66个字符,22个中文】
        public byte ucLevelNumber; //  提升等级，范围[1,6]
        public byte ucUnUse1; // 预留
        public short usRegionListNum; // ROI区域个数 范围1-8个
        public IDM_DEV_POINTREGION_S[] astRegionList = (IDM_DEV_POINTREGION_S[]) new IDM_DEV_POINTREGION_S().toArray(8); // ROI区域列表 区域坐标左上角开始顺时针旋转  x y坐标范围均是 范围[0,10000]
        public byte[] ucUnUse2 = new byte[120]; // 预留

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "usStreamType", "ucRegionIndex", "ucEnabled", "szRegionName", "ucLevelNumber", "ucUnUse1", "usRegionListNum", "astRegionList", "ucUnUse2");
        }

        public static class ByReference extends IDM_DEV_ROI_CONFIG_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ROI_CONFIG_S implements Structure.ByValue {
        }

    }

    /*语音配置列表 CONFIG_VOICE_LIST_V2*/
    public class IDM_DEV_VOICELIST_S_V2 extends Structure {
        public int ulChannelNo; //通道号
        public int ulListNum; //语音列表数量 没有限制
        public IDM_VOICELIST_INFO_S.ByReference stVoiceInfo = new IDM_VOICELIST_INFO_S.ByReference(); //语音列表信息 成员内存需要用户调用SDK接口IDM_FREE(响应结构体地址)释放
        public byte[] ucUnuse = new byte[52];


        @Override
        public void read() {
            super.read();
        }

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("ulChannelNo", "ulListNum", "stVoiceInfo", "ucUnuse");
        }

        public static class ByReference extends IDM_DEV_VOICELIST_S_V2 implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_VOICELIST_S_V2 implements Structure.ByValue {
        }
    }


    public class IDM_DEV_ALARM_CHANNEL_S extends Structure {
        public int uiChannelNo; // 已布防使能的 通道号
        public int[] puiEventTypeList; // 已布防使能的 通道对应的 事件类型数组 [0]表示所有 []表示无
        public int uiEventTypeListLen; // 已布防使能的 通道对应的 事件类型数组长度
        public byte[] unUsed = new byte[496];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("uiChannelNo", "puiEventTypeList", "uiEventTypeListLen", "unUsed");
        }

        public static class ByReference extends IDM_DEV_ALARM_CHANNEL_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARM_CHANNEL_S implements Structure.ByValue {
        }
    }


    public class IDM_DEV_ALARM_INFO_S extends Structure {
        public IDM_DEV_ALARM_CHANNEL_S.ByReference[] pstGuardChannelList; // 已布防布防通道列表
        public int uiGuardChannelListLen; // 已布防通道列表长度
        public byte[] unUsed = new byte[500];

        @Override
        protected List getFieldOrder() {
            return Arrays.asList("pstGuardChannelList", "uiGuardChannelListLen", "unUsed");
        }

        public static class ByReference extends IDM_DEV_ALARM_INFO_S implements Structure.ByReference {
        }

        public static class ByValue extends IDM_DEV_ALARM_INFO_S implements Structure.ByValue {
        }
    }


    public interface IDM_DEV_Connect_Callback_PF_V2 extends Callback {
        int apply(IDM_DEV_PASSIVE_CONNECT_DEVINFO_S.ByReference pInfo, Pointer pUserData);
    }


    public interface IDM_DEV_RealPlay_Callback_PF extends Callback {
        /**
         * @param ulDataType 0视频帧,1音频帧,2其它数据
         * @param pucBuffer  私有封装格式数据
         */
        void invoke(int lRealPlayHandle, int ulDataType, Pointer pucBuffer, int ulBufferSize, Pointer pUserData);
    }


    public interface IDM_DEV_RealPlayES_Callback_PF extends Callback {
        void invoke(int lRealPlayHandle, IDM_DEV_PACKET_INFO_S pstPacketInfo, Pointer pUserData);
    }


    public interface IDM_DEV_PlayBack_Callback_PF extends Callback {
        /**
         * @param ulBufferSize 私有帧数据
         */
        void invoke(int lPlayBackHandle, int ulDataType, Pointer pucBuffer, int ulBufferSize, Pointer pUserData);
    }


    public interface IDM_DEV_Download_Callback_PF extends Callback {
        void invoke(int lPlayBackHandle, int ulDataType, Pointer pucBuffer, int ulBufferSize, Pointer pUserData);
    }


    public interface IDM_DEV_Download_Progress_Callback_PF extends Callback {
        void invoke(int lPlayBackHandle, float fProgress, Pointer pUserData);
    }


    public interface IDM_DEV_SearchDevice_Callback_PF extends Callback {
        void invoke(IDM_DEV_DEVICE_SEARCH_INFO_S.ByReference pstDeviceInfo, Pointer pUserData);
    }


    public interface IDM_DEV_VoiceCom_Callback_PF extends Callback {
        void invoke(int lVoiceComHandle, int ulDataType, Pointer pucBuffer, int ulBufferSize, Pointer pUserData);
    }


    public interface IDM_DEV_TransFile_Callback_PF extends Callback {
        void invoke(Pointer pucBuffer, int ulBufferSize, float fProgress, Pointer pUserData);
    }


    public interface IDM_DEV_EventNotify_Callback_PF extends Callback {
        void invoke(int lUserID, int lHandle, Pointer pUserData, int emType, Pointer param1, Pointer param2);
    }


    public interface IDM_DEV_LogCallback extends Callback {
        void invoke(byte level, Pointer logMsg);
    }

    /**
     * @brief: SDK反初始化
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_Cleanup();

    /**
     * @brief: 设置保存日志到文件, 会自动添加输出到文件模式.
     * @param: IN ucLogLevel 日志等级  0-关闭日志 1-error级别 2-info级别 3-debug级别
     * @param: IN ucLogMode 日志存储模式 未实现 填0
     * @param: IN szLogDirectory 日志文件路径  比如 C:\\logs  或者 .
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SaveLogToFile(byte ucLogLevel, byte ucLogMode, Pointer szLogDirectory);

    /**
     * @brief: 设置日志输出模式
     * @param: IN mode 日志输出模式 0关闭,1输出到命令行,2输出到文件(需要先配置文件信息),4输出到调试窗口(windows有效),8使用回调(需要设置回调)
     * @return: 无
     */
    void IDM_DEV_SetLogOutputMode(byte mode);

    /**
     * @brief: 设置日志回调(会自动添加输出到日志文件模式)
     * @param: IN mode 0关闭,1输出到命令行,2输出到文件(需要先配置文件信息),4输出到调试窗口(windows有效),8使用回调(需要设置回调)
     * @return: 无
     */
    void IDM_DEV_SetLogCallback(IDM_DEV_LogCallback callback);

    /**
     * @brief: 设置日志输出模式
     * @param: IN level 日志等级  0-关闭日志 1-error级别 2-info级别 3-debug级别
     * @return: 无
     */
    void IDM_DEV_SetLogLevel(byte level);

    /**
     * @brief: 设置断线重连功能
     * @param: IN stReconnectInfo 重连参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetReconnect(IDM_DEV_RECONNECT_INFO_S.ByValue stReconnectInfo);

    /**
     * @brief: 设备登录
     * @param: IN stLoginInfo 登录结构体
     * @param: OUT pstDeviceInfo 设备信息
     * @param: OUT plUserID 登录成功分配的设备句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_Login(IDM_DEV_USER_LOGIN_INFO_S.ByValue stLoginInfo, IDM_DEV_DEVICE_INFO_S pstDeviceInfo, IntByReference plUserID);


    /**
     * @brief: 设备实时预览
     * @param: IN lUserID 设备句柄
     * @param: IN stPreviewInfo 预览参数结构体
     * @param: IN pfRealPlayCallBack 预览数据回调函数
     * @param: IN pUserData 用户数据
     * @param: OUT plRealPlayHandle 预览句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_RealPlay(int lUserID, IDM_DEV_PREVIEW_INFO_S.ByValue stPreviewInfo, IDM_DEV_RealPlay_Callback_PF pfRealPlayCallBack, Pointer pUserData, IntByReference plRealPlayHandle);

    /**
     * @brief: 设备实时预览
     * @param: IN lUserID 设备句柄
     * @param: IN sPreviewInfo 预览参数结构体
     * @param: IN pfRealPlayCallBack 预览数据回调函数
     * @param: IN pUserData 用户数据
     * @param: OUT plRealPlayHandle 预览句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_RealPlayES(int lUserID, IDM_DEV_PREVIEW_INFO_S.ByValue sPreviewInfo, IDM_DEV_RealPlayES_Callback_PF pfRealPlayCallBack, Pointer pUserData, IntByReference plRealPlayHandle);

    /**
     * @brief: 停止实时预览
     * @param: IN lRealPlayHandle 预览句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopRealPlay(int lRealPlayHandle);

    /**
     * @brief: 设置实时预览回调函数
     * @param: IN lRealPlayHandle 预览句柄
     * @param: IN pfRealPlayCallback 预览数据回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetRealPlayCallback(int lRealPlayHandle, IDM_DEV_RealPlay_Callback_PF pfRealPlayCallback, Pointer pUserData);

    /**
     * @brief: 设置实时预览回调函数(ES流)
     * @param: IN lRealPlayHandle 预览句柄
     * @param: IN pfRealPlayCallback 预览数据回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetRealPlayESCallback(int lRealPlayHandle, IDM_DEV_RealPlayES_Callback_PF pfRealPlayCallback, Pointer pUserData);

    /**
     * @brief: 保存实时流到文件
     * @param: IN lRealPlayHandle 预览句柄
     * @param: IN pcFileName 保存的文件路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SaveRealPlayData(int lRealPlayHandle, Pointer pcFileName);

    /**
     * @brief: 保存实时流到文件
     * @param: IN lRealPlayHandle 预览句柄
     * @param: IN pcFileName 保存的文件路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SaveRealPlayData(int lRealPlayHandle, String pcFileName);

    /**
     * @brief: 停止保存实时流到文件
     * @param: IN lRealPlayHandle 预览句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopSaveRealPlayData(int lRealPlayHandle);

    /**
     * @brief: 录像回放
     * @param: IN lUserID 设备句柄
     * @param: IN stPlayBackCond 录像查询条件
     * @param: IN pfPlayBackCallback 回放数据回调函数
     * @param: IN pUserData 用户数据
     * @param: OUT lPlayBackHandle 回放句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_PlayBack(int lUserID, IDM_DEV_PLAYBACK_COND_S.ByReference stPlayBackCond, IDM_DEV_PlayBack_Callback_PF pfPlayBackCallback, Pointer pUserData, IntByReference plPlayBackHandle);

    int IDM_DEV_PlayBack(int lUserID, IDM_DEV_PLAYBACK_COND_S.ByValue stPlayBackCond, IDM_DEV_PlayBack_Callback_PF pfPlayBackCallback, Pointer pUserData, IntByReference plPlayBackHandle);

    /**
     * @brief: 停止录像回放
     * @param: IN lPlayBackHandle 回放句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopPlayBack(int lPlayBackHandle);

    /**
     * @brief: 设置录像回放回调函数
     * @param: IN lPlayBackHandle 回放句柄
     * @param: IN pfPlayBackCallback 回放数据回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetPlayBackCallback(int lPlayBackHandle, IDM_DEV_PlayBack_Callback_PF pfPlayBackCallback, Pointer pUserData);

    /**
     * @brief: 回放控制
     * @param: IN lPlayBackHandle 回放句柄
     * @param: IN ulCommand 命令号
     * @param: IN pBuffer 参数指针，根据命令号对应不同结构体
     * @param: IN ulBufferSize 参数长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_PlayBackControl(int lPlayBackHandle, int ulCommand, Pointer pBuffer, int ulBufferSize);

    /**
     * @brief: 保存回放流到文件
     * @param: IN lPlayBackHandle 回放句柄
     * @param: IN pcFileName 保存的文件路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SavePlayBackData(int lPlayBackHandle, Pointer pcFileName);

    /**
     * @brief: 保存回放流到文件
     * @param: IN lPlayBackHandle 回放句柄
     * @param: IN pcFileName 保存的文件路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SavePlayBackData(int lPlayBackHandle, String pcFileName);

    /**
     * @brief: 停止保存回放流到文件
     * @param: IN lPlayBackHandle 回放句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopSavePlayBackData(int lPlayBackHandle);

    /**
     * @brief: 按条件查询录像文件
     * @param: IN lUserID 设备句柄
     * @param: IN stFileCond 查找条件
     * @param: OUT pstFileResult 查找结果
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_FindFile(int lUserID, IDM_DEV_FILE_COND_S.ByValue stFileCond, IDM_DEV_FILE_RESULT_S pstFileResult);

    /**
     * @brief: 按条件查询录像文件
     * @param: IN lUserID 设备句柄
     * @param: IN stFileCond 查找条件
     * @param: OUT pstFileResult 查找结果
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_FindFile_Ex(int lUserID, IDM_DEV_FILE_COND_EX_S.ByValue stFileCond, IDM_DEV_FILE_RESULT_S.ByReference pstFileResult);

    /**
     * @brief: 按文件名设置录像锁定状态
     * @param: IN lUserID 设备句柄
     * @param: IN sFileName 需要设置的录像文件名
     * @param: IN ulLockStatus 锁定状态 0：未锁定，1：锁定
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SetFileLockStatus(int lUserID, Pointer sFileName, int ulLockStatus);

    /**
     * @brief: 按文件名设置录像锁定状态
     * @param: IN lUserID 设备句柄
     * @param: IN sFileName 需要设置的录像文件名
     * @param: IN ulLockStatus 锁定状态 0：未锁定，1：锁定
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetFileLockStatus(int lUserID, String sFileName, int ulLockStatus);

    /**
     * @brief: 按文件名获取录像锁定状态
     * @param: IN lUserID 设备句柄
     * @param: IN sFileName 需要获取的录像文件名
     * @param: OUT pulLockStatus 锁定状态 0：未锁定，1：锁定
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_GetFileLockStatus(int lUserID, Pointer sFileName, IntByReference pulLockStatus);

    /**
     * @brief: 按文件名获取录像锁定状态
     * @param: IN lUserID 设备句柄
     * @param: IN sFileName 需要获取的录像文件名
     * @param: OUT pulLockStatus 锁定状态 0：未锁定，1：锁定
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetFileLockStatus(int lUserID, String sFileName, IntByReference pulLockStatus);

    /**
     * @brief: 录像月历查询
     * @param: IN lUserID 设备句柄
     * @param: IN stSearchParam 查询条件结构体
     * @param: OUT psetResult 查询结果结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetMonthlyRecord(int lUserID, IDM_DEV_MRD_SEARCH_PARAM_S.ByValue stSearchParam, IDM_DEV_MRD_SEARCH_RESULT_S psetResult);

    /**
     * @brief: 录像月历查询
     * @param: IN lUserID 设备句柄
     * @param: IN stSearchParam 查询条件结构体
     * @param: OUT psetResult 查询结果结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetMonthlyRecord_Ex(int lUserID, IDM_DEV_MRD_SEARCH_PARAM_EX_S.ByValue stSearchParam, IDM_DEV_MRD_SEARCH_RESULT_S psetResult);

    /**
     * @brief: 录像文件下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownloadCond 录像下载条件
     * @param: IN pcSavedFileName 下载后保存的文件名(包含路径)
     * @param: OUT plFileHandle 文件句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_DownloadFile(int lUserID, IDM_DEV_PLAYBACK_COND_S pstDownloadCond, Pointer pcSavedFileName, IntByReference plFileHandle);

    /**
     * @brief: 录像文件下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownloadCond 录像下载条件
     * @param: IN pcSavedFileName 下载后保存的文件名(包含路径)
     * @param: OUT plFileHandle 文件句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DownloadFile(int lUserID, IDM_DEV_PLAYBACK_COND_S pstDownloadCond, byte pcSavedFileName[], IntByReference plFileHandle);


    /*
     *@brief: 布防通道信息查询
     *@param: IN lAlarmHandle      布防句柄
     *@param: IN szRequestParam    请求参数JSON字符串 目前支持通道号 {\"channel_no\":[1,2,3]}
     *@param: IN uiRequestParamLen 请求参数JSON字符串长度
     *@param: OUT pstResponse 响应结构体 内存由SDK申请 需要用户调用IDM_DEV_Free释放
     *@return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_AlarmSetUpQuery(int lUserID, Pointer szRequestParam, int uiRequestParamLen, IDM_DEV_ALARM_INFO_S.ByReference pstResponse);

    /**
     * @brief: 录像文件下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownloadCond 录像下载条件
     * @param: IN pfDownloadCallback 录像下载以帧模式的回调函数
     * @param: IN pcSavedFileName 下载后保存的文件名(包含路径),普通下载模式
     * @param: OUT plFileHandle 文件句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_DownloadFile_Ex(int lUserID, IDM_DEV_PLAYBACK_COND_S.ByReference pstDownloadCond, IDM_DEV_Download_Callback_PF pfDownloadCallback, Pointer pcSavedFileName, Pointer pUserData, IntByReference plFileHandle);

    int IDM_DEV_DownloadFile_Ex(int lUserID, Pointer pstDownloadCond, IDM_DEV_Download_Callback_PF pfDownloadCallback, Pointer pcSavedFileName, Pointer pUserData, IntByReference plFileHandle);

    /**
     * @brief: 录像文件下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownloadCond 录像下载条件
     * @param: IN pfDownloadCallback 录像下载以帧模式的回调函数
     * @param: IN pcSavedFileName 下载后保存的文件名(包含路径),普通下载模式
     * @param: OUT plFileHandle 文件句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DownloadFile_Ex(int lUserID, IDM_DEV_PLAYBACK_COND_S pstDownloadCond, IDM_DEV_Download_Callback_PF pfDownloadCallback, byte pcSavedFileName[], Pointer pUserData, IntByReference plFileHandle);

    /**
     * @brief: 设置录像文件下载回调函数
     * @param: IN lPlayBackHandle 录像文件下载句柄
     * @param: IN pfVodDownloadFileCallback 录像文件下载数据回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DownloadFileData(int lUserID, IDM_DEV_PLAYBACK_COND_S pstDownloadCond, IDM_DEV_Download_Callback_PF pfDownloadCallback, Pointer pUserData, IntByReference plFileHandle);

    /**
     * @brief: 停止录像文件下载
     * @param: IN lFileHandle 文件句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopDownloadFile(int lFileHandle);

    /**
     * @brief: 查询录像文件下载进度
     * @param: IN lFileHandle 文件句柄
     * @param: OUT total_len  文件的总大小(若该值为0，则标识正在请求中)
     * @param: OUT down_len   已下载大小
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_GetDownloadProgress(int lFileHandle, LongByReference total_len, LongByReference down_len);

    /**
     * @brief: 查询录像文件下载进度
     * @param: IN lFileHandle 文件句柄
     * @param: OUT total_len  文件的总大小(若该值为0，则标识正在请求中)
     * @param: OUT down_len   已下载大小
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetDownloadProgress(int lFileHandle, LongBuffer total_len, LongBuffer down_len);

    /**
     * @brief: 批量获取设备配置
     * @param: IN lUserID 设备句柄
     * @param: IN ulCommand 命令号
     * @param: IN ulCount 命令号
     * @param: IN pInBuffer 输入参数指针，根据命令号对应不同结构体
     * @param: IN ulInBufferSize 输入参数长度
     * @param: OUT pOutBuffer 输出参数指针，根据命令号对应不同结构体
     * @param: OUT ulOutBufferSize 输出参数长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetMultipleConfig(int lUserID, int ulCommand, int ulCount, Pointer pInBuffer, int ulInBufferSize, Pointer pOutBuffer, int ulOutBufferSize);

    /**
     * @brief: 批量设置设备配置
     * @param: IN lUserID 设备句柄
     * @param: IN ulCommand 命令号
     * @param: IN pInBuffer 输入参数指针，根据命令号对应不同结构体
     * @param: IN ulInBufferSize 输入参数长度
     * @param: OUT pOutBuffer 输出参数指针，根据命令号对应不同结构体
     * @param: OUT ulOutBufferSize 输出参数长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetMultipleConfig(int lUserID, int ulCommand, int ulCount, Pointer pInBuffer, int ulInBufferSize, Pointer pOutBuffer, int ulOutBufferSize);

    /**
     * @brief: 获取设备能力集
     * @param: IN lUserID 设备句柄
     * @param: IN ulAbilityType 能力集类型
     * @param: IN pcInBuffer 输入数据指针
     * @param: IN ulInLength 输入数据长度
     * @param: OUT pcOutBuffer 输出数据指针
     * @param: OUT ulOutLength 输出数据长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_GetAbility(int lUserID, int ulAbilityType, Pointer pcInBuffer, int ulInLength, Pointer pcOutBuffer, int ulOutLength);

    /**
     * @brief: 获取设备能力集
     * @param: IN lUserID 设备句柄
     * @param: IN ulAbilityType 能力集类型
     * @param: IN pcInBuffer 输入数据指针
     * @param: IN ulInLength 输入数据长度
     * @param: OUT pcOutBuffer 输出数据指针
     * @param: OUT ulOutLength 输出数据长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetAbility(int lUserID, int ulAbilityType, String pcInBuffer, int ulInLength, String pcOutBuffer, int ulOutLength);

    /**
     * @brief: REST API透传
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 请求参数
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_TransRestApi(int lUserID, IDM_DEV_REQUEST_PARAM_S pstRequest, IDM_DEV_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 名单库库配置
     * @param: IN lUserID 设备句柄
     * @param: IN stParamIn 输入名单库操作信息
     * @param: OUT pstParamOut 输出名单库操作结果信息
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_RepositoryOpt(int lUserID, IDM_DEV_REPOSITORY_OPT_PARAM_S.ByValue stParamIn, IDM_DEV_REPOSITORY_OPT_PARAMOUT_S pstParamOut);

    /**
     * @brief: 名单库库内容配置
     * @param: IN plRepoHandle 通过IDM_DEV_RepositoryOpt加载名单库返回的句柄
     * @param: IN stParam 输入命令和对应参数的结构体
     * @param: OUT pszResult 输出操作结果JSON字符串数据的缓冲指针
     * @param: OUT pulResultSize 输出数据的缓冲长度
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_RepositoryControl(int lRepoHandle, IDM_REPOSITORY_CONTROL_PARAM_S.ByValue stParam, IDM_REPOSITORY_CONTROL_RESULT_S pstResult);

    /**
     * @brief: 手动抓拍透传
     * @param: IN lUserID 设备句柄
     * @param: IN pInter 抓拍参数
     * @param: OUT pOuter 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ManualSnap(int lUserID, IDM_DEV_MANUALSNAP_S pInter, IDM_DEV_MANUALSNAP_RESULT_S pOuter);

    /**
     * @brief: 手动抓拍牌识
     * @param: IN lUserID 设备句柄
     * @param: IN pInter 抓拍参数
     * @param: OUT pOuter 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ManualSnap_Ex(int lUserID, IDM_DEV_MANUALSNAP_EX_S pInter, IDM_DEV_MANUALSNAP_RESULT_EX_S pOuter);

    /**
     * @brief: 启动搜索服务
     * @param: IN pfSearchCallback 搜索结果回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartSearchDevices(IDM_DEV_SearchDevice_Callback_PF pfSearchCallback, Pointer pUserData);

    /**
     * @brief: 停止搜索服务
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopSearchDevices();

    /**
     * @brief: 通过IP搜索设备
     * @param: IN pfSearchCallback 搜索结果回调函数
     * @param: IN pUserData 用户数据
     * @param: IN sDevIP 设备IP地址
     * @param: IN usDevPort 设备端口号
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SearchDevice(IDM_DEV_SearchDevice_Callback_PF pfSearchCallback, Pointer pUserData, Pointer szIP, short usPort);

    /**
     * @brief: 通过IP搜索设备
     * @param: IN pfSearchCallback 搜索结果回调函数
     * @param: IN pUserData 用户数据
     * @param: IN sDevIP 设备IP地址
     * @param: IN usDevPort 设备端口号
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SearchDevice(IDM_DEV_SearchDevice_Callback_PF pfSearchCallback, Pointer pUserData, String szIP, short usPort);

    /**
     * @brief: 设备激活
     * @param: IN sDevIP 设备IP地址
     * @param: IN usDevPort 设备端口号
     * @param: IN pActivateInfo 激活信息
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_ActivateDevice(Pointer sDevIP, short usDevPort, IDM_DEV_ACTIVATE_INFO_S.ByReference pActivateInfo);

    /**
     * @brief: 设备激活
     * @param: IN sDevIP 设备IP地址
     * @param: IN usDevPort 设备端口号
     * @param: IN pActivateInfo 激活信息
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ActivateDevice(String sDevIP, short usDevPort, IDM_DEV_ACTIVATE_INFO_S pActivateInfo);

    /**
     * @brief: 设置设备报警输出
     * @param: IN lUserID 设备句柄
     * @param: IN pstAlarmControl 报警输出详细控制参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetAlarmOut_EX(int lUserID, IDM_DEV_ALARMOUT_CONTROL_S pstAlarmControl);

    /**
     * @brief: 获取设备报警输出
     * @param: IN lUserID 设备句柄
     * @param: OUT pstAlarmOutStatus 报警输出状态
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetAlarmOut(int lUserID, IDM_DEV_ALARMOUT_STATUS_S pstAlarmOutStatus);

    /**
     * @brief: 启动语音转发
     * @param: IN lUserID 设备句柄
     * @param: IN pstVoiceComInfo 语音转发参数
     * @param: IN pfVoiceComCallback 音频数据回调函数
     * @param: IN pUserData 用户数据指针
     * @param: OUT plVoiceComHandle 语音转发句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartVoiceCom(int lUserID, IDM_DEV_VOICECOM_INFO_S pstVoiceComInfo, IDM_DEV_VoiceCom_Callback_PF pfVoiceComCallback, Pointer pUserData, IntByReference plVoiceComHandle);

    /**
     * @brief: 停止语音转发
     * @param: IN plVoiceComHandle 语音转发句柄
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopVoiceCom(int lVoiceComHandle);

    /**
     * @brief: 转发语音数据
     * @param: IN plVoiceComHandle 语音转发句柄
     * @param: IN pSendBuf 存放语音数据的缓冲区
     * @param: IN ulBufSize 语音数据大小
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_VoiceComSendData(int lVoiceComHandle, Pointer pSendBuf, int ulBufSize);

    /**
     * @brief: 转发语音数据
     * @param: IN plVoiceComHandle 语音转发句柄
     * @param: IN pSendBuf 存放语音数据的缓冲区
     * @param: IN ulBufSize 语音数据大小
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_VoiceComSendData(int lVoiceComHandle, String pSendBuf, int ulBufSize);

    /**
     * @brief: 组播获取tcp/ip配置
     * @param: IN DevSN 设备序列号
     * @param: OUT psTCPIPConfig 组播获取ip配置结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_GetTCPIPConfig(Pointer DevSN, IDM_DEV_TCPIP_CFG_S psTCPIPConfig);

    /**
     * @brief: 组播获取tcp/ip配置
     * @param: IN DevSN 设备序列号
     * @param: OUT psTCPIPConfig 组播获取ip配置结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetTCPIPConfig(String DevSN, IDM_DEV_TCPIP_CFG_S.ByReference psTCPIPConfig);

    /**
     * @brief: 组播设置tcp/ip配置
     * @param: IN psTriggerAlarmVoice 组播设置ip配置结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetTCPIPConfig(IDM_DEV_TCPIP_CFG_S.ByReference psTCPIPConfig);

    /**
     * @brief: P2P穿网信息协商
     * @param: IN lUsrID 设备句柄
     * @param: IN psP2PThroughNet p2p穿网信息协商结构体
     * @param: IN psP2PThroughResult p2p穿网信息协商返回结果结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_P2PThroughNet(int lUserID, IDM_DEV_P_S2P_THROUGH_NET psP2PThroughNet, IDM_DEV_P_S2P_THROUGH_RESULT psP2PThroughResult);

    /**
     * @brief: 0. 释放结构体中的动态内存
     * IDM_FREE(&响应结构体变量);或者 IDM_DEV_Free(&响应结构体变量,sizeof(响应结构体变量));
     * 释放内存时 传入结构体地址 将结构体中所有空间置0或者释放 防止野指针
     * 凡是响应结构体中有动态内存的 都需要调用IDM_FREE释放内存
     * @param: pstResponse为需要释放动态内存的结构体首地址
     * @param: sizeOfstResponse结构体空间大小
     * @return: 无返回值
     */
    void IDM_DEV_Free(Pointer pstResponse, int sizeOfstResponse);

    /**
     * @brief: 2.1 设备上通用化算法包结果建表规则查询 需要调用IDM_FREE(响应结构体地址)释放内存
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求信息构成的结构体
     * @param: OUT pstResponse 响应信息构成的结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UNI_QueryAlgoResultTableRules(int lUserID, IDM_UNI_TRANS_REQUEST_PARAM_S pstRequest, IDM_UNI_TRANS_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 2.2 设备上通用化算法包页面配置规则查询 需要调用IDM_FREE(结构体地址)释放内存
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求信息构成的结构体
     * @param: OUT pstResponse 响应信息构成的结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UNI_QueryAlgoConfigWebPage(int lUserID, IDM_UNI_TRANS_REQUEST_PARAM_S pstRequest, IDM_UNI_TRANS_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 2.3 设置设备上通用算法配置规则参数
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求信息构成的结构体
     * @param: OUT pstResponse 响应信息构成的结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UNI_SetAlgoRuleParam(int lUserID, IDM_UNI_TRANS_REQUEST_PARAM_S pstRequest, IDM_UNI_TRANS_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 2.4 获取设备上通用算法配置规则参数 需要调用IDM_FREE(响应结构体地址)释放内存
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求信息构成的结构体
     * @param: OUT pstResponse 响应信息构成的结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UNI_GetAlgoRuleParam(int lUserID, IDM_UNI_TRANS_REQUEST_PARAM_S pstRequest, IDM_UNI_TRANS_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 2.5 已安装算法的查询接口
     * @note : 调用完成后需要调用IDM_FREE(响应结构体地址)释放内存
     * @param: IN  lUserID   设备句柄
     * @param: IN  ulChannel 编号 从0开始  无效值0xFFFF
     * @param: OUT pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_UNI_QueryInstalledAlgo(int lUserID, int ulChannel, IDM_UNI_QUERY_INSTALLED_ALGO_RESPONSE_S pstResponse);

    /**
     * @brief: 2.6 算法切换接口
     * @param: IN  lUserID   设备句柄
     * @param: OUT pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_UNI_SwitchAlgo(int lUserID, IDM_UNI_SWITCH_ALGO_S pstRequest);

    /**
     * @brief: 2.7 加载/升级/卸载算法版本接口
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求信息构成的结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_UNI_LoadAlgo(int lUserID, IDM_UNI_LOAD_ALGO_REQUEST_S pstRequest);

    /**
     * @brief: 启动一键搜索添加设备
     * @param: IN lUsrID 设备句柄
     * @param: IN psStartDevAutoSearchAdd 启动一键搜索添加设备参数结构体
     * @param: OUT lTaskID 启动一键搜索添加设备返回的任务ID,预留，当前只支持一个任务，任务id可以不带
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartDevAutoSearchAdd(int lUserID, IDM_DEV_START_DEV_AUTO_SEARCH_ADD_S psStartDevAutoSearchAdd, IntByReference lTaskID);

    /**
     * @brief: 查询一键搜索添加设备处理进度
     * @param: IN lUsrID 设备句柄
     * @param: OUT psQueryDevAutoAddProgress 查询一键搜索添加设备处理进度结构体
     * @param: IN lTaskID 启动一键搜索添加设备返回的任务ID,预留，当前只支持一个任务，任务id可以不带
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_QueryDevAutoAddProgress(int lUserID, IDM_DEV_QUERY_DEV_AUTO_ADD_PROGRESS_S psQueryDevAutoAddProgress, int lTaskID);


    int IDM_DEV_GetThransFileProgress(int lFileHandle, FloatByReference pfProgress);


    /**
     * @brief: 获取文件上传任务进度
     * @param: IN taskId 任务id
     * @param: OUT curSize 当成已经传输字节数
     * @param: OUT totalSize 总文件字节数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetTransFileProgress(int taskId, IntByReference curSize, IntByReference totalSize);

    /**
     * @brief: 创建文件上传任务
     * @param: IN lUsrID 设备句柄
     * @param: IN psTransFileInfo 创建文件上传任务参数结构体
     * @param: OUT plTaskID 创建文件上传任务返回任务ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_CreatUploadFileTask(int lUserID, IDM_DEV_TRANS_FILE_INFOS_S psTransFileInfo, IntByReference plTaskID);

    /**
     * @brief: 创建文件下载任务
     * @param: IN lUsrID 设备句柄
     * @param: IN psDownloadFileInfo 创建文件下载任务参数结构体
     * @param: OUT plTaskID 创建文件下载任务返回任务ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_CreatDownloadFileTask(int lUserID, IDM_DEV_DOWNLOAD_FILE_INFO_S psDownloadFileInfo, IntByReference plTaskID);


    /**
     * @brief: 上传文件
     * @param: IN lUsrID 设备句柄
     * @param: IN pSendBuf 文件流数据缓冲区
     * @param: IN ulBufSize 文件流数据大小
     * @param: IN lTaskID  文件上传任务ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_UploadFile(int lUserID, String pSendBuf, int ulBufSize, int lTaskID);

    /**
     * @brief: 下载文件
     * @param: IN lUsrID 设备句柄
     * @param: IN pfDownloadFileCallback 文件下载回调函数
     * @param: IN lTaskID  文件下载任务ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DownloadFileS(int lUserID, IDM_DEV_TransFile_Callback_PF pfDownloadFileCallback, int lTaskID);

    /**
     * @brief: 手动触发语音播放
     * @param: IN lUsrID 设备句柄
     * @param: IN psTriggerAlarmVoice 触发语音播放结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_TrrigerAlarmVoice(int lUserID, IDM_DEV_TRIGGER_ALARM_VOICE_S psTriggerAlarmVoice);

    /**
     * @brief: 设置全局超时时间
     * @param: IN lWaitTimems 超时时间单位ms(建议3000-5000)
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetGlobalWaitTime(int lWaitTimems);

    /**
     * @brief: REST API透传V2
     * @note : 请求结构体空间由用户自行管理   需要调用IDM_FREE(响应结构体地址)释放内存
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 请求参数
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_TransRestApi_V2(int lUserID, IDM_DEV_REQUEST_PARAM_S pstRequest, IDM_DEV_RESPONSE_PARAM_S pstResponse);

    /**
     * @brief: 获取设备二维码
     * @param: IN lUserID 设备句柄
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetQRCode(int lUserID, IDM_DEV_QR_RESPONSE_S pstResponse);

    /**
     * @brief: 15. 查询设备信息    需要调用IDM_FREE(响应结构体地址)释放动态内存
     * @param: IN    lUserID    设备句柄
     * @param: IN    szDeviceID 设备ID
     * @param: OUT   pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_QueryDeviceInfo(int lUserID, Pointer szDeviceID, IDM_DEV_QUERY_DEV_INFO_S pstResponse);

    /**
     * @brief: 15. 查询设备信息    需要调用IDM_FREE(响应结构体地址)释放动态内存
     * @param: IN    lUserID    设备句柄
     * @param: IN    szDeviceID 设备ID
     * @param: OUT   pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_QueryDeviceInfo(int lUserID, String szDeviceID, IDM_DEV_QUERY_DEV_INFO_S pstResponse);

    /**
     * @brief: 关闭主动注册模式下的套接字
     * @param: IN    szDeviceID 设备ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_CloseTcpSocket(Pointer szDeviceID);

    /**
     * @brief: 关闭主动注册模式下的套接字
     * @param: IN    szDeviceID 设备ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_CloseTcpSocket(String szDeviceID);

    /**
     * 获取SDK版本 字符串信息
     */
    Pointer IDM_DEV_GetSDKStringVersion();

    /**
     * @brief: 设置录像下载进度回调函数
     * @param: IN lDownloadHandle 下载句柄
     * @param: IN pfDownloadProgressCallback 录像下载进度回调函数
     * @param: IN pUserData 用户数据
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetDownloadProgressCallback(int lDownloadHandle, IDM_DEV_Download_Progress_Callback_PF pfDownloadProgressCallback, Pointer pUserData);

    /**
     * @brief: 启动抓拍图片批量下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 启动抓拍图片批量下载参数结构体
     * @param: IN szFilePath 文件单个/批量下载保存路径
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_StartSapPicDownload(int lUserID, IDM_DEV_SAP_PIC_BATCH_DOWONLOAD_S pstRequest, IDM_START_PIC_DOWNLOAD_RESULT_S pstResponse, Pointer szFilePath);

    /**
     * @brief: 启动抓拍图片批量下载
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 启动抓拍图片批量下载参数结构体
     * @param: IN szFilePath 文件单个/批量下载保存路径
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartSapPicDownload(int lUserID, IDM_DEV_SAP_PIC_BATCH_DOWONLOAD_S pstRequest, IDM_START_PIC_DOWNLOAD_RESULT_S pstResponse, String szFilePath);

    /**
     * @brief: 停止抓拍图片批量下载
     * @param: IN szPicDownloadSessionID 启动抓拍图片批量下载接口返回结果结构体中的，下载会话ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_StopSapPicDownload(Pointer szPicDownloadSessionID);

    /**
     * @brief: 停止抓拍图片批量下载
     * @param: IN szPicDownloadSessionID 启动抓拍图片批量下载接口返回结果结构体中的，下载会话ID
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopSapPicDownload(String szPicDownloadSessionID);

    /**
     * @brief: 停止抓拍图片批量下载
     * @param: IN szPicDownloadSessionID 启动抓拍图片批量下载接口返回结果结构体中的，下载会话ID
     * @param: IN pstProgress 下载进度结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_GetSapPicDownloadProgess(Pointer szPicDownloadSessionID, IDM_SNAP_PIC_DOWNLOAD_PROGRESS_S pstProgress);

    /**
     * @brief: 停止抓拍图片批量下载
     * @param: IN szPicDownloadSessionID 启动抓拍图片批量下载接口返回结果结构体中的，下载会话ID
     * @param: IN pstProgress 下载进度结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetSapPicDownloadProgess(String szPicDownloadSessionID, IDM_SNAP_PIC_DOWNLOAD_PROGRESS_S pstProgress);

    /**
     * @brief: 文件单个/批量下载，10M以内的文件
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownlodFiles 文件单个/批量下载参数结构体
     * @param: IN szFilePath 文件单个/批量下载保存路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_DownloadSmallFiles(int lUserID, IDM_DOWNLOAD_FILES_S pstDownlodFiles, Pointer szFilePath);

    /**
     * @brief: 文件单个/批量下载，10M以内的文件
     * @param: IN lUserID 设备句柄
     * @param: IN pstDownlodFiles 文件单个/批量下载参数结构体
     * @param: IN szFilePath 文件单个/批量下载保存路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DownloadSmallFiles(int lUserID, IDM_DOWNLOAD_FILES_S pstDownlodFiles, String szFilePath);

    /**
     * @brief: 查询公有云解析任务抓图计划
     * @param: IN lUserID 设备句柄
     * @param: IN pstTaskID 任务id列表结构体
     * @param: IN/OUT pstAnalysisTaskSnapPlan 获取抓图计划返回结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetAnalysisPicSnapPlan(int lUserID, IDM_DEV_TASK_ID_S pstTaskID, IDM_DEV_ANALISYS_TASK_SNAP_PLAN_S pstAnalysisTaskSnapPlan);

    /**
     * @brief: 设置公有云解析任务抓图计划
     * @param: IN lUserID 设备句柄
     * @param: IN pstPicSnapPlan 设置抓图计划结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetAnalysisPicSnapPlan(int lUserID, IDM_DEV_ANALISYS_TASK_SNAP_PLAN_S pstAnalysisTaskSnapPlan);

    /**
     * @brief: 删除公有云解析任务抓图计划
     * @param: IN lUserID 设备句柄
     * @param: IN pstTaskID 任务id列表结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_DelAnalysisPicSnapPlan(int lUserID, IDM_DEV_TASK_ID_S pstTaskID);

    /**
     * @brief: 设置公有云解析任务抓图计划使能状态
     * @param: IN lUserID 设备句柄
     * @param: IN pstTaskID 任务id列表结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetAnalysisPicSnapPlanEnale(int lUserID, IDM_DEV_TASK_ID_S pstTaskID);

    /**
     * @brief: 手动抓拍透传V2
     * @param: IN lUserID 设备句柄
     * @param: IN pInter 抓拍参数  内存由用户自行管理
     * @param: OUT pOuter 响应参数 调用IDM_FREE进行内存释放
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ManualSnap_V2(int lUserID, IDM_DEV_MANUALSNAP_S pInter, IDM_DEV_MANUALSNAP_RESULT_S pOuter);

    /**
     * @param: IN lUserID 设备句柄
     * @param: IN stFileCond 查找条件
     * @param: OUT pstFileResult 查找结果
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_FindFile_V3(int lUserID, IDM_DEV_FILE_COND_V_S3.ByValue stFileCond, IDM_DEV_FILE_RESULT_V_S3 pstFileResult);

    /**
     * @brief: 启动升级
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 请求结构体
     * @param: OUT pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartUpgrade(int lUserID, IDM_DEV_UPGRADE_REQUEST_S pstRequest, IDM_DEV_UPGRADE_SESSION_S pstResponse);

    /**
     * @brief: 终止升级
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 请求结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StopUpgrade(int lUserID, IDM_DEV_UPGRADE_SESSION_S pstRequest);

    /**
     * @brief: 获取升级状态
     * @param: IN lUserID 设备句柄
     * @param: IN pstRequest 请求结构体
     * @param: OUT pstResponse 响应结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetUpgradeStatus(int lUserID, IDM_DEV_UPGRADE_SESSION_S pstRequest, IDM_DEV_UPGRADE_STATUS_S pstResponse);

    /**
     * @brief: 保存实时流到文件 V2
     * @param: IN lRealPlayHandle 预览句柄
     * @param: IN pcFileName 保存的文件路径
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SaveRealPlayData_V2(int lRealPlayHandle, IDM_DEV_SAVE_DATA_INFO_S pFileInfo);

    /**
     * @brief: 保存回放流到文件 V2
     * @param: IN lRealPlayHandle 回放句柄
     * @param: IN pFileInfo       文件信息
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SavePlayBackData_V2(int lPlayBackHandle, IDM_DEV_SAVE_DATA_INFO_S pFileInfo);

    /**
     * @brief: 开启被动模式监听服务 V2
     * @param: IN usSerPort 监听端口
     * @param: IN pUserData 回调函数返回的用户数据
     * @param: IN pfConnectCallback 设备连接后从回调函数中返回
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_StartServer_V2(short usSerPort, Pointer pUserData, IDM_DEV_Connect_Callback_PF_V2 pfConnectCallback);

    /**
     * @brief: 下载URL对应图片
     * @note : 响应结构体中内存由用户调用IDM_DEV_Free(响应结构体首地址, 响应结构体长度)进行释放
     * @param: IN lUserID 设备句柄
     * @param: IN pRequst 请求参数
     * @param: OUT pResp 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetImageByURL(int lUserID, IDM_DEV_WGET_IMAGE_S pRequest, IDM_DEV_IMAGE_RESPONSE_S pResponse);

    /**
     * @brief: 公有云平台注册证书
     * @param: IN pstRequest 请求参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_RegisterCert(IDM_DEV_CERTIFICATE_INFO_S pCertInfo);

    /**
     * @brief: 算法操作接口
     * @param: IN  lUserID    设备句柄
     * @param: IN  szAlgoID   算法ID   PERIMETER_ALGO_ID 周界 或者 AIUNITE_ALGO_ID 人脸比对
     * @param: IN  pstParam   参数结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_UNI_AlgoOp(int lUserID, Pointer szAlgoID, IDM_UNI_ALGO_OP_S pstParam);

    /**
     * @brief: 算法操作接口
     * @param: IN  lUserID    设备句柄
     * @param: IN  szAlgoID   算法ID   PERIMETER_ALGO_ID 周界 或者 AIUNITE_ALGO_ID 人脸比对
     * @param: IN  pstParam   参数结构体
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_UNI_AlgoOp(int lUserID, byte szAlgoID[], IDM_UNI_ALGO_OP_S pstParam);

    /**
     * @brief: 5 修改用户密码
     * @param: IN  lUserID 设备句柄
     * @param: IN  pstRequest 请求参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ResetUserPassword(int lUserID, IDM_DEV_RESET_PASSWORD_S pstRequest);

    /**
     * @brief: 获取设备树V2(通道列表)
     * 使用完后需要调用IDM_DEV_FREE释放结构体中开辟的内存
     * @param: IN  lUserID 设备句柄
     * @param: OUT pstResponse 响应参数
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_GetDevTree_V2(int lUserID, DEV_TREE_GET_RESPONSE_S_V2 pstResponse);

    /**
     * @brief: 强制I帧
     * @param: IN lUserID    登录成功分配的设备句柄
     * @param: IN pstRequest 请求参数结构体地址
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_ForceSendIFrame(int lUserID, IDM_DEV_FORCE_I_FRAME_S pstRequest);

    /**
     * @brief: 修改本机设备名称
     * @param: IN lUserID 设备句柄
     * @param: IN szDeviceName 设备名称
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */

    int IDM_DEV_SetLocalDeviceName(int lUserID, Pointer szDeviceName);

    /**
     * @brief: 修改本机设备名称
     * @param: IN lUserID 设备句柄
     * @param: IN szDeviceName 设备名称
     * @return: 成功返回IDM_SUCCESS，失败返回错误码
     */
    int IDM_DEV_SetLocalDeviceName(int lUserID, String szDeviceName);

    /**
     * @brief 设置图像视频模式
     * @param: IN lUserID 登录接口返回的id
     * @param: const IDM_DEV_SET_VIDEO_MODE_S *pstMode 图像视频模式参数结构体
     * @returns: IDM_API INT
     */
    int IDM_DEV_SetVideoMode(int lUserID, IDM_DEV_SET_VIDEO_MODE_S.ByReference pstMode);


}




