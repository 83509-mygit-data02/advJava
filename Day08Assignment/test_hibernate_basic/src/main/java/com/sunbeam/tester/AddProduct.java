package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.*;

public class AddProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner (System.in)){
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Product Details :-  int availableQuantity, Category category, double price, String productName ");
			Product product = new Product(sc.nextInt(),Category.valueOf(sc.next().toUpperCase()),sc.nextDouble(),sc.nextLine());
			System.out.println(dao.addProduct(product));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
