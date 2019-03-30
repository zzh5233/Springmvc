package com.itheima.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itheima.controller.validation.ValidGroup1;
import com.itheima.domain.ItemCustom;
import com.itheima.domain.ItemQueryVo;
import com.itheima.exception.CustomException;
import com.itheima.service.ItemService;

/**
 * ItemConterller
 * @author zzh
 *
 */
@Controller
//对url进行分类管理，可以在这里定义根路径，最终访问url为根路径+子路径
@RequestMapping("/item")
public class ItemController {

	@Resource(name="itemService")
	private ItemService itemService;
	
	/**
	 * 商品分类
	 * itemtypes表示最终将方法返回值放入request中的key
	 * @return
	 */
	@ModelAttribute("itemtypes")
	public Map<String,String> getItemTypes(){
		
		Map<String,String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "男装");
		
		return itemTypes;
	}
	
	/**
	 * 查询商品的信息，输出为json
	 * /itemView/{id}里面的{id}表示将这个位置的参数传到@pathVariable指定的名称中
	 */
	@RequestMapping("/itemView/{id}")
	public @ResponseBody ItemCustom itemView(@PathVariable("id") Integer id)throws Exception{
		
		//调用Service完成查询商品信息
		ItemCustom itemCustom = itemService.findItemById(id);
		
		//TODO 这返回结果到底是返回到哪里了啊？去哪输出查看 啊？
		return itemCustom;
	}
	
	/**
	 * 按条件查询所有商品
	 * @param itemQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryItem")
	public ModelAndView queryItem(ItemQueryVo itemQueryVo) throws Exception{
		
		//调用service查找数据库，返回商品列表
		List<ItemCustom> itemList = itemService.findItemList(itemQueryVo);
		
		//返回ModelAndVIew
		ModelAndView modelAndView = new ModelAndView();
		//相当于request.setAttribut，咋jsp页面通过itemsList取数据
		modelAndView.addObject("itemList", itemList);
		
		//指定视图
		//在视图解析器中配置jsp路径的前缀和后缀，可以简写为
		modelAndView.setViewName("item/itemList");
		
		return modelAndView;	
	}
	/**
	 * 跳转到单个商品修改的页面
	 * @param model
	 * @param itemId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/editItem",method= {RequestMethod.POST,RequestMethod.GET})
	public String editItem(Model model,@RequestParam(value="id",required=true)Integer itemId) throws Exception{
	
		//调用service根据商品的id查询商品
		ItemCustom itemCustom = itemService.findItemById(itemId);
		
		if(itemCustom == null) {
			throw new CustomException("没有找到查询的商品");
		}
		
		//通过形参中的model将model数据传到页面
		//将商品的信息放到model
		model.addAttribute("item", itemCustom);
		
		return "item/editItem";
	}
	
	/**
	 * 修改商品的信息提交
	 * @param request
	 * @param id
	 * @param itemCustom
	 * @return
	 * @throws Exception
	 * 在需要校验的pojo类前添加@Validated,在需要校验的pojo后面添加BindingResult bindingResult接受校验出错信息
	 * 注意：Validated和BindingResult bindingResult时配对出现，并且形参顺序是固定的（一前一后）
	 * value= {ValidGroup1.class}指定使用ValidFroup1分组的校验
	 * MultipartFile item_pic 接受商品图片
	 */
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(
			Model model,
			HttpServletRequest request,
			Integer id,
			@ModelAttribute("item") @Validated(value= {ValidGroup1.class}) ItemCustom itemCustom,
			BindingResult bindingResult,
			MultipartFile item_pic) throws Exception{
		//获取校验的错误信息
		if(bindingResult.hasErrors()) {
			//取出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for(ObjectError objectError:allErrors) {
				//输出错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			//将错误信息传到页面
			model.addAttribute("allErrors",allErrors);
			//跳会到修改页面进行错误显示
			return "item/editItem";
		}
		
		//原始名称
		String originalFilename = item_pic.getOriginalFilename();
		//上传图片
		if(item_pic != null && originalFilename!=null && originalFilename.length()>0) {
			
			//存储图片的物理路径
			String pic_path = "E:\\Codes\\img\\upload\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			//新的图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘中
			item_pic.transferTo(newFile);
			
			//将新图片名称写入到itemCustom中
			itemCustom.setPic(newFileName);
		}
		
		//调用service完成更新商品信息，页面需要将商品的信息传到此方法上
		itemService.updateItem(id, itemCustom);
		
		return "redirect:queryItem.action";
	}
	/**
	 * 批量删除商品
	 * @param items_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception{
		//批量删除商品
		for(Integer id: items_id) {
			ItemCustom itemCustom = itemService.findItemById(id);
			itemService.removeItem(itemCustom);
		}
		return "redirect:queryItem.action";
	}
	/**
	 * 跳转到批量修改的页面
	 * @param model
	 * @param items_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editItemsList")
	public String editItemsList(Model model,Integer[] items_id)throws Exception{
		//批量修改商品
		List<ItemCustom> itemList = new ArrayList<ItemCustom>();
		for(Integer id: items_id) {
			ItemCustom itemCustom = itemService.findItemById(id);
			itemList.add(itemCustom);
		}		
		model.addAttribute("itemList",itemList);
		
		return "item/editItemsList";
	}
	
	/**
	 * 批量修改商品信息
	 * @param itemQueryVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editItemsListSubmit")
	public String editItemsListSubmit(ItemQueryVo itemQueryVo) throws Exception{
		
		List<ItemCustom> itemsList = itemQueryVo.getItemsList();
		for(ItemCustom itemCustom: itemsList) {
			//TODO 这个更新操作取id,此处实在有些多余
			itemService.updateItem(itemCustom.getId(), itemCustom);
		}
		return "redirect:queryItem.action";
	}
}
