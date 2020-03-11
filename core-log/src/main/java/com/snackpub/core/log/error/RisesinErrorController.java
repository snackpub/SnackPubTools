package com.snackpub.core.log.error;

import com.snackpub.core.tools.jackson.JsonUtil;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 更改html请求异常为ajax
 * @author Administrator
 */
public class RisesinErrorController extends BasicErrorController {
    public RisesinErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = this.getStatus(request);
        response.setStatus(status.value());
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setObjectMapper(JsonUtil.getInstance());
        view.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return new ModelAndView(view, body);
    }
}
