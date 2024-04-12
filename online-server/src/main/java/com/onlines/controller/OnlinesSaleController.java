package com.onlines.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.onlines.entiry.CaseInfoDto;
import com.onlines.entiry.DataReqDto;
import com.onlines.entiry.OnlineSaleDto;
import com.onlines.entiry.ResponseDto;
import com.onlines.enums.ErrCodelEnum;
import com.onlines.mapper.OnlinesPatrolMapper;
import com.onlines.pojo.H5Stat;
import com.onlines.pojo.OnlinesPatrol;
import com.onlines.service.IOnlinesPatrolService;
import com.onlines.utils.DateUtil;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.*;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value = "patrol/onlines")
public class OnlinesSaleController {
    @Resource
    private IOnlinesPatrolService onlinesPatrolService;
    @Resource
    private OnlinesPatrolMapper onlinesPatrolMapper;
    @GetMapping("/selectInfo")
    public ResponseDto OnlinePatrolSelect(OnlineSaleDto onlineSaleDto) {
        System.out.println("入參：" + JSON.toJSONString(onlineSaleDto));
        PageInfo pageInfo = onlinesPatrolService.selectAll(onlineSaleDto);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @PostMapping("/insertInfo")
    @ResponseBody
    public ResponseDto OnlinePatrolAdd(@RequestBody OnlinesPatrol onlinesPatrol) {
        System.out.println("入參：" + JSON.toJSONString(onlinesPatrol));
        if (onlinesPatrol.getUrl() == null || onlinesPatrol.getTitle() == null || onlinesPatrol.getHtmlinfo() == null || onlinesPatrol.getGroupId() == null) {
            return new ResponseDto(ErrCodelEnum.fail.getCode());
        }
        onlinesPatrolService.insertInfoTest(onlinesPatrol);
        return new ResponseDto(ErrCodelEnum.success.getCode());
    }

    @PostMapping("/updataCaseInfo")
    @ResponseBody
    public ResponseDto UpdataCaseInfo(@RequestBody OnlinesPatrol onlinesPatrol) {
        return new ResponseDto(ErrCodelEnum.success.getCode(), onlinesPatrolService.updataCase(onlinesPatrol));
    }

    //    @PostMapping("/resetDatum")
    @GetMapping("/resetDatum")
//    @ResponseBody
    public ResponseDto resetDatumInfo(int id) {
        return new ResponseDto(ErrCodelEnum.success.getCode(), onlinesPatrolService.resetDatum(id));
    }

    @GetMapping("/delectInfo")
    public ResponseDto OnlinePatrolDelect(int id) {

        if (id <= 0) {
            return new ResponseDto(ErrCodelEnum.fail.getCode(), null, "参数不合法");
        }
        if (onlinesPatrolService.deleteById(id) > 0) {
            return new ResponseDto(ErrCodelEnum.success.getCode());
        }
        return new ResponseDto(ErrCodelEnum.fail.getCode(), null, "id不存在");
    }

    @GetMapping("/getCaseExecInfo")
    public ResponseDto getCaseExecInfo(CaseInfoDto caseInfoDto) {
        System.out.println("入參：" + JSON.toJSONString(caseInfoDto));
        PageInfo pageInfo = onlinesPatrolService.getCaseExecInfo(caseInfoDto);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @GetMapping("/getCaseBaseInfo")
    public ResponseDto getCaseBaseInfo(CaseInfoDto caseInfoDto) {
        System.out.println("入參：" + JSON.toJSONString(caseInfoDto));
        OnlinesPatrol onlinesPatrol = onlinesPatrolService.getCaseBaseInfo(caseInfoDto);
        return new ResponseDto(ErrCodelEnum.success.getCode(), onlinesPatrol);
    }

    @GetMapping("/getFailedCaseInfo")
    public ResponseDto getFailedCaseInfo(DataReqDto params) throws ParseException {
        System.out.println("入參" + params);
        Integer beginDay = params.getBeginDate();
        Integer endDay = params.getEndDate();
        Integer group = params.getGroup();
        if (beginDay == null || endDay == null || group == null) {
            return new ResponseDto(ErrCodelEnum.parameter_error.getCode(), "请检查入参");
        }
        PageInfo pageInfo = onlinesPatrolService.getFailedCaseInfo(DateUtil.getDayStartDate(beginDay), DateUtil.getDayEndDate(endDay), params);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @GetMapping("/getTimeoutCaseInfo")
    public ResponseDto getTimeoutCaseInfo(DataReqDto params) throws ParseException {
        System.out.println("入參" + params);
        Integer beginDay = params.getBeginDate();
        Integer endDay = params.getEndDate();
        Integer group = params.getGroup();
        if (beginDay == null || endDay == null || group == null) {
            return new ResponseDto(ErrCodelEnum.parameter_error.getCode(), "请检查入参");
        }
        PageInfo pageInfo = onlinesPatrolService.getTimeoutCaseInfo(DateUtil.getDayStartDate(beginDay), DateUtil.getDayEndDate(endDay), params);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @GetMapping("/getTestPlanList")
    public ResponseDto getTestPlanList(DataReqDto params) throws ParseException {
        System.out.println("入參" + params);
        Integer beginDay = params.getBeginDate();
        Integer endDay = params.getEndDate();
        if (beginDay == null || endDay == null) {
            return new ResponseDto(ErrCodelEnum.parameter_error.getCode(), "请检查入参");
        }
        PageInfo pageInfo = onlinesPatrolService.getTestPlanList(DateUtil.getDayStartDate(beginDay), DateUtil.getDayEndDate(endDay), params);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @GetMapping("/getH5Stat")
    public ResponseDto getH5Stat(DataReqDto params) throws ParseException {
        System.out.println("入參" + params);
        Integer beginDay = params.getBeginDate();
        Integer endDay = params.getEndDate();
        Integer group = params.getGroup();
        if (beginDay == null || endDay == null || group == null) {
            return new ResponseDto(ErrCodelEnum.parameter_error.getCode(), "请检查入参");
        }
        H5Stat stat = onlinesPatrolService.getH5Stat(DateUtil.getDayStartDate(beginDay), DateUtil.getDayEndDate(endDay), group);
        return new ResponseDto(ErrCodelEnum.success.getCode(), stat);
    }

    @GetMapping("/invokerTestng")
    public ResponseDto invokerTestng() throws ParseException {
        System.out.println("invokerTestng");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suite = Lists.newArrayList();

        suite.add("D:\\gitcode\\11\\online-inspection-tracker\\online-server\\src\\main\\resources\\testng.xml");
        //suite.add("D:/gitcode/11/online-inspection-tracker/online-server/src/main/resources/testng.xml");//path to xml..
        testng.setTestSuites(suite);
        testng.run();
        return new ResponseDto(ErrCodelEnum.success.getCode(), null);
    }

    @GetMapping(value = "/images",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<InputStreamResource> getImage(@RequestParam String imageName, HttpServletResponse response) throws IOException {
        System.out.println("images");
        System.out.println(imageName);
        // 同样的图片资源路径定义
        Path dir = Paths.get(System.getProperty("user.dir") + "/online-images");
        File file = new File(dir + "/" + imageName + ".png");

        // 检查资源是否存在
        if (!file.exists()) {
            System.out.println("资源不存在：" + file.exists());
            return ResponseEntity.notFound().build();
        }

        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        // 设置HTTP响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG); // 根据实际图片类型设置

        // 返回InputStreamResource作为HTTP响应体
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .body(isr);
    }

}
