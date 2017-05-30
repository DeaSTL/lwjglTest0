package engineTester;
import org.lwjgl.opengl.Display;

import renderEngine.*;

public class MainGame {

	public static void main(String[] args){
		DisplayManager.CreateDisplay();
		Display.setTitle("Title");
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		float[] vertices = {
			    -0.5f, 0.5f, 0f,
			    -0.5f, -0.5f, 0f,
			    0.5f, -0.5f, 0f,
			    0.5f, -0.5f, 0f,
			    0.5f, 0.5f, 0f,
			    -0.5f, 0.5f, 0f
			  };
		RawModel model = loader.loadToVao(vertices);
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			
			renderer.render(model);
			DisplayManager.updateDisplay();
			
		}
		loader.cleanUp();
		DisplayManager.CloseDisplay();
		
	}

}
