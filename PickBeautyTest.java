import java.util.Arrays;
import java.util.NoSuchElementException;

public class PickBeautyTest {

	public static boolean testAdd() {
		BeautyBackend testTable= new BeautyBackend();
		Product puraShampoo = new Product("B00FH692PQ","PURA D'OR Original Gold Label "
				+ "Anti-Thinning Biotin Shampoo (16oz) w/ Argan Oil, Nettle Extract, "
				+ "Saw Palmetto, Red Seaweed, 17+ DHT Herbal Actives, No Sulfates, "
				+ "Natural Preservatives, For Men & Women",(float)29.99,(float)4.3, 
				21019,"/PURA-DOR-Anti-Thinning-Clinically-Ingredients/dp/B00FH692PQ");
		Product myerDishSoup = new Product("B01M6779ER","Mrs. Meyer's Clean Day Liquid "
				+ "Dish Soap, Cruelty Free Formula, Lavender Scent, 16 oz- Pack of 3",
				(float)31.68, (float)4.7,9975,
				"/Mrs-Meyer%C2%B4s-Clean-Dish-Lavender/dp/B01M6779ER");
		// Check normal adding
		if(!testTable.add(puraShampoo)) {
			System.out.println("Problem with add puraShampoo!");
			return false;
		}
		if(!testTable.add(myerDishSoup)) {
			System.out.println("Problem with add myerDishSoup!");
			return false;
		}
		
		// Check adding repeated product
		if(testTable.add(puraShampoo)) {
			System.out.println("Shouldn't add puraShampoo, but added!");
			return false;
		}
		
		return true;
	}
	public static boolean testRemove() {
		BeautyBackend testTable= new BeautyBackend();
		// Remove from empty table
		if(testTable.remove("B00FH692PQ")) {
			System.out.println("Shouldn't be able to remove an item from empty table!");
			return false;
		}
		Product puraShampoo = new Product("B00FH692PQ","PURA D'OR Original Gold Label "
				+ "Anti-Thinning Biotin Shampoo (16oz) w/ Argan Oil, Nettle Extract, "
				+ "Saw Palmetto, Red Seaweed, 17+ DHT Herbal Actives, No Sulfates, "
				+ "Natural Preservatives, For Men & Women",(float)29.99,(float)4.3, 
				21019,"/PURA-DOR-Anti-Thinning-Clinically-Ingredients/dp/B00FH692PQ");
		Product myerDishSoup = new Product("B01M6779ER","Mrs. Meyer's Clean Day Liquid "
				+ "Dish Soap, Cruelty Free Formula, Lavender Scent, 16 oz- Pack of 3",
				(float)31.68, (float)4.7,9975,
				"/Mrs-Meyer%C2%B4s-Clean-Dish-Lavender/dp/B01M6779ER");
		Product revlonHairDryer = new Product("B01LSUQSB0","Revlon One-Step Hair Dryer "
				+ "And Volumizer Hot Air Brush, Black, Packaging May Vary",
				(float)64.22,(float)4.4,76124,
				"/Revlon-One-Step-Dryer-Volumizer-Brush/dp/B01LSUQSB0");
		
		testTable.add(puraShampoo);
		testTable.add(myerDishSoup);
		testTable.add(revlonHairDryer);
		// Remove one in the table
		if(!testTable.remove("B00FH692PQ")) {
			System.out.println("puraShampoo should be removed but doesn't");
			return false;
		}
		
		// Remove one not in the table
		if(testTable.remove("B00FH692AA")) {
			System.out.println("This itmem is not in the table, cannot be removed!");
			return false;
		}
		return true;
	}
	public static boolean testGet() {
		BeautyBackend testTable= new BeautyBackend();
		// Get an item from empty table
		if(testTable.get("B00FH692PQ")!=null) {
			System.out.println("Shoudln't be able to get an item from empty table!");
			return false;	
		}
		
		Product puraShampoo = new Product("B00FH692PQ","PURA D'OR Original Gold Label "
				+ "Anti-Thinning Biotin Shampoo (16oz) w/ Argan Oil, Nettle Extract, "
				+ "Saw Palmetto, Red Seaweed, 17+ DHT Herbal Actives, No Sulfates, "
				+ "Natural Preservatives, For Men & Women",(float)29.99,(float)4.3, 
				21019,"/PURA-DOR-Anti-Thinning-Clinically-Ingredients/dp/B00FH692PQ");
		Product myerDishSoup = new Product("B01M6779ER","Mrs. Meyer's Clean Day Liquid "
				+ "Dish Soap, Cruelty Free Formula, Lavender Scent, 16 oz- Pack of 3",
				(float)31.68, (float)4.7,9975,
				"/Mrs-Meyer%C2%B4s-Clean-Dish-Lavender/dp/B01M6779ER");
		Product revlonHairDryer = new Product("B01LSUQSB0","Revlon One-Step Hair Dryer "
				+ "And Volumizer Hot Air Brush, Black, Packaging May Vary",
				(float)64.22,(float)4.4,76124,
				"/Revlon-One-Step-Dryer-Volumizer-Brush/dp/B01LSUQSB0");
		
		testTable.add(puraShampoo);
		testTable.add(myerDishSoup);
		testTable.add(revlonHairDryer);
		// Get an existing item
		if(!testTable.get("B00FH692PQ").equals(puraShampoo)) {
			System.out.println("Should get puraShampoo, but fail to work!");
			return false;
		}
		
		// Get an non-existing item
		if(testTable.get("B00FH692AA")!=null) {
			System.out.println("Should not get this item! It's not in the table!");
			return false;
		}
		return true;
	}
	public static boolean testList() {
		BeautyBackend testTable= new BeautyBackend();
		Product puraShampoo = new Product("B00FH692PQ","PURA D'OR Original Gold Label "
				+ "Anti-Thinning Biotin Shampoo (16oz) w/ Argan Oil, Nettle Extract, "
				+ "Saw Palmetto, Red Seaweed, 17+ DHT Herbal Actives, No Sulfates, "
				+ "Natural Preservatives, For Men & Women",(float)29.99,(float)4.3, 
				21019,"/PURA-DOR-Anti-Thinning-Clinically-Ingredients/dp/B00FH692PQ");
		Product myerDishSoup = new Product("B01M6779ER","Mrs. Meyer's Clean Day Liquid "
				+ "Dish Soap, Cruelty Free Formula, Lavender Scent, 16 oz- Pack of 3",
				(float)31.68, (float)4.7,9975,
				"/Mrs-Meyer%C2%B4s-Clean-Dish-Lavender/dp/B01M6779ER");
		Product revlonHairDryer = new Product("B01LSUQSB0","Revlon One-Step Hair Dryer "
				+ "And Volumizer Hot Air Brush, Black, Packaging May Vary",
				(float)64.22,(float)4.4,76124,
				"/Revlon-One-Step-Dryer-Volumizer-Brush/dp/B01LSUQSB0");
		Product blushBrush = new Product("B01EO2KP2M","wet n wild Blush Brush",
				(float)5.44, (float)4.5,21865,"/wet-n-wild-Blush-Brush/dp/B01EO2KP2M");
		// Check empty table
		Product[] testResult1 = testTable.list();
		if(testResult1.length!=0) {
			System.out.println("Empty table should get empty list, but doesn't!");
			return false;
		}
		// Check one item table list
		testTable.add(puraShampoo); //B00FH692PQ
		Product[] result2 = {puraShampoo};
		Product[] testResult2 = testTable.list();
		for(int i = 0; i<testResult2.length; i++) {
			if (!result2[i].equals(testResult2[i])) {
				System.out.println("Item doesn't match for index "+i);
				return false;
			}
		}
		// Check more items
		testTable.add(myerDishSoup); //B01M6779ER
		testTable.add(revlonHairDryer); //B01LSUQSB0
		testTable.add(blushBrush); //B01EO2KP2M
		
		Product[] result3 = {puraShampoo,revlonHairDryer,blushBrush,myerDishSoup};
		Product[] testResult3 = testTable.list();
		
		for(int i = 0; i<testResult3.length; i++) {
			if (!result3[i].equals(testResult3[i])) {
				System.out.println("Item doesn't match for index "+i);
				return false;
			}
		}
		
		// Check with alphabetical sorting and filter
		Filter lowPrice = new Filter();
		lowPrice.setMaxPrice(50);
		lowPrice.setMinPrice(0);
		lowPrice.setMaxStars(5);
		lowPrice.setMinStars((float)4.5);
		Product[] testResult4 = testTable.list(lowPrice, Sort.ALPHABETICAL);
		Product[] result4 = {myerDishSoup,blushBrush};
		for(int i = 0; i<testResult4.length; i++) {
			if (!result4[i].equals(testResult4[i])) {
				System.out.println("Item doesn't match for index "+i+" for sort of Alphabetical");
				return false;
			}
		}
		
		// Check with price low to high sorting and filter
		Product[] testResult5 = testTable.list(lowPrice, Sort.PRICE_LOW_TO_HIGH);
		Product[] result5 = {blushBrush,myerDishSoup};
		for(int i = 0; i<testResult5.length; i++) {
			if (!result5[i].equals(testResult5[i])) {
				System.out.println("Item doesn't match for index "+i+" for sort of price LTH");
				return false;
			}
		}
		
		// Check with rating sorting and filter
		Product[] testResult6 = testTable.list(lowPrice, Sort.AVG_RATING);
		Product[] result6 = {myerDishSoup,blushBrush};
		for(int i = 0; i<testResult6.length; i++) {
			if (!result6[i].equals(testResult6[i])) {
				System.out.println("Item doesn't match for index "+i+" for sort of avg ratings");
				return false;
			}
		}
		return true;
	}
	public static boolean testSearch() {
		BeautyBackend testTable= new BeautyBackend();
		Product puraShampoo = new Product("B00FH692PQ","PURA D'OR Original Gold Label "
				+ "Anti-Thinning Biotin Shampoo (16oz) w/ Argan Oil, Nettle Extract, "
				+ "Saw Palmetto, Red Seaweed, 17+ DHT Herbal Actives, No Sulfates, "
				+ "Natural Preservatives, For Men & Women",(float)29.99,(float)4.3, 
				21019,"/PURA-DOR-Anti-Thinning-Clinically-Ingredients/dp/B00FH692PQ");
		Product myerDishSoup = new Product("B01M6779ER","Mrs. Meyer's Clean Day Liquid "
				+ "Dish Soap, Cruelty Free Formula, Lavender Scent, 16 oz- Pack of 3",
				(float)31.68, (float)4.7,9975,
				"/Mrs-Meyer%C2%B4s-Clean-Dish-Lavender/dp/B01M6779ER");
		Product revlonHairDryer = new Product("B01LSUQSB0","Revlon One-Step Hair Dryer "
				+ "And Volumizer Hot Air Brush, Black, Packaging May Vary",
				(float)64.22,(float)4.4,76124,
				"/Revlon-One-Step-Dryer-Volumizer-Brush/dp/B01LSUQSB0");
		Product blushBrush = new Product("B01EO2KP2M","wet n wild Blush Brush",
				(float)5.44, (float)4.5,21865,"/wet-n-wild-Blush-Brush/dp/B01EO2KP2M");
		Product myerHandSoup = new Product("B0020VJTDG","Mrs. Meyer's Clean Day Liquid "
				+ "Hand Soap Refill, Cruelty Free and Biodegradable Formula, "
				+ "Basil Scent, 33 Oz",(float)23.42,(float)4.6,13807,
				"/Mrs-Meyers-Liquid-Refill-Basil/dp/B0020VJTDG");
		
		testTable.add(puraShampoo);
		testTable.add(myerDishSoup);
		testTable.add(revlonHairDryer);
		testTable.add(blushBrush);
		testTable.add(myerHandSoup);
		
		// Search not exist product
		Product[] testResult0 = testTable.search("LALA");
		
		if(testResult0.length!=0) {
			System.out.println("This item shouldn't be searched out!");
			return false;
		}
		
		// Search without filtering or sorting
		Product[] testResult1 = testTable.search("Meyer");
		Product[] result1 = {myerHandSoup,myerDishSoup};
		
		for(int i = 0; i<testResult1.length; i++) {
			if (!result1[i].equals(testResult1[i])) {
				System.out.println("Item doesn't match for index "+i+" for search of Meyer!");
				return false;
			}
		}
		
		// Check search for meyer with empty filter and sorting price High to low
		Filter noFilt = new Filter();
		Product[] testResult2 = testTable.search("Meyer", noFilt, Sort.PRICE_HIGH_TO_LOW);
		Product[] result2 = {myerDishSoup,myerHandSoup};
		
		for(int i = 0; i<testResult2.length; i++) {
			if (!result2[i].equals(testResult2[i])) {
				System.out.println("Item doesn't match for index "+i+" for search of Meyer with price HTL sort!");
				return false;
			}
		}
		
		// Check search for meyer with a filter and sorting num_ratings
		Filter someFilt = new Filter();
		someFilt.setMaxPrice(30);
		someFilt.setMinStars((float)4.5);
		Product[] testResult3 = testTable.search("Meyer", someFilt, Sort.NUM_RATING);
		Product[] result3 = {myerHandSoup};
		
		for(int i = 0; i<testResult3.length; i++) {
			if (!result3[i].equals(testResult3[i])) {
				System.out.println("Item doesn't match for index "+i+" for search of Meyer with num_review sort!");
				return false;
			}
		}
		return true;
	}

	
	public static void main(String []args) {
		System.out.println("TestAdd result: "+ testAdd());
		System.out.println("TestRemove result: "+ testRemove());
		System.out.println("TestGet result: "+ testGet());
		System.out.println("TestList result: "+ testList());
		System.out.println("TestSearch result: "+ testSearch());
	}
}
