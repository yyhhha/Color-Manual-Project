package mini.view;

import java.util.Scanner;

import mini.controller.ColorController;
import mini.exception.NotExistingException;
import mini.model.dto.Color;
import mini.model.dto.RGB;

public class StartView {



	public static void main(String[] args) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(" 1.모든 색상 출력 \n "); 
		builder.append("2.색상 추가 하기 \n ");
		builder.append("3.Hex 명으로 색상데이터 찾기 \n ");
		builder.append("4.색상 명으로 색상데이터 찾기 \n ");
		builder.append("5.RGB 로 색상 찾기1 \n ");
		builder.append("6.RGB 로 색상 찾기2 \n ");
		builder.append("7.조회된 색상에서 RGB 변경된 새로운 색상 찾기 \n ");
		builder.append("8.제일 많이 검색된 색 \n ");
		builder.append("9.보색 찾기 \n ");
		builder.append("10.종료 \n ");
		builder.append("원하는 기능의 숫자를 입력하세요 \n ");
		
		
		ColorController controller = ColorController.getInstance();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("============= 컬러 라이브러리 ============");
		System.out.println("====== 0을 눌러서 기능을 확인해보세요 =======");
		boolean sessionEnd = false;
		while(!sessionEnd) {
						
			try {
				int num = sc.nextInt();
				
				if(num == 0) {
					System.out.println(builder.toString());
				} else if (num == 1) {
//					1. 모든 색상 출력
					System.out.println("------색상 데이터 보기-----");
					controller.getColorList();
					System.out.println("\n");
					
				} else if(num == 2) {
					
					sc.nextLine();
					
					System.out.println("------색상 추가하기-----");
					System.out.println("색상명을 입력하세요");
					String colorName = sc.nextLine();
	
					System.out.println("--------HEX 코드--------");
					System.out.println("헥스 번호를 입력하세요");
					String HEX = sc.nextLine();
					
					System.out.println("--------RGB R--------");
					System.out.println("RGB의 R을 입력하세요");
					int R = sc.nextInt();
					
					System.out.println("--------RGB G--------");
					System.out.println("RGB의 G을 입력하세요");
					int G = sc.nextInt();
					
					System.out.println("--------RGB B--------");
					System.out.println("RGB의 B을 입력하세요");
					int B = sc.nextInt();
					
					controller.insertColor(new Color(colorName, HEX, new RGB(R, G, B)));
						
					
				} else if(num == 3) {
					
					sc.nextLine();
					
					System.out.println("------Hex 명으로 색상데이터 찾기-----");
					System.out.println("헥스 번호를 입력하세요");
					
					String HEX = sc.nextLine();
					
					controller.searchByHex(HEX);
					
					
				} else if(num == 4) {
					
					sc.nextLine();
					
					System.out.println("------색상 명으로 색상데이터 찾기-----");
					System.out.println("색상명을 입력하세요");
					
					String colorName = sc.nextLine();
					controller.searchByName(colorName);
					
				} else if(num == 5) {
					
					sc.nextLine();
					
					System.out.println("------RGB 로 색상 찾기1-----");
					
					System.out.println("--------RGB R--------");
					System.out.println("RGB의 R를 입력하세요");
					
					int R = sc.nextInt();
					
					System.out.println("--------RGB R--------");
					System.out.println("RGB의 G를 입력하세요");
					
					int G = sc.nextInt();
					
					System.out.println("--------RGB R--------");
					System.out.println("RGB의 B를 입력하세요");
					
					int B = sc.nextInt();
					
					controller.searchByRGB(R, G, B);
					
				} else if(num == 6) {
					
					sc.nextLine();
					
					System.out.println("------RGB 로 색상 찾기2-----");
					System.out.println("R,G,B중 선택하여 입력하세요");
					
					String rgb = sc.nextLine();
					
					System.out.println("--------RGB " + rgb + "--------");
					System.out.println("RGB의 " + rgb + "를 입력하세요");
					
					int colorCode = sc.nextInt();
					
					controller.searchByRGB(rgb, colorCode);
					
				} else if(num == 7) {
					
					sc.nextLine();
					
					System.out.println("------조회된 색상에서 RGB 변경된 새로운 색상 찾기-----");		
					System.out.println("색상명을 입력하세요 ");
					
	        		String colorName = sc.nextLine();
	        		
	        		System.out.println("R,G,B중 선택하여 입력하세요");

	        		String rgb = sc.nextLine();
	        		
	        		System.out.println("RGB의 " + rgb + "를 입력하세요");
	        		
	        		int colorCode = sc.nextInt();
	        		
	        		
	        		Color color = controller.searchByName2(colorName);
	        		controller.searchEdit(color, rgb, colorCode);
					
				} else if(num == 8) {
					
	        		System.out.println("------제일 많이 검색된 색-----");
	        		try {
	        			controller.TodayColor();
	        		} catch (NotExistingException e) {
	        			e.printStackTrace();
	        		}finally {
	        			
	        		}
										
				} else if(num == 9) {
					
					sc.nextLine();
					
					System.out.println("-----색상명으로 보색 찾기-----");
					
					String colorName = sc.nextLine();
					
					controller.searchComplementaryColor(colorName);
					
				} else if(num == 10) {
					sc.close();
					sessionEnd = true;
					System.out.println("종로됩니다");
				} else {
					System.out.println("잘못 된 커맨드입니다");
				}
			} catch(Exception e) {
				System.out.println("잘못 된 커맨드입니다");
				sc.next();
			} finally {
				
			}
			
		}
		
		
//		System.out.println("------색상 데이터 보기-----");
//		
//		controller.getColorList();
//		System.out.println("\n");
//		
//		
//					
//		System.out.println("------색상 추가하기-----");
//		
//		Color pink = new Color("pink","#FFC0CB",new RGB(255,192,203));
//		controller.insertColor(pink);
//		controller.getColorList();
//		controller.insertColor(pink);
//		System.out.println("\n");
//		
//		
//		
//		System.out.println("------Hex 명으로 색상데이터 찾기-----");
//		
//		controller.searchByHex("#34eb37");
//		System.out.println("\n");
//			
//		
//		
//		System.out.println("------색상 명으로 색상데이터 찾기-----");
//		
//		controller.searchByName("red");
//		controller.searchByName("violet");
//		System.out.println("\n");
//				
//		
//		
//		System.out.println("------RGB 로 색상 찾기1-----");
//		
//		controller.searchByRGB(255,192,203);
//		controller.searchByRGB(255,255,203);
//		System.out.println("\n");
//		
//		
//		
//		System.out.println("------RGB 로 색상 찾기2-----");
//		
//		controller.searchByRGB("R", 255);
//		controller.searchByRGB("G", 192);
//		controller.searchByRGB("B", 200);
//		System.out.println("\n");
//				
//		
//		
//		System.out.println("------조회된 색상에서 RGB 변경된 새로운 색상 찾기-----");
//		
//		controller.searchEdit(pink, "R", 100);
//		System.out.println("\n");
//		
//		System.out.println("------제일 많이 검색된 색-----");
//		
//		try {
//			controller.TodayColor();
//		} catch (NotExistingException e) {
//			EndView.errView(e.getMessage());
//		}
	}

}
