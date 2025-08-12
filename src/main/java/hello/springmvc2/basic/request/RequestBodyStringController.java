package hello.springmvc2.basic.request;


import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.Charset;

@Slf4j
@Controller
public class RequestBodyStringController {

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));

        log.info("messageBody:{}", messageBody);
        response.getWriter().write(messageBody);
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {


        String messageBody = StreamUtils.copyToString(inputStream, Charset.forName("UTF-8"));

        log.info("messageBody2:{}", messageBody);
        responseWriter.write(messageBody);
    }



    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {

        //HTTP header, body 정보를 편리하게 조회
        //요청,응답에도 사용 가능
        //view조회 X
        //ResponseEntity 상태코드 설정가능
        String body = httpEntity.getBody();
        log.info("messageBody3:{}", body);
        return new HttpEntity<>("ok");
    }

}
