package com.miracle.util;


import javax.servlet.http.HttpServletRequest;

/**
 * @author Miracle
 * @version v1.0
 * @description TODO
 * @date 2021-03-27 13:40
 */
public class CrowdUtil {
    public static boolean isJsonRequest(HttpServletRequest request) {
        String accept = request.getHeader("Accept");
        String requestedWith = request.getHeader("X-Requested-With");
        return (accept != null && accept.contains("json"))
                ||
                (requestedWith != null && requestedWith.contains("XMLHttpRequest"));
    }
}
