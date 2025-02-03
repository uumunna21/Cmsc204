package package1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTrackerTest {
    private ProductSalesTracker tracker1;
    private ProductSalesTracker tracker2;

    @BeforeEach
    public void setUp() {
        // Create two instances of ProductSalesTracker with some sales added

    	tracker1 = new ProductSalesTracker(5);
    	tracker2 = new ProductSalesTracker(4);
    	
    	tracker1.addSale(200.0);
    	tracker1.addSale(300.0);
    	tracker1.addSale(30.0);
    	
    	tracker2.addSale(100.0);
    	tracker2.addSale(60.0);
    	tracker2.addSale(500.0);

     }

    @AfterEach
    public void tearDown() {
        // Set the objects to null to clean up

    	tracker1 = null;
    	tracker2 = null;
    			
     }

    @Test
    public void testAddSale() {
        // Test adding a sale to tracker1

    	assertTrue(tracker1.addSale(400.0)); //Should return true
    	assertTrue(tracker1.addSale(50.0)); //Should return true
    	assertFalse(tracker1.addSale(600.0)); //Should return false
    	
    	// testing adding a sale for tracker2
    	assertTrue(tracker2.addSale(400.0)); //Should return true 
    	assertFalse(tracker2.addSale(40.0)); //Should return false

     }

    @Test
    public void testTotalSales() {
    	assertEquals(530.0, tracker1.totalSales(), 0.001);
    	// 200.0 + 300.0 + 30.0 = 530.0
    	assertEquals(660.0, tracker2.totalSales(), 0.001);
    	// 100.0 + 60.0 + 500.0 = 660.0

    }

    @Test
    public void testLowestSale() {
    	assertEquals(30.0, tracker1.lowestSale(), 0.001); //lowest sale is 30.0
    	
    	assertEquals(60.0, tracker2.lowestSale(), 0.001); //lowest sale is 60.0
    	
    	// Test lowestSale for an empty tracker
        ProductSalesTracker emptyTracker = new ProductSalesTracker(5);
        assertEquals(0.0, emptyTracker.lowestSale(), 0.001);
        // No sales, should return 0
    }

    @Test
    public void testFinalSalesTotal() {
    	assertEquals(500.0, tracker1.finalSalesTotal(), 0.001); 
    	// 530.0 - 30.0 = 30.0
    	
    	assertEquals(600.0, tracker2.finalSalesTotal(), 0.001);
    	// 660.0 - 60.0 = 600.0
    	
    	// Test finalSalesTotal for an empty tracker
        ProductSalesTracker emptyTracker = new ProductSalesTracker(5);
        assertEquals(0.0, emptyTracker.finalSalesTotal(), 0.001);
        // No sales, should return 0

    	
    }

    @Test
    public void testToString() {
    	//Test toString for tracker1
    	String expected1 = "The total sales is 530.0, The lowest sale is 30.0, The final sales total is 500.0";
        assertEquals(expected1, tracker1.toString());
        
        //Test toString for tracker2
        String expected2 = "The total sales is 660.0, The lowest sale is 60.0, The final sales total is 600.0";
        assertEquals(expected2, tracker2.toString());
    	
    }
    @Test
    public void testAddSaleThrowsException() {
        // Test adding a sale to a tracker with no capacity
        ProductSalesTracker fullTracker = new ProductSalesTracker(1);
        fullTracker.addSale(100.0);

        // Ensure no exception is thrown when adding to a full tracker
        assertFalse(fullTracker.addSale(200.0)); // Should return false, not throw an exception
    }
}

