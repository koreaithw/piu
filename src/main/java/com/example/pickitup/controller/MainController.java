package com.example.pickitup.controller;

import com.example.pickitup.service.project.projectFile.ProjectFileService;

import com.example.pickitup.service.ProjectService;
import com.example.pickitup.service.project.projectFile.ProjectFileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.text.ParseException;

@Controller
@Slf4j
@RequestMapping("/main/*")
@RequiredArgsConstructor
public class MainController {
    private final ProjectService projectService;
    private final ProjectFileService projectFileService;


    // 메인페이지
    @GetMapping("/main")
    public String main(HttpSession session, Model model) throws ParseException {
       int checkLogin=0;

        if(session.getAttribute("token")!=null){
//            log.info("tokentokentokentokentokentokentoken");
//            log.info(session.toString());
//            log.info((String)session.getAttribute("token"));
//            log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            checkLogin = 2;
        }else if(session.getAttribute("num")!=null&&session.getAttribute("nickname")!=null){
            checkLogin= 3;
        }else{
//           log.info("elseelseelseelseelseelseelseelseelse");
//           log.info(session.toString());
//           log.info("aaaaaaaaaaaaaaaaaaaaaaaaaa");
           checkLogin= 1;
       }

       model.addAttribute("checkLogin",checkLogin);
        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기

//        String course = "asdf";
        model.addAttribute("course1",projectService.getListCourse("산"));
        model.addAttribute("course2",projectService.getListCourse("바다"));
        model.addAttribute("course3",projectService.getListCourse("강"));

        log.info("메인 들어옴");
       return "/main/main";

    }



    @GetMapping("/getCourseList/{course}")
    @ResponseBody
    public String getCourseList(@PathVariable("course") String course, Model model) throws ParseException {
        model.addAttribute("courseList", projectService.getListCourse(course));  // 내용가져오기
        log.info("레스트 들어옴");
        log.info(course);
        return "/main/main";
    }


//    @GetMapping("/test")
//    public void test(Model model) throws ParseException {
//
////        model.addAttribute("projectListThumb", projectFileService.getList());   // 사진 가져오기
//        model.addAttribute("projectListJJim", projectService.getListJJim());  // 내용가져오기
//        model.addAttribute("projectListPoint", projectService.getListPoint());  // 내용가져오기
//        model.addAttribute("projectListApply", projectService.getListApply());  // 내용가져오기
//
//        return "/main/main";
//
//    }


}
