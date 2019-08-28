package com.bubble.hotel;

import com.alibaba.fastjson.JSON;
import com.bubble.hotel.bean.HotelBean;
import com.bubble.hotel.controller.MessageController;
import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.net.URL;
import java.nio.file.Paths;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 离线导出Swagger生成的API文档
 *
 * @author wugang
 * date: 2019-08-27 16:42
 **/
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest
public class Swagger2OfflineApplicationTests {
    private String outputDir = "target/asciidoc";

    @Autowired
    private MockMvc mockMvc;

//    /**
//     * 初始化 MockMvc 通过MockMvcBuilders.standaloneSetup 模拟一个 MessageController 测试环境，通过build得到一个MockMvc
//     */
//    @Before
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new MessageController()).build();
//    }

    /**
     * 执行`mvn clean test`将Swagger生成的API文档保存为Markdown离线文档
     */
    @After
    public void genAPI2Markdown() throws Exception {
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN)//设置生成格式
                .withOutputLanguage(Language.ZH)//设置语言中文还是其他语言
                .withPathsGroupedBy(GroupBy.TAGS)
                .withGeneratedExamples()  //将测试demo包含其中
                .withoutInlineSchema()
                .build();
        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get(outputDir + "/markdown/酒店接口文档"));// 输出
    }


    @Test
    public void recognizeByMsgTest() throws Exception {
        mockMvc.perform(post("/hotel/msg/recognize/msg")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(genHotelInfo()))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("recognizeByMsg", preprocessResponse(prettyPrint())));
    }

    @Test
    public void recognizeByNameTest() throws Exception {
        mockMvc.perform(get("/hotel/msg/recognize/name")
                .param("hotelName", "北京四季酒店")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentation.document("recognizeByName", preprocessResponse(prettyPrint())));

    }

    @Test
    public void recognizeTest() throws Exception {
        mockMvc.perform(post("/hotel/msg/recognize")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(genHotelInfo()))
                .content("北京四季酒店")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("recognize", preprocessResponse(prettyPrint())));
    }

    private HotelBean genHotelInfo() {
        HotelBean hotelBean = new HotelBean();
        hotelBean.setName("北京四季酒店");
        hotelBean.setCheckInTime("2019-08-29");
        hotelBean.setHouseType("豪华大床房");
        hotelBean.setAddress("朝阳区");
        hotelBean.setGeneralAmenities("24小时前台，行李寄存，叫醒服务");
        hotelBean.setTraffic("http://xxxxxx");
        hotelBean.setTel("http://xxxxxx");
        hotelBean.setNearbyAmenities("http://xxxxxx");
        hotelBean.setHotelService("http://xxxxxx");
        return hotelBean;
    }

}
