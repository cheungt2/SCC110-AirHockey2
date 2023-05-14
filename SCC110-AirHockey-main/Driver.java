public class Driver {
    public static void main(String args[]) {
        GameArena newGameArena = new GameArena(1200, 600, true);
        Rectangle newRectangle = new Rectangle(100, 500, 500, 200, BLUE, 0);
        newGameArena.addRectangle(newRectangle);
        
    }
}