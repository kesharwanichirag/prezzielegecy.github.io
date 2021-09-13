package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Set;

public class Product{
	private Integer productId;
	private Seller seller;
	private Category category;
	private String productName;
	private Integer quantity;
	private Integer sold;
	private Integer price;
	private Integer discount;
	private String description;
	private String warranty;
	private String returningPolicy;
	private String shippingDetails;
	private String paymentDetails;
	private String disclamer;
	private String specification;
	
	//constructors
	public Product(){

	}
	public Product(Seller seller,String productName,Category category,Integer quantity,Integer price,Integer discount){
		this.seller = seller;
		this.productName = productName;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount){
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.sold = sold;
		this.price = price;
		this.discount = discount;
	}

	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount,Seller seller){
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.sold = sold;
		this.price = price;
		this.discount = discount;
		this.seller = seller;
	}

	public Product(Integer productId){
		this.productId = productId;
	}

	public Product(Integer productId,String productName,Integer price,Integer discount){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
	}
	//---------------------------------------------------
	public static ArrayList<Product> getProductThirtyPlus(){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,quantity,sold,price,discount from products where discount>=30 order by rand()";
			PreparedStatement prep = con.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return products;
	}
	//---------------------------------------------------
	public static ArrayList<Product> getProductTwentyToThirty(){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,quantity,sold,price,discount from products where discount>=20 and discount<=30 order by rand()";
			PreparedStatement prep = con.prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return products;
	}
	//---------------------------------------------------
	public static ArrayList<Product> getProductTenToTwenty(){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,quantity,sold,price,discount from products where discount>=10 and discount<=20 order by rand()";

			PreparedStatement prp = con.prepareStatement(query);
			
			ResultSet rs = prp.executeQuery();

			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return products;
	}
	//------------------------------------------------------------------
	public static ArrayList<Product> getMoreThanThirtyPercentDiscountProducts(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products where discount >30 order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//-----------------------------------------------------
	public static ArrayList<Product> getThirtyPercentDiscountProducts(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products where discount >=20 and discount<=30 order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//-----------------------------------------------------
	public static ArrayList<Product> getTwentyPercentDiscountProducts(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products where discount >=10 and discount<=20 order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//-----------------------------------------------------
	public static ArrayList<Product> getFlowers(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products where category_id=70 order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//-----------------------------------------------------
	public static ArrayList<Product> getCakesProduct(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products where category_id=69  order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//-----------------------------------------------------
	public static ArrayList<Product> getProductForIndex(){
		ArrayList<Product> product = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
				
			String query = "select product_id,product_name,price,discount from products order by rand() limit 6";

			PreparedStatement prep = con.prepareStatement(query);
		
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				product.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return product;
	}
	//---------------------------------------------------
	public static ArrayList<Product> getProductByCatId(Integer catId){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,quantity,sold,price,discount from products where category_id=?";

			PreparedStatement prp = con.prepareStatement(query);
			prp.setInt(1,catId);
			
			ResultSet rs = prp.executeQuery();

			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return products;
	}

	//===================collect products=================
	public static ArrayList<Product> getProductsDetailsForCartShow(Set<Integer>productIds){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,price,discount from products where product_id=?";

			PreparedStatement prp = con.prepareStatement(query);
			
			for(Integer productId:productIds){
				prp.setInt(1,productId);

				ResultSet rs = prp.executeQuery();

				if(rs.next()){
					products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
				}
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return products;
	}
	
	public static ArrayList<Product> searchAllProduct(String searchKey){
		ArrayList<Product> recs = new ArrayList<Product>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_id,product_name,quantity,sold,price,discount,p.seller_id,seller_account_name from products as p inner join sellers as s where p.seller_id=s.seller_id and product_name like'%"+searchKey+"%'";

			PreparedStatement prp = con.prepareStatement(query);

			ResultSet rs = prp.executeQuery();

			while(rs.next()){
				recs.add(new Product(
									rs.getInt(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getInt(4),
									rs.getInt(5),
									rs.getInt(6),
									new Seller(rs.getInt(7),rs.getString(8))));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return recs;
	}
	
	public void getProductDetails(){
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_name,quantity,sold,price,discount,description,warranty,returning_policy,shipping_details,payment_details,disclamer,specification,p.seller_id,seller_account_name from products as p inner join sellers as s where product_id=? and p.seller_id=s.seller_id";
		
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);

			ResultSet rs = prep.executeQuery();
			
			if(rs.next()){
				productName = rs.getString(1);
				quantity = rs.getInt(2);
				sold = rs.getInt(3);
				price = rs.getInt(4);
				discount = rs.getInt(5);
				description = rs.getString(6);
				warranty = rs.getString(7);
				returningPolicy = rs.getString(8);
				shippingDetails = rs.getString(9);
				paymentDetails = rs.getString(10);
				disclamer = rs.getString(11);
				specification = rs.getString(12);
				seller = new Seller(rs.getInt(13),rs.getString(14));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Product> getAllProducts(int sellerId){
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "select product_id,product_name,quantity,sold,price,discount from products where seller_id=? order by product_id desc";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,sellerId);
			ResultSet rs = prep.executeQuery();

			while(rs.next()){
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	
		return products;
	}
	
	//===================methods==================
		//8 saveWarranty
	public boolean saveWarranty(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set warranty=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,warranty);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
		
		//7 save returning_policy
	public boolean saveReturningPolicy(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set returning_policy=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,returningPolicy);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
		//6 save PaymentDetails
	public boolean savePaymentDetails(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set payment_details=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,paymentDetails);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
		//5 save ShippingDetails
	public boolean saveShippingDetails(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set shipping_details=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,shippingDetails);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
		//4 save disclamer
	public boolean saveDisclamer(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set disclamer=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,disclamer);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
		
		//3 save specification
	public boolean saveSpecification(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set specification=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,specification);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
		
		//2 save description
	public boolean saveDescription(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "update products set description=? where product_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setString(1,description);
			prep.setInt(2,productId);

			prep.executeUpdate();
			
			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}	
		//1 save product
	public boolean saveProduct(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "insert into products (seller_id,category_id,product_name,quantity,price,discount) value (?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1,seller.getSellerId());
			ps.setInt(2,category.getCategoryId());
			ps.setString(3,productName);
			ps.setInt(4,quantity);
			ps.setInt(5,price);
			ps.setInt(6,discount);

			int res = ps.executeUpdate();
			if(res==1){
				flag = true;
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					productId = rs.getInt(1);
				}
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	//getters-setters
	public void setProductId(Integer productId){
		this.productId = productId;	
	}
	public Integer getProductId(){
		return productId;	
	}

	public void setSeller(Seller seller){
		this.seller = seller;	
	}
	public Seller getseller(){
		return seller;	
	}

	public void setCategory(Category category){
		this.category = category;	
	}
	public Category getCategory(){
		return category;	
	}

	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}
	
	public void setQuantity(Integer quantity){
		this.quantity = quantity;	
	}
	public Integer getQuantity(){
		return quantity;	
	}
	
	public void setSold(Integer sold){
		this.sold = sold;	
	}
	public Integer getSold(){
		return sold;	
	}

	public void setPrice(Integer price){
		this.price = price;	
	}
	public Integer getPrice(){
		return price;	
	}

	public void setDiscount(Integer discount){
		this.discount = discount;	
	}
	public Integer getDiscount(){
		return discount;	
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}

	public void setWarranty(String warranty){
		this.warranty = warranty;
	}
	public String getWarranty(){
		return warranty;
	}

	public void setReturningPolicy(String returningPolicy){
		this.returningPolicy = returningPolicy;
	}
	public String getReturningPolicy(){
		return returningPolicy;
	}

	public void setShippingDetails(String shippingDetails){
		this.shippingDetails = shippingDetails;
	}
	public String getShippingDetails(){
		return shippingDetails;
	}

	public void setPaymentDetails(String paymentDetails){
		this.paymentDetails = paymentDetails;
	}
	public String getPaymentDetails(){
		return paymentDetails;
	}

	public void setDisclamer(String disclamer){
		this.disclamer = disclamer;
	}
	public String getDisclamer(){
		return disclamer;
	}

	public void setSpecification(String specification){
		this.specification = specification;
	}
	public String getSpecification(){
		return specification;
	}
	
}