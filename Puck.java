public class Puck extends Ball{

    private double xVelocity, yVelocity, friction;

    public Puck(double x, double y, double diameter, String col, int layer, double friction) {
        super(x, y, diameter, col, layer);

        this.friction = friction;
        
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



    public void movement(double leftBoundary, double rightBoundary, double topBoundary, double bottomBoundary, Mallet mallet1, Mallet mallet2) {
    
        this.move(xVelocity, yVelocity);
        xVelocity *= friction;
        yVelocity *= friction;
        if (this.getXPosition() - this.getSize()/2 < leftBoundary) {
            this.setXPosition(leftBoundary + (this.getSize()/2));
            this.xVelocity *= -1;
        }

        if (this.getXPosition() + this.getSize()/2 > rightBoundary) {
            this.setXPosition(rightBoundary - (this.getSize()/2));
            this.xVelocity *= -1;
        }

        if (this.getYPosition() - this.getSize()/2 < topBoundary) {
            this.setYPosition(topBoundary + (this.getSize()/2));
            this.yVelocity *= -1;
        }

        if (this.getYPosition() + this.getSize()/2 > bottomBoundary) {
            this.setYPosition(bottomBoundary - (this.getSize()/2));
            this.yVelocity *= -1;
        }   


        //when the puck overlaps with the mallet
        double xDistance = this.getXPosition() - mallet1.getXPosition();
        double yDistance = this.getYPosition() - mallet1.getYPosition();
        if (Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) - mallet1.getSize()/2 - this.getSize()/2 <= 0) {
            double[] norm = Collisions.normalizeVector(new double[]{xDistance, yDistance});
            double totalRadius = mallet1.getSize()/2 + this.getSize()/2;

            double totalVelocity = Math.sqrt(Math.pow(this.xVelocity,2) + Math.pow(this.yVelocity,2));
            this.xVelocity = totalVelocity * norm[0];
            this.yVelocity = totalVelocity * norm[1];

            norm[0] *= totalRadius;
            norm[1] *= totalRadius;
            this.setXPosition(mallet1.getXPosition() + norm[0]);
            this.setYPosition(mallet1.getYPosition() + norm[1]);
        }

        
        xDistance = this.getXPosition() - mallet2.getXPosition();
        yDistance = this.getYPosition() - mallet2.getYPosition();
        if (Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) - mallet2.getSize()/2 - this.getSize()/2 <= 0) {
            double[] norm = Collisions.normalizeVector(new double[]{xDistance, yDistance});
            double totalRadius = mallet2.getSize()/2 + this.getSize()/2;

            double totalVelocity = Math.sqrt(Math.pow(this.xVelocity,2) + Math.pow(this.yVelocity,2));
            this.xVelocity = totalVelocity * norm[0];
            this.yVelocity = totalVelocity * norm[1];

            norm[0] *= totalRadius;
            norm[1] *= totalRadius;
            this.setXPosition(mallet2.getXPosition() + norm[0]);
            this.setYPosition(mallet2.getYPosition() + norm[1]);
        }



    }
    
}