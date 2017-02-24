package com.mango.jtt.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mango.jtt.model.StudentEditModel;
import com.mango.jtt.model.StudentSearchModel;
import com.mango.jtt.model.StudentListModel;
import com.mango.jtt.model.StudentT;
import com.mango.jtt.service.IStudentTService;
import com.mango.jtt.system.entity.PagedResult;
@RestController
@RequestMapping(value = "/student")
public class StudentController extends BaseController {

	@Autowired
	private IStudentTService studentTService;

	@SuppressWarnings("finally")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<StudentListModel> index(@Valid StudentSearchModel searcher,HttpServletRequest req) throws Exception {
		//1验证部分，其他在参数上自己验证
		ResponseEntity<StudentListModel> re = new ResponseEntity<StudentListModel>(null);
		try{
			//2如果存在则构造分页，构造数据给前端
			List<StudentT> studentlist = studentTService.list(searcher);
			StudentListModel ss = new StudentListModel();
			PagedResult<StudentT> pr = new PagedResult<StudentT>();
			pr.setDataList(studentlist);
			pr.setPageSize(searcher.getPageSize());
			pr.setPageNo(searcher.getPageNo());
			ss.setPr(pr);
			re = new ResponseEntity<StudentListModel>(ss,HttpStatus.OK);
			return re;
		}catch (Exception e) {
			StudentListModel ss = new StudentListModel();
			ss.setMsg(new StringBuilder(e.getMessage()));
			re = new ResponseEntity<StudentListModel>(ss,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			return re;
		}
	}
	
	/** 显示 */
	@SuppressWarnings("finally")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<StudentEditModel> show(@PathVariable Integer id, HttpServletRequest req) throws Exception {
		ResponseEntity<StudentEditModel> re = null;
		StudentEditModel ss = new StudentEditModel();
		try{
			StudentEditModel result = studentTService.get(id);
			if(result != null){
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.OK);
			}else{
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			ss.setMsg(new StringBuilder(e.getMessage()));
			re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			return re;
		}
	}
	
	/** 进入新增 */
	@RequestMapping(value = "/new")
	public String toCreate(HttpServletRequest req) throws Exception {
		return "student";
	}
	
	/** 保存新增 */
	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StudentEditModel> create(@Valid StudentEditModel model,HttpServletRequest req) throws Exception {
		ResponseEntity<StudentEditModel> re = null;
		StudentEditModel ss = new StudentEditModel();
		try {
			Boolean result = studentTService.save(model);
			if(result){
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.OK);
			}else{
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.FAILED_DEPENDENCY);
			}
		} catch (Exception e) {
			ss.setMsg(new StringBuilder(e.getMessage()));
			re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			return re;
		}
	}
	

	@SuppressWarnings("finally")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<StudentEditModel> edit(@PathVariable Integer id, @Valid StudentEditModel model, HttpServletRequest req) throws Exception {
		ResponseEntity<StudentEditModel> re = null;
		StudentEditModel ss = new StudentEditModel();
		try{
			if (id == model.getId()) {
				Boolean result = studentTService.update(model);
				if(result){
					re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.OK);
				}else{
					re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.FAILED_DEPENDENCY);
				}
			} else {
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.CONFLICT);
			}
		}catch (Exception e) {
			ss.setMsg(new StringBuilder(e.getMessage()));
			re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			return re;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<StudentEditModel> delete(@PathVariable Integer id, HttpServletRequest req) throws Exception {
		ResponseEntity<StudentEditModel> re = null;
		StudentEditModel ss = new StudentEditModel();
		try{
			Boolean result = studentTService.delete(id);
			if(result){
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.OK);
			}else{
				re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.FAILED_DEPENDENCY);
			}
		}catch (Exception e) {
			ss.setMsg(new StringBuilder(e.getMessage()));
			re = new ResponseEntity<StudentEditModel>(ss,HttpStatus.INTERNAL_SERVER_ERROR);
		}finally{
			return re;
		}
	}
}
