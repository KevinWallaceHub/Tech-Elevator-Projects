package com.techelevator;

import com.techelevator.CateringSystem;
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





}
