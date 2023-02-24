package DreamShop.paging;

import org.springframework.stereotype.Service;

@Service
public interface IPaginateService {
	 Paginate GetInfoPaginate(long totalData, long limit, long currentPage);
	 
	
}
