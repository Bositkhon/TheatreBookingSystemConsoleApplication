import java.util.Scanner;

public class BookingSystem {

    private int currectTheatreID;
    private double totalCost = 0;
    private int currentPerformanceID;

    public void run(){
        Scanner sc = new Scanner(System.in);
        boolean retry = true;
        String answer;
        int option, people;

        while(retry){
            System.out.println("Please choose a theatre where you want to buy a ticker");

            while (retry){
                Output.showTheatresList();
                while (retry){
                    option = sc.nextInt();
                    if(option > 0 && option <= Theatres.theatres.length){
                        this.setCurrectTheatreID(option - 1);
                        retry = false;
                    }else{
                        Output.showInvalidInputText();
                        retry = true;
                    }
                }

                Output.showPerformancesList(this.currectTheatreID);
                retry = true;
                while(retry){
                    option = sc.nextInt();
                    if(option > 0 && option <= Theatres.performances[this.currectTheatreID].length){
                        this.setCurrentPerformanceID(option - 1);
                        retry = false;
                    }else{
                        Output.showInvalidInputText();
                        retry = true;
                    }
                }

                System.out.println("Would you really want to buy it? (YES / NO)");
                answer = sc.next();
                if(answer.equals("YES")){
                    retry = true;
                    while(retry){
                        System.out.println("Enter the number of tickets you need to purchase");
                        people = sc.nextInt();
                        if(people > 0){
                            this.addToTotalCost(people * Theatres.getPerformancePrice(this.currectTheatreID, this.currentPerformanceID));
                            retry = false;
                        }else{
                            Output.showInvalidInputText();
                            retry = true;
                        }
                    }
                }else if(answer.equals("NO")){
                    retry = false;
                }else{
                    Output.showInvalidInputText();
                    retry = true;
                }
            }

            System.out.println("Purchase info");
            System.out.println("=============================");
            System.out.println("Theatre: " + this.getCurrentTheatreName());
            System.out.println("Performance: " + this.getCurrentPerformanceName());
            System.out.println("Cost" + this.getTotalCost());
            System.out.println("=============================");
            System.out.println("You have successfully purchased the ticket!");

            System.out.println("Would you to buy another ticket? (YES/NO)");
            answer = sc.next();
            if(answer.equals("YES")){
                retry = true;
            }else if(answer.equals("NO")){
                retry = false;
            }else{
                Output.showInvalidInputText();
            }

        }
    }

    private double getTotalCost() {
        return totalCost;
    }

    private void setCurrectTheatreID(int currectTheatreID) {
        this.currectTheatreID = currectTheatreID;
    }

    private void addToTotalCost(double price){
        this.totalCost += price;
    }

    private void setCurrentPerformanceID(int currentPerformanceID) {
        this.currentPerformanceID = currentPerformanceID;
    }

    public String getCurrentTheatreName (){
        return Theatres.theatres[this.currectTheatreID];
    }

    public String getCurrentPerformanceName(){
        return Theatres.performances[this.currectTheatreID][this.currentPerformanceID];
    }

}
