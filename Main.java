//import com.sun.java.util.jar.pack.Instruction;

import java.util.Scanner;

public class Main {


    public static long taxi1Start = 0;
    public static long taxi1Stop = 0;
    public static long taxi1Pause = 0;
    public static boolean taxi1Active = false;
    public static boolean taxi1Unpause = false;
    public static double taxi1Time = 0;


    public static long taxi2Start = 0;
    public static long taxi2Stop = 0;
    public static long taxi2Pause = 0;
    public static boolean taxi2Active = false;
    public static boolean taxi2Unpause = false;
    public static double taxi2Time = 0;


    public static long taxi3Start = 0;
    public static long taxi3Stop = 0;
    public static long taxi3Pause = 0;
    public static boolean taxi3Active = false;
    public static boolean taxi3Unpause = false;
    public static double taxi3Time = 0;

    public static long taxi4Start = 0;
    public static long taxi4Stop = 0;
    public static long taxi4Pause = 0;
    public static boolean taxi4Active = false;
    public static boolean taxi4Unpause = false;
    public static double taxi4Time = 0;

    public static long taxi5Start = 0;
    public static long taxi5Stop = 0;
    public static long taxi5Pause = 0;
    public static boolean taxi5Active = false;
    public static boolean taxi5Unpause = false;
    public static double taxi5Time = 0;


    public static long taxi6Start = 0;
    public static long taxi6Stop = 0;
    public static long taxi6Pause = 0;
    public static boolean taxi6Active = false;
    public static boolean taxi6Unpause = false;
    public static double taxi6Time = 0;


    public static long taxi7Start = 0;
    public static long taxi7Stop = 0;
    public static long taxi7Pause = 0;
    public static boolean taxi7Active = false;
    public static boolean taxi7Unpause = false;
    public static double taxi7Time = 0;


    public static long taxi8Start = 0;
    public static long taxi8Stop = 0;
    public static long taxi8Pause = 0;
    public static boolean taxi8Active = false;
    public static boolean taxi8Unpause = false;
    public static double taxi8Time = 0;


    public static long taxi9Start = 0;
    public static long taxi9Stop = 0;
    public static long taxi9Pause = 0;
    public static boolean taxi9Active = false;
    public static boolean taxi9Unpause = false;
    public static double taxi9Time = 0;


    public static long taxi10Start = 0;
    public static long taxi10Stop = 0;
    public static long taxi10Pause = 0;
    public static boolean taxi10Active = false;
    public static boolean taxi10Unpause = false;
    public static double taxi10Time = 0;


    public static void main(String[] args) {
        showMenu();
        taxi();


    }

