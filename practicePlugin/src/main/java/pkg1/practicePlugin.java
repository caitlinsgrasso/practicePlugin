package pkg1;

import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.ImageStack;
import ij.gui.*;
import ij.plugin.filter.*;
import ij.process.*;
import java.awt.*;
import ij.Executer;
import ij.io.*;

public class practicePlugin implements PlugInFilter {

	protected ImagePlus imp; 
	protected ImageStack stack;
	protected ImageStack stack2;
	protected ImageStack stack3;
	protected ImageProcessor ip;
	protected ImageProcessor slice;
	
	private int height;
	private int width;
	private int numSlices;
	
	public int setup(String arg, ImagePlus imp) {
		if (arg == "about"){
			showAbout();
			return DONE;
		}
		imp = this.imp;
		ip = imp.getProcessor(); 
		stack = imp.getStack();
		return DOES_ALL + STACK_REQUIRED;
	}

	public void run(ImageProcessor ip) {
		height = stack.getHeight();
		width = stack.getWidth();
		stack2 = new ImageStack(width, height);
		
		stack3 = stack.duplicate();
		
		numSlices = stack.size();
		
		for(int i=1; i<=numSlices; i++){
			slice = stack2.getProcessor(i);
		}
		
	}
	
	public void showAbout(){
		IJ.showMessage("About plugin.....", "This plugin automatically segments a stack of images with minial human interaction using thresholding techniques and active contours.");;
	}

}
