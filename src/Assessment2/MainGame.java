package Assessment2;
import Assessment2.GameUserInterface;
public class MainGame {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameUserInterface ui = new GameUserInterface();
        });
    }
}
