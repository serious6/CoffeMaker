package edu.ncsu.csc326.coffeemaker.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.ncsu.csc326.coffeemaker.CoffeeMakerTest;
import edu.ncsu.csc326.coffeemaker.AddRecipeTest;

@RunWith(Suite.class)
@SuiteClasses({CoffeeMakerTest.class, AddRecipeTest.class})
public class AllTests {

}
