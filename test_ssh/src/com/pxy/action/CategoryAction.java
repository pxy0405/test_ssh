package com.pxy.action;

import java.sql.ResultSet;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.pxy.model.Category;
import com.pxy.service.CategoryService;
import com.pxy.utils.ExcelUtil;
import com.pxy.utils.ResponseUtil;

public class CategoryAction  extends SuperAction{
		private Category category;
		private Integer myCid;
		
		public void setMyCid(Integer myCid) {
			this.myCid = myCid;
		}

		public Category getModel() {
			return category;
		}
		// 注入Service
		private CategoryService categoryService;
		
		public void setCategoryService(CategoryService categoryService) {
			this.categoryService = categoryService;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		//后台:查询所有的一级分类的方法:
		public String adminFindAll(){
			List<Category> cList = categoryService.findAll();
			// 压入值栈:
			ActionContext.getContext().getValueStack().set("cList", cList);
			return "adminFindAllSuccess";
		}
		//跳转到添加页面
		public String add(){
			return "addCategoryPage";
		}
		//后台:保存一级分类:
		public String save(){
			categoryService.save(category);
			return "saveSuccess";
		}

		//后台:删除一级分类：
		public String delete(){
			Integer  cid = Integer.parseInt(request.getParameter("cid"));
			categoryService.delete(cid);
			return "deleteSuccess";
		}
		
		//后台:编辑一级分类:(查询一级分类)
		public String edit(){
			Integer cid=Integer.parseInt(request.getParameter("cid"));
			category = categoryService.findByCid(cid);
			session.setAttribute("category", category);
			return "editSuccess";
		}
		
		//后台:修改一级分类:
		public String update(){
			System.out.println("--");
			category.setCid(myCid);
			categoryService.update(category);
			return "updateSuccess";
		}
		
		//后台：导出一级分类为Excel列表
		public String export() throws Exception{
			Workbook wb=new HSSFWorkbook();
			String headers[]={"cid","cname"};
			List<Category> rs=categoryService.findAll();
			ExcelUtil.fillExcelData(rs, wb, headers);
			ResponseUtil.export(ServletActionContext.getResponse(), wb, "导出excel.xls");
			return null;
		}
}
