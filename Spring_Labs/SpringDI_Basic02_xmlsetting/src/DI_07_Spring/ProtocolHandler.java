package DI_07_Spring;

import java.util.List;

//이 클래스가 Filter 사용하기
public class ProtocolHandler {
  
  private List<MyFilter> filters; //filter 라는 Collection 주소값
  
  public List<MyFilter> getFilters() {
    return filters;
  }

  public void setFilters(List<MyFilter> filters) {
    this.filters = filters;
  }

  //검증하는 함수
  public int filter_Length() {
    return this.filters.size();
  }
}
