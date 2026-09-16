package com.yourcompany.automation.stepdefinitions;

import org.testng.Assert;

import com.yourcompany.automation.factory.DriverFactory;
import com.yourcompany.automation.pages.Dashboardpage;

import io.cucumber.java.en.Then;

public class DashboardStepdef {
	
	Dashboardpage dashBoardPage;
	
	@Then("I verifies total users")
	public void user_verifies_total_users() {
		dashBoardPage = new Dashboardpage(DriverFactory.getDriver());
	   String totalvalue= dashBoardPage.getTotalUsers();
	   Assert.assertEquals(totalvalue,"1,248");
	}

	@Then("I verifies products")
	public void user_verifies_products() {
		String productsvalue =dashBoardPage.getProducts();
		Assert.assertEquals(productsvalue,"386");
	}

	@Then("I verifies today orders")
	public void user_verifies_today_orders() {
		String ordersvalue =dashBoardPage.getOrderToday();
		Assert.assertEquals(ordersvalue,"74");
	}
	    

	@Then("I verifies revenue")
	public void user_verifies_revenue() {
		String revenuevalue=dashBoardPage.getRevenue();
		Assert.assertEquals(revenuevalue,"₹84,920");
	}

}
