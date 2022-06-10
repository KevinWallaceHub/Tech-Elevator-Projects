package com.techelevator;


import com.techelevator.items.Appetizer;
import com.techelevator.items.CateringItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CateringItemTest {

    private CateringItem testItem;


    @Before
    public void setUp() {
        testItem = new Appetizer("YUM", "Delicious", 25, 10.0f);
    }


    @Test
    public void test_get_item_type() {
        String expected = "Appetizer";
        Assert.assertEquals(expected, testItem.getItemType());
    }

    @Test
    public void test_get_reminder_message() {
        String expected = "You might need extra plates";
        Assert.assertEquals(expected, testItem.getOnScreenReminder());
    }

}