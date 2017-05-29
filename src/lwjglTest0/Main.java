package lwjglTest0;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;



public class Main extends events{
	public int width = 500;
	public int height = 500;
	
	private float AngleX = 0;
	private float AngleY = 0;
	private float AngleZ = 0;
	
	private float PositionX = 0;
	private float PositionY = 0;
	private float PositionZ = 0;
	
	
	public void InitRender(){
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, 0, height, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
	}
	public void start(){
		try {
			Display.setDisplayMode(new DisplayMode(width,height));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitRender();
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		while(!Display.isCloseRequested()){
	
			PollEvents();
			Render();
			
			Display.update();
			
		}
		
		Display.destroy();
		Display.sync(60);
		
	}

	
	
	public void PreRender(){
		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
		         
		// set the color of the quad (R,G,B,A)
		GL11.glColor3f(0.5f,0.5f,1.0f);
		GL11.glPushMatrix();
		
		
	}
	public void Render(){
		PreRender();
		
	}
	
	public void KeyDown(int key,String sym){
		if(key == Keyboard.KEY_A){
			AngleZ += 1.0f;
			System.out.println(AngleZ);
		}
		System.out.println(sym);
		
	}
	

	
	public static void main(String[] args){
		
		Main display = new Main();
		display.start();
		
	}
	
}
