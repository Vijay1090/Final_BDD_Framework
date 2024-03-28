package com.base;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.MenuPage;
import com.pages.PaymentPage;

public class PageObjectManager {

  public HomePage getHomePage() {
    return new HomePage();
  }

  public MenuPage getMenuPage() {
    return new MenuPage();
  }

  public CartPage getCartPage() {
    return new CartPage();
  }

  public PaymentPage getPaymentPage() {
    return new PaymentPage();
  }

}
