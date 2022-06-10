package com.techelevator;

import com.techelevator.CateringSystem;
import com.techelevator.items.Appetizer;
import com.techelevator.items.CateringItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class CateringSystemTest {

    private CateringSystem cateringSystem;

    @Before
    public void setup(){
        Map<String, CateringItem> testMap = new TreeMap<String, CateringItem>();
        CateringItem testItem = new Appetizer("YUM","Delicious",25,10.0f);
        testMap.put(testItem.getProductCode(),testItem);

        this.cateringSystem = new CateringSystem(testMap);
    }

    @Test
    public void add_money_twice(){
        this.cateringSystem.addMoney(50);
        this.cateringSystem.addMoney(20);
        float expectedAccountBalance = 70;
        float actualAccountBalance = this.cateringSystem.getCurrentAccountBalance();
        Assert.assertEquals("Balances not equal", expectedAccountBalance, actualAccountBalance,0.009);
    }

    @Test
    public void add_too_much_money_fails(){
        boolean result =  this.cateringSystem.addMoney(501);
        float expected = 0;
        Assert.assertFalse(result);
        Assert.assertEquals(expected,this.cateringSystem.getCurrentAccountBalance(),0.009);
    }


    @Test
    public void max_balance_is_succsessfull_test(){
          this.cateringSystem.addMoney(500);
          this.cateringSystem.addMoney(500);
        boolean result =  this.cateringSystem.addMoney(500);

        Assert.assertTrue(result);
    }

    @Test
    public void over_max_balance_is_fails(){
        this.cateringSystem.addMoney(500);
        this.cateringSystem.addMoney(500);
        this.cateringSystem.addMoney(500);
        boolean result = this.cateringSystem.addMoney(1);
        float expectedAmount = 1500;
        Assert.assertFalse(result);
        Assert.assertEquals(expectedAmount,this.cateringSystem.getCurrentAccountBalance(), 0.009);
    }

    @Test
    public void has_sufficient_funds_test(){

        int testQuantity = 3;
        cateringSystem.addMoney(500);

        Assert.assertTrue(cateringSystem.hasSufficientFunds("YUM",testQuantity));

    }

    @Test
    public void has_sufficient_funds_false(){

        int testQuantity = 3;
        cateringSystem.addMoney(29);

        Assert.assertFalse(cateringSystem.hasSufficientFunds("YUM",testQuantity));

    }

    @Test
    public void test_add_products_to_cart_updates_balance(){
        cateringSystem.addMoney(50);
        cateringSystem.addProductToCart(2,"YUM");
        float expectedAccountBalance = 30;
        Assert.assertEquals(expectedAccountBalance,cateringSystem.getCurrentAccountBalance(), 0.009);
    }

    @Test
    public void test_add_products_to_cart_updates_quantity(){
        cateringSystem.addMoney(50);
        cateringSystem.addProductToCart(2,"YUM");
        int expectedRemainingQuantity = 23;
        Assert.assertEquals(expectedRemainingQuantity, cateringSystem.getQuantity("YUM"));
    }

    @Test
    public void testing_valid_product_code(){

        Assert.assertTrue(cateringSystem.isValidProductCode("YUM"));

    }

    @Test
    public void invalid_product_code_test(){

        Assert.assertFalse(cateringSystem.isValidProductCode(""));
    }
}
