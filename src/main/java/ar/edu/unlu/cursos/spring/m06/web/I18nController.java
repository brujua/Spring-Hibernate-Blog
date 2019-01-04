package ar.edu.unlu.cursos.spring.m06.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;


/**
 * Responsible of redirecting back. The {@link org.springframework.web.servlet.i18n.LocaleChangeInterceptor}
 * defined on {@link ar.edu.unlu.cursos.spring.m06.config.WebConfig} will change the locale.
 */
@Controller
@RequestMapping("/i18n")
public class I18nController {

    @GetMapping("")
    public String interceptar(HttpServletRequest request) {
        return getPreviousPageByRequest(request).orElse("redirect:/");
    }

    protected Optional<String> getPreviousPageByRequest(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
    }
}
