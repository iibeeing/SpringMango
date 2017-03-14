package com.mango.jtt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.mango.jtt.model.ExamCourse;
import com.mango.jtt.model.ExamCourseEditModel;
import com.mango.jtt.model.ExamCourseSearchModel;
import com.mango.jtt.service.IExamCourseService;

@RestController
public class ExamCourseController extends BaseController<ExamCourse> {
	@Autowired
	private IExamCourseService examCourseService;

	@RequestMapping({ "/examCourse/toindex", "/examCourse/toindex" })
	public ModelAndView toindex() throws Exception {
		ModelAndView mav = new ModelAndView("/examCourse/toindex");
		return mav;
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/{id}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> get(@PathVariable("id") Long id) {
		try {
			if (id == null) {
				this.setMsg("参数传递错", HttpStatus.BAD_REQUEST);
			} else {
				// 2如果存在则构造分页，构造数据给前端
				ExamCourse model = examCourseService.getObjectById(id);
				map.put("model", model);
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally {
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}

	/*
	 * @SuppressWarnings("finally")
	 * 
	 * @RequestMapping(value = "/examCourse/list", method = RequestMethod.GET)
	 * public ResponseR<ExamCourse> list(@Valid ExamCourseSearchModel model,
	 * BindingResult br) throws Exception { try { if (br.hasErrors()) {
	 * this.setMsg(br.getFieldError().getDefaultMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } else { // 2如果存在则构造分页，构造数据给前端
	 * List<ExamCourse> list = examCourseService.list(model);
	 * this.setResponseEntityList(list); }
	 * 
	 * } catch (Exception e) { this.setMsg(e.getMessage(),
	 * HttpStatus.INTERNAL_SERVER_ERROR); } finally {
	 * responser.setResponseEntity(responseEntity); return responser; } }
	 */

	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> save(@Valid ExamCourseEditModel model, BindingResult br)
			throws IOException {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				Boolean result = examCourseService.save(model);
				map.put("result", result);
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally {
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/", method = RequestMethod.PUT)
	public ResponseEntity<Map<String, Object>> update(@Valid ExamCourseEditModel model, BindingResult br)
			throws IOException {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				Boolean result = examCourseService.update(model);
				map.put("result", result);
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally {
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/lists")
	public ResponseEntity<Map<String, Object>> lists(@Valid ExamCourseSearchModel searcher, BindingResult br)
			throws IOException {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				List<ExamCourse> list = examCourseService.list(searcher);
				map.put("list", list);
				map.put("searcher", searcher);
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally {
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}

	@SuppressWarnings("finally")
	@RequestMapping(value = "/examCourse/{ids}", method = RequestMethod.DELETE)
	public ResponseEntity<Map<String, Object>> delete(@RequestParam("ids[]") List<Long> ids, BindingResult br)
			throws Exception {
		try {
			if (br.hasErrors()) {
				map.put("msg", br.getFieldError().getDefaultMessage());
			} else {
				Boolean result = examCourseService.delete(ids);
				map.put("result", result);
				httpStatus = HttpStatus.OK;
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
		} finally {
			return new ResponseEntity<Map<String, Object>>(map, headers, httpStatus);
		}
	}
}
