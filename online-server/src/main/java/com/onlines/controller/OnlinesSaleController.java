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
import com.onlines.service.ExcelUpload;
import com.onlines.service.IOnlinesPatrolService;
import com.onlines.utils.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.SuiteXmlParser;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

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
//        onlineSaleDto.setPageSize(10);
//        onlineSaleDto.setPageNum(1);
//        onlineSaleDto.setGroup(1);
//        List<OnlinesPatrol> pageInfo = onlinesPatrolService.selectAll(onlineSaleDto);
        PageInfo pageInfo = onlinesPatrolService.selectAll(onlineSaleDto);
        return new ResponseDto(ErrCodelEnum.success.getCode(), pageInfo);
    }

    @PostMapping("/insertInfo")
    @ResponseBody
    public ResponseDto OnlinePatrolAdd(@RequestBody OnlinesPatrol onlinesPatrol) {
        System.out.println("入參：" + JSON.toJSONString(onlinesPatrol));
//        onlinesPatrol.setUrl("url11111");
//        onlinesPatrol.setTitle("title");
//        onlinesPatrol.setHtmlinfo("htmlinfo");
//        onlinesPatrol.setGroup("ceshi");
        if (onlinesPatrol.getUrl() == null || onlinesPatrol.getTitle() == null || onlinesPatrol.getHtmlinfo() == null || onlinesPatrol.getGroupId() == null) {
            return new ResponseDto(ErrCodelEnum.fail.getCode());
        }
        onlinesPatrolService.insertInfoTest(onlinesPatrol);
        return new ResponseDto(ErrCodelEnum.success.getCode());
    }

    //    @GetMapping("")
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


    @PostMapping(value = "/uploadExcl")
    //@GetMapping("/uploadExcl")
    @ResponseBody
    public Map<String, Object> uploadExcl(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        String path = request.getSession().getServletContext().getRealPath("/");

        List<OnlinesPatrol> onlinesPatrols = new ArrayList<>();
        try {
            // 如果文件不为空，写入上传路径
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                InputStream str = file.getInputStream();
                onlinesPatrols = new ExcelUpload().uploadExcel(fileName, str);
            } else {
                String filePath = "D:\\songgaimin\\用例集.xlsx";
                File fileDes = new File(filePath);
                InputStream str = new FileInputStream(fileDes);
                String fileName = fileDes.getName();
                onlinesPatrols = new ExcelUpload().uploadExcel(fileName, str);
            }
            if (!CollectionUtils.isEmpty(onlinesPatrols)) {
                for (OnlinesPatrol onlinesPatrol : onlinesPatrols) {
                    onlinesPatrolMapper.insert(onlinesPatrol);
                }
            }

//            } else {
//                result.put("code", "1");
//                result.put("message", "上传文件为空！");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result.get("code").equals("0")) {
            //根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            //也可以用UUID创建
            String fileName = "";//System.currentTimeMillis() + file.getOriginalFilename();
            //通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = request.getContextPath() + "uploaded" + File.separator + fileName;
            System.out.println(request.getServletPath());
            System.out.println(request.getServletContext());
            System.out.println(request.getServletContext().getRealPath(""));
            System.out.println(request.getServletContext().getRealPath("/"));
            System.out.println(request.getContextPath());
            System.out.println(destFileName);
            //第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            System.out.println(destFile);
            //把浏览器上传的文件复制到希望的位置
//            try {
//               // file.transferTo(destFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            System.out.println(fileName);
        }
        return result;
    }

    @GetMapping("/invokeTestNg11")
    public ResponseDto invokeTestNg11() throws ParseException {
        String xmlName = "testng.xml";
        //根据传递过来的xmlName，找到目录下的对应的xml
        InputStream inputStream = OnlinesSaleController.class.getClassLoader().getResourceAsStream(xmlName);
        TestNG testNG = new TestNG();
        SuiteXmlParser suiteXmlParser = new SuiteXmlParser();
        List<XmlSuite> suites = new ArrayList<>();
        XmlSuite xmlSuite = suiteXmlParser.parse(xmlName, inputStream, true);
        suites.add(xmlSuite);
        //定义一个map键值对
        Map<String,String> parameters = new HashMap<>();
        //此时参数的格式是name:1,2,3,4,5,6
        //要看一下这个xml到底是怎么运行的？去xml文件中xmlAndParamter.xml
        String param="name:1,2";
        parameters.put("list", param);//本身这个xml中就有name这个参数，那么这么做就会替换掉原来的name
        xmlSuite.setParameters(parameters);
        testNG.setXmlSuites(suites);
        //添加一个小的监听器
        TestListenerAdapter listener = new TestListenerAdapter();
        testNG.addListener(listener);

        List list=new ArrayList();
        //list.add();
        testNG.setListenerClasses(list);
        testNG.run();

        //收集通过的用例和失败的用例
        List<ITestResult> pass = listener.getPassedTests();
        //log.info("本次通过的用例数是："+pass.size());
        List<ITestResult> failed = listener.getFailedTests();
        System.out.println("本次失败的用例数是："+failed.size());

        //return testNG.getStatus();
        return new ResponseDto(ErrCodelEnum.success.getCode(), null);
    }
    @GetMapping("/invokerTestng")
    public ResponseDto invokerTestng() throws ParseException {
        System.out.println("invokerTestng");
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suite = Lists.newArrayList();
        suite.add("E:/wumj/project/qa/online-inspection-tracker/online-server/src/main/resources/testng.xml");//path to xml..
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
