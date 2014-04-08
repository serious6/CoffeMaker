package edu.ncsu.csc326.coffeemaker.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.ncsu.csc326.coffeemaker.AddRecipeTest;
import edu.ncsu.csc326.coffeemaker.CheckInventoryTest;
import edu.ncsu.csc326.coffeemaker.CoffeeMakerTest;
import edu.ncsu.csc326.coffeemaker.DeleteRecipeTest;
import edu.ncsu.csc326.coffeemaker.EditRecipeTest;
import edu.ncsu.csc326.coffeemaker.PurchaseCoffeeTest;

@RunWith(Suite.class)
@SuiteClasses({ CoffeeMakerTest.class, AddRecipeTest.class,
		CheckInventoryTest.class, DeleteRecipeTest.class, EditRecipeTest.class,
		PurchaseCoffeeTest.class })
public class AllTests {

}
