package com.miracle.util;

/**
 * @author Miracle
 * @version v1.0
 * @description 用于Ajax结果返回的工具类
 * @date 2021-03-27 12:59
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    /**
     * 封装当前请求的结果是成功或失败
     */
    private String result;
    /**
     * 请求处理失败时返回的错误信息
     */
    private String message;
    /**
     * 返回的T类型的数据
     */
    private T data;

    /**
     * 请求处理成功且不需要返回数据
     *
     * @param <Type> 请求数据类型
     * @return ResultEntity
     */
    public static <Type> ResultEntity<Type> successWithoutData() {
        return new ResultEntity<Type>(SUCCESS, null, null);
    }

    /**
     * 请求处理成功且需要返回数据
     * @param data 数据
     * @param <Type> 请求数据类型
     * @return ResultEntity
     */
    public static <Type> ResultEntity<Type> successWithData(Type data) {
        return new ResultEntity<Type>(SUCCESS, null, data);
    }

    /**
     * 请求处理失败后返回的消息
     * @param message 失败消息内容
     * @param <Type> 请求数据类型
     * @return ResultEntity
     */
    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<Type>(FAILED, message, null);
    }

    public ResultEntity() {
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "result='" + result + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
