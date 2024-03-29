///*
// *  Copyright 2019-2020 Zheng Jie
// *
// *  Licensed under the Apache License, Version 2.0 (the "License");
// *  you may not use this file except in compliance with the License.
// *  You may obtain a copy of the License at
// *
// *  http://www.apache.org/licenses/LICENSE-2.0
// *
// *  Unless required by applicable law or agreed to in writing, software
// *  distributed under the License is distributed on an "AS IS" BASIS,
// *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *  See the License for the specific language governing permissions and
// *  limitations under the License.
// */
//package com.daemu.commons.config;
//
//
//import com.daemu.commons.api.ApiError;
//import com.daemu.commons.api.BusinessException;
//import com.daemu.commons.api.CommonResult;
//import com.daemu.commons.api.IErrorCode;
//import com.daemu.commons.utills.ThrowableUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.MethodParameter;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//
//import java.util.Objects;
//
///**
// * @author Zheng Jie
// * @date 2018-11-23
// */
//@Slf4j
//@RestControllerAdvice
//public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {
//
//
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//
//        Class returnType = methodParameter.getMethod().getReturnType();
//        if (void.class.isAssignableFrom(returnType)) {
//            return CommonResult.success("empty");
//        } else if (Object.class.equals(returnType)) {
//            return o;
//        } else if (returnType.isPrimitive() || CommonResult.class.isAssignableFrom(returnType)) {
//            return o;
//        }
//        return CommonResult.success(o);
//    }
//
//    /**
//     * 处理所有不可知的异常
//     */
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<ApiError> handleException(Throwable e) {
//        // 打印堆栈信息
//        log.error(ThrowableUtil.getStackTrace(e));
//        return buildResponseEntity(ApiError.error(e.getMessage()));
//    }
//
////    /**
////     * BadCredentialsException
////     */
////    @ExceptionHandler(BadCredentialsException.class)
////    public ResponseEntity<ApiError> badCredentialsException(BadCredentialsException e){
////        // 打印堆栈信息
////        String message = "坏的凭证".equals(e.getMessage()) ? "用户名或密码不正确" : e.getMessage();
////        log.error(message);
////        return buildResponseEntity(ApiError.error(message));
////    }
//
//    /**
//     * 处理自定义异常
//     */
//    @ExceptionHandler(value = BusinessException.class)
//    public ResponseEntity<ApiError> businessException(BusinessException e) {
//        // 打印堆栈信息
//        IErrorCode errorCode = e.getErrorCode();
//        log.error(ThrowableUtil.getStackTrace(e));
//        return buildResponseEntity(ApiError.error(errorCode.getCode(), errorCode.getMessage()));
//    }
//
//    /**
//     * 处理所有接口数据验证异常
//     */
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        // 打印堆栈信息
//        log.error(ThrowableUtil.getStackTrace(e));
//        String[] str = Objects.requireNonNull(e.getBindingResult().getAllErrors().get(0).getCodes())[1].split("\\.");
//        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        String msg = "不能为空";
//        if (msg.equals(message)) {
//            message = str[1] + ":" + message;
//        }
//        return buildResponseEntity(ApiError.error(message));
//    }
//
//    /**
//     * 统一返回
//     */
//    private ResponseEntity<ApiError> buildResponseEntity(ApiError errorCode) {
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert requestAttributes != null;
//        return new ResponseEntity<>(errorCode, HttpStatus.valueOf(errorCode.getStatus()));
//    }
//}
