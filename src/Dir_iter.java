import java.io.*;
class Dir_iter{
	public static void showFiles(File [] file)throws IOException{
		for(File f:file){
			if(f.isDirectory()){
				System.out.println("dir "+f.getCanonicalPath());
				
				showFiles(f.listFiles());
				
			}else{
				System.out.println("file "+f.getCanonicalPath());
			}
		}
	}
}
class Test{
	public static void main(String args[])throws IOException{
		Dir_iter i=new Dir_iter();
		File f=new File("D:/");
		File[] file=f.listFiles();
		Dir_iter.showFiles(file);
	}
}