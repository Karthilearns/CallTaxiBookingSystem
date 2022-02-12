import javax.annotation.processing.SupportedSourceVersion;
import java.util.*;

public class Main
{
    static ArrayList<Taxi> allTaxi = new ArrayList<Taxi>(4);
    static ArrayList<Taxi> availableTaxi;
    static  int bookingno=0;
    static Hashtable<Taxi,List<Booked>> allBookings = new Hashtable<>();
    public static void main(String args[]) {
        allTaxi.add(new Taxi("taxi1", 0, 'A', 0));
        allTaxi.add(new Taxi("taxi2", 0, 'A', 0));
        allTaxi.add(new Taxi("taxi3", 0, 'A', 0));
        allTaxi.add(new Taxi("taxi4", 0, 'A', 0));

        Scanner scans = new Scanner(System.in);
        int choice = 1;

        while (choice == 1) {
            System.out.println("ENTER 1 FOR CREATING A BOOKING");
            choice = scans.nextInt();
            if(choice==2)
            {
                printAllBooking();
            }
            System.out.println("ENTER CUSTOMER ID");
            int customerId = scans.nextInt();
            System.out.println("ENTER PICKUP TIME");
            int pickuptime = scans.nextInt();
            System.out.println("ENTER PICKUP POINT");
            char pickUpPoint = scans.next().charAt(0);
            System.out.println("ENTER DROP POINT");
            char dropPoint = scans.next().charAt(0);

            Booking booking = new Booking(customerId, pickUpPoint, dropPoint, pickuptime);
            Taxi taxi = findAvailable(allTaxi, booking);
            if (taxi == null) {
                System.out.println("No taxi can be Allocated");
            } else {
                System.out.println("Taxi can be Allocated ");
                System.out.println(taxi.getTaxiId() + " is allocated");
            }

            createBooking(taxi, booking);

        }
    }

    private static void printAllBooking()
    {
        for(Map.Entry<Taxi,List<Booked>> e: allBookings.entrySet())
        {
            System.out.print("Taxi id : "+e.getKey().getTaxiId()+"  ");
            System.out.println("TOTAL EARNING : "+getTotalAmount(e.getKey()));
            for(Booked b:e.getValue())
            {
                System.out.println(b.getBookingId()+" "+b.getCustomerId()+" "+b.getFrom()+" "+b.getTo()+" "+b.getPickUpTime()+" "+b.getDropTime()+" "+b.getAmount());
            }
            System.out.println();
        }
    }

    private static int getTotalAmount(Taxi key)
    {
        int finalamt =0;
        List<Booked> topCheckAmount = allBookings.get(key);
        for(Booked b:topCheckAmount)
        {
            finalamt+=b.getAmount();
        }
        return finalamt;
    }


    public  static void createBooking(Taxi taxi,Booking booking)
    {
        Booked booked = new Booked(++bookingno,booking.getCustomerId(),booking.getPickupPoint(),booking.getDropPoint(), booking.getPickUpTime()
                , booking.getPickUpTime()+Math.abs(booking.getPickupPoint()-booking.getDropPoint()),generatAmount(booking.getPickupPoint(),booking.getDropPoint()));

       if(allBookings.contains(taxi))
       {
           List<Booked> currBooked = allBookings.get(taxi);
           currBooked.add(booked);
           allBookings.put(taxi,currBooked);
       }
       else
       {
           List<Booked>  newBook= new ArrayList<>();
           newBook.add(booked);
           allBookings.put(taxi,newBook);
       }
       updateAllTaxis(booked,taxi);
    }

    private static void updateAllTaxis(Booked booked,Taxi taxi)
    {
        Taxi toBeUpdated = null;
        int index=0;
        for(Taxi t:allTaxi)
        {
            if(t.getTaxiId().equals(taxi.getTaxiId()))
            {
                index++;
                toBeUpdated = t;
               break;
            }
        }

        allTaxi.remove(toBeUpdated);

        Taxi updated = new Taxi(taxi.taxiId,booked.getDropTime(),
                booked.getTo(),booked.getAmount()+taxi.getEarnings());
        allTaxi.add(index,updated);
    }


    private static int generatAmount(Character pickupPoint, Character dropPoint)
    {
        int totalKm = Math.abs(pickupPoint-dropPoint)*15;
        int firstPointCharge = 200;
        int restPointCharge = 150;
        if(totalKm==15)
        {
            return firstPointCharge;
        }
        else
        {
            return firstPointCharge+((Math.abs(pickupPoint-dropPoint)-1)*restPointCharge);
        }

    }

    public static Taxi findAvailable(ArrayList<Taxi> allTaxi,Booking booking)
    {
        availableTaxi = new ArrayList<>();

        for(Taxi t:allTaxi)
        {
            if(t.getDrop_time()<=booking.getPickUpTime())
            {
                availableTaxi.add(t);
              //  System.out.println(t.toString());
            }

        }
        if(availableTaxi.size()==0)
        {
            return null;
        }
         return findNearest(availableTaxi,booking);
    }
    public static Taxi findNearest(ArrayList<Taxi> availableTaxi, Booking booking)
    {
        int nearest =Integer.MAX_VALUE;
        Character nearestPoint = null;
        for(Taxi t:availableTaxi)
        {
            if((Math.abs(t.getPosition()-booking.getPickupPoint()))<nearest)
            {
                nearest = Math.abs(t.getPosition()-booking.getPickupPoint());
                nearestPoint = t.getPosition();

            }
        }
     //   System.out.println(nearestPoint);
        return finalizeTaxi(availableTaxi,nearestPoint);
    }
    public static Taxi finalizeTaxi(List<Taxi> availableTaxi,Character nearestPoint)
    {
        int count=0;
        for(Taxi t:availableTaxi)
        {
            if(t.getPosition()==nearestPoint)
            {
                count++;
            }
        }
      //  System.out.println(count);
        ArrayList<Taxi> nearestTaxi = new ArrayList<>();
        if(count==1)
        {
           for(Taxi t:availableTaxi)
           {
               if(t.getPosition()==nearestPoint)
               {
                   return t;
               }
           }
        }

        else{
            for(Taxi t:availableTaxi)
            {
                if(t.getPosition()==nearestPoint)
                {
                    nearestTaxi.add(t);

                }
            }
           return findLowestEarning(nearestTaxi);
        }
        return null;
    }

    private static  Taxi findLowestEarning(ArrayList<Taxi> nearestTaxi)
    {
        int minEarn = Integer.MAX_VALUE;
        Taxi finalTaxi =null;
        for(Taxi t:nearestTaxi)
        {
            if(t.getEarnings()<minEarn)
            {
                minEarn = t.getEarnings();
                finalTaxi= t;
            }
        }
        return finalTaxi;
    }
}
