package common;

import java.util.List;

public class PageInfo<T> {

  private Integer pageNum;

  private Integer pageSize;

  private Long total;

  private List<T> rows;

  public PageInfo() {

  }

  public PageInfo(int pageNumber, int pageSize) {
    this.pageNum = pageNumber;
    this.pageSize = pageSize;
  }

  public PageInfo(PageInfo other) {
    if (other == null || other.pageNum == null || other.pageSize == null) {
      this.pageNum = 1;
      this.pageSize = 0;
    } else {
      this.pageNum = other.pageNum;
      this.pageSize = other.pageSize;
    }
  }

  public Integer getPageNum() {
    return pageNum;
  }

  public void setPageNum(Integer pageNum) {
    this.pageNum = pageNum;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Long getTotal() {
    return total;
  }

  public void setTotal(Long total) {
    this.total = total;
  }

  public List<T> getRows() {
    return rows;
  }

  public void setRows(List<T> rows) {
    this.rows = rows;
  }
}
