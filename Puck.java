public class Puck extends Ball{

    private double xVelocity, yVelocity;

    public Puck(double x, double y, double diameter, String col, int layer) {
        super(x, y, diameter, col, layer);
        
    }

    public double getXVelocity(){
        return xVelocity;
    }

    public double getYVelocity(){
        return yVelocity;
    }

    public void setXVelocity(double XVelocity){
        this.xVelocity = XVelocity;
    }

    public void setYVelocity(double YVelocity){
        this.yVelocity = YVelocity;
    }

    public void movement(double leftBoundary, double rightBoundary, double topBoundary, double bottomBoundary) {
    
        this.move(xVelocity, yVelocity);
        if (this.getXPosition() - this.getSize()/2 < leftBoundary) {
            this.setXPosition(leftBoundary + (this.getSize()/2));
            this.xVelocity *= -1;
        }

        if (this.getXPosition() + this.getSize()/2 >= rightBoundary) {
            this.setXPosition(rightBoundary - (this.getSize()/2));
            this.xVelocity *= -1;
        }

        if (this.getYPosition() - this.getSize()/2 <= topBoundary) {
            this.setYPosition(topBoundary + (this.getSize()/2));
            this.yVelocity *= -1;
        }

        if (this.getYPosition() + this.getSize()/2 >= bottomBoundary) {
            this.setYPosition(bottomBoundary - (this.getSize()/2));
            this.yVelocity *= -1;
            }   

    }
    
}