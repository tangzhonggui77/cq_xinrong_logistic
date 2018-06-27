package cq.anbu.modules.bill.controller;

import cq.anbu.common.utils.PageUtils;
import cq.anbu.common.utils.Query;
import cq.anbu.common.utils.R;
import cq.anbu.common.utils.excel.ExcelExportUtil;
import cq.anbu.modules.bill.entity.BillEntity;
import cq.anbu.modules.bill.service.BillService;
import cq.anbu.modules.sys.controller.AbstractController;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 账单表
 * 
 * @author tangzhonggui
 * @email java_tangzg@163.com
 * @date 2018-06-10 09:48:20
 */
@RestController
@RequestMapping("/bill/bill")
public class BillController extends AbstractController {
	@Autowired
	private BillService billService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("bill:bill:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BillEntity> billList = billService.queryList(query);
		int total = billService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(billList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("bill:bill:info")
	public R info(@PathVariable("id") Long id){
		BillEntity bill = billService.queryObject(id);
		
		return R.ok().put("bill", bill);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("bill:bill:save")
	public R save(@RequestBody BillEntity bill){
		bill = wrapperBaseEntity(bill);
		billService.save(bill);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("bill:bill:update")
	public R update(@RequestBody BillEntity bill){
		bill.setUpdateAt(new Date());
		bill.setUpdateBy(getUser().getUsername());
		billService.update(bill);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("bill:bill:delete")
	public R delete(@RequestBody Long[] ids){
		billService.deleteBatch(ids);
		
		return R.ok();
	}


	@RequestMapping(value = "/export",method = RequestMethod.GET)
	public R export(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("ids");
		String[] idsArray = ids.split(",", -1);
		List<BillEntity> billCollectEntityList = new ArrayList<>();
		BillEntity billEntity;
		for(String id : idsArray){
			billEntity = billService.queryObject(Long.parseLong(id));
			billCollectEntityList.add(billEntity);
		}
		String templateFilePath = ExcelExportUtil.class.getClassLoader().getResource("excel/test.xlsx").getPath();
			ExcelExportUtil excel = new ExcelExportUtil();
			List<Map<Integer, Object>> datalist = new ArrayList<Map<Integer, Object>>();
			for(BillEntity entity : billCollectEntityList) {
				Map<Integer, Object> data = new HashMap<Integer, Object>();
				data.put(1,entity.getSerialNo()+"");
				data.put(2,entity.getTrackingNo()+"");
				data.put(3,entity.getDeliveryDate()+"");
				data.put(4,entity.getArrivalDate()+"");
				data.put(5,entity.getDeliveryAddr());
				data.put(6,entity.getArrivalAddr());
				data.put(7,entity.getGoodsName());
				data.put(8,entity.getLoadingModel());
				data.put(9,entity.getPalteNo()+"");
				data.put(10,entity.getTrainNo()+"");
				data.put(11,entity.getShippedQuantity()+"");
				data.put(12,entity.getWeight()+"");
				data.put(13,entity.getPrice()+"");
				data.put(14,entity.getPickUpCharge()+"");
				data.put(15,entity.getDeliveryFee()+"");
				data.put(16,entity.getTotalExpenses()+"");
				data.put(17,entity.getComment());
				datalist.add(data);
			}
			String[] heads = new String[]{"A4","B4", "C4", "D4", "E4", "F4", "G4", "H4","I4","J4","K4","L4","M4","N4","O4","P4","Q4"};
		Workbook workbook = null;
		try {
			workbook = excel.writeDateList(templateFilePath, heads, datalist, 0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		// 判断数据
			if(workbook == null) {
				return R.error("fail");
			}
			// 设置excel的文件名称
			String excelName = "测试excel" ;
			// 重置响应对象
			response.reset();
			// 当前日期，用于导出文件名称
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
			// 指定下载的文件名--设置响应头
			response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xlsx");
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			// 写出数据输出流到页面
			try {
				OutputStream output = response.getOutputStream();
				BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
				workbook.write(bufferedOutPut);
				bufferedOutPut.flush();
				bufferedOutPut.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return R.ok();
	}

	/**
	 * 导出
	 * @param map
	 * @param request
	 * @param response
	 */

/*	@RequestMapping("/export")
	public String downloadByPoiBaseView(HttpServletResponse response) {
		// 获取workbook对象
		Workbook workbook = exportSheetByTemplate() ;
		// 判断数据
		if(workbook == null) {
			return "fail";
		}
		// 设置excel的文件名称
		String excelName = "测试excel" ;
		// 重置响应对象
		response.reset();
		// 当前日期，用于导出文件名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateStr = "["+excelName+"-"+sdf.format(new Date())+"]";
		// 指定下载的文件名--设置响应头
		response.setHeader("Content-Disposition", "attachment;filename=" +dateStr+".xls");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 写出数据输出流到页面
		try {
			OutputStream output = response.getOutputStream();
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
			workbook.write(bufferedOutPut);
			bufferedOutPut.flush();
			bufferedOutPut.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}*/

	/**
	 * 模版单sheet导出示例
	 * @return
	 */
	/*public Workbook exportSheetByTemplate(){
		// 查询数据,此处省略
		List list = new ArrayList<>();
		int count1 = 0 ;
		EasyPOIModel easyPOIModel11 = new EasyPOIModel(String.valueOf(count1++),"信科",new User("张三","男",20)) ;
		EasyPOIModel easyPOIModel12 = new EasyPOIModel(String.valueOf(count1++),"信科",new User("李四","男",17)) ;
		EasyPOIModel easyPOIModel13 = new EasyPOIModel(String.valueOf(count1++),"信科",new User("淑芬","女",34)) ;
		EasyPOIModel easyPOIModel14 = new EasyPOIModel(String.valueOf(count1++),"信科",new User("仲达","男",55)) ;
		list.add(easyPOIModel11) ;
		easyPOIModel11 = null ;
		list.add(easyPOIModel12) ;
		easyPOIModel12 = null ;
		list.add(easyPOIModel13) ;
		easyPOIModel13 = null ;
		list.add(easyPOIModel14) ;
		easyPOIModel14 = null ;
		// 设置导出配置
		// 获取导出excel指定模版
		TemplateExportParams params = new TemplateExportParams("d:/项目测试文件夹/easypoiExample.xlsx");
		// 标题开始行
		params.setHeadingStartRow(0);
		// 标题行数
		params.setHeadingRows(2);
		// 设置sheetName，若不设置该参数，则使用得原本得sheet名称
		params.setSheetName("班级信息");
		// 导出excel
		return ExcelExportUtil.exportExcel(params, EasyPOIModel.class,list, new HashMap<>());
	}*/
}
