package mini.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;

import mini.model.dto.Color;
import mini.model.dto.RGB;
import mini.service.ColorService;
import mini.exception.DuplicateException;
import mini.exception.NotExistingException;
import mini.view.EndView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ColorController {
	
	private static ColorController instance = new ColorController();
	private ColorService colorService = ColorService.getInstance();

	public static ColorController getInstance() {
		return instance;
	}

//	getColorList()
	public void getColorList() {
		ArrayList<Color> colorList = colorService.getColorList();
				
		if(colorList.size() != 0) {
			EndView.colorListView(colorList);
		}else {
			System.out.println("XX");
		}
	}
	
//	insertColor()
	public void insertColor(Color newColor) {
		
		try {
			colorService.insertColor(newColor);
			System.out.println(newColor.getColorName() + " 가 색상라이브러리에 추가되었습니다");
		} catch (DuplicateException e) {
			EndView.errView(e.getMessage());
		}
		
	}
	
//	searchByName()
	public void searchByName(String colorName) {
		
		try {
			EndView.colorListView(colorService.searchByName(colorName));
		} catch (NotExistingException e) {
			EndView.errView(e.getMessage());
		}
		
	}
	
//	searchByName2()
	public Color searchByName2(String colorName) {
	return colorService.searchByName2(colorName);	
	}
	
//	searchByHex()
	public void searchByHex(String hex) {
		Color color = colorService.searchByHex(hex);
		
		if(color != null) {
			EndView.colorView(color);
		} else {
			EndView.errView("요청하신 색상이 없습니다");
		}
	}


	public void searchByRGB(int R, int G, int B) {
		Boolean range = R >= 0 && R <= 255 && G >= 0 && G <= 255 && B >= 0 && B <= 255;
		
		if(range) {
			try {	
				EndView.colorView(colorService.searchByRGB(R,G,B));
			} catch (NotExistingException e) {
				EndView.errView(e.getMessage());
			}
		} else {
			EndView.errView("Color code out of range");
		}
		
	}
	
	public void searchByRGB(String colorPallete, int rgb) {
		Boolean range = rgb >= 0 && rgb <= 255;
		ArrayList<Color> filtered;
		
		if(range) {			
			try {
				filtered = colorService.searchByRGB(colorPallete, rgb);
				EndView.colorListView(filtered);		
			} catch (NullPointerException e) {
				EndView.errView("데이터가 존재하지 않습니다");			
			}
		} else {
			EndView.errView("Color code out of range");
		}
		
	}


	public void searchEdit(Color color, String colorPallete, int rgb) {
		Boolean range = rgb >= 0 && rgb <= 255;
		
		if(range) {			
			if(colorPallete.equals("R")) {
				searchByRGB(rgb, color.getRgb().getGreen(), color.getRgb().getBlue());
			} else if(colorPallete.equals("G")) {
				searchByRGB(color.getRgb().getRed(), rgb, color.getRgb().getBlue());	
			} else if(colorPallete.equals("B")) {
				searchByRGB(color.getRgb().getRed(), color.getRgb().getGreen(), rgb);			
			} else {
				EndView.errView("요청하신 색상이 없습니다");
			}
		} else {
			EndView.errView("Color code out of range");
		}
		
	}

	public void TodayColor() throws NotExistingException {
		BufferedReader in =null;
		
		try {
			in = new BufferedReader(new FileReader("C:\\20210628_lab\\88.log\\searchColor.log"));
			String data = null;
			ArrayList<String> rank = new ArrayList<>();
			while( (data = in.readLine()) != null ) {
//				System.out.println(data);
				rank.add(data);
			}
			
			Set<String> set = new HashSet<String>(rank);
			HashMap<String ,Integer> hm = new HashMap<>();
			for(String str : set) {
//				System.out.println((str + " : " + Collections.frequency(rank, str)));
				hm.put(str,Collections.frequency(rank, str));
			}
			Entry<String, Integer> maxEntry = null;
			
			Set<Entry<String, Integer>> entrySet = hm.entrySet();
			for (Entry<String, Integer> entry : entrySet) {
				if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
			System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue());

		} catch (Exception e) {
//			System.out.println("파일 내용이 존재하지 않습니다.");
//			e.printStackTrace();
//			FailView.MsgView(e.printStackTrace());
			throw new NotExistingException( );
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void searchComplementaryColor(String colorName) {
		Color color = colorService.searchByName2(colorName);
		
		RGB rgb = (RGB) colorService.searchComplementaryColor(color.getRgb().getRed(), color.getRgb().getGreen(), color.getRgb().getBlue());
			EndView.RGBView(rgb);	
		try {
			Color cmplColor = colorService.searchByRGB(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
			EndView.cmplColorView(colorName, cmplColor);
		} catch (NotExistingException e) {
			EndView.errView(e.getMessage());
		}

	}
	

}
