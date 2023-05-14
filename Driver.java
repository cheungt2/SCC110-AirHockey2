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

        Line firstLine = new Line(125, 300, 125, 450, 10, "GREY", 2);
        newGameArena.addLine(firstLine);
        Line secondLine = new Line(1075, 300, 1075, 450, 10, "GREY", 2);
        newGameArena.addLine(secondLine);

        // Ball mallet1 = new Ball(325, 375, 60, "BLUE", 5);
        // newGameArena.addBall(mallet1);
        // Ball mallet2 = new Ball(875, 375, 60, "BLUE", 5);
        // newGameArena.addBall(mallet2);
        // Ball puck = new Ball(600, 375, 25, "BLACK", 5);
        // newGameArena.addBall(puck);

        Mallet mallet1 = new Mallet(325, 375, 60, "BLUE", 5, 5);
        newGameArena.addBall(mallet1);

        Mallet mallet2 = new Mallet(875, 375, 60, "BLUE", 5, 5);
        newGameArena.addBall(mallet2);

        Puck puck = new Puck(600, 375, 25, "BLACK", 5);
        newGameArena.addBall(puck);

        while(true) {
            newGameArena.pause();
            mallet1.setVelocity(newGameArena.upPressed(), newGameArena.downPressed(), newGameArena.leftPressed(), newGameArena.rightPressed());
            mallet1.movement(120, 600, 145, 605);

            mallet2.setVelocity(newGameArena.up2Pressed(), newGameArena.down2Pressed(), newGameArena.left2Pressed(), newGameArena.right2Pressed());
            mallet2.movement(600, 1080, 145, 605);
            // System.out.println(newGameArena.upPressed() + " " + newGameArena.downPressed() + " " + newGameArena.leftPressed() + " " + newGameArena.rightMousePressed());
        }
        
    }
}
