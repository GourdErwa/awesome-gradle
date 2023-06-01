package com.hoteamsoft.nevermore.cloud.common.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import lombok.Data;

/**
 * HTTP 响应体基础字段
 *
 * @author Li.Wei by 2022/11/25
 */
@Schema(description = "响应数据体")
@Data
public abstract class BaseResponse implements Response {
    @Schema(description = "请求处理成功标识")
    private boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    @Schema(description = "错误码")
    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    @Schema(description = "错误信息")
    private String errorMsg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    @Schema(description = "分页信息")
    private PageInfo pageInfo;
    /**
     * 调试信息：不可用于业务
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Nullable
    @Schema(description = "调试信息")
    private Object debugMsg;

    public BaseResponse() {}

    public BaseResponse(
            boolean success, @Nullable Object errorCode, @Nullable String errorMsg, @Nullable PageInfo pageInfo) {
        this.success = success;
        this.errorCode = errorCode == null ? null : errorCode.toString();
        this.errorMsg = errorMsg;
        this.pageInfo = pageInfo;
    }
}
