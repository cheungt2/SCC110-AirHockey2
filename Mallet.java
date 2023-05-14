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

    public void movement(double leftBoundary, double rightBoundary, double topBoundary, double bottomBoundary) {
        
        this.move(xVelocity, yVelocity);
        if (this.getXPosition() - this.getSize()/2 <= leftBoundary)
            this.setXPosition(leftBoundary + (this.getSize()/2));

        if (this.getXPosition() + this.getSize()/2 >= rightBoundary)
            this.setXPosition(rightBoundary - (this.getSize()/2));

        if (this.getYPosition() - this.getSize()/2 <= topBoundary)
            this.setYPosition(topBoundary + (this.getSize()/2));

        if (this.getYPosition() + this.getSize()/2 >= bottomBoundary)
            this.setYPosition(bottomBoundary - (this.getSize()/2));
    }
}