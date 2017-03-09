package com.mango.jtt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mango.jtt.model.ExamCourse;
import com.mango.jtt.model.ExamCourseSearchModel;
import com.mango.jtt.model.ResponseR;
import com.mango.jtt.service.IExamCourseService;

@RestController
@RequestMapping(value = "/examCourse")
public class ExamCourseController extends BaseController<ExamCourse> {
	@Autowired
	private IExamCourseService examCourseService;
	
	@RequestMapping({ "/toindex", "/toindex" })
	public ModelAndView toindex() throws Exception {
		ModelAndView mav = new ModelAndView("/examCourse/toindex");
		return mav;
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseR<ExamCourse> list(@Valid ExamCourseSearchModel searcher, HttpServletRequest req)
			throws Exception {
		try {
			// 2如果存在则构造分页，构造数据给前端
			List<ExamCourse> list = examCourseService.list(searcher);
			this.setResponseEntityList(list);
		} catch (Exception e) {
			this.setMsg(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			responser.setResponseEntity(responseEntity);
			return responser;
		}
	}
}
