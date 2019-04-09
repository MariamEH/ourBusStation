package application;

public class TableType {
   StationController station = new StationController();
   String val ;
   public String type() {
	   if(station.checkPassenger())
		   val="SELECT * FROM riders";
	   if(station.checkDriver())
		   val="SELECT * FROM drivers";
	   if(station.checkManager())
		   val="SELECT * FROM managers";
	   return val ;
	   
   }
}

