public class E15021Ball{
	public static void main(String[] args) {
		Ball b1 = new Ball(0.0,1.0,10.0,45.0);  //creating the 1st Ball object

		Ball.updateTime(5); //update globale time

		Ball b2= new Ball(0.0,1.0,20.0,45.0);
		Ball.updateTime(5);

		if (b1.willCollide(b2)){
			System.out.println("B1 and B2 will colide");
		} else {
			System.out.println("B1 and B2 won't colide");
		}
		
		Ball b3 = new Ball(-10,5,3,30);
		Ball.updateTime(20);

		if (b2.willCollide(b3)){
			System.out.println("B2 and B3 will colide");
		} else {
			System.out.println("B2 and B3 won't colide");
		}
	}
}


class Ball{
	/*  	ABOUT ACCESS MODIFIERS    
	    *most of the variables' access modifires set to private since there is no need to
		 use this variable from another class 
		*methods' access modifires set to nothing since, this methods only have to use from
		 another class in the same package only. 
	*/

	//some variables for save the object's current status
	private double xCord;  //x-cordinate
	private double yCord;  //y-cordinate
	private double speed;
	private double angleOfSpeedWithX;
	private double time;

	//this static variable global Time is common for all objects
	private static double  globalTime;

	//class constructor
	Ball(double x, double y, double speed, double angleOfSpeedWithX){
		this.xCord=x;
		this.yCord=y;
		this.speed=speed;
		this.angleOfSpeedWithX=angleOfSpeedWithX;
		this.time=globalTime;
	}
 	
 	//a method to update the global time
	static void updateTime(double time){
		 globalTime+=time;
	}

	//a method to change the cordinates of the ball according to the time
	public void updatePosition(){
		double movedDistance= this.speed*(globalTime-time);

		//new cordinates of the object
		this.xCord+=movedDistance*Math.cos(Math.toRadians(angleOfSpeedWithX));
		this.yCord+=movedDistance*Math.cos(Math.toRadians(angleOfSpeedWithX));

		this.time=globalTime;  /*since we changed the cordinates of ball, we have to change the
		                         object time for correct future calculations*/
	}

	//a method to check whether the balls will collide each other
	boolean willCollide(Ball testBall){
		//updating the position of the balls according to the globale time
		this.updatePosition();
		testBall.updatePosition();

		if (this.xCord==testBall.xCord && this.yCord==testBall.yCord){
			return true;
		} 
		return false;
	}
}
