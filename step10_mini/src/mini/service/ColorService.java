package mini.service;

import java.util.ArrayList;

import mini.exception.DuplicateException;
import mini.exception.NotExistingException;
import mini.model.ColorModel;
import mini.model.dto.Color;
import mini.model.dto.RGB;
import mini.view.EndView;
import org.apache.log4j.Logger;

public class ColorService {
	static Logger logger = Logger.getLogger("mini.view.ColorService");
	
	private static ColorService instance = new ColorService();
	private ColorModel ColorModelData = ColorModel.getInstance();

	public static ColorService getInstance() {
		return instance;
	}

	public ArrayList<Color> getColorList() {
		return ColorModelData.getColorList();
	}

	public ArrayList<Color> searchByName(String colorName) throws NotExistingException {
		ArrayList<Color> filtered = new ArrayList<Color>();
		
		ArrayList<Color> colorList = ColorModelData.getColorList();
		for(Color color : colorList) {
			if(color.getColorName().contains(colorName)) {
				logger.info(color.getColorName());
				filtered.add(color);
			}	
		}
		if(!(filtered.isEmpty())){
			return filtered;
		} else {
			throw new NotExistingException();
		}
	}
	
	public  Color searchByName2(String colorName) {
		ArrayList<Color> colorList = ColorModelData.getColorList();
		for(Color color : colorList) {
			if(colorName.equals(color.getColorName())) {
				logger.info(color.getColorName());
				return color;
			}	
		}
		return null;
	}
	
	public Color searchByHex(String hex) {
		
		ArrayList<Color> colorList = ColorModelData.getColorList();
		for(Color color : colorList) {
			if(hex.equals(color.getHex())) {
				logger.info(color.getColorName());
				return color;
			}	
		}
		return null;
	}

	public void insertColor(Color newColor) throws DuplicateException {
		Color color = searchByHex(newColor.getHex());
		
		if(color != null) {
			throw new DuplicateException();
		}
		ColorModelData.insertColor(newColor);
		
	}
	
	public Color searchByRGB(int R, int G, int B) throws NotExistingException {
		ArrayList<Color> colorList = ColorModelData.getColorList();
		Color color = null;
		
		for(Color clr : colorList) {
			if(clr.getRgb().getRed() == R && clr.getRgb().getGreen() == G && clr.getRgb().getBlue() == B) {
//				logger.info(clr.getColorName());
				color = clr;
			}
		}
		if(color != null) {
			return color;
		} else {
			throw new NotExistingException();
		}
	}

	public ArrayList<Color> searchByRGB(String colorPallete, int rgb) {
		ArrayList<Color> colorList = ColorModelData.getColorList();
		ArrayList<Color> filtered = new ArrayList<Color>();
		
		if(colorPallete.equals("R")) {
			for(Color color : colorList) {
				if(color.getRgb().getRed() == rgb) {
					filtered.add(color);
				}
			}
		} else if(colorPallete.equals("G")) {
			for(Color color : colorList) {
				if(color.getRgb().getGreen() == rgb) {
					filtered.add(color);
				}
			}
		} else if(colorPallete.equals("B")) {
			for(Color color : colorList) {
				if(color.getRgb().getBlue() == rgb) {
					filtered.add(color);
				}
			}
		}
		
		if(!(filtered.isEmpty())){
			return filtered;
		} else {
			return null;
		}
			
	}

	public RGB searchComplementaryColor(int R, int G, int B) {
		ArrayList<Color> colorList = ColorModelData.getColorList();
		int max = 255;
		int r = 0;
		int g = 0;
		int b = 0;

		for(Color color : colorList) {
			if(color.getRgb().getRed() == R) {
				r = max - R;
		}if(color.getRgb().getGreen() == G) {
				g = max - G;
			}if(color.getRgb().getBlue() == B) {
				b = max - B;
			}
		}
		RGB rgb = new RGB(r, g, b);
		return rgb;

	}

	
}
