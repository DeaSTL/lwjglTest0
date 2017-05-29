package lwjglTest0;

import org.lwjgl.input.Keyboard;

public abstract class events {
	
	public void KeyDown(int key, String sym) {
	}
	public void KeyUp(int key, String sym) {
	}
	public void PollEvents(){
		while(Keyboard.next()){
			
			if(Keyboard.getEventKeyState()){
				KeyDown(Keyboard.getEventKey(),Keyboard.getKeyName(Keyboard.getEventKey()));
			}
			
			if(!Keyboard.getEventKeyState()){
				KeyUp(Keyboard.getEventKey(),Keyboard.getKeyName(Keyboard.getEventKey()));
			}
			
		}
	}
	
}
