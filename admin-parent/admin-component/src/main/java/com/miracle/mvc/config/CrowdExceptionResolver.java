package com.miracle.mvc.config;

import com.google.gson.Gson;
import com.miracle.util.CrowdConstant;
import com.miracle.util.CrowdUtil;
import com.miracle.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Miracle
 * @version v1.0
 * @description TODO
 * @date 2021-03-27 14:39
 */
@ControllerAdvice
public class CrowdExceptionResolver {
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws IOException {
        String viewName = "system-error";
        return commonResolve(viewName, exception, request, response);
    }

    private ModelAndView commonResolve(String viewName,
                                       Exception exception,
                                       HttpServletRequest request,
                                       HttpServletResponse response) throws IOException {
        boolean isJsonRequest = CrowdUtil.isJsonRequest(request);
        if (isJsonRequest) {
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            Gson gson = new Gson();
            String json = gson.toJson(resultEntity);
            response.getWriter().write(json);
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowdConstant.ATTR_NAME_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
