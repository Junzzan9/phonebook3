package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {
	// [field]

	// [construct]

	// [g/s method]

	// [general method]

	// List
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list() {
		System.out.println("[PhoneController.list]");

		return "/WEB-INF/views/list.jsp"; // DispatcherServlet --> list.jsp로 foward
	}

	// WriteForm
	@RequestMapping(value = "/writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("[PhoneController.wForm]");

		return "/WEB-INF/views/writeForm.jsp";
	}

	// Write

	/*
	 * //파라미터가 없을때 디폴트값
	 * 
	 * @RequestMapping(value = "/write", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String write(@RequestParam("name") String name,
	 * 
	 * @RequestParam("hp") String hp,
	 * 
	 * @RequestParam(value="company", required=false, defaultValue="-1") String
	 * company) { System.out.println("[PhoneController.write]");
	 * 
	 * PersonVo pVo = new PersonVo(name, hp, company);
	 * 
	 * System.out.println(pVo);
	 * 
	 * return "/WEB-INF/views/list.jsp"; }
	 */

	// ModelAttribte 사용
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo pVo) {
		System.out.println("[PhoneController.write]");

		// @ModelAttribute --> new PersonVo [필드,파라미터 이름이 같으면 자동으로 생성]
		// 디폴트생성자+g/s 로 생성

		System.out.println(pVo);

		PhoneDao pDao = new PhoneDao();
		pDao.personInsert(pVo);

		return "redirect:/list";
	}

	/*
	 * 파라미터를 개별로 받을 때
	 * 
	 * @RequestMapping(value = "/write", method = { RequestMethod.GET,
	 * RequestMethod.POST }) public String write(@RequestParam("name") String name,
	 * 
	 * @RequestParam("hp") String hp,
	 * 
	 * @RequestParam("company") String company) {
	 * System.out.println("[PhoneController.write]");
	 * 
	 * PersonVo pVo = new PersonVo(name, hp, company);
	 * 
	 * System.out.println(pVo);
	 * 
	 * return "/WEB-INF/views/list.jsp"; }
	 */

	@RequestMapping(value = "/board/read/{no}", method = { RequestMethod.GET, RequestMethod.POST })
	public String read(@PathVariable("no") int boardNo) {
		System.out.println("[PhoneController.read]");
		System.out.println("PathVariable.Test.read");

		// localhost:8088/phoneboo3/board/read/1
		// localhost:8088/phoneboo3/board/read/2
		// localhost:8088/phoneboo3/board/read/3

		System.out.println(boardNo);

		return "";
	}

	@RequestMapping(value = "/test")
	public String test() {
		System.out.println("test");

		return "/WEB-INF/views/test.jsp";
	}

}
