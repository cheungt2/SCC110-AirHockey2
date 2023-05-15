import java.util.WeakHashMap;

public class Driver {
    public static void main(String args[]) {
        GameArena newGameArena = new GameArena(1200, 700, true);
        Rectangle blueRectangle = new Rectangle(100, 125, 1000, 500, "BLUE", 1);
        Rectangle whiteRectangle = new Rectangle(120, 145, 960, 460, "WHITE", 2);

        newGameArena.addRectangle(blueRectangle);
        newGameArena.addRectangle(whiteRectangle);

        Line middleLine = new Line(600, 145, 600, 605, 5, "BLUE", 3);
        newGameArena.addLine(middleLine);

        Ball blueBall = new Ball(600, 375, 100, "BLUE", 4);
        newGameArena.addBall(blueBall);
        Ball whiteBall = new Ball(600, 375, 90, "WHITE", 5);
        newGameArena.addBall(whiteBall);

        //Left goalPost
        Line firstLine = new Line(125, 300, 125, 450, 10, "GREY", 2);
        newGameArena.addLine(firstLine);
        //Right goalPost
        Line secondLine = new Line(1075, 300, 1075, 450, 10, "GREY", 2);
        newGameArena.addLine(secondLine);


        Mallet mallet1 = new Mallet(325, 375, 60, "BLUE", 5, 10);
        newGameArena.addBall(mallet1);

        Mallet mallet2 = new Mallet(875, 375, 60, "BLUE", 5, 10);
        newGameArena.addBall(mallet2);

        Puck puck = new Puck(600, 375, 25, "BLACK", 5, 0.993);
        newGameArena.addBall(puck);

        int P1Score = 0;
        int P2Score = 0;

        Text p1Text = new Text("0", 50, 50, 375, "WHITE");
        Text p2Text = new Text("0", 50, 1150, 375, "WHITE");
        newGameArena.addText(p1Text);
        newGameArena.addText(p2Text);



        while(true) {
            newGameArena.pause();
            mallet1.setVelocity(newGameArena.upPressed(), newGameArena.downPressed(), newGameArena.leftPressed(), newGameArena.rightPressed());
            mallet1.movement(120, 600, 145, 605);

            mallet2.setVelocity(newGameArena.up2Pressed(), newGameArena.down2Pressed(), newGameArena.left2Pressed(), newGameArena.right2Pressed());
            mallet2.movement(600, 1080, 145, 605);
            // System.out.println(newGameArena.upPressed() + " " + newGameArena.downPressed() + " " + newGameArena.leftPressed() + " " + newGameArena.rightMousePressed());
            
            //collision with mallet1
            double xDistance = mallet1.getXPosition() - puck.getXPosition();
            double yDistance = mallet1.getYPosition()- puck.getYPosition();
            if (Math.sqrt( Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) - mallet1.getSize()/2 -puck.getSize()/2 <= 0) {
                double[] collision1 = Collisions.deflect(mallet1.getXPosition(), mallet1.getYPosition(), mallet1.getXVelocity(), mallet1.getYVelocity(), puck.getXPosition(), puck.getYPosition(), puck.getXVelocity(), puck.getYVelocity());
                puck.setXVelocity(collision1[2]);
                puck.setYVelocity(collision1[3]);
            }

            //collision with mallet2
            xDistance = mallet2.getXPosition() - puck.getXPosition();
            yDistance = mallet2.getYPosition()- puck.getYPosition();
            if (Math.sqrt( Math.pow(xDistance, 2) + Math.pow(yDistance, 2)) - mallet2.getSize()/2 -puck.getSize()/2 <= 0) {
                double[] collision2 = Collisions.deflect(mallet2.getXPosition(), mallet2.getYPosition(), mallet2.getXVelocity(), mallet2.getYVelocity(), puck.getXPosition(), puck.getYPosition(), puck.getXVelocity(), puck.getYVelocity());
                puck.setXVelocity(collision2[2]);
                puck.setYVelocity(collision2[3]);
            }

            
            puck.movement(120, 1080, 145, 605);
        
            if(puck.getXPosition() - puck.getSize()/2 <= 125 && (puck.getYPosition() >= 300) && (puck.getYPosition() <= 450)) {
                P2Score += 1;
                puck.setXPosition(600);
                puck.setYPosition(375);
                puck.setXVelocity(0);
                puck.setYVelocity(0);

                mallet1.setXPosition(325);
                mallet1.setYPosition(375);
                mallet2.setXPosition(875);
                mallet2.setYPosition(375);

                p2Text.setText("" + P2Score);

            }

            if(puck.getXPosition() + puck.getSize()/2 >= 1075 && (puck.getYPosition() >= 300) && (puck.getYPosition() <= 450)) {
                P1Score += 1;
                puck.setXPosition(600);
                puck.setYPosition(375);
                puck.setXVelocity(0);
                puck.setYVelocity(0);

                mallet1.setXPosition(325);
                mallet1.setYPosition(375);
                mallet2.setXPosition(875);
                mallet2.setYPosition(375);

                p1Text.setText("" + P1Score);

            }

        }



    }
}
