/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.privacy.controller;

import cn.zhuatech.privacy.common.ApiResponse;
import cn.zhuatech.privacy.service.DataSubjectRequestClosureService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/enterprise/privacy")
public class DataSubjectRequestClosureController {
    private final DataSubjectRequestClosureService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DataSubjectRequestClosureController(DataSubjectRequestClosureService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping("/data-subject-request-closure")
    public ApiResponse<DataSubjectRequestClosureService.Assessment> assess(
            @Valid @RequestBody DataSubjectRequestClosureService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
