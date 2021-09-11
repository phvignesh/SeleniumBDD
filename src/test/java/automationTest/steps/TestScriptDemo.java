package automationTest.steps;
import automationTest.pages.TestScriptPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TestScriptDemo {
    TestScriptPage testScriptPage;

    @Given("I am on the test script demo page")
    public void i_am_on_the_test_script_demo_page(){
        testScriptPage=new TestScriptPage();
        testScriptPage.openurl("https://testscriptdemo.com/");
    }

    @Given("I add {int} different products to my wish list")
    public void given_i_add_four_different_products_to_my_wish_list(int numOfItems) throws InterruptedException {
        testScriptPage.addProductsToWishlist(numOfItems);
    }
    @When("I view my wishlist table")
    public void when_i_view_my_wishlisttable() {
        testScriptPage.viewWishlistTable();
    }
    @Then("I find total {int} selected items in my Wishlist")
    public void then_i_find_total_selected_items_in_wishlist(int numberOfItems) {
        Assert.assertEquals("Number of items are not matching in wishlist", numberOfItems, testScriptPage.getNumberOfItemsFromWishList());
    }

    @When("I search for lowest price product")
    public void i_search_for_lowest_product(){
        testScriptPage.iSearchLowestPriceProduct();
    }

    @When("I am able to add the lowest price item to my cart")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart(){
        testScriptPage.iAddLowestPriceProductToCart();
    }

    @When("I am able to verify the item in my cart")
    public void i_am_able_to_verify_item_in_my_cart(){
        testScriptPage.iVerifyProductAddedToCart();
    }
}
