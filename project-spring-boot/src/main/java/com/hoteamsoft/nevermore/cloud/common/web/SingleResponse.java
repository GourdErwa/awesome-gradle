package com.hoteamsoft.nevermore.cloud.common.web;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 单值对象类型数据响应体
 *
 * @author Li.Wei by 2022/11/25
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "响应数据体-对象类")
public class SingleResponse<T> extends BaseResponse {
    /**
     * 数据对象，无数据默认为 null
     */
    @Nullable
    @Schema(description = "数据体")
    private T data;

    public SingleResponse(
            boolean success,
            @Nullable Object errorCode,
            @Nullable String errorMsg,
            @Nullable PageInfo pageInfo,
            @Nullable T data) {
        super(success, errorCode, errorMsg, pageInfo);
        this.data = data;
    }

    public static <T> SingleResponse<T> success() {
        return success(null, null);
    }

    public static <T> SingleResponse<T> success(T data) {
        return success(data, null);
    }

    public static <T> SingleResponse<T> success(T data, PageInfo pageInfo) {
        return new SingleResponse<T>(true, null, null, pageInfo, data);
    }

    public static <T> SingleResponse<T> failure(Object errorCode, String errorMsg) {
        return failure(errorCode, errorMsg, null);
    }

    public static <T> SingleResponse<T> failure(Object errorCode, String errorMsg, T data) {
        return new SingleResponse<T>(false, errorCode, errorMsg, null, data);
    }
}
