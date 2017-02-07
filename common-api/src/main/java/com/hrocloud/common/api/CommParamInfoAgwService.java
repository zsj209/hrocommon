package com.hrocloud.common.api;

import com.hrocloud.apigw.client.annoation.*;
import com.hrocloud.apigw.client.define.CommonParameter;
import com.hrocloud.apigw.client.define.SecurityType;
import com.hrocloud.common.dto.*;
import com.hrocloud.common.exception.CommonServiceHttpCode;

import java.util.List;


/**
 * Created by zfy on 2016/12/2.
 * 公共参数信息对外接口
 */
@ApiGroup(name = "commparminfo", minCode = 3000, maxCode = 4000, codeDefine = CommonServiceHttpCode.class, owner = "zfy")
public interface CommParamInfoAgwService {
    /**
     * 删除参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @param delIds
     * @return
     */
    @HttpApi(name = "commparminfo.deleteParamInfo", desc = "刪除公共参数信息信息", security = SecurityType.UserLogin)
    @DesignedErrorCode({CommonServiceHttpCode.C_DELETE_FAILED,
            CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
            CommonServiceHttpCode.C_PARAMETER_ERROR
    })
    int deleteParamInfo(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = true, name = "delIds", desc = "公共参数信息id") String delIds
    );

    /**
     * 添加参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @return
     */
    @HttpApi(name = "commparminfo.insertParamInfo", desc = "添加公共参数信息", security = SecurityType.UserLogin)
    @DesignedErrorCode({
        CommonServiceHttpCode.C_NECESSARY_COLUMN_ERROR,
        CommonServiceHttpCode.C_INSERT_EXISTS,
        CommonServiceHttpCode.C_INSERT_FAILED,
        CommonServiceHttpCode.C_PARAMETER_ERROR
})
    int insertParamInfo(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
            @ApiParameter(required = true, name = "data", desc = "json字符串") String data
    );

    /**
     * 查询参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @param id
     * @param createBy
     * @param updateBy
     * @param companyId
     * @param paramType
     * @param paramName
     * @param comment
     * @return
     */
    @HttpApi(name = "commparminfo.selectParamInfoByColumn", desc = "查询公共参数信息", security = SecurityType.UserLogin)
    public List<CommParamInfoDTO> selectParamInfoByColumn(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "id", desc = "公共参数信息id") int id,
            @ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
            @ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
            @ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
            @ApiParameter(required = false, name = "paramCode", desc = "参数编码") String paramCode,
            @ApiParameter(required = false, name = "paramType", desc = "参数类型") String paramType,
            @ApiParameter(required = false, name = "paramName", desc = "参数名称") String paramName,
            @ApiParameter(required = false, name = "comment", desc = "备注") String comment
    );

    /**
     * 查询参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @param id
     * @param createBy
     * @param updateBy
     * @param companyId
     * @param paramType
     * @param paramName
     * @param comment
     * @param types
     * @param rows
     * @param page
     * @return
     */
    @HttpApi(name = "commparminfo.selectParamInfo", desc = "查询公共参数信息", security = SecurityType.UserLogin)
    CommParamInfoPageDTO selectParamInfo(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "id", desc = "公共参数信息id") int id,
            @ApiParameter(required = false, name = "createBy", desc = "创建人") int createBy,
            @ApiParameter(required = false, name = "updateBy", desc = "更改人") int updateBy,
            @ApiParameter(required = false, name = "companyId", desc = "所属公司") int companyId,
            @ApiParameter(required = false, name = "paramCode", desc = "参数编码") String paramCode,
            @ApiParameter(required = false, name = "paramType", desc = "参数类型") String paramType,
            @ApiParameter(required = false, name = "paramName", desc = "参数名称") String paramName,
            @ApiParameter(required = false, name = "comment", desc = "备注") String comment,
            @ApiParameter(required = false, name = "types", desc = "备注") String types,
            @ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
            @ApiParameter(required = true, name = "page", desc = "当前页") int page
    );

    /**
     * 更改参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @return
     */
    @HttpApi(name = "commparminfo.updateParamInfoByPrimaryKey", desc = "更改公共参数信息", security = SecurityType.UserLogin)
    @DesignedErrorCode({
        CommonServiceHttpCode.C_SELECT_NOT_FOUND,
        CommonServiceHttpCode.C_UPDATE_FAILED
})
    int updateParamInfoByPrimaryKey(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.userId) int userId,
            @ApiParameter(required = true, name = "data", desc = "json字符串") String data
    );

    /**
     * 根据id查询参数信息
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @param id
     * @return
     */
    @HttpApi(name = "commparminfo.selectParamInfoById", desc = "根据参数类型id查询参数信息", security = SecurityType.UserLogin)
    CommParamInfoDTO selectParamInfoById(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = true, name = "id", desc = "主键id") int id
    );

    /**
     * 根据ids查询参数信息集合
     *
     * @param clientIp
     * @param deviceId
     * @param applicationId
     * @param selIds
     * @return
     */
    @HttpApi(name = "commparminfo.selDataListByCodes", desc = "根据参数类型ids查询参数信息", security = SecurityType.UserLogin)
    List<CommParamInfoDTO> selDataListByCodes(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = true, name = "type", desc = "主键id") int type,
            @ApiParameter(required = true, name = "selIds", desc = "主键id") String selIds
    );

    @HttpApi(name = "commparminfo.getTableSelectvl", desc = "获取select选项", security = SecurityType.UserLogin)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    List<String> getTableSelectvl(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "userid", desc = "用户id") int userId,
            @ApiParameter(required = false, name = "selids", desc = "节点id") String selids
    );

    @HttpApi(name = "commparminfo.getSelect", desc = "根据类型编码获取参数信息", security = SecurityType.UserLogin)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    List<ParamValueDTO> getSelect(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "typeCode", desc = "类型编码") String typeCode,
            @ApiParameter(required = false, name = "paramCode", desc = "参数编码") String paramCode);

    @HttpApi(name = "commparminfo.getForIdselName", desc = "根据id查询框 根据id反查名称", security = SecurityType.UserLogin)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    String getForIdselName(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "selId", desc = "查询id") int selId,
            @ApiParameter(required = false, name = "userId", desc = "用户id") int userId,
            @ApiParameter(required = false, name = "selVal", desc = "iD值") int selVal);

    @HttpApi(name = "commparminfo.getForIdselData", desc = "根据id查询信息", security = SecurityType.UserLogin)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    PubForIdselobjRespDTO getForIdselData(
            @ApiAutowired(CommonParameter.clientIp) String clientIp,
            @ApiAutowired(CommonParameter.deviceId) long deviceId,
            @ApiAutowired(CommonParameter.applicationId) long applicationId,
            @ApiParameter(required = false, name = "id", desc = "id") int id,
            @ApiParameter(required = false, name = "strVla", desc = "第一列值") String strVla,
            @ApiParameter(required = false, name = "strVlb", desc = "第二列值") String strVlb,
            @ApiParameter(required = false, name = "strVlc", desc = "第三列值") String strVlc,
            @ApiParameter(required = false, name = "strVld", desc = "第四列值") String strVld,
            @ApiParameter(required = false, name = "strVle", desc = "第五列值") String strVle,
            @ApiParameter(required = false, name = "strVlf", desc = "第六列值") String strVlf,
            @ApiParameter(required = false, name = "strVlg", desc = "第七列值") String strVlg,
            @ApiParameter(required = false, name = "strVlh", desc = "第八列值") String strVlh,
            @ApiParameter(required = false, name = "strVli", desc = "第九列值") String strVli,
            @ApiParameter(required = false, name = "strVlj", desc = "第十列值") String strVlj,
            @ApiParameter(required = true, name = "rows", desc = "每页显示条数") int rows,
            @ApiParameter(required = true, name = "page", desc = "当前页") int page);

    /**
     * 根据参数类型获取参数列表
     * @param typeCode
     * @return
     */
    //TODO:更新错误码
    @HttpApi(name = "commparminfo.getparamlist", desc = "根据参数类型获取参数列表", security = SecurityType.None)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    List<ParamValueDTO> getParamList(@ApiParameter(required = true, name = "typecode", desc = "值列表的编码标识") String typeCode);

    /**
     * 根据参数类型列表获取参数列表组
     * @param paramTypeList
     * @return
     */
    //TODO:更新错误码
    @HttpApi(name = "commparminfo.getparamlistgroup", desc = "根据参数类型列表获取参数列表组", security = SecurityType.None)
    @DesignedErrorCode({CommonServiceHttpCode.C_SELECT_NOT_FOUND})
    List<ParamGroupDTO> getParamList(@ApiParameter(required = true, name = "paramtypelist", desc = "值列表的编码标识列表") List<String> paramTypeList);

}
