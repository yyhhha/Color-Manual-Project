package mini.view;

import mini.model.dto.Color;
import mini.model.dto.RGB;

import java.util.ArrayList;

public class EndView {

	public static void colorListView(ArrayList<Color> colorList) {
		for(Color color : colorList) {		
			System.out.println(color.toString());		
		}
	}
	
	public static void colorView(Color color) {
		System.out.println(color.toString());		
	}
	
	public static void RGBView(RGB rgb) {
		System.out.println(rgb.toString());				
	}

	public static void errView(String message) {
		System.out.println("에러 : " + message);
	}

	public static void cmplColorView(String colorName, Color cmplColor) {
		System.out.println("데이터에 " + colorName + " 의 보색이 존재합니다");		
		System.out.println(cmplColor.toString());		
	}

}
