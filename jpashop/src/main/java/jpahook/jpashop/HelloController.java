package jpahook.jpashop;

import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // Model을 통해 view에 값을 넘길 수 있다.
        model.addAttribute("data", "hello!!!"); // key = "data", value = "hello!!!"

        // thymeleaf에서 /resources/templates 폴더에 해당 뷰 네임의 html 파일을 자동으로 맵핑해준다.
        // resources:templates/ + {ViewName} + .html
        return "hello"; // 화면 페이지 이름
    }
}
