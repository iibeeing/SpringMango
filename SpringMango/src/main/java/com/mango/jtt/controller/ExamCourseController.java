package com.mango.jtt.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mango.jtt.model.ExamCourse;
import com.mango.jtt.model.ExamCourseEditModel;
import com.mango.jtt.model.ExamCourseSearchModel;
import com.mango.jtt.model.ResponseR;
import com.mango.jtt.service.IExamCourseService;

@RestController
//@RequestMapping(value = "/examCourse")
public class ExamCourseController extends BaseController<ExamCourse> {
	@Autowired
	private IExamCourseService examCourseService;
	
	@RequestMapping({ "/examCourse/toindex", "/examCourse/toindex" })
	public ModelAndView toindex() throws Exception {
		ModelAndView mav = new ModelAndView("/examCourse/toindex");
		return mav;
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/list", method = RequestMethod.GET)
	public ResponseR<ExamCourse> list(@Valid ExamCourseSearchModel model, BindingResult br)
			throws Exception {
		try {
			if(br.hasErrors()){
				this.setMsg(br.getFieldError().getDefaultMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}else{
				// 2如果存在则构造分页，构造数据给前端
				List<ExamCourse> list = examCourseService.list(model);
				this.setResponseEntityList(list);
			}

		} catch (Exception e) {
			this.setMsg(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			responser.setResponseEntity(responseEntity);
			return responser;
		}
	}
	
	/**
	 * lists
	 * @param searcher
	 * @param br
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/",method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> save(@Valid ExamCourseEditModel model, BindingResult br)
			throws IOException {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				Boolean result = examCourseService.save(model);
				map.put("result", result);
				//默认是：TEXT_PLAIN，如果需要修改这里才写
				headers.setContentType(MediaType.APPLICATION_JSON);
				//默认是：INTERNAL_SERVER_ERROR，一般正常结果需要修改
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally{
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/lists")
	public ResponseEntity<Map<String, Object>> lists(@Valid ExamCourseSearchModel searcher, BindingResult br)
			throws IOException {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				List<ExamCourse> list = examCourseService.list(searcher);
				map.put("list", list);
				//默认是：TEXT_PLAIN，如果需要修改这里才写
				headers.setContentType(MediaType.APPLICATION_JSON);
				//默认是：INTERNAL_SERVER_ERROR，一般正常结果需要修改
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally{
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}
}
