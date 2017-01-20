package com.niit.controller;

import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.domainobject.Category;
import com.niit.domainobject.Product;
import com.niit.domainobject.Supplier;
import com.niit.util.FileUtil;

@Controller
public class ProductController {
	private static Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private Product product;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private SupplierDao supplierDao;
	
	@Autowired
	private Supplier supplier;
	
	private String path = "resources/img/";
	@Transient
	private MultipartFile file;
	
	
	@RequestMapping(value="/manageAllProducts",  method = RequestMethod.GET)
	public String myProducts(Model model){
		log.debug("Starting of the method: myProducts");
		model.addAttribute("product",product);
		model.addAttribute("productList",this.productDao.list());
		model.addAttribute("isAdminClickedProducts","true");
		log.debug("Ending of the method: myProducts");
		return "/home";
	}
	
	@RequestMapping(value="/manageProductAdd" , method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file,Model model)
	
	{
		log.debug("Starting of the method: addProduct");
		Category category = categoryDao.getByName(product.getCategory().getName());
		Supplier supplier = supplierDao.getByName(product.getSupplier().getName());
		
		product.setCategory(category);
		product.setSupplier(supplier);
		
		product.setCategoryID(category.getId());
		product.setSupplierID(supplier.getId());
		product.setProductID(product.getProductID());
		productDao.saveOrUpdate(product);
		
		
		
	System.out.println("file upload");
		FileUtil.upload(path, file , product.getProductID()+".jpg");
		log.debug("End of the method: addProduct");
		model.addAttribute("isAdminClickedProducts","true");
		model.addAttribute("productAdded", true);
		model.addAttribute("productList",this.productDao.list());
		model.addAttribute("product", new Product());
	return "/home";
		
	}
	@RequestMapping("manageProductRemove/{productID}")
	public String removeProduct(@PathVariable("productID") String productID, Model model) throws Exception{
		log.debug("Starting of the method: removeProduct");
		boolean flag = productDao.delete(productID);
		String msg = "Successfully removed product";
		if(flag != true){
			msg = "Not able to remove product";
		}
		model.addAttribute("msg", msg);
		log.debug("Ending of the method: removeProduct");
		return "forward:/manageAllProducts";
		
	}
	
	@RequestMapping("manageProductEdit/{productID}")
	public String editProduct(@PathVariable("productID") String productID,Model model){
		//productDAO.saveOrUpdate(product);
		log.debug("Starting of the method: editProduct");
		product = productDao.get(productID);
		model.addAttribute("product", product);
		log.debug("Ending of the method editProduct");
		return "forward:/manageAllProducts";
	}
	
	@RequestMapping("manageProductGet/{productID}")
	public ModelAndView getSelectedProduct(@PathVariable("productID") String productID, RedirectAttributes redirectAttributes){
		
		log.debug("Start of the method: getSelectedProduct");
		ModelAndView mv = new ModelAndView("redirect:/home");
		redirectAttributes.addFlashAttribute("selectedProduct", productDao.get(productID));
		log.debug("End of the method: getSelectedProduct");
		return mv;
		
	}
}
