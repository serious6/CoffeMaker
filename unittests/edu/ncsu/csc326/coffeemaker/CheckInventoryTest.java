package edu.ncsu.csc326.coffeemaker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class CheckInventoryTest {

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	@Before
	public void setUp() throws Exception {
		cm = new CoffeeMaker();

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("30");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");

		// Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
	}

	// Prompt for each

	@Test(expected = InventoryException.class)
	public void addInventory1() throws InventoryException {
		cm.addInventory("10", null, "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory2() throws InventoryException {
		cm.addInventory(null, "10", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory3() throws InventoryException {
		cm.addInventory("10", "10", null, "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory4() throws InventoryException {
		cm.addInventory("10", "10", "10", null);
	}

	// Negative

	@Test(expected = InventoryException.class)
	public void addInventory5() throws InventoryException {
		cm.addInventory("-10", "10", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory6() throws InventoryException {
		cm.addInventory("10", "-10", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory7() throws InventoryException {
		cm.addInventory("10", "10", "-10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory8() throws InventoryException {
		cm.addInventory("10", "10", "10", "-10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory9() throws InventoryException {
		cm.addInventory("10.0", "10", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory10() throws InventoryException {
		cm.addInventory("10", "10.0", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory11() throws InventoryException {
		cm.addInventory("10", "10", "10.0", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory12() throws InventoryException {
		cm.addInventory("10", "10", "10", "10.0");
	}

	// Alpha

	@Test(expected = InventoryException.class)
	public void addInventory13() throws InventoryException {
		cm.addInventory("A", "10", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory14() throws InventoryException {
		cm.addInventory("10", "A", "10", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory15() throws InventoryException {
		cm.addInventory("10", "10", "A", "10");
	}

	@Test(expected = InventoryException.class)
	public void addInventory16() throws InventoryException {
		cm.addInventory("10", "10", "10", "A");
	}

	@Test(expected = InventoryException.class)
	public void addInventory17() throws InventoryException {
		cm.addInventory("A", "A", "A", "A");
	}
	
	@Test
	public void checkIfEnough() throws InventoryException{
	}
	
	@Test
	public void checkGetter(){
		Inventory inventory = new Inventory();
		Assert.assertEquals(inventory.getChocolate(), 15);
		Assert.assertEquals(inventory.getCoffee(), 15);
		Assert.assertEquals(inventory.getMilk(), 15);
		Assert.assertEquals(inventory.getSugar(), 15);
	}
	
	@Test
	public void testToString(){
		Inventory inventory = new Inventory();
		Assert.assertNotNull(inventory.toString());
	}
	
	@Test
	public void testSet(){
		Inventory inventory = new Inventory();
		
		int test = inventory.getChocolate();
		inventory.setChocolate(-1);
		
		Assert.assertSame(test, inventory.getChocolate());
	}
	
	@Test
	public void testSet2(){
		Inventory inventory = new Inventory();
		
		int test = inventory.getCoffee();
		inventory.setCoffee(-1);
		
		Assert.assertSame(test, inventory.getCoffee());
	}
	
	@Test
	public void testSet3(){
		Inventory inventory = new Inventory();
		
		int test = inventory.getMilk();
		inventory.setMilk(-1);
		
		Assert.assertSame(test, inventory.getMilk());
	}
	
	@Test
	public void testSet4(){
		Inventory inventory = new Inventory();
		
		int test = inventory.getSugar();
		inventory.setSugar(-1);
		
		Assert.assertSame(test, inventory.getSugar());
	}
	
	
}
