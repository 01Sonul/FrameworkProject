package Sikuli;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class HandlingNotepad {

	public static void main(String[] args) throws Throwable{
		
		Screen screen = new Screen();
		
//		Pattern miniBar = new Pattern("");
//		screen.click(miniBar);
		
		Pattern searchBar = new Pattern("C:\\Users\\HP\\Pictures\\Screenshots\\searchBarImg.png");
		screen.click(searchBar);
		screen.type ("Excel");
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_ENTER);
//		r.keyRelease(KeyEvent.VK_ENTER);
		

	}

}
