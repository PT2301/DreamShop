package DreamShop.paging;

import org.springframework.stereotype.Service;

@Service
public class PaginateService implements IPaginateService{

	@Override
	public Paginate GetInfoPaginate(long totalData, long limit, long currentPage) {
		Paginate paginate = new Paginate();
		paginate.setLimit(limit);
		paginate.setCurrentPage(checkCurrentPage(currentPage,getTotalPage(totalData,limit)));
		paginate.setTotalPage(getTotalPage(totalData,limit));
		paginate.setStart(FindStart(currentPage,limit));
		paginate.setEnd(FindEnd(FindStart(currentPage,limit),limit,totalData));
		
		return paginate;
	}
	public long getTotalPage(long totalData,long limit) {
		long totalPage;
		totalPage=totalData/limit;
		totalPage=totalPage*limit<totalData?totalPage+1:totalPage;
		return totalPage;
		
	}
	public long checkCurrentPage(long currentPage,long totalPage) {
		if (currentPage < 1) {
			return 1;
		}
		if (currentPage > totalPage) {
			return totalPage;
		}
		return currentPage;
	}
	private long FindEnd(long start, long limit, long totalData) {
		return start + limit > totalData ? totalData : (start + limit) -1;
	}

	private long FindStart(long currentPage, long limit) {
		return ((currentPage - 1) * limit) + 1;
	}

}
