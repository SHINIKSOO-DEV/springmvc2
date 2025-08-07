package hello.springmvc2.basic.requestmapping;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hello-basic");
        return "OK";
    }


    /**
     * PathVarriable 사용
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}"  , data);
        return "OK";

    }

    /**
     * PathVarriable 다중사용
     * @return
     */
    @GetMapping("/mapping/{userId}/order/{orderId}")
    public String mappingPath(@PathVariable("userId") String data, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}"  , data, orderId);
        return "OK";

    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
}
