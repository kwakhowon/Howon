package kr.or.bit3.function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import kr.or.bit3.auth.NUser;

public class DataBaseExcel {
	
	// ----------------- 회원목록 데이터 베이스화 ---------------
	
	public static void dataBase_ExcelCreate(String excelName) { // 엑셀(책 데이터베이스) 파일 생성
		File fileDir = new File("./DataBase");
		if (!fileDir.exists()) {
			fileDir.mkdir();
		}
		File fileFolder = new File("./DataBase/"+ excelName+ ".xls");
		if (!fileFolder.exists()) {
			dataDase_ExcelFile(excelName);
		}
	}
	
	public static void dataDase_ExcelFile(String excelName) {
		try {
			// . xls 로 생성시
			HSSFWorkbook writeBook = new HSSFWorkbook(); // 새 엑셀파일 만들기 위한 객체 생성
			HSSFSheet mySheet = writeBook.createSheet(excelName); // 새 시트 만들기
			FileOutputStream fos = new FileOutputStream("./DataBase/"+excelName+".xls"); // 엑셀파일을 생성함.
			writeBook.write(fos);
			dataBase_Write(excelName);
			fos.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void dataBase_Write(String excelName) { //회원 정보만...
		String path = "./DataBase/"+ excelName +".xls";
//		String path = "./DataBase/RegisterDataBase.xlsx";
		try {
			File file = new File(path);
			FileOutputStream outputStream = new FileOutputStream(file);
			HSSFWorkbook hworkbook = new HSSFWorkbook();
			HSSFSheet sheet = hworkbook.createSheet(excelName);
			HSSFRow curRow; // 현재 row

//			XSSFWorkbook hworkbook = new XSSFWorkbook();
//			XSSFSheet sheet = hworkbook.createSheet("Register");
//			XSSFRow curRow; // 현재 row
//			if(NUser.userArr.size()==-1) {
//				return;
//			}
			int row = NUser.userArr.size();
			for (int i = 0; i < row; i++) {
				curRow = sheet.createRow(i);
				curRow.createCell(0).setCellValue(NUser.userArr.get(i).getName());
				curRow.createCell(1).setCellValue(NUser.userArr.get(i).getId());
				curRow.createCell(2).setCellValue(NUser.userArr.get(i).getPwd());
				curRow.createCell(3).setCellValue(NUser.userArr.get(i).getPhone());
				curRow.createCell(4).setCellValue(NUser.userArr.get(i).getEmail());
			}
			hworkbook.write(outputStream);
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void synchronization(String filePath) { //회원정보 동기화 메서드
		try {
            File file = new File(filePath);
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
            Cell cell = null;
            // 첫번재 sheet 내용 읽기
            for (Row row : wb.getSheetAt(0)) {
                // 셋째줄부터..
//                if (row.getRowNum() < 2) {
//                    continue;
//                }
                // 두번째 셀이 비어있으면 for문을 멈춘다.
                if(row.getCell(1) == null){
                    break;
                }
                NUser.userArr.add(new NUser(row.getCell(0).getStringCellValue(), 
                		row.getCell(1).getStringCellValue(),
                		row.getCell(2).getStringCellValue(),
                		row.getCell(3).getStringCellValue(),
                		row.getCell(4).getStringCellValue()));
                // 4번째 셀 값을 변경
//                cell = row.createCell(4);
//                cell.setCellValue("확인");
            }
            // 엑셀 파일 저장
            FileOutputStream fileOut = new FileOutputStream(file);
            wb.write(fileOut);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException >> " + fe.toString());
        } catch (IOException ie) {
            System.out.println("IOException >> " + ie.toString());
        }
	}
	
	// ----------------- 도서 데이터 베이스화 ---------------
	
	public static void dataBase_ExcelCreate2(String excelName) { // 엑셀(책 데이터베이스) 파일 생성
		File fileDir2 = new File("./DataBase");
		if (!fileDir2.exists()) {
			fileDir2.mkdir();
		}
		File fileFolder2 = new File("./DataBase/"+ excelName+ ".xls");
		if (!fileFolder2.exists()) {
			dataDase_ExcelFile2(excelName);
		}
	}
	
	public static void dataDase_ExcelFile2(String excelName) {
		try {
			// . xls 로 생성시
			HSSFWorkbook writeBook2 = new HSSFWorkbook(); // 새 엑셀파일 만들기 위한 객체 생성
			HSSFSheet mySheet2 = writeBook2.createSheet(excelName); // 새 시트 만들기
			FileOutputStream fos2 = new FileOutputStream("./DataBase/"+excelName+".xls"); // 엑셀파일을 생성함.
			writeBook2.write(fos2);
			dataBase_Write2(excelName);
			fos2.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void dataBase_Write2(String excelName) { //회원 정보만...
		String path2 = "./DataBase/"+ excelName +".xls";
		try {
			File file2 = new File(path2);
			FileOutputStream outputStream2 = new FileOutputStream(file2);
			HSSFWorkbook hworkbook2 = new HSSFWorkbook();
			HSSFSheet sheet2 = hworkbook2.createSheet(excelName);
			HSSFRow curRow2; // 현재 row
			if(Book.bookList.size()==-1) {
				return;
			}
			int row2 = Book.bookList.size();
			for (int i = 0; i < row2; i++) {
				curRow2 = sheet2.createRow(i);
				curRow2.createCell(0).setCellValue(Book.bookList.get(i).getBookIndex());
				curRow2.createCell(1).setCellValue(Book.bookList.get(i).getBookCategory());
				curRow2.createCell(2).setCellValue(Book.bookList.get(i).getBookTitle());
				curRow2.createCell(3).setCellValue(Book.bookList.get(i).getBookAuthor());
				curRow2.createCell(4).setCellValue(Book.bookList.get(i).getBookPublisher());
				curRow2.createCell(5).setCellValue(Book.bookList.get(i).getBookPublishedDate());
				curRow2.createCell(6).setCellValue(Book.bookList.get(i).getBookPrice());
				curRow2.createCell(7).setCellValue(Book.bookList.get(i).getUser());
				curRow2.createCell(8).setCellValue(Book.bookList.get(i).getStock());
				curRow2.createCell(9).setCellValue(Book.bookList.get(i).getSearchWord());
			}
			hworkbook2.write(outputStream2);
			outputStream2.close();

		} catch (Exception e) {
			System.out.println("오류발생" +e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void synchronization2(String filePath) { //회원정보 동기화 메서드
		try {
            File file2 = new File(filePath);
            HSSFWorkbook wb2 = new HSSFWorkbook(new FileInputStream(file2));
            Cell cell = null;
            // 첫번재 sheet 내용 읽기
            for (Row row : wb2.getSheetAt(0)) {
                if(row.getCell(1) == null){
                    break;
                }
                Book.bookList.add(new Book(
                		(int)row.getCell(0).getNumericCellValue(), 
                		row.getCell(1).getStringCellValue(),
                		row.getCell(2).getStringCellValue(),
                		row.getCell(3).getStringCellValue(),
                		row.getCell(4).getStringCellValue(),
                		row.getCell(5).getStringCellValue(),
                		row.getCell(6).getStringCellValue(),
                		row.getCell(7).getStringCellValue(),
                		row.getCell(8).getStringCellValue(),
                		row.getCell(9).getStringCellValue()
                		));
            }
            // 엑셀 파일 저장
            FileOutputStream fileOut2 = new FileOutputStream(file2);
            wb2.write(fileOut2);
        } catch (FileNotFoundException fe) {
            System.out.println("FileNotFoundException >> " + fe.toString());
        } catch (IOException ie) {
            System.out.println("IOException >> " + ie.toString());
        }
	}
	
//	// ----------------- 검색내역 데이터 베이스화 ---------------
//	
//	public static void dataBase_ExcelCreate3(String excelName) { // 엑셀(책 데이터베이스) 파일 생성
//		File fileDir3 = new File("./DataBase");
//		if (!fileDir3.exists()) {
//			fileDir3.mkdir();
//		}
//		File fileFolder3 = new File("./DataBase/"+ excelName+ ".xls");
//		if (!fileFolder3.exists()) {
//			dataDase_ExcelFile3(excelName);
//		}
//	}
//	
//	public static void dataDase_ExcelFile3(String excelName) {
//		try {
//			// . xls 로 생성시
//			HSSFWorkbook writeBook3 = new HSSFWorkbook(); // 새 엑셀파일 만들기 위한 객체 생성
//			HSSFSheet mySheet3 = writeBook3.createSheet(excelName); // 새 시트 만들기
//			FileOutputStream fos3 = new FileOutputStream("./DataBase/"+excelName+".xls"); // 엑셀파일을 생성함.
//			writeBook3.write(fos3);
//			dataBase_Write3(excelName);
//			fos3.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//	
//	public static void dataBase_Write3(String excelName) { //회원 정보만...
//		String path3 = "./DataBase/"+ excelName +".xls";
//		try {
//			File file3 = new File(path3);
//			FileOutputStream outputStream3 = new FileOutputStream(file3);
//			HSSFWorkbook hworkbook3 = new HSSFWorkbook();
//			HSSFSheet sheet3 = hworkbook3.createSheet(excelName);
//			HSSFRow curRow3; // 현재 row
//			if(Crawling.searchWordMap.size()==-1) {
//				return;
//			}
//			int row3 = Crawling.searchWordMap.size();
//			for (int i = 0; i < row3; i++) {
//				curRow3 = sheet3.createRow(i);
//				curRow3.createCell(0).setCellValue(Crawling.searchWordMap.keySet());
//				curRow3.createCell(1).setCellValue(Book.bookList.get(i).getBookCategory());
//			}
//			hworkbook3.write(outputStream3);
//			outputStream3.close();
//
//		} catch (Exception e) {
//			System.out.println("오류발생" +e.getMessage());
//			e.printStackTrace();
//		}
//	}
//	
//	public static void synchronization3(String filePath) { //회원정보 동기화 메서드
//		try {
//            File file3 = new File(filePath);
//            HSSFWorkbook wb3 = new HSSFWorkbook(new FileInputStream(file3));
//            Cell cell = null;
//            // 첫번재 sheet 내용 읽기
//            for (Row row : wb3.getSheetAt(0)) {
//                if(row.getCell(1) == null){
//                    break;
//                }
//                Book.bookList.add(new Book(
//                		(int)row.getCell(0).getNumericCellValue(), 
//                		row.getCell(1).getStringCellValue(),
//                		row.getCell(2).getStringCellValue(),
//                		row.getCell(3).getStringCellValue(),
//                		row.getCell(4).getStringCellValue(),
//                		row.getCell(5).getStringCellValue(),
//                		row.getCell(6).getStringCellValue(),
//                		row.getCell(7).getStringCellValue()
//                		));
//            }
//            // 엑셀 파일 저장
//            FileOutputStream fileOut3 = new FileOutputStream(file3);
//            wb3.write(fileOut3);
//        } catch (FileNotFoundException fe) {
//            System.out.println("FileNotFoundException >> " + fe.toString());
//        } catch (IOException ie) {
//            System.out.println("IOException >> " + ie.toString());
//        }
//	}


}
