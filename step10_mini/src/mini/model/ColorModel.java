package mini.model;

import java.util.ArrayList;

import mini.model.dto.Color;
import mini.model.dto.RGB;

public class ColorModel {
	
	private static ColorModel instance = new ColorModel();
	private ArrayList<Color> colorList = new ArrayList<Color>();

	public ColorModel() {
		
//		 String colorName, String hex,RGB rgb;
		colorList.add(new Color("red","#eb3434",new RGB(235,52,52)));
		colorList.add(new Color("dark red","#eb3124",new RGB(235,52,53)));
		colorList.add(new Color("green","#34eb37",new RGB(52,235,55)));
		colorList.add(new Color("blue","#3734eb",new RGB(55,52,235)));
		colorList.add(new Color("newColor","64C0CB",new RGB(55,52,100)));
		colorList.add(new Color("red complementary","64C0CB",new RGB(20,203,203)));
//		("pink","#FFC0CB",new RGB(255,192,203))
	}
	
	public static ColorModel getInstance() {
		return instance;
	}
	
	public ArrayList<Color> getColorList() {
		return colorList;
	}

	public void insertColor(Color newColor) {
		colorList.add(newColor);		
	}


//	public void insertColor(Color color) {
//		Color color = colorList.getColor()
//		colorList.add(color);	
//	}
	
}
