package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;

import models.Category;
import models.Product;

import java.util.ArrayList;

public class GiftListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent ev){
		ServletContext context = ev.getServletContext();
		ArrayList<Category> categories = Category.getCategories();
			
		context.setAttribute("categories",categories);

		ArrayList<Integer> count = new ArrayList<Integer>();
		for(int i=1;i<=10;i++){
			count.add(i);
		}
		context.setAttribute("cart_count",count);

		//---------------------------------------------
		ArrayList<Category> allCat1 = Category.showCategories1();
		
		context.setAttribute("all_category1",allCat1);

		//----------------------------------------------
		ArrayList<Category> allCat2 = Category.showCategories2();
		
		context.setAttribute("all_category2",allCat2);
		//----------------------------------------------
		ArrayList<Category> allCat3 = Category.showCategories3();
		
		context.setAttribute("all_category3",allCat3);
		//----------------------------------------------
		ArrayList<Category> allCat4 = Category.showCategories4();
		
		context.setAttribute("all_category4",allCat4);
		//----------------------------------------------
		ArrayList<Category> allCat5 = Category.showCategories5();
		
		context.setAttribute("all_category5",allCat5);
		//----------------------------------------------
		ArrayList<Category> allCat6 = Category.showCategories6();
		
		context.setAttribute("all_category6",allCat6);
		
		//################### for cart  ##############################
		ArrayList<Category> cart = Category.showCatForCart();

		context.setAttribute("show_cat_forcart",cart);
		
		//#################### cakes ##########################
		
		ArrayList<Product> cakes = Product.getCakesProduct();
		context.setAttribute("index_cake",cakes);
		//##################### flowers #######################

		ArrayList<Product> flowers = Product.getFlowers();
		context.setAttribute("flowers",flowers);
		//##################### 20% ############################
	
		ArrayList<Product> twenty = Product.getTwentyPercentDiscountProducts();
		context.setAttribute("twenty_percent_disc",twenty);
		//####################### 30% #################################
		ArrayList<Product> thirty = Product.getThirtyPercentDiscountProducts();

		context.setAttribute("thirty_percent_disc",thirty);
		//####################### 30+ #####################################
		ArrayList<Product> thirtyPlus = Product.getMoreThanThirtyPercentDiscountProducts();

		context.setAttribute("thirty_plus",thirtyPlus);
		//##################### recom +############################
		ArrayList<Product> product = Product.getProductForIndex();
		context.setAttribute("pro_index",product);			
	}

	public void contextDestroyed(ServletContextEvent ev){
		
	}
}