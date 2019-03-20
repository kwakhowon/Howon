package kr.or.bit3.function;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import kr.or.bit3.auth.NLogin;

public class Crawling {
	private static String mainUrl;
	public static int totalCount;
	
	static {
		totalCount = 0 ;
		mainUrl = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=";
	}
	
	private static int getCharNumber(String str){ //품절 제외를 위해 카운팅
        int count = 0;
        for(int i=0;i<str.length()-1;i++)
        {
            if(str.charAt(i) == 'I')
                count++;
        }
        return count;
    }
	private static String searchWord() {
		System.out.println("\n------------------------------\n");
			do {
					System.out.print("검색할 도서명을 입력하세요 : ");
					String searchWord = NLogin.sc.nextLine();
					searchWord.trim();
					if (searchWord.matches("^[^\\s][a-z|A-Z|가-힣|0-9|\\s]+$")) { 
						System.out.print("=>"+searchWord + " - [v]\n");
						return searchWord;
					} else {
						System.out.print("=>"+searchWord + " - [x]\n");
						System.out.print("=> It's Incorret value.\n");
						System.out.println("\nex) 국문, 영문, 숫자를 적어주세요.\n");
					}
				}while(true);
			}
	
	public static String crawling() { //책이름 찾기 
		String searchWord = searchWord();
		System.out.println("\n------------------------------\n");
		System.out.println("\n      [\""+searchWord+"\" 검색결과]\n");
		for(int i=0; i<totalCount; i++) {
			if(Book.bookList.get(i).getSearchWord().equals(searchWord) && Book.bookList.get(i).getUser().equals(NLogin.userId)) {
				return searchWord;
			}
		}
		
		try {
//			String searchWordUrl1 = URLEncoder.encode(searchWord, "UTF-8");
			String searchWordUrl1 = URLEncoder.encode(searchWord, "euc-kr"); //한글 검색어 인코딩 
			Document doc = Jsoup.connect(mainUrl + searchWordUrl1).header("User-Agent", "Mozilla/5.0").timeout(8000).get();
			Elements category = doc.select("div.list_wrap div.info p.tit > span");
			Elements titles = doc.select("div.list_wrap div.info p.tit > b");
			Elements author = doc.select("div.list_wrap div.info p.writer");
			Elements publisher = doc.select("div.list_wrap div.info p.writer a:nth-child(4)");
			Elements publishedDate = doc.select("div.list_wrap div.info p.writer span.date");
			Elements bookPrice = doc.select("div.list_wrap div.price div.topCon > p:nth-child(1)");

			//카운팅 반복변수
			Elements tempCount = doc.select("#onmousecate > dl:nth-child(1) > dt > span");
			String DtempCount = tempCount.text().trim().replace(",", "");
			int DtempCountInt = 0;
			if(Integer.parseInt(DtempCount)<20) {
				DtempCountInt = (Integer.parseInt(DtempCount));
			}else {
				DtempCountInt=20; 
			}
			String Dcategory;
			String Dtitles;
			String Dauthor;
			String Dpublisher;
			String DpublishedDate;
			String DbookPrice;
			for(int i=0; i<DtempCountInt;i++) {
				Dcategory = category.get(i).text().trim();
				Dtitles = titles.get(i).text().trim();
				if(getCharNumber(author.get(i).text())==2) {
					Dauthor = author.get(i).text().substring(0,author.get(i).text().indexOf("I"));
					Dpublisher = author.get(i).text().substring(author.get(i).text().indexOf("I")+1,author.get(i).text().length()-11);
					DpublishedDate = publishedDate.get(i).text().trim().substring(publishedDate.get(i).text().length()-10, publishedDate.get(i).text().length());
				}else {
					Dauthor = "없음";
					Dpublisher = author.get(i).text().substring(0,author.get(i).text().indexOf("I"));
					DpublishedDate = publishedDate.get(i).text().trim().substring(publishedDate.get(i).text().length()-10, publishedDate.get(i).text().length());
				}
				DbookPrice = bookPrice.get(i).text().trim().replace("정가인하", "");
//				if(!NLogin.userId.equals("GUEST")) { //추가 할까말까 고민중.. 
					Book.bookList.add(new Book(++totalCount, Dcategory, Dtitles, Dauthor, Dpublisher, DpublishedDate, DbookPrice, NLogin.userId,"1",searchWord));
					DataBaseExcel.dataBase_Write2("BookDataBase");	
//				}
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.out.println("실패");
		}return searchWord;
	}
}