    public static void taxi() {
        int input, index;
        double driveTime;

//        System.out.println("3333");
        while (true){
            input = chooseMenu();

            if (input == 1) {// choose option 1: Start
                showTaxis();
                index = chooseTaxi();
                if(getTaxiActive(index) == false && getTaxiPause(index) > 0){ //Unpause
                    setTaxiStart(index, System.currentTimeMillis());
                    setTaxiPause(index, 0);
                    setTaxiActive(index, true);
                    setTaxiUnpause(index, true);
                    System.out.println("taxi " + index +": "+ "unpause");

                }else if(getTaxiActive(index) == false){ // Start
                    setTaxiStart(index, System.currentTimeMillis());
                    setTaxiActive(index, true);
                    System.out.println("taxi " + index +": "+ "started");
                    showMenu();
                }else{ //error
                    System.out.println("taxi " + index +": "+ "already started. Stop taxi before starting another one");
                    showMenu();
                }


            } else if (input == 2) {// choose option 2: Pause
                showTaxis();
                index = chooseTaxi();
                if(getTaxiActive(index)){ //Pause

                    setTaxiPause(index, System.currentTimeMillis());
                    System.out.println("taxi " + index +": "+ "pause taxi");

                    //midway time
                    driveTime = (getTaxiPause(index) - getTaxiStart(index))/1000.0;
                    driveTime = Math.round(driveTime * 100d)/100d;// round up to two digits

                    System.out.println("taxi " + index +": "+ "time 1: " + getTaxiTime(index));
                    System.out.println("taxi " + index +": "+ "time 2: " + driveTime);
                    setTaxiTime(index, getTaxiTime(index) + driveTime); //time1+time2
                    System.out.println("taxi " + index +": "+ "Total time " + getTaxiTime(index));

                    setTaxiActive(index, false);
                    driveTime = 0;
                    showMenu();

                }else{ // Error
                    System.out.println("taxi " + index +": "+ "Choosen taxi isn't started yet");
                    showMenu();

                }
            } else if (input == 3) {// choose option 3: Stop
                showTaxis();
                index = chooseTaxi();
                if(getTaxiTime(index) > 0 && getTaxiUnpause(index) && getTaxiPause(index) > 0){ //Start -> Pause -> Unpause -> Pause -> Stop
                    System.out.println("taxi " + index +": "+ "Start -> Pause -> Unpause -> Pause -> Stop");
                    System.out.println("taxi " + index +": "+ "total time " + getTaxiTime(index));
                    setTaxiStop(index, System.currentTimeMillis() );

                    setTaxiActive(index, false);
                    System.out.println("taxi " + index +": "+ "stopped " );
                    showPrice(getTaxiTime(index));
                    setTaxiReset(index);
                    showMenu();

                }else if(getTaxiTime(index) > 0 && getTaxiUnpause(index)){ // Start -> Pause -> Unpause -> Stop
                    System.out.println("taxi " + index +": "+ "Start -> Pause -> Unpause -> Stop");
                    setTaxiStop(index, System.currentTimeMillis() );


                    driveTime = (getTaxiStop(index) - getTaxiStart(index))/1000.0;
                    driveTime = Math.round(driveTime * 100d)/100d;// round up to two digits

                    System.out.println("taxi " + index +": "+ "time 1 :" + getTaxiTime(index));
                    System.out.println("taxi " + index +": "+ "time 2 :" + driveTime);
                    setTaxiTime(index, getTaxiTime(index) + driveTime); //time1+time2
                    System.out.println("taxi " + index +": "+ "Total time " + getTaxiTime(index));

                    setTaxiActive(index, false);
                    driveTime = 0;

                    System.out.println("taxi " + index +": "+ "stopped" );
                    showPrice(getTaxiTime(index));
                    setTaxiReset(index);
                    showMenu();

                }else if(getTaxiTime(index) > 0){ // Start -> Pause -> Stop
                    System.out.println("taxi " + index +": "+ "Start -> Pause -> Stop");
                    setTaxiStop(index, System.currentTimeMillis() );

                    driveTime = (getTaxiPause(index) - getTaxiStart(index))/1000.0;
                    driveTime = Math.round(driveTime * 100d)/100d;// round up to two digits

                    System.out.println("taxi " + index +": "+ "time 1: " + getTaxiTime(index));
                    setTaxiTime(index,driveTime);
                    System.out.println("taxi " + index +": "+ "Total time " + getTaxiTime(index));

                    setTaxiActive(index, false);
//                    driveTime = 0;

                    System.out.println("taxi " + index +": "+ "stopped" );
                    showPrice(getTaxiTime(index));
                    setTaxiReset(index);
                    showMenu();

                }else if(getTaxiActive(index)){ // Start -> Stop
                    System.out.println("taxi " + index +": "+ "Start -> Stop");
                    setTaxiStop(index, System.currentTimeMillis() );


                    driveTime = (getTaxiStop(index) - getTaxiStart(index))/1000.0;
                    driveTime = Math.round(driveTime * 100d)/100d;// round up to two digits

                    System.out.println("taxi " + index +": "+ "time 1: " + getTaxiTime(index));
                    System.out.println("taxi " + index +": "+ "time 2: " + driveTime);
                    setTaxiTime(index, getTaxiTime(index) + driveTime); //time1+time2
                    System.out.println("taxi " + index +": "+ "Total time " + getTaxiTime(index));

                    setTaxiActive(index, false);
                    driveTime = 0;

                    System.out.println("taxi " + index +": "+ "stopped" );
                    showPrice(getTaxiTime(index));
                    setTaxiReset(index);
                    showMenu();


                }else{ // Error
                    System.out.println("taxi " + index +": "+ "Taxi not started yet. Stop ongoing taxi or paused taxi");
                    showMenu();
                }
            } else if (input == 4) {// choose option 4: Price
                showTaxis();
                index = chooseTaxi();
                showPrice(getTaxiTime(index));

            } else if (input == 5) {// choose option 5: Free ride
                showTaxis();
                index = chooseTaxi();
                showFreeRide(getTaxiTime(index));

            }
//            showMenu();//calls menu() function
//            break;

        }


    }
//}



//getters
    public static long getTaxiStart (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Start;
            case 2:  return taxi2Start;
            case 3:  return taxi3Start;
            case 4:  return taxi4Start;
            case 5:  return taxi5Start;
            case 6:  return taxi6Start;
            case 7:  return taxi7Start;
            case 8:  return taxi8Start;
            case 9:  return taxi9Start;
            case 10: return taxi10Start;
        }
        return -1;

    }

    public static long getTaxiStop (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Stop;
            case 2:  return taxi2Stop;
            case 3:  return taxi3Stop;
            case 4:  return taxi4Stop;
            case 5:  return taxi5Stop;
            case 6:  return taxi6Stop;
            case 7:  return taxi7Stop;
            case 8:  return taxi8Stop;
            case 9:  return taxi9Stop;
            case 10: return taxi10Stop;
        }
        return -1;

    }

    public static long getTaxiPause (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Pause;
            case 2:  return taxi2Pause;
            case 3:  return taxi3Pause;
            case 4:  return taxi4Pause;
            case 5:  return taxi5Pause;
            case 6:  return taxi6Pause;
            case 7:  return taxi7Pause;
            case 8:  return taxi8Pause;
            case 9:  return taxi9Pause;
            case 10: return taxi10Pause;
        }
        return -1;

    }

    public static boolean getTaxiActive (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Active;
            case 2:  return taxi2Active;
            case 3:  return taxi3Active;
            case 4:  return taxi4Active;
            case 5:  return taxi5Active;
            case 6:  return taxi6Active;
            case 7:  return taxi7Active;
            case 8:  return taxi8Active;
            case 9:  return taxi9Active;
            case 10: return taxi10Active;
        }
        return false;

    }

    public static boolean getTaxiUnpause (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Unpause;
            case 2:  return taxi2Unpause;
            case 3:  return taxi3Unpause;
            case 4:  return taxi4Unpause;
            case 5:  return taxi5Unpause;
            case 6:  return taxi6Unpause;
            case 7:  return taxi7Unpause;
            case 8:  return taxi8Unpause;
            case 9:  return taxi9Unpause;
            case 10: return taxi10Unpause;
        }
        return false;

    }

    public static double getTaxiTime (int taxi) {


        switch (taxi) {
            case 1:  return taxi1Time;
            case 2:  return taxi2Time;
            case 3:  return taxi3Time;
            case 4:  return taxi4Time;
            case 5:  return taxi5Time;
            case 6:  return taxi6Time;
            case 7:  return taxi7Time;
            case 8:  return taxi8Time;
            case 9:  return taxi9Time;
            case 10: return taxi10Time;
        }
        return -1;

    }



    //Setters x7 setters

    public static void setTaxiStart (int taxi, long time) {

        switch (taxi) {
            case 1:   taxi1Start = time;
                break;
            case 2:   taxi2Start = time;
                break;
            case 3:   taxi3Start = time;
                break;
            case 4:   taxi4Start = time;
                break;
            case 5:   taxi5Start = time;
                break;
            case 6:   taxi6Start = time;
                break;
            case 7:   taxi7Start = time;
                break;
            case 8:   taxi8Start = time;
                break;
            case 9:   taxi9Start = time;
                break;
            case 10:  taxi10Start = time;
                break;
        }

    }


    public static void setTaxiStop (int taxi, long time) {

        switch (taxi) {
            case 1:   taxi1Stop = time;
                break;
            case 2:   taxi2Stop = time;
                break;
            case 3:   taxi3Stop = time;
                break;
            case 4:   taxi4Stop = time;
                break;
            case 5:   taxi5Stop = time;
                break;
            case 6:   taxi6Stop = time;
                break;
            case 7:   taxi7Stop = time;
                break;
            case 8:   taxi8Stop = time;
                break;
            case 9:   taxi9Stop = time;
                break;
            case 10:  taxi10Stop = time;
                break;
        }

    }



    public static void setTaxiPause (int taxi, long time) {

        switch (taxi) {
            case 1:   taxi1Pause = time;
                break;
            case 2:   taxi2Pause = time;
                break;
            case 3:   taxi3Pause = time;
                break;
            case 4:   taxi4Pause = time;
                break;
            case 5:   taxi5Pause = time;
                break;
            case 6:   taxi6Pause = time;
                break;
            case 7:   taxi7Pause = time;
                break;
            case 8:   taxi8Pause = time;
                break;
            case 9:   taxi9Pause = time;
                break;
            case 10:  taxi10Pause = time;
                break;
        }

    }



    public static void setTaxiActive (int taxi, boolean value) {

        switch (taxi) {
            case 1:   taxi1Active = value;
                break;
            case 2:   taxi2Active = value;
                break;
            case 3:   taxi3Active = value;
                break;
            case 4:   taxi4Active = value;
                break;
            case 5:   taxi5Active = value;
                break;
            case 6:   taxi6Active = value;
                break;
            case 7:   taxi7Active = value;
                break;
            case 8:   taxi8Active = value;
                break;
            case 9:   taxi9Active = value;
                break;
            case 10:  taxi10Active = value;
                break;
        }

    }



    public static void setTaxiUnpause (int taxi, boolean value) {

        switch (taxi) {
            case 1:   taxi1Unpause = value;
                break;
            case 2:   taxi2Unpause = value;
                break;
            case 3:   taxi3Unpause = value;
                break;
            case 4:   taxi4Unpause = value;
                break;
            case 5:   taxi5Unpause = value;
                break;
            case 6:   taxi6Unpause = value;
                break;
            case 7:   taxi7Unpause = value;
                break;
            case 8:   taxi8Unpause = value;
                break;
            case 9:   taxi9Unpause = value;
                break;
            case 10:  taxi10Unpause = value;
                break;
        }

    }



    public static void setTaxiTime (int taxi, double time) {

        switch (taxi) {
            case 1:   taxi1Time = time;
                break;
            case 2:   taxi2Time = time;
                break;
            case 3:   taxi3Time = time;
                break;
            case 4:   taxi4Time = time;
                break;
            case 5:   taxi5Time = time;
                break;
            case 6:   taxi6Time = time;
                break;
            case 7:   taxi7Time = time;
                break;
            case 8:   taxi8Time = time;
                break;
            case 9:   taxi9Time = time;
                break;
            case 10:  taxi10Time = time;
                break;
        }

    }

    public static void setTaxiReset(int taxi) {
        switch (taxi) {
            case 1:
                taxi1Start = 0;
                taxi1Stop = 0;
                taxi1Pause = 0;
                taxi1Active = false;
                taxi1Unpause = false;
                taxi1Time = 0;
                break;
            case 2:
                taxi2Start = 0;
                taxi2Stop = 0;
                taxi2Pause = 0;
                taxi2Active = false;
                taxi2Unpause = false;
                taxi2Time = 0;
                break;
            case 3:
                taxi3Start = 0;
                taxi3Stop = 0;
                taxi3Pause = 0;
                taxi3Active = false;
                taxi3Unpause = false;
                taxi3Time = 0;
                break;
            case 4:
                taxi4Start = 0;
                taxi4Stop = 0;
                taxi4Pause = 0;
                taxi4Active = false;
                taxi4Unpause = false;
                taxi4Time = 0;
                break;
            case 5:
                taxi5Start = 0;
                taxi5Stop = 0;
                taxi5Pause = 0;
                taxi5Active = false;
                taxi5Unpause = false;
                taxi5Time = 0;
                break;
            case 6:
                taxi6Start = 0;
                taxi6Stop = 0;
                taxi6Pause = 0;
                taxi6Active = false;
                taxi6Unpause = false;
                taxi6Time = 0;
                break;
            case 7:
                taxi7Start = 0;
                taxi7Stop = 0;
                taxi7Pause = 0;
                taxi7Active = false;
                taxi7Unpause = false;
                taxi7Time = 0;
                break;
            case 8:
                taxi8Start = 0;
                taxi8Stop = 0;
                taxi8Pause = 0;
                taxi8Active = false;
                taxi8Unpause = false;
                taxi8Time = 0;
                break;
            case 9:
                taxi9Start = 0;
                taxi9Stop = 0;
                taxi9Pause = 0;
                taxi9Active = false;
                taxi9Unpause = false;
                taxi9Time = 0;
                break;
            case 10:
                taxi10Start = 0;
                taxi10Stop = 0;
                taxi10Pause = 0;
                taxi10Active = false;
                taxi10Unpause = false;
                taxi10Time = 0;
                break;
        }


    }

    public static void showMenu() {

        System.out.println("Welcome to Damn Fast Taxis");
        System.out.println("------------------------");
        System.out.println("(1) Start a taxi");
        System.out.println("(2) Pause a ride");
        System.out.println("(3) Stop a taxi");
        System.out.println("(4) Ask for price");
        System.out.println("(5) Free ride");
        System.out.println("\n");
        System.out.println("Choose a <number> and hit \"enter\" ");
        System.out.println(" \n ");

    }
    public static int input() {

//        System.out.println("input");

        Scanner in = new Scanner(System.in);
        int number;
        number = in.nextInt();//takes a number as an input
        System.out.println("Input:  " + number);//prints  input + choice number
        return number;

    }


    public static void start (int currentTaxi){

    }


    public static void showPrice(double time) {

        System.out.println(" \n ");
        System.out.println("Damn Fast Taxis");
        System.out.println("Time: " + time + " seconds");
        System.out.println("Price per second: 2.25 dollar");
        System.out.println("Total price: " + time*2.25 + " dollar");// calculates price per seconds
        System.out.println("Press any key to continue...");
        System.out.println(" \n ");
        //prints price menu

    }

    public static void showFreeRide(double time) {

        System.out.println("Damn Fast Taxis");
        System.out.println("------------------------");
        System.out.println("Time: " + time + " seconds");// prints time as seconds
        System.out.println("Price per second: 0 dollar");
        System.out.println("Total price: " + 0 + " dollar");
        System.out.println("Press any key to continue...");
        //prints free ride menu
    }

    public static void showTaxis(){

        System.out.println("Choose a taxi number and press 'enter'");
        for (int i= 1; i<= 10 ; i++){
//            System.out.println(i + " -  - " + getTaxiActive(i));
            if (getTaxiActive(i)){
                System.out.println(i + " - Taxi is active ");
            }else if(getTaxiTime(i) > 0){
                System.out.println(i + " - Taxi is stopped ");
            }else if(getTaxiActive(i) == false) {

                System.out.println(i + " - Taxi is inactive ");
            }
        }

    }

    public static int chooseMenu() {
        int number = input();
        if (number == 1 || number == 2 || number == 3 || number == 4 || number == 5) {
            return number;

        }
        return chooseMenu();
    }

    public static int chooseTaxi() {
        int number = input();
        if (number == 1 || number == 2 || number == 3 || number == 4 || number == 5 || number == 6 || number == 7 || number == 8 || number == 9 || number == 10) {
            return number;

        }
        return chooseTaxi();

    }

}

