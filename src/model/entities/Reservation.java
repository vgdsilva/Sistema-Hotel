package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ReserExcepition;

public class Reservation {
 
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
    	if(checkOut.before(checkIn)) {
       		throw new ReserExcepition("Check-out date must be after check-in date ");
       }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

   public Date getCheckOut() {
        return checkOut;
    }

   public long duration(){
       long deff = checkOut.getTime() - checkIn.getTime();
       return TimeUnit.DAYS.convert(deff, TimeUnit.MILLISECONDS);
   }
    
   public void updateDate(Date checkIn, Date checkOut){
       
	   Date now = new Date();
       if (checkIn.after(now) || checkOut.before(now)) {
       		throw new ReserExcepition("Reservation dates for update must be future dates ");
       	
       }
	   this.checkIn = checkIn;
       this.checkOut = checkOut;
       
      
   }
    
   @Override
   public String toString(){
       return "Room"
             + roomNumber
             + ", check In: "
             + sdf.format(checkIn)
             + ", check Out: "
             + sdf.format(checkOut)  
             + ", "
             + duration()
             + " nights";
   }
   
   
   
   
}

























/*
Reservation reservation = new Reservation(number, checkIn, checkOut);
        	System.out.println("Reservation " + reservation);
        
			
*/