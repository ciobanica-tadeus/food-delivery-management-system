import PresentationLayer.Controller;
import PresentationLayer.Welcome;

public class Main {
    public static void main(String[] args) {
        Welcome welcome = new Welcome();
        Controller controller = new Controller(welcome);
    }
}
