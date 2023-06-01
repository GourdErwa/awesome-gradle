package com.hoteamsoft.nevermore.cloud.common.web;

/**
 * HTTP 响应体.
 *
 * @author Li.Wei by 2022/11/25
 */
public interface Response {

    /**
     * Is success boolean.
     *
     * @return the boolean
     */
    boolean isSuccess();

    /**
     * Gets error code.
     *
     * @return the error code
     */
    String getErrorCode();

    /**
     * Gets error msg.
     *
     * @return the error msg
     */
    String getErrorMsg();

    /**
     * Gets page info.
     *
     * @return the page info
     */
    PageInfo getPageInfo();
}
