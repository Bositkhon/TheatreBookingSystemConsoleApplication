public class Theatres {

    public static String[] theatres = {
            "Alisher Navoi Theatre",
            "Ilkhom Theatre",
            "Русский драматургический театр"
    };

    public static String[][] performances = {
            {"Hamlet", "Polito de Torino"},
            {"Russian Drama", "Alexander Shevchenko", "Prestuplenie i nakazanie"},
            {""}
    };

    public static double[][] prices = {
            {30000, 25000},
            {35000, 30000, 25000}
    };

    public static double getPerformancePrice(int theatreID, int performanceID){
        return prices[theatreID][performanceID];
    }



}