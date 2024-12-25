import abstractFactory.GUIAbstractFactory;
import abstractFactory.IButton;
import abstractFactory.ITextBox;
import abstractFactory.Ifactory;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter OS Type :");
        String osType = sc.nextLine();
        Ifactory iFactory = GUIAbstractFactory.createFactory(osType);
       IButton iButton =  iFactory.CreateButton();
       iButton.press();
        ITextBox iTextBox =  iFactory.CreateTextBox();
        iTextBox.showText();

    }
}