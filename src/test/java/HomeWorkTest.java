import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeWorkTest {

    public double getTax(double income) {
        if (income <10000 ){
            return income * 0.13;} else if (income >= 10000 && income < 50000 ) {
            return income * 0.2;
        } else { return income * 0.3;
            
        }

    }

     @Test(dataProvider = "incomeprovider")
     public void checkTexesCalculation(int income, double expTax){
         Assert.assertEquals(getTax(income), expTax * income,String.format("Texes for %s should be %s", income, expTax));
     }
     @DataProvider
     public Object[][] incomeprovider(){return new Object[][]{
             {0,0},
             {9999,0.13},
             {10000,0.2},
              {15000,0.2},

             {49999,0.2},
             {50000,0.3},
     };

    }
}