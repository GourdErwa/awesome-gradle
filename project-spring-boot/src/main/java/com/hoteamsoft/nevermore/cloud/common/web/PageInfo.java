package com.hoteamsoft.nevermore.cloud.common.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The type Page info.
 *
 * @author liwei
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "分页信息")
public class PageInfo {
    /**
     * 页码
     */
    @Schema(description = "页码")
    private final int num;
    /**
     * 每页展示的大小
     */
    @Schema(description = "每页大小")
    private final int size;
    /**
     * 总的页数
     */
    @Schema(description = "总页数")
    private final long count;
    /**
     * 该条件下总共的数据条数
     */
    @Schema(description = "数据总条数")
    private final long total;

    public static PageInfo of(int pageNum, int pageSize, long total) {
        // 根据每页的记录数，计算总的页数
        long pageCount = (total + pageSize - 1) / pageSize;
        return new PageInfo(pageNum, pageSize, pageCount, total);
    }
}
