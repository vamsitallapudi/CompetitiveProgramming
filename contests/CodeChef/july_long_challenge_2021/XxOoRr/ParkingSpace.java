/*
Design a parking lot using object-oriented principles

Goals:
- Your solution should be in Java - if you would like to use another language, please let the interviewer know.
- Boilerplate is provided. Feel free to change the code as you see fit

Assumptions:
- The parking lot can hold motorcycles, cars and vans
- The parking lot has motorcycle spots, car spots and large spots
- A motorcycle can park in any spot
- A car can park in a single compact spot, or a regular spot
- A van can park, but it will take up 3 regular spots
- These are just a few assumptions. Feel free to ask your interviewer about more assumptions as needed

Here are a few methods that you should be able to run:
- Tell us how many spots are remaining
- Tell us how many total spots are in the parking lot
- Tell us when the parking lot is full
- Tell us when the parking lot is empty
- Tell us when certain spots are full e.g. when all motorcycle spots are taken
- Tell us how many spots vans are taking up

Hey candidate! Welcome to your interview. I'll start off by giving you a Solution class. To run the code at any time, please hit the run button located in the top left corner.
*/

import java.io.*;
import java.util.*;

class ParkingSpace {
    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();
        System.out.println(lot.park(new Car()));
        System.out.println(lot.park(new Car()));
        System.out.println(lot.park(new Car()));
    }

    public static enum SpotSize {
        MOTOR_CYCLE, CAR, VAN
    };

    public static class ParkingSpot {
        private boolean available = true;

        public ParkingSpot() {
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }

    }

    public static class ParkingLot {
        static ParkingLot lot;
        static ParkingSpot[] totalParkingSpots = new ParkingSpot[5];
        static long availableSpots = totalParkingSpots.length;

        static Vehicle vehicle;

        public static ParkingLot getInstance() {
            if (lot == null) {
                lot = new ParkingLot();
                initializeParkingSpots();
            }
            return lot;
        }

        private static void initializeParkingSpots() {
            for (int i = 0; i < 5; i++) {
                ParkingSpot spot = new ParkingSpot();
                totalParkingSpots[i] = spot;
            }
        }

        public String park(Vehicle vehicle) {
            int parkingSize = vehicle.getParkingSize();
            if (availableSpots < parkingSize || !performParking(parkingSize)) {
                return "No parking space available";
            }
            calculateAvailableSpots();
            return "Vehicle parked successfully";
        }

        // to check the size and perform parking
        private boolean performParking(int size) {
            Deque<Integer> spot = new ArrayDeque<Integer>();
            for (int i = 0; i < totalParkingSpots.length; i++) {
                if (spot.size() >= size) {
                    fillSpots(spot);
                    return true;
                }
                if (totalParkingSpots[i].isAvailable()) {
                    spot.addLast(i);
                } else {
                    spot = new ArrayDeque<Integer>();
                }
            }
            return false;
        }

        // to check if the spots are available in consecutive order
        private void fillSpots(Deque<Integer> spot) {
            spot.forEach(i -> totalParkingSpots[i].setAvailable(false));
        }

        // to check the remaining available spots
        private void calculateAvailableSpots() {
            availableSpots = Arrays.stream(totalParkingSpots).filter(a -> a.isAvailable() == true).count();
        }

    }

    public static abstract class Vehicle {
        protected int parkingSize;

        public int getParkingSize() {
            return parkingSize;
        }
    }

    public static class MotorCycle extends Vehicle {
        public MotorCycle() {
            parkingSize = 1;
        }
    }

    public static class Car extends Vehicle {
        public Car() {
            parkingSize = 2;
        }
    }

    public static class Van extends Vehicle {
        public Van() {
            parkingSize = 3;
        }
    }
}
