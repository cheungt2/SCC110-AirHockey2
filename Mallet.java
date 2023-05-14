import java.util.function.BooleanSupplier;

public class Mallet extends Ball {

    private double xVelocity, yVelocity, speed;

	public Mallet(double x, double y, double diameter, String col, int layer, double speed) {
        super(x, y, diameter, col, layer);
        
        this.speed = speed;
    }

    public void setVelocity(boolean up, boolean down, boolean left, boolean right) {
        int xDirection = 0;
        int yDirection = 0;

        if(up) 
            yDirection -= 1;
        if(down) 
            yDirection += 1;
        if(left) 
            xDirection -= 1;
        if(right) 
            xDirection += 1;

        if (xDirection == 0 && yDirection == 0) {
            xVelocity = 0;
            yVelocity = 0;
        }

        else if (xDirection == 0) {
            yVelocity = yDirection * speed;
        }
        else if(yDirection ==0) 
            xVelocity = xDirection * speed;
        else {
            xVelocity = (xDirection*speed)/1.4142;
            yVelocity = (yDirection*speed)/1.4142;
        }
    }

    public void movement() {
        
        this.move(xVelocity, yVelocity);
        if (this.getXPosition() - this.getSize()/2 <= 120)
            this.setXPosition(120 + (this.getSize()/2));

        if (this.getXPosition() + this.getSize()/2 >= 600)
            this.setXPosition(600 - (this.getSize()/2));

        if (this.getYPosition() - this.getSize()/2 <= 145)
            this.setYPosition(145 + (this.getSize()/2));

        if (this.getYPosition() + this.getSize()/2 >= 605)
            this.setYPosition(605 - (this.getSize()/2));
    }
}