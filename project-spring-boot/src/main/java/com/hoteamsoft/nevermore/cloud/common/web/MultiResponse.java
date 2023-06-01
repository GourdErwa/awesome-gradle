package com.hoteamsoft.nevermore.cloud.common.web;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/**
 * 集合类型数据响应体
 *
 * @author Li.Wei by 2022/11/25
 */
@Schema(description = "响应数据体-集合类")
public class MultiResponse<T> extends BaseResponse {
    /**
     * 数据对象，无数据默认为 null
     */
    @Nullable
    @Schema(description = "数据体列表")
    private final Collection<T> data;

    public MultiResponse(
            boolean success,
            @Nullable String errorCode,
            @Nullable String errorMsg,
            @Nullable PageInfo pageInfo,
            @Nullable Collection<T> data) {
        super(success, errorCode, errorMsg, pageInfo);
        this.data = data;
    }

    public static <T> MultiResponse<T> success() {
        return success(null, null);
    }

    public static <T> MultiResponse<T> success(Collection<T> data) {
        return success(data, null);
    }

    public static <T> MultiResponse<T> success(Collection<T> data, PageInfo pageInfo) {
        return new MultiResponse<T>(true, null, null, pageInfo, data);
    }

    public static <T> MultiResponse<T> failure(String errorCode, String errorMsg) {
        return failure(errorCode, errorMsg, null);
    }

    public static <T> MultiResponse<T> failure(String errorCode, String errorMsg, Collection<T> data) {
        return new MultiResponse<>(false, errorCode, errorMsg, null, data);
    }

    /**
     * 返回数据列表
     *
     * @return List
     */
    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }
}
