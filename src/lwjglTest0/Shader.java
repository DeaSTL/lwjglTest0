package lwjglTest0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static org.lwjgl.opengl.GL20.*;

public class Shader {
	private int program;
	private int vs;
	private int fs;
	
	
	public Shader(String filename){
		program = glCreateProgram();
		
		vs = glCreateShader(GL_VERTEX_SHADER);
		glShaderSource(vs, readFile(filename+".vs"));
		glCompileShader(vs);
		if(glGetShaderi(vs, GL_COMPILE_STATUS) != 1){
			
			System.err.println(glGetShaderInfoLog(vs,0));
			System.exit(1);
		}
		fs = glCreateShader(GL_FRAGMENT_SHADER);
		glShaderSource(fs, readFile(filename+".fs"));
		glCompileShader(fs);
		if(glGetShaderi(fs, GL_COMPILE_STATUS) != 1){
			
			System.err.println(glGetShaderInfoLog(fs,0));
			System.exit(1);
		}
		
		glAttachShader(program,vs);
		glAttachShader(program,fs);
		
		glBindAttribLocation(program, 0, "verts");
		
		glLinkProgram(program);
		
		if(glGetProgrami(program,GL_LINK_STATUS) != 1){
			System.err.println(glGetProgramInfoLog(program,0));
			System.exit(1);
			
		}
		glValidateProgram(program);
		
		if(glGetProgrami(program,GL_VALIDATE_STATUS) != 1){
			System.err.println(glGetProgramInfoLog(program,0));
			System.exit(1);
			
		}

	}
	
	public void bind(){
		
		glUseProgram(program);
	}
	private String readFile(String filename){
		StringBuilder string = new StringBuilder();
		BufferedReader br;
		
		try{
			br = new BufferedReader(new FileReader(new File("./shaders/"+filename)));
			String line;
			while((line = br.readLine()) != null){
				string.append(line);
				string.append("\n");
				
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return string.toString();

	}
}
