package edu.ncsu.csc326.coffeemaker;

/**
 * Created by iamapo on 08.04.14.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteRecipeTest {

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
		r1.setAmtCoffee("3");
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

	@Test
	public void deleteInAEmptyBook() {

		Assert.assertEquals(cm.deleteRecipe(0), null);
	}

	@Test
	public void deleteFirstRecipe() {
		cm.addRecipe(r1);
		Assert.assertEquals(cm.deleteRecipe(0), "Coffee");
		Recipe recipe = cm.getRecipes()[0];
		Assert.assertNull(recipe);
	}

	// TODO Veränderung checken, 2x löschen

	@Test
	public void deleteInTheMiddle() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		Assert.assertEquals(cm.deleteRecipe(1), "Mocha");
		Assert.assertEquals(cm.deleteRecipe(1), "Latte");

	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void deleteInvalifRecipe() {
		int outOfBounce = Integer.MAX_VALUE;
		Recipe recipe = cm.getRecipes()[outOfBounce];
	}

	@Test(expected = NumberFormatException.class)
	public void invalidCharacter() {
		Recipe recipe = cm.getRecipes()[Integer.valueOf("Test")];
	}

}
