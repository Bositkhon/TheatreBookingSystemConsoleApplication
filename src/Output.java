public class Output {

    public static void showPerformancesList(int theatreID){
        for(int i = 0; i < Theatres.performances[theatreID].length; i++){
            System.out.println((i+1) + ". " + Theatres.performances[theatreID][i]);
            System.out.println("    Price: " + Theatres.prices[theatreID][i] + "/ per person");
        }
    }

    public static void showTheatresList(){
        for(int i = 0; i < Theatres.theatres.length; i++){
            System.out.println((i+1) + ". " + Theatres.theatres[i]);
        }
    }

    public static void showInvalidInputText(){
        System.out.println("Invalid Input. Please try again!");
    }

}