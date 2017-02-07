package com.hrocloud.common.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.hrocloud.common.api.CommParamInfoService;
import com.hrocloud.common.api.model.ParamValue;
import com.hrocloud.common.dto.ParamValueDTO;
import com.hrocloud.util.CommonUtil;

/**
 * Created by hanzhihua on 2016/11/23.
 */
public abstract class Utils {

    private static final long DEFAULT_DOMAIN_ID = 1000;

    public static long genDeviceId(){
        return -(System.currentTimeMillis() * 1000 + new Random().nextInt(999));
    }

    public static String getSessionKey(long domainId,long userId){
        return domainId+"_"+userId;
    }

    public static long getDomainId(long appId){
        return DEFAULT_DOMAIN_ID;
    }

    public static String getSessionKey(long userId){
        return DEFAULT_DOMAIN_ID+"_"+userId;
    }

    /**
     * build the list according to the enum value
     *
     * @param listCode
     * @param definecls 定义枚举的类
     * @param t
     * @param allItem   check if get all the allItem, or just the checked item
     * @return
     */
    public static <T> List<ParamValueDTO> buildAgwParamList(String listCode, Class definecls,CommParamInfoService commParamInfoService, T t, boolean allItem) {
        List<ParamValueDTO> list = new ArrayList<ParamValueDTO>();
        List<ParamValue> listVL = null;
        if (t instanceof String)
            listVL = CommonUtil.getValueList(commParamInfoService,listCode, definecls, (String) t, allItem);
        else if (t instanceof Integer)
            listVL = CommonUtil.getValueList(listCode, definecls, (Integer) t, allItem);
        else
            return null;

        if (listVL == null)
            return null;
        for (ParamValue vl : listVL) {
            list.add(new ParamValueDTO(vl));
        }
        return list;
    }


    /**
     *
     * @param paramValue
     * @param pvList
     * @return
     */
    public static String getParamValueDesc(String paramValue, List<ParamValueDTO> pvList) {
        for (ParamValueDTO pv : pvList) {
            if (pv.code.equalsIgnoreCase(paramValue)) {
                return pv.desc;
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        /*   System.out.println(CommonUtil.getUUID());
           for (UserStatus status : UserStatus.values()) {
               System.out.println(status.getKey());
               System.out.println(status.toString());Define
               System.out.println(status.getDesc());
           }
           List<ValueListDTO> list = CommonUtil.buildListFromEnum(UserStatus.class, 1, true);*/

    	
         // List<ParamValue> list = CommonUtil.getValueList("selmonths", null, 1, true);
          // List<ParamValue> list=CommonUtil.getValueList(commParamInfoService, "taxtype", null, "", true);
    
         //  System.out.println("hello");
       }
}
