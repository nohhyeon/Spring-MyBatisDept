package su.boot.begin.mybatis.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import su.boot.begin.mybatis.dto.DeptDTO;
import su.boot.begin.mybatis.service.DeptService;
import lombok.RequiredArgsConstructor;

@Controller

@RequiredArgsConstructor
public class DeptController {
	private static final Logger logger = LogManager.getLogger(DeptController.class);
	@Autowired
	private final DeptService deptService;


	@GetMapping("/DeptSelect")
	public String list(Model model) {
		model.addAttribute("list", deptService.deptSelectAll());
		logger.info("list", model);
		return "./dept/dept_select_view";
	}


	@GetMapping("/DeptSelectDetail")
	public String detail(Model model, DeptDTO deptDTO) {
		model.addAttribute("deptDTO", deptService.deptSelect(deptDTO.getDeptno()));
		return "./dept/dept_select_detail_view";
	}


	@GetMapping("/DeptInsert")
	public String insert() {
		return "./dept/dept_insert";
	}


	@PostMapping("/DeptInsert")
	public String insert(Model model, DeptDTO deptDTO) {
		model.addAttribute("list", deptService.deptSelectAll());
		deptService.deptInsert(deptDTO);
		return "./dept/dept_insert_view";
	}


	@GetMapping("/DeptUpdate")

	public String update(Model model, DeptDTO deptDTO) {
		model.addAttribute("deptDTO", deptService.deptSelect(deptDTO.getDeptno()));
		return "./dept/dept_update";
	}


	@PostMapping("/DeptUpdate")
	public String update(DeptDTO deptDTO) {
		deptService.deptUpdate(deptDTO);
		return "./dept/dept_update_view";
	}


	@GetMapping("/DeptDelete")
	public String delete() {
		return "./dept/dept_delete";
	}


	@PostMapping("/DeptDelete")
	public String delete(DeptDTO deptDTO) {
		deptService.deptDelete(deptDTO.getDeptno());
		return "./dept/dept_delete_view";
	}

}