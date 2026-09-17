package com.yourcompany.automation.stepdefinitions;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.pages.Productspage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductsStepdef {
	 Productspage productsPage;
	
	@When("I clicked on products menu")
	public void i_clicked_on_products_menu() {
		productsPage=new Productspage(DriverFactory.getDriver());
		productsPage.clickProducts();
	    
	}

	@Then("I verify the products {string} {string} {string} {string}")
	public void i_verify_the_products(String product, String category, String price, String stock) {
		productsPage.verifyProducts(product,category,price,stock);
	}

}
